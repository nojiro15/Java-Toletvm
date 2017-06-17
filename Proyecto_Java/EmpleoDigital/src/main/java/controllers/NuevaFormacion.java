package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.DAOFormacion;
import dao.DAOModulo;
import dao.DAOModuloFormacion;
import dao.DAOMunicipio;
import dao.DAOProvincia;
import dao.DAOVacaciones;
import modelos.Formacion;
import modelos.Modulo;
import modelos.ModuloFormacion;
import modelos.Municipio;
import modelos.Provincia;
import modelos.Vacaciones;
import utils.Calendario;
import utils.DateUtils;

@Controller
public class NuevaFormacion {

	@Autowired
	DAOModulo daom;
	
	@Autowired
	DAOFormacion daof;
	
	@Autowired
	DAOModuloFormacion daomf;
	
	@Autowired
	DAOProvincia daopr;
	
	@Autowired
	DAOVacaciones daov;
	
	@Autowired
	DAOProvincia daop;
	
	@Autowired
	DAOMunicipio daomun;
	
	@Autowired
	ApplicationContext ctx;
	
	@RequestMapping(value = {"VCCrearNFormacion"})
	public ModelAndView VNFormacion(HttpSession sesion){
		ModelAndView mv = new ModelAndView("VNFormacion");	
		List<Provincia> listaProvincias=daopr.listar();
		mv.addObject("listaProvincias", listaProvincias);
		return mv;
	}
	@RequestMapping(value = {"VCInsertModulosFormacion"})
	public ModelAndView VModulos(HttpSession sesion, HttpServletRequest request, 
			@RequestParam("nombre")String nombre,
			@RequestParam("fechaInicio")String stfechaInicio){
		int idMunicipio = Integer.parseInt(request.getParameter("municipio"));
		
		Formacion formacion = null;
		
		//Parseo de la fecha
		SimpleDateFormat parser = new SimpleDateFormat(DateUtils.getFormatoFecha());
		try {
			Date fechaInicio = parser.parse(stfechaInicio);	
			formacion = new Formacion(nombre, fechaInicio, idMunicipio);
			daof.create(formacion);
						
		} catch (ParseException pe) {
			pe.printStackTrace();
		}

		
		List<Modulo> listaTroncal = daom.listarByBloque(0);
		List<Modulo> listaMetodo = daom.listarByBloque(1);
		List<Modulo> listaSuma = daom.listarByBloque(2);
		
		
		ModelAndView mv = new ModelAndView("VModulos");
		mv.addObject("idFormacion", formacion.getId());
		mv.addObject("listaTroncal", listaTroncal);
		mv.addObject("listaMetodo", listaMetodo);
		mv.addObject("listaSuma", listaSuma);
		return mv;
	}
	
	
	
	@RequestMapping(value = {"VCInsertarVacaciones"})
	public ModelAndView VInsertarVacaciones(HttpSession sesion, HttpServletRequest request,
			@RequestParam("idFormacion")int idFormacion){
		
		List<ModuloFormacion> listMF = daomf.listarByIdFormacion(idFormacion);
		if(!listMF.isEmpty()){
			for(ModuloFormacion mf:listMF){
				daomf.delete(mf);
			}
		}
		
		Enumeration<String> nombresParametros = request.getParameterNames();
		int orden = 0;
		List<ModuloFormacion> listaModuloFormacion = daomf.listarByIdFormacion(idFormacion);
		
		
		while(nombresParametros.hasMoreElements()){
			String nombre = nombresParametros.nextElement();
			if(nombre.substring(0, 7).equals("modulo_")){
				String stModuloId = nombre.substring(7);
				int idModulo = Integer.parseInt(stModuloId);
				int value = Integer.parseInt(request.getParameter(nombre));
				if(value == 1){
					String stFecha=request.getParameter("fechaModulo_"+stModuloId);
					Date fecha;
					if(stFecha.trim().equals("")){
						fecha = null;
					}
					else{
						fecha = utils.DateUtils.parse(stFecha);
					}
					Modulo modulo = daom.readById(idModulo);
					orden++; 
					ModuloFormacion mf = new ModuloFormacion(modulo, idFormacion, orden, fecha);
					daomf.create(mf);

				}
			}
		}
		ModelAndView mv = new ModelAndView("VVacaciones");
		mv.addObject("idFormacion", idFormacion);
		return mv;
	}
	

	@RequestMapping(value = {"VCResumen"})
	public ModelAndView VResumen(HttpSession sesion,
			HttpServletRequest request,
			@RequestParam("idFormacion")int idFormacion){
		
		String asunto = request.getParameter("asunto");
		
		
		String multiFecha=request.getParameter("fecha");
		String[] fechas=multiFecha.split(",");
		for(int i=0;i<fechas.length;i++) fechas[i]=fechas[i].trim();
		
		
		ArrayList<Date> fechasDate = new ArrayList<Date>();
		for(String fecha: fechas){
			fechasDate.add(utils.DateUtils.parse(fecha));
		}
		
		List<Vacaciones> listV = daov.listarByIdFormacion(idFormacion);
		if(!listV.isEmpty()){
			for(Vacaciones v:listV){
				daov.delete(v.getId());
			}
		}
		
		for(Date fechaD: fechasDate){
			Vacaciones v = new Vacaciones(asunto, fechaD, idFormacion);
			if(fechaD!=null && !asunto.equals("")){
				daov.create(v);
			}
		}		
		return PrepararResumen(sesion, request);
		
	}
	
	@RequestMapping(value = {"PrepararResumen"})
	public ModelAndView PrepararResumen(HttpSession sesion, HttpServletRequest request){
		ModelAndView mv = new ModelAndView("VResumen");
		int idFormacion = Integer.parseInt(request.getParameter("idFormacion"));
		Formacion formacion = daof.readById(idFormacion);
		Provincia provincia = daop.readByIdFormacion(idFormacion);
		Municipio localidad = daomun.readByIdFormacion(idFormacion);
		List<ModuloFormacion> listaModulos = daomf.listarByIdFormacion(idFormacion);
		
		int jornadasTotales = 0;
		for(ModuloFormacion mf: listaModulos){
			jornadasTotales = jornadasTotales + mf.getJornadas();
		}
		Calendario cal = new Calendario(ctx);

		mv.addObject("formacion", formacion);
		mv.addObject("stFechaInicio",utils.DateUtils.formatearFecha(formacion.getFechaInicio()));
		mv.addObject("provincia", provincia);
		mv.addObject("localidad", localidad);
		mv.addObject("listaModulos", listaModulos);
		mv.addObject("jornadasTotales", jornadasTotales);
		String stFechaFin = utils.DateUtils.formatearFecha(cal.getFechaFin(formacion));
 			
			
			mv.addObject("stFechaFin",stFechaFin);

		return mv;						

	}
	
	
}	
