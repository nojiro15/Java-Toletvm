package modelos;

import java.util.Date;

import dao.DAOMunicipio;
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
	private Municipio municipio;
	private DAOMunicipio daomu;
	/**
	 * Constructores por orden:
	 * Vacío
	 * Sin Id 
	 * Con Id 
	 */
	public Formacion(){}
	
	public Formacion(String nombre, Date fechaInicio, Municipio municipio){
		
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.setMunicipio(municipio);
	}
	
	public Formacion(int id, String nombre, Date fechaInicio,Municipio municipio){
		this.id = id;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.setMunicipio(municipio);
	}
	
	public Formacion(String nombre, Date fechaInicio, int idMunicipio){
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.idMunicipio = idMunicipio;
	}
	
	public Formacion(int id, String nombre, Date fechaInicio, int idMunicipio){
		this.id = id;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.idMunicipio = idMunicipio;

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

	
	public String getStringFechaInicio(){
		return DateUtils.formatearFecha(fechaInicio);
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

}
