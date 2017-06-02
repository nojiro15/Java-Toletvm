package modelos;

import java.util.Date;

import utils.DateUtils;

/**
 * 
 * @author JavaToletvm
 *
 */
public class Formacion {
	
	/**
	 * Propiedades del objeto Formacion
	 * id --Identificador de la formación dentro de la base de datos
	 * nombre --Nombre de la formación. Ejemplo: Java Toledo
	 * fechaInicio --Fecha de inicio de la formación
	 */
	private int id; 
	private String nombre; 
	private Date fechaInicio;
	private int idMunicipio;
	private Date fechaFin;
	
	/**
	 * Constructores por orden:
	 * Vacío
	 * Sin Id y sin Fecha de Fin
	 * Sin Id y con Fecha de Fin
	 * Con Id y sin Fecha de Fin
	 * Con Id y con Fecha de Fin
	 */
	public Formacion(){}
	
	public Formacion(String nombre, Date fechaInicio, int idMunicipio){
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
	}
	
	public Formacion(String nombre, Date fechaInicio, int idMunicipio, Date fechaFin){
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	
	public Formacion(int id, String nombre, Date fechaInicio, int idMunicipio){
		this.id = id;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
	}
	public Formacion(int id, String nombre, Date fechaInicio, int idMunicipio, Date fechaFin){
		this.id = id;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	
	/**
	 * Getters
	 */
	
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public int getIdMunicipio(){
		return idMunicipio;
	}
	
	public Date getFechaFin(){
		return fechaFin;
	}
	
	/**
	 * Setters
	 */
	public void setId(int id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public void setIdMunicipio(int idMunicipio){
		this.idMunicipio = idMunicipio;
	}
	public void setFechaFin(Date fechaFin){
		this.fechaFin = fechaFin;
	}
	
	public String getStringFechaInicio(){
		return DateUtils.formatearFecha(fechaInicio);
	}
	public String getStringFechaFin(){
		return DateUtils.formatearFecha(fechaFin);
	}
}
