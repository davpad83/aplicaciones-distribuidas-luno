package uade.ejercicio.clase4.beans;

public class AlumnoView {

	private int legajo;
	private String nombre;
	private String estado;
	
	public AlumnoView(int legajo, String nombre, String estado) {
		this.legajo = legajo;
		this.nombre = nombre;
		this.estado = estado;
	}
	
	public int getLegajo() {
		return legajo;
	}
	public String getNombre() {
		return nombre;
	}
	public String getEstado() {
		return estado;
	}
}
