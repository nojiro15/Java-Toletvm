package modelos;

import java.util.Date;

import utils.DateUtils;

public class FiestaRegional {

	private String nombre;
	private Date fecha;
	private int idComunidad;
	
	
	public FiestaRegional(){
		
	}
	
	public FiestaRegional(String nombre,Date fecha,int idComunidad){
		this.nombre=nombre;
		this.fecha=fecha;
		this.idComunidad=idComunidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getIdComunidad() {
		return idComunidad;
	}

	public void setIdComunidad(int idComunidad) {
		this.idComunidad = idComunidad;
	}
	
	public String getStringFecha(){
		return DateUtils.formatearFecha(fecha);
	}
	public long getIntFecha(){
		long i = fecha.getTime();
		return i;
	}
}
