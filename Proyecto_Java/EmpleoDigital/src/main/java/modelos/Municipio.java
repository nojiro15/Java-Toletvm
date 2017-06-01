package modelos;

public class Municipio {

	/**
	 * Idendificador de la provincia al que pertenece el municipio
	 */
	private int provinciaId;
	/**
	 * Nombre del municipio, contiene mayusculas, tildes y caracteres.
	 */
	
	private String municipio;
	
	/**
	 * Identificador del municipio
	 */
	
	private int id;
	
	/**
	 * slug es el nombre el municipio en texto plano.
	 */
	
	private String slug;
	
	
	/**
	 * Constructor vacio para el beans
	 */
	
	public Municipio(){
		
	}
	
	/**
	 * Constructor con 4 parametros
	 * @param provinciaId: Id pronvincia
	 * @param municipio: Municipio con acentos y mayusculas
	 * @param id: Identificador del municipio
	 * @param slug: Nombre del municipio en texto plano
	 */
	public Municipio(int provinciaId, String municipio, int id, String slug){
		this.provinciaId=provinciaId;
		this.municipio=municipio;
		this.id=id;
		this.slug=slug;
	}

	//Getters y Setters
	public int getProvinciaId() {
		return provinciaId;
	}

	public void setProvinciaId(int provinciaId) {
		this.provinciaId = provinciaId;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
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
	
	
	
}
