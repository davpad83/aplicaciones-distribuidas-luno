package uade.ejercicio.clase1.vista;

public class MateriaView {
	
	private String nombre;
	private String numero;
		
	public MateriaView(String nombre, String numero) {
		
		this.nombre = nombre;
		this.numero = numero;
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getNumero() {
		return numero;
	}
}
