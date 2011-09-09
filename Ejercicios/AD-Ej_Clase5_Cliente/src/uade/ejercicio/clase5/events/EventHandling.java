package uade.ejercicio.clase5.events;

import uade.ejercicio.clase5.beans.DireccionBean;
import uade.ejercicio.clase5.clienteRmi.BusinessDelegate;



public class EventHandling {

	private static final BusinessDelegate cliente = new BusinessDelegate();
	
	public void agregarAlumnoEvent(int legajo, String nombre, String estado) {
		cliente.agregarAlumno(legajo, nombre, estado);
		
	}
	
	public void agregarMateriaEvent(String nombre, String numero) {
		cliente.agregarMateria(nombre, numero);
	}
	
	public void agregarProfesorEvent(int numeroLegajo, DireccionBean direccion) {
	
	}
	
	public void eliminarAlumnoEvent(int legajo) {
	}
	
	public void eliminarMateriaEvent(String numero) {
	}
	
	public void eliminarProfesorEvent(int numeroLegajo) {
	}
}
