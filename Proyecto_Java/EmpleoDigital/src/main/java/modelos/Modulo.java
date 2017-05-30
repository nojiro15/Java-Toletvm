package modelos;

public class Modulo {
	
	//Enumeración Bloque
	public enum Bloque{
		TRONCAL, METODOLOGIAS, HABILIDADES;
	}
	
	//Propiedades del objeto Módulo
	private int id; //Identificador del módulo en la base de datos
	private String nombre; //Nombre del módulo. Ejemplo: Metodologías Ágiles
	private int jornadas; //Número de jornadas que durará el módulo
	private int horas; //Número de horas de las que constará el módulo
	private int horasTutorias; //Número de horas de tutoría de las que constará el módulo
	private Bloque bloque; //Bloque al que pertenecerá el módulo.
	
	
	//Constructores (vacío y con propiedades)
	public Modulo(){}
	
	public Modulo(int id, String nombre, int jornadas, int horas, int horasTutoria, Bloque bloque){
		this.id = id;
		this.nombre = nombre;
		this.horas = horas;
		this.horasTutorias = horasTutoria;
		this.bloque = bloque;
	}
	
	
	//Getters
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
	
	//Setters
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

