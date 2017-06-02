package modelos;

import java.util.Date;

import modelos.Modulo.Bloque;
import utils.DateUtils;

/**
 * ModuloFormacion ser� una clase hija de Modulo, que incluir� propiedades de los m�dulos de una formaci�n concreta.
 * @author JavaToletvm
 *
 */

public class ModuloFormacion extends Modulo{
	
	/**
	 * Propiedades de la clase hija ModuloFormacion
	 * idFormacion --Identificador de la formaci�n a la que corresponde el m�dulo
	 * orden --Lugar que ocupa el m�dulo en la planificaci�n de la formaci�n.
	 * fechaInicio --Fecha en la que empieza el m�dulo dentro de la formaci�n.
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
