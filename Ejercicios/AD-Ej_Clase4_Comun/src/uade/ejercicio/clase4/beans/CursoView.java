package uade.ejercicio.clase4.beans;

import java.util.ArrayList;
import java.util.List;

public class CursoView {
	
	private int numero;
	private ProfesorView profesor;
	private MateriaView materia;
	private int capacidad;
	private ArrayList<AlumnoView> alumnos;
	
	public CursoView(int numero, ProfesorView profesor, MateriaView materia, int capacidad,
			ArrayList<AlumnoView> alumnos) {
		this.numero = numero;
		this.profesor = profesor;
		this.materia = materia;
		this.capacidad = capacidad;
		this.alumnos = alumnos;
	}
	
	public int getNumero() {
		return numero;
	}
	public ProfesorView getProfesor() {
		return profesor;
	}
	public MateriaView getMateria() {
		return materia;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public ArrayList<AlumnoView> getAlumnos() {
		return alumnos;
	}
}
