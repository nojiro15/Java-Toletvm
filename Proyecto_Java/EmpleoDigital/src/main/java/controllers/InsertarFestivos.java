package controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dao.DAOComunidad;
import dao.DAOFiestaLocal;
import dao.DAOFiestaNacional;
import dao.DAOFiestaRegional;
import dao.DAOMunicipio;
import dao.DAOProvincia;
import modelos.Comunidad;
import modelos.FiestaLocal;
import modelos.FiestaNacional;
import modelos.FiestaRegional;
import modelos.Municipio;
import modelos.Provincia;
import utils.DateUtils;

@Controller
public class InsertarFestivos {
	
	@Autowired
	DAOFiestaLocal daofl;
	
	@Autowired
	DAOFiestaNacional daofn;
	
	@Autowired
	DAOFiestaRegional daofr;
	
	@Autowired
	DAOComunidad daoco;
	
	@Autowired
	DAOProvincia daopr;
	
	@Autowired
	DAOMunicipio daomu;

	@RequestMapping("VCCrearFestivos")
    public ModelAndView VListados(HttpSession sesion){
    	ModelAndView mv = new ModelAndView("VFestivos");
    	
    	List<Comunidad> listaComunidades=daoco.listar();
    	mv.addObject("listaComunidades",listaComunidades);
    
    	
    	return mv;
    }
	@RequestMapping(path="/listaProvincias", produces="application/json")
	@ResponseBody
	public String listaComunidades(
			HttpSession sesion, HttpServletRequest request){
		
		
		int idComunidad = Integer.parseInt(request.getParameter("idComunidad"));
		List<Provincia> listapr=daopr.listarPorComunidad(idComunidad);
		JsonArrayBuilder json=Json.createArrayBuilder();
		for(Provincia pr : listapr){
			System.out.println(pr.getProvincia());
			json.add(pr.toJson());
		}
	
		
		return json.build().toString();
	}
	@RequestMapping(path="/listaMunicipios", produces="application/json")
	@ResponseBody
	public String listarMunicipios(
			HttpSession sesion, HttpServletRequest request){
		
		
		int idProvincia = Integer.parseInt(request.getParameter("idProvincia"));
		List<Municipio> listamu=daomu.listarPorProvincias(idProvincia);
		JsonArrayBuilder json=Json.createArrayBuilder();
		for(Municipio mu : listamu){
			json.add(mu.toJson());
		}
	
		
		return json.build().toString();
	}
	
	@RequestMapping("/altaFiestas")
	public ModelAndView altaFiestas(HttpSession sesion,
			HttpServletResponse response,
			HttpServletRequest request,
			@RequestParam(value="tipoFiesta") int tipoFiesta,
			@RequestParam(value="nombre") String nombre,
			@RequestParam(value="fecha") String fecha){
		
		

		if(tipoFiesta==2){
			Date d = DateUtils.parse(fecha);
			int idMunicipio = Integer.parseInt(request.getParameter("municipio"));
			FiestaLocal l = new FiestaLocal(nombre,d,idMunicipio);
		daofl.create(l);
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
			
		daofr.create(re);
		try {
			response.sendRedirect("VCCrearFestivos");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else if(tipoFiesta==0){

			Date n = DateUtils.parse(fecha);
			FiestaNacional na = new FiestaNacional(nombre,n);
		daofn.create(na);
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
		
	
	
}
