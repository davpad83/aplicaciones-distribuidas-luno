package uade.ejercicio.clase5.negocio;

import uade.ejercicio.clase5.beans.AlumnoBean;

public class Alumno {

	private int legajo;
	private String nombre;
	private String estado;
	
	public Alumno(int legajo, String nombre, String estado) {
		this.legajo = legajo;
		this.nombre = nombre;
		this.estado = estado;
	}
	
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public AlumnoBean toBean(){
		AlumnoBean ab = new AlumnoBean();
		ab.setEstado(this.getEstado());
		ab.setLegajo(this.getLegajo());
		ab.setNombre(this.getNombre());
		return ab;
	}
	
	
}
