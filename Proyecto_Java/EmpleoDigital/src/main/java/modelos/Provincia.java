package modelos;

import javax.json.Json;
import javax.json.JsonObjectBuilder;

public class Provincia {

	/**
	 * Identificador de provincia
	 */
	private int id;
	/**
	 * Nombre provincia en texto plano
	 */
	private String slug;
	/**
	 * Nombre provincia con formato
	 */
	private String provincia;
	/**
	 * Codigo de la comunidad al que pertenece la provincia
	 */
	private int idComunidad;
	
	/**
	 * Constructor vacio para el beans
	 */
	
	public Provincia(){
		
	}
	
	/**
	 * Constructor con 4 parametros
	 * @param id: id de l provinca
	 * @param slug: texto plano provincias
	 * @param provincia: Texto provincias con mayusculas y tildes
	 * @param comunidadId: identificador de la comunidad
	 */
	
	public Provincia(int id,String slug, String provincia, int idComunidad){
		
		this.id=id;
		this.slug=slug;
		this.provincia=provincia;
		this.idComunidad=idComunidad;
	}
	
	/*
	 * Getters y Setters
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int getIdComunidad() {
		return idComunidad;
	}

	public void setIdComunidad(int idComunidad) {
		this.idComunidad = idComunidad;
	}
	/**
	 * Metedo para trabajar con Json
	 * @return
	 */
	public JsonObjectBuilder toJson(){
		JsonObjectBuilder jb2=Json.createObjectBuilder();
		jb2=jb2.add("idComunidad", idComunidad).add("provincia",provincia).
				add("id",id).add("slug",slug);
				
				
			return jb2;
	}
	
}
