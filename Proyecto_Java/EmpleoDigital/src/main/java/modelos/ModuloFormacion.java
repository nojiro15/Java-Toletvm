package modelos;

import java.util.Date;

import modelos.Modulo.Bloque;
import utils.DateUtils;

/**
 * ModuloFormacion será una clase hija de Modulo, que incluirá propiedades de los módulos de una formación concreta.
 * @author JavaToletvm
 *
 */

public class ModuloFormacion extends Modulo{
	
	/**
	 * Propiedades de la clase hija ModuloFormacion
	 * idFormacion --Identificador de la formación a la que corresponde el módulo
	 * orden --Lugar que ocupa el módulo en la planificación de la formación.
	 * fechaInicio --Fecha en la que empieza el módulo dentro de la formación.
	 */
	private int idFormacion; 
	private int orden; 
	private Date fechaInicio; 
	
	/**
	 * Constructores
	 */
	public ModuloFormacion(){}
	
	public ModuloFormacion(int id, String nombre, int jornadas, int horas, int horasTutoria, Bloque bloque,int idFormacion, int orden, Date fechaInicio){
		super(id, nombre,jornadas,horas, horasTutoria, bloque);
		this.idFormacion = idFormacion;
		this.orden = orden;
		this.fechaInicio = fechaInicio;
	}
	
	public ModuloFormacion(String nombre, int jornadas, int horas, int horasTutoria, Bloque bloque, int orden, Date fechaInicio){
		super(nombre,jornadas,horas, horasTutoria, bloque);
		this.orden = orden;
		this.fechaInicio = fechaInicio;
	}
	
	/**
	 * Getters
	 * 
	 */
	public int getIdFormacion() {
		return idFormacion;
	}

	public int getOrden() {
		return orden;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	
	/**
	 * Setters
	 * 
	 */
	public void setIdFormacion(int idFormacion) {
		this.idFormacion = idFormacion;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	
	public String getStringFechaInicio(){
		return DateUtils.formatearFecha(fechaInicio);
	}

	
}
