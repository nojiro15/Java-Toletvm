package modelos;

import java.util.Calendar;
import java.util.Date;

import utils.DateUtils;

public class FiestaNacional {

	private Date fecha;
	private String nombre;
	
	public FiestaNacional(){
		
	}
	
	public FiestaNacional(String nombre,Date fecha){
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
	public long getIntFecha(){
		long i = fecha.getTime();
		return i;
	}
}
