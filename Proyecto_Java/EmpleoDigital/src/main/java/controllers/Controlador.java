package controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.*;
import modelos.*;
import modelos.Modulo.Bloque;
import utils.DateUtils;

@Controller
public class Controlador {
	
	
		@RequestMapping("/")
	    public ModelAndView index(HttpSession sesion){
	    	ModelAndView mv = new ModelAndView("index");
	    	return mv;
	    }
		
		
		@RequestMapping("/VCBotonCrearModificar")
	    public ModelAndView VCBotonCrearModificar(HttpSession sesion){
	    	ModelAndView mv = new ModelAndView("VCrear");
	    	
	    	
	    	return mv;
	    }
		
	
		
		
}
