package uade.ejercicio.clase5.negocio;

import java.util.ArrayList;
import java.util.Iterator;
import uade.ejercicio.clase5.beans.MateriaBean;
import uade.ejercicio.clase5.beans.ProfesorBean;

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
	
	public ProfesorBean toBean(){
		ProfesorBean pb = new ProfesorBean();
		pb.setNumeroLegajo(this.getNumeroLegajo());
		pb.setDireccion(this.getDireccion().toBean());
		toMateriaBeanList(pb);		
		return pb;
	}

	private void toMateriaBeanList(ProfesorBean pb) {
		Materia m=null;
		ArrayList<MateriaBean> mbs = new ArrayList<MateriaBean>();
		for(Iterator<Materia> it = this.vinculado.iterator(); it.hasNext(); m=it.next()){
			mbs.add(m.toBean());
		}
		pb.setVinculado(mbs);
	}

}
