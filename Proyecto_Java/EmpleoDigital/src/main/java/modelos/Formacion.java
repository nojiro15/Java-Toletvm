package modelos;

import java.util.Date;

/**
 * 
 * @author JavaToletvm
 *
 */
public class Formacion {
	
	/**
	 * Propiedades del objeto Formacion
	 * id --Identificador de la formaci�n dentro de la base de datos
	 * nombre --Nombre de la formaci�n. Ejemplo: Java Toledo
	 * fechaInicio --Fecha de inicio de la formaci�n
	 */
	private int id; 
	private String nombre; 
	private Date fechaInicio; 
	
	/**
	 * Constructores (vac�o y con propiedades)
	 */
	public Formacion(){}
	
	public Formacion(int id, String nombre, Date fechaInicio){
		this.id = id;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
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
}
