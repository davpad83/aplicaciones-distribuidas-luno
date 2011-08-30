package uade.ejercicio.clase4.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import uade.ejercicio.clase4.beans.DireccionView;
import uade.ejercicio.clase4.beans.MateriaView;


public interface IAdministracion extends Remote {
	
	
	public void agregarAlumno(int legajo, String nombre, String estado) throws RemoteException;
	
	public void agregarMateria(String nombre, String numero) throws RemoteException;
	
	public void agregarProfesor(int numeroLegajo, DireccionView direccion) throws RemoteException;
	
	public void eliminarAlumno(int legajo) throws RemoteException;
	
	public void eliminarMateria(String numero) throws RemoteException;
	
	public void eliminarProfesor(int numeroLegajo) throws RemoteException;
	
	public boolean exists(Object obj) throws RemoteException;
}
