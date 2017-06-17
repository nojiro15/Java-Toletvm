package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.DAOFormacion;
import modelos.Formacion;
import utils.Calendario;

@Controller
public class ListarFormacion {

	@Autowired
	DAOFormacion daof;
	
	@Autowired
	ApplicationContext ctx;
	
    
	
	/**
	 * Este método enviará a la vista los tres diferentes listados de formaciones.
	 * Una lista será la completa, otra la del listado de finalizados, y otro la de en curso.
	 * @param sesion
	 * @return
	 */
	@RequestMapping(value = {"VCIndex"})
	public ModelAndView listado(HttpSession sesion){
		ModelAndView mv = new ModelAndView("VListados");
		
		//Fecha actual
		Date fechaD = new Date();
		int fecha = (int)fechaD.getTime();
		
		List<Formacion> listaCompleta = daof.listar();
		List<Formacion> listaFinalizados = new ArrayList<Formacion>();
		List<Formacion> listaEnCurso = new ArrayList<Formacion>();
		
		//Recorremos todas las fechas mirando si están o no finalizados
				Calendario objetoCal = new Calendario(ctx);
				
				for(Formacion formacion:listaCompleta){
					if (fechaD.compareTo(objetoCal.getFechaFin(formacion)) > 0){
						System.out.println(formacion);
						listaFinalizados.add(formacion);
					}else{
						listaEnCurso.add(formacion);
					}
				}
		
		
		//Enviamos a la vista todas las listas para mostrarlas en su correspondiente sesion
		mv.addObject("listaCompleta", listaCompleta);
		mv.addObject("listaFinalizados", listaFinalizados);
		mv.addObject("listaEnCurso", listaEnCurso);
		
		return mv;
	}
}
