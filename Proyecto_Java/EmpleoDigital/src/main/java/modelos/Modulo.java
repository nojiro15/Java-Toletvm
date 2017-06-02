package modelos;

/**
 * 
 * @author JavaToletvm
 *
 */
public class Modulo {
	
	/**
	 * Enumeraci�n Bloque
	 *
	 */
	public enum Bloque{
		/**
		 * 'Bloque' == 0 ==> TRONCAL hace referencia a los m�dulos propios de la formaci�n
		 * 'Bloque' == 1 ==> METODO hace referencia a los m�dulos de Metodolog�as �giles
		 * 'Bloque' == 2 ==> SUMA hace referencia a los m�dulos de Habilidades Personales
		 */
		TRONCAL, METODO, SUMA;
	}
	
	/**Propiedades del objeto M�dulo
	 *  id --Identificador del m�dulo en la base de datos
	 *  nombre --Nombre del m�dulo. Ejemplo: Metodolog�as �giles
	 *  jornadas --N�mero de jornadas que durar� el m�dulo
	 *  horas --N�mero de horas de las que constar� el m�dulo
	 *  horasTutorias --N�mero de horas de tutor�a de las que constar� el m�dulo
	 *  bloque --Bloque al que pertenecer� el m�dulo.
	 */
	private int id;
	private String nombre; 
	private int jornadas; 
	private int horas; 
	private int horasTutorias; 
	private Bloque bloque; 
	
	
	/**
	 * Constructores (vac�o y con propiedades)
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

