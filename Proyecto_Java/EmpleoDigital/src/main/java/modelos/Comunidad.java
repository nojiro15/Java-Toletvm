package modelos;

public class Comunidad {

	/**
	 * Identificador de la Comunidad Autonoma
	 */
	private int  id;
	/**
	 * Texto plano del nombre de la comunidad
	 */
	private String slug;
	/**
	 * Nombre de la comunidad con Mayusculas y tildes
	 */
	private String comunidad;
	
	/**
	 * Constructor vacio para el beans
	 */
	public Comunidad(){
		
	}
	
	/**
	 * Constructor con 3 paramentros
	 * @param id: identificador comunidad
	 * @param slug: texto plano comunidad
	 * @param comunidad: Nombre de la comunidad
	 */
	
	public Comunidad(int id, String comunidad,String slug){
		this.id=id;
		this.slug=slug;
		this.comunidad=comunidad;
	}

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

	public String getComunidad() {
		return comunidad;
	}

	public void setComunidad(String comunidad) {
		this.comunidad = comunidad;
	}
	
	
}
