package modelos;

import java.util.Date;

import utils.DateUtils;

public class Vacaciones {

	private int id;
	private String asunto;
	private Date fechaInicio;
	private Date fechaFin;
	private int idFormacion;
	
	public Vacaciones(){
		
	}
	
	
	public Vacaciones(int id,String asunto,Date fechaInicio,Date fechaFin, int idFormacion){
		this.id=id;
		this.asunto=asunto;
		this.fechaInicio=fechaInicio;
		this.fechaFin=fechaFin;
		this.idFormacion=idFormacion;
	}
	
	
	public Vacaciones(String asunto,Date fechaInicio,Date fechaFin, int idFormacion){
		this.asunto=asunto;
		this.fechaInicio=fechaInicio;
		this.fechaFin=fechaFin;
		this.idFormacion=idFormacion;
	}
	
	
	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getAsunto() {
		return asunto;
	}
	
	
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	
	
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	
	public Date getFechaFin() {
		return fechaFin;
	}
	
	
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	
	public int getIdFormacion() {
		return idFormacion;
	}	
	
	
	public void setIdFormacion(int idFormacion) {
		this.idFormacion = idFormacion;
	}
	
	public String getStringFechaInicio(){
		return DateUtils.formatearFecha(fechaInicio);
	}
	public String getStringFechaFin(){
		return DateUtils.formatearFecha(fechaFin);
	}
}
