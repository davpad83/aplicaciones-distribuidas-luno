package uade.ejercicio.clase1.vista;

import java.util.ArrayList;
import java.util.List;

public class ProfesorView {
	
	private int numeroLegajo;
	private DireccionView direccion;
	private ArrayList<MateriaView> vinculado;
	
	public ProfesorView(int numeroLegajo, DireccionView direccion) {
		this.numeroLegajo = numeroLegajo;
		this.direccion = direccion;
	}
	
	public ProfesorView(int numeroLegajo, DireccionView direccion,
			ArrayList<MateriaView> vinculado) {
		this.numeroLegajo = numeroLegajo;
		this.direccion = direccion;
		this.vinculado = vinculado;
	}

	public int getNumeroLegajo() {
		return numeroLegajo;
	}

	public DireccionView getDireccion() {
		return direccion;
	}

	public ArrayList<MateriaView> getVinculado() {
		return vinculado;
	}
}
