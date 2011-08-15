package uade.ejercicio.clase1.negocio;

import java.util.ArrayList;
import java.util.List;

public class Curso {
	
	private int numero;
	private Profesor profesor;
	private Materia materia;
	private int capacidad;
	private ArrayList<Alumno> alumnos;
	
	public Curso(int numero, Profesor profesor, Materia materia, int capacidad,
			ArrayList<Alumno> alumnos) {
		this.numero = numero;
		this.profesor = profesor;
		this.materia = materia;
		this.capacidad = capacidad;
		this.alumnos = alumnos;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
}
