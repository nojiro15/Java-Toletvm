package modelos;

import java.util.Date;

import utils.DateUtils;

public class Vacaciones {

	private int id;
	private String asunto;
	private Date fecha;
	private int idFormacion;
	
	public Vacaciones(){
		
	}
	
	
	public Vacaciones(int id,String asunto,Date fecha, int idFormacion){
		this.id=id;
		this.asunto=asunto;
		this.fecha=fecha;
		this.idFormacion=idFormacion;
	}
	
	
	public Vacaciones(String asunto,Date fecha, int idFormacion){
		this.asunto=asunto;
		this.fecha=fecha;
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
	
	
	public Date getFecha() {
		return fecha;
	}
	
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}	
	
	
	
	public int getIdFormacion() {
		return idFormacion;
	}	
	
	
	public void setIdFormacion(int idFormacion) {
		this.idFormacion = idFormacion;
	}
	
	public String getStringFecha(){
		return DateUtils.formatearFecha(fecha);
	}
}
