package uade.ejercicio.clase4.negocio;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
	
	private int numeroLegajo;
	private Direccion direccion;
	private ArrayList<Materia> vinculado;
	
	public Profesor(int numeroLegajo, Direccion direccion) {
		this.numeroLegajo = numeroLegajo;
		this.direccion = direccion;
	}
	
	public Profesor(int numeroLegajo, Direccion direccion,
			ArrayList<Materia> vinculado) {
		this.numeroLegajo = numeroLegajo;
		this.direccion = direccion;
		this.vinculado = vinculado;
	}

	public void agregarMateria(Materia materia){
		//completar metodo
	}

	public int getNumeroLegajo() {
		return numeroLegajo;
	}

	public void setNumeroLegajo(int numeroLegajo) {
		this.numeroLegajo = numeroLegajo;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public ArrayList<Materia> getVinculado() {
		return vinculado;
	}

	public void setVinculado(ArrayList<Materia> vinculado) {
		this.vinculado = vinculado;
	}

}
