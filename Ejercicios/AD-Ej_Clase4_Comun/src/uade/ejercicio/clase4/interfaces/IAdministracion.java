package uade.ejercicio.clase4.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import uade.ejercicio.clase4.beans.AlumnoBean;
import uade.ejercicio.clase4.beans.DireccionBean;
import uade.ejercicio.clase4.beans.MateriaBean;
import uade.ejercicio.clase4.beans.ProfesorBean;


public interface IAdministracion extends Remote {
	
	
	public void agregarAlumno(AlumnoBean alumno) throws RemoteException;
	
	public void agregarMateria(MateriaBean materia) throws RemoteException;
	
	public void agregarProfesor(ProfesorBean profesor) throws RemoteException;
	
	public void eliminarAlumno(AlumnoBean alumno) throws RemoteException;
	
	public void eliminarMateria(MateriaBean materia) throws RemoteException;
	
	public void eliminarProfesor(ProfesorBean profesor) throws RemoteException;
	
	public boolean exists(Object obj) throws RemoteException;
}
