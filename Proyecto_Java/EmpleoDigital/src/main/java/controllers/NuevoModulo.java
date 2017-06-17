package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.DAOModulo;
import modelos.Modulo;
import modelos.Modulo.Bloque;



@Controller
public class NuevoModulo {
	
	@Autowired
	DAOModulo daom;

	@RequestMapping(value = {"VCCrearNModulo"})
	public ModelAndView VNModulo(HttpSession sesion){
		ModelAndView mv = new ModelAndView("VNModulo");	
		return mv;
	}
	@RequestMapping(value={"nuevoModulo"})
	public ModelAndView nuevoModulo(HttpSession sesion, HttpServletRequest request,
			@RequestParam(value="nombre" )String nombre,
			@RequestParam(value="jornadas")int jornadas,
			@RequestParam(value="horas")int horas,
			@RequestParam(value="b")int b
			){
		
		boolean tutoria = Boolean.parseBoolean(request.getParameter("tutoria"));
		System.out.println(tutoria);
		
				int horasTutoria;
			if (tutoria){
				 horasTutoria = 4;
			}
			else {horasTutoria = 0;}
			
		ModelAndView mv = null;
		
		Bloque bloque = null;
		if(b == 0){
			bloque = Bloque.TRONCAL;
		}else if(b == 1){
			bloque = Bloque.METODO;
		}else if(b == 2){
			bloque = Bloque.SUMA;
		}
		
		Modulo m = new Modulo(nombre, jornadas, horas, horasTutoria, bloque);
		boolean ok = daom.create(m);
		
		if(ok){
			mv = new ModelAndView("VNModulo");
		}
		return mv;	
	}
	
	@RequestMapping(value = {"VNModuloVolver"})
	public ModelAndView VNModuloVolver(HttpSession sesion){
		ModelAndView mv = new ModelAndView("VListados");	
		return mv;
	}
}
