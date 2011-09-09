package uade.ejercicio.clase5.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CursoBean implements Serializable{
	
	private int numero;
	private ProfesorBean profesor;
	private MateriaBean materia;
	private int capacidad;
	private ArrayList<AlumnoBean> alumnos;
	
	public CursoBean(int numero, ProfesorBean profesor, MateriaBean materia, int capacidad,
			ArrayList<AlumnoBean> alumnos) {
		this.numero = numero;
		this.profesor = profesor;
		this.materia = materia;
		this.capacidad = capacidad;
		this.alumnos = alumnos;
	}
	
	public int getNumero() {
		return numero;
	}
	public ProfesorBean getProfesor() {
		return profesor;
	}
	public MateriaBean getMateria() {
		return materia;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public ArrayList<AlumnoBean> getAlumnos() {
		return alumnos;
	}
}
