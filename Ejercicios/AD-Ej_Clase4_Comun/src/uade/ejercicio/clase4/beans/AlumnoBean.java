package uade.ejercicio.clase4.beans;

import java.io.Serializable;

public class AlumnoBean implements Serializable{

	private int legajo;
	private String nombre;
	private String estado;
	
	public AlumnoBean() {
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

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public boolean equals(AlumnoBean alumno){
		return alumno.getLegajo() == this.legajo;
	}
}
