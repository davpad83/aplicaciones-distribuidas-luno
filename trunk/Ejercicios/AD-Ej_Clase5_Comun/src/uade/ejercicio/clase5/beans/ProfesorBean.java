package uade.ejercicio.clase5.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProfesorBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 543218957718634476L;
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
	
	public String toString(){
		return "Numero de legajo: "+numeroLegajo+"\n"+direccion.toString()+
				"\nMaterias que dicta: \n"+vinculado.toString();
	}
}
