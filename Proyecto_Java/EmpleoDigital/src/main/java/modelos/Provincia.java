package modelos;

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
	private int comunidadId;
	
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
	
	public Provincia(int id,String slug, String provincia, int comunidadId){
		
		this.id=id;
		this.slug=slug;
		this.provincia=provincia;
		this.comunidadId=comunidadId;
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

	public int getComunidadId() {
		return comunidadId;
	}

	public void setComunidadId(int comunidadId) {
		this.comunidadId = comunidadId;
	}
	
	
}
