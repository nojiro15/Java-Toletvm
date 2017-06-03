package modelos;

import java.util.Date;

import utils.DateUtils;

public class FiestaNacional {

	private Date fecha;
	private String nombre;
	
	public FiestaNacional(){
		
	}
	
	public FiestaNacional(Date fecha,String nombre){
		this.fecha=fecha;
		this.nombre=nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getStringFecha(){
		return DateUtils.formatearFecha(fecha);
	}
}
