package uade.ejercicio.clase1.negocio;

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

}
