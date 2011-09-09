package uade.ejercicio.clase5.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProfesorBean implements Serializable{
	
	private int numeroLegajo;
	private DireccionBean direccion;
	private ArrayList<MateriaBean> vinculado;
	
	public ProfesorBean() {
	}
	
	public int getNumeroLegajo() {
		return numeroLegajo;
	}

	public DireccionBean getDireccion() {
		return direccion;
	}

	public ArrayList<MateriaBean> getVinculado() {
		return vinculado;
	}

	public void setNumeroLegajo(int numeroLegajo) {
		this.numeroLegajo = numeroLegajo;
	}

	public void setDireccion(DireccionBean direccion) {
		this.direccion = direccion;
	}

	public void setVinculado(ArrayList<MateriaBean> vinculado) {
		this.vinculado = vinculado;
	}
	
	public boolean equals(ProfesorBean profesor){
		return profesor.getNumeroLegajo() == this.numeroLegajo;
	}
}
