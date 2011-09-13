package uade.ejercicio.clase5.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CursoBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4878136248485820123L;
	private int numero;
	private ProfesorBean profesor;
	private MateriaBean materia;
	private int capacidad;
	private ArrayList<AlumnoBean> alumnos;
	
	public CursoBean() {
		//empty
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
	
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setProfesor(ProfesorBean profesor) {
		this.profesor = profesor;
	}

	public void setMateria(MateriaBean materia) {
		this.materia = materia;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public void setAlumnos(ArrayList<AlumnoBean> alumnos) {
		this.alumnos = alumnos;
	}

	public boolean equals(CursoBean c){
		return this.numero == c.getNumero();
	}
	
	public String toString(){
		return "Numero de Curso: "+numero+"\nProfesor: \n"+profesor.toString()+"\nMateria:\n" + 
		materia.toString()+"\nCapacidad: "+capacidad +"\nAlumnos:\n"+ alumnos.toString();
	}
}
