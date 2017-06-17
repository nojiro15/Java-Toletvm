package controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.DAOComunidad;
import dao.DAOFiestaLocal;
import dao.DAOFiestaNacional;
import dao.DAOFiestaRegional;
import modelos.Comunidad;
import modelos.FiestaLocal;
import modelos.FiestaNacional;
import modelos.FiestaRegional;
import utils.DateUtils;

@Controller
public class ListarFiestas {

	@Autowired
	DAOFiestaLocal daofl;
	
	@Autowired
	DAOFiestaRegional daofr;
	
	@Autowired
	DAOFiestaNacional daofn;
	
	@Autowired
	DAOComunidad daoco;
	
	
	/**
	 * Este controlador entra en funcionamiento cuando pasamos de la vista crear festivo a la de listar (botón)
	 * Lo que nos crea es el listado, separado por fiestas nacionales, regionales y locales
	 * a su vez, cada una de las fiestas del listado podrá ser seleccionada para ser borrada o modificada
	 * @param sesion
	 * @return
	 */
	@RequestMapping("/ListarFestivos")
    public ModelAndView VCListFestivos(HttpSession sesion){
    	ModelAndView mv = new ModelAndView("VCListFestivos");    	
    	  
	/* Controlador que junta todas las fiestas*/

		List<FiestaNacional> listaN = daofn.listar();
		List<FiestaRegional> listaR = daofr.listar();
		List<FiestaLocal> listaL = daofl.listar();
		mv.addObject("listaN", listaN);
		mv.addObject("formatoFecha",DateUtils.getFormatoFechaVista());
		mv.addObject("listaR", listaR);
		mv.addObject("listaL", listaL);
		
		return mv;
	}
	
	@RequestMapping("/borrarFiestaLocal")
	public ModelAndView borrarFiestaLocal(
			HttpSession sesion, 
			@RequestParam("intFecha")long intFecha) {
		Calendar cal = Calendar.getInstance();
		
		cal.setTimeInMillis(intFecha);
		 Date fecha = cal.getTime();
		daofl.delete(fecha);
		
		return VCListFestivos(sesion);	
		
	}
	
	@RequestMapping("/borrarFiestaRegional")
	public ModelAndView borrarFiestaRegional(
			HttpSession sesion, 
			@RequestParam("intFecha")long intFecha) {
		Calendar cal = Calendar.getInstance();
		
		cal.setTimeInMillis(intFecha);
		 Date fecha = cal.getTime();
		daofr.delete(fecha);
		return VCListFestivos(sesion);		
	}
	
	@RequestMapping("/borrarFiestaNacional")
	public ModelAndView borrarFiestaNacional(
			HttpSession sesion, 
			@RequestParam("intFecha")long intFecha) {
		Calendar cal = Calendar.getInstance();
		
		cal.setTimeInMillis(intFecha);
		 Date fecha = cal.getTime();
		
		daofn.delete(fecha);
		
		return VCListFestivos(sesion);	
	}
	
	
}
