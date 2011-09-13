package uade.ejercicio.clase5.beans;

import java.io.Serializable;

public class MateriaBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5569231673088533311L;
	private String nombre;
	private String numero;
		
	public MateriaBean() {
		//empty
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getNumero() {
		return numero;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public boolean equals(MateriaBean materia){
		return materia.getNumero() == this.numero;
	}
	
	public String toString(){
		return "Nombre de Materia: "+nombre+"\nNumero de Materia: "+numero;
	}
	
	
}
