package modelos;

/**
 * 
 * @author JavaToletvm
 *
 */
public class Modulo {
	
	/**
	 * Enumeración Bloque
	 *
	 */
	public enum Bloque{
		/**
		 * 'Bloque' == 0 ==> TRONCAL hace referencia a los módulos propios de la formación
		 * 'Bloque' == 1 ==> METODO hace referencia a los módulos de Metodologías Ágiles
		 * 'Bloque' == 2 ==> SUMA hace referencia a los módulos de Habilidades Personales
		 */
		TRONCAL, METODO, SUMA;
	}
	
	/**Propiedades del objeto Módulo
	 *  id --Identificador del módulo en la base de datos
	 *  nombre --Nombre del módulo. Ejemplo: Metodologías Ágiles
	 *  jornadas --Número de jornadas que durará el módulo
	 *  horas --Número de horas de las que constará el módulo
	 *  horasTutorias --Número de horas de tutoría de las que constará el módulo
	 *  bloque --Bloque al que pertenecerá el módulo.
	 */
	private int id;
	private String nombre; 
	private int jornadas; 
	private int horas; 
	private int horasTutorias; 
	private Bloque bloque; 
	
	
	/**
	 * Constructores (vacío y con propiedades)
	 */
	public Modulo(){}
	
	public Modulo(String nombre, int jornadas, int horas, int horasTutoria, Bloque bloque){
		this.nombre = nombre;
		this.horas = horas;
		this.horasTutorias = horasTutoria;
		this.bloque = bloque;
	}
	
	public Modulo(int id, String nombre, int jornadas, int horas, int horasTutoria, Bloque bloque){
		this.id = id;
		this.nombre = nombre;
		this.horas = horas;
		this.horasTutorias = horasTutoria;
		this.bloque = bloque;
	}
	
	
	/**
	 * Getters
	 */
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public int getJornadas() {
		return jornadas;
	}
	public int getHoras() {
		return horas;
	}
	public int getHorasTutorias() {
		return horasTutorias;
	}
	public Bloque getBloque() {
		return bloque;
	}
	
	/**
	 * Setters
	 */
	public void setId(int id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setJornadas(int jornadas) {
		this.jornadas = jornadas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public void setHorasTutorias(int horasTutorias) {
		this.horasTutorias = horasTutorias;
	}
	public void setBloque(Bloque bloque) {
		this.bloque = bloque;
	}
	
	
	
}

