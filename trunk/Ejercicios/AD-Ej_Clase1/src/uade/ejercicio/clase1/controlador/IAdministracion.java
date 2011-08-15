package uade.ejercicio.clase1.controlador;

import java.util.List;

import uade.ejercicio.clase1.negocio.Direccion;
import uade.ejercicio.clase1.negocio.Materia;


public interface IAdministracion {
	
	public void agregarAlumno(int legajo, String nombre, String estado);
	
	public void agregarMateria(String nombre, String numero);
	
	public void agregarProfesor(int numeroLegajo, Direccion direccion);
	
	public void eliminarAlumno(int legajo);
	
	public void eliminarMateria(String numero);
	
	public void eliminarProfesor(int numeroLegajo);
	
	public boolean exists(Object obj);

}
