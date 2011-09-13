package uade.ejercicio.clase5.events;

import java.util.ArrayList;

import uade.ejercicio.clase5.beans.AlumnoBean;
import uade.ejercicio.clase5.beans.DireccionBean;
import uade.ejercicio.clase5.clienteRmi.BusinessDelegate;

public class EventHandling {

	private static final BusinessDelegate cliente = new BusinessDelegate();
	
	public void agregarAlumnoEvent(int legajo, String nombre, String estado) {
		AlumnoBean alumno = new AlumnoBean();
		alumno.setLegajo(legajo);
		alumno.setNombre(nombre);
		alumno.setEstado(estado);
		
		cliente.agregarAlumno(alumno);
	}
	
	public void agregarMateriaEvent(String nombre, String numero) {
		cliente.agregarMateria(nombre, numero);
	}
	
	public void agregarProfesorEvent(int numeroLegajo, DireccionBean direccion) {
		cliente.agregarProfesor(numeroLegajo, direccion);
	}
	
	public void eliminarAlumnoEvent(int legajo) {
		cliente.eliminarAlumnoEvent(legajo);
	}
	
	public void eliminarMateriaEvent(String numero) {
		cliente.eliminarMateriaEvent(numero);
	}
	
	public void eliminarProfesorEvent(int numeroLegajo) {
		cliente.eliminarProfesorEvent(numeroLegajo);
	}
	
	public AlumnoBean obtenerAlumno(int legajo){
		return cliente.obtenerAlumno(legajo);
	}
	
	public ArrayList<AlumnoBean> listarAlumnos(){
		return cliente.listarAlumnos();
	}
}
