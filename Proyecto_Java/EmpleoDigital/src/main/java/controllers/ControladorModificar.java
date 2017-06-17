package controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import modelos.*;
import utils.DateUtils;
import dao.*;


@Controller
public class ControladorModificar {

	@Autowired 
	DAOFiestaNacional daofn;
	
	@Autowired
	DAOFiestaRegional daofr;
	
	@Autowired
	DAOFiestaLocal daofl;
	
	@Autowired 
	DAOComunidad daoco;
	
	@Autowired
	DAOFormacion daof;
	
	@Autowired
	DAOProvincia daopr;
	
	@Autowired
	DAOModulo daom;
	
	@Autowired
	DAOModuloFormacion daomf;
	
	@RequestMapping("/modificarFiestaNacionalForm")
	public ModelAndView modificarFiestaNacional(HttpSession sesion,
			@RequestParam("intFecha")long intFecha){
		Calendar cal = Calendar.getInstance();
		
		cal.setTimeInMillis(intFecha);
		Date fecha = cal.getTime();
		
		FiestaNacional fn = daofn.read(fecha);
		
		List<Comunidad> listaComunidades = daoco.listar();
		
		ModelAndView mv = new ModelAndView("VMFestivos");
    	mv.addObject("listaComunidades",listaComunidades);
    	mv.addObject("nombre", fn.getNombre());
    	mv.addObject("stfecha",utils.DateUtils.formatearFecha(fn.getFecha()));
    	mv.addObject("fecha", fn.getFecha());
    	mv.addObject("tipo", 0);
		return mv;
	}
	@RequestMapping("/modificarFiestaRegionalForm")
	public ModelAndView modificarFiestaRegional(HttpSession sesion,
			@RequestParam("intFecha")long intFecha){
		Calendar cal = Calendar.getInstance();
		
		cal.setTimeInMillis(intFecha);
		Date fecha = cal.getTime();
		
		FiestaRegional fr = daofr.read(fecha);
		
		List<Comunidad> listaComunidades = daoco.listar();
		
		ModelAndView mv = new ModelAndView("VMFestivos");
    	mv.addObject("listaComunidades",listaComunidades);
    	mv.addObject("nombre", fr.getNombre());
    	mv.addObject("stfecha",utils.DateUtils.formatearFecha(fr.getFecha()));
    	mv.addObject("fecha", fr.getFecha());
    	mv.addObject("tipo", 0);
		return mv;
	}
	@RequestMapping("/modificarFiestaLocalForm")
	public ModelAndView modificarFiestaLocal(HttpSession sesion,
			@RequestParam("intFecha")long intFecha){
		Calendar cal = Calendar.getInstance();
		
		cal.setTimeInMillis(intFecha);
		Date fecha = cal.getTime();
		
		FiestaLocal fl = daofl.read(fecha);
		
		List<Comunidad> listaComunidades = daoco.listar();
		
		ModelAndView mv = new ModelAndView("VMFestivos");
    	mv.addObject("listaComunidades",listaComunidades);
    	mv.addObject("nombre", fl.getNombre());
    	mv.addObject("stfecha",utils.DateUtils.formatearFecha(fl.getFecha()));
    	mv.addObject("fecha", fl.getFecha());
    	mv.addObject("tipo", 0);
		return mv;
	}
	@RequestMapping("/modificarFiesta")
	public ModelAndView modificar(HttpSession sesion,
			HttpServletResponse response,
			HttpServletRequest request,
			@RequestParam(value="tipoFiesta") int tipoFiesta,
			@RequestParam(value="nombre") String nombre,
			@RequestParam(value="fecha") String fecha){
		
		System.out.println(request.getParameter("fechaString"));
		Date fechaOriginal = utils.DateUtils.parse(request.getParameter("fechaString"));
		
		if(tipoFiesta==2){
			Date d = DateUtils.parse(fecha);
			int idMunicipio = Integer.parseInt(request.getParameter("municipio"));
			FiestaLocal l = new FiestaLocal(nombre,d,idMunicipio);
			daofl.update(l, fechaOriginal);
		try {
			response.sendRedirect("VCCrearFestivos");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else if(tipoFiesta==1){
			int idProvincia = Integer.parseInt(request.getParameter("idProvincia"));

			Date r = DateUtils.parse(fecha);
			FiestaRegional re = new FiestaRegional(nombre,r,idProvincia);
			
		daofr.update(re, fechaOriginal);
		try {
			response.sendRedirect("VCCrearFestivos");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else if(tipoFiesta==0){

			Date n = DateUtils.parse(fecha);
			FiestaNacional na = new FiestaNacional(nombre,n);
			daofn.update(na, fechaOriginal);
		try {
			response.sendRedirect("VCCrearFestivos");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}else{
			try {
				response.sendRedirect("VCCrearFestivos");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	}	
	
	@RequestMapping("/modForm")
	public ModelAndView modForm(HttpSession sesion,
			@RequestParam("idFormacion")int idFormacion){
		ModelAndView mv = new ModelAndView("VMNFormacion");
		Formacion formacion = daof.readById(idFormacion);
		List<Provincia> listaProvincias=daopr.listar();
		mv.addObject("listaProvincias", listaProvincias);
		mv.addObject("formacion", formacion);
		mv.addObject("stfechaInicio", utils.DateUtils.formatearFecha(formacion.getFechaInicio()));
		return mv;
	}
	
	
}
