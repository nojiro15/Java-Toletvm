package modelos;

import java.util.Date;

import utils.DateUtils;

public class FiestaLocal {

	private String nombre;
	private Date fecha;
	private int idMunicipio;
	
	
	public FiestaLocal(){
		
	}
	public FiestaLocal(String nombre,Date fecha,int idMunicipio){
		this.nombre=nombre;
		this.fecha=fecha;
		this.idMunicipio=idMunicipio;
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
	public int getIdMunicipio() {
		return idMunicipio;
	}
	public void setIdMunicipio(int idMunicipio) {
		this.idMunicipio = idMunicipio;
	}
	
	public String getStringFecha(){
		return DateUtils.formatearFecha(fecha);
	}
	
}
