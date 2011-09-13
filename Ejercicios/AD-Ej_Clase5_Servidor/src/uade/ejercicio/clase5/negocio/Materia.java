package uade.ejercicio.clase5.negocio;

import uade.ejercicio.clase5.beans.MateriaBean;

public class Materia {
	
	private String nombre;
	private String numero;
		
	public Materia(String nombre, String numero) {
		
		this.nombre = nombre;
		this.numero = numero;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public MateriaBean toBean(){
		MateriaBean mb = new MateriaBean();
		mb.setNombre(this.getNombre());
		mb.setNumero(this.getNumero());
		return mb;
	}

}
