package uade.ejercicio.clase5.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import uade.ejercicio.clase5.beans.AlumnoBean;
import uade.ejercicio.clase5.beans.CursoBean;
import uade.ejercicio.clase5.beans.MateriaBean;
import uade.ejercicio.clase5.beans.ProfesorBean;


public interface IAsociaciones extends Remote {
	
	public void nuevoCurso(MateriaBean materia, ProfesorBean profesor, int cantidadMaxima) throws RemoteException;
	
	public void eliminarCurso(CursoBean curso) throws RemoteException;
	
	public void asignarAlumnoCurso(CursoBean curso, AlumnoBean alumno) throws RemoteException;
	
	public void asignarMateriaProfesor(MateriaBean materia, ProfesorBean profesor) throws RemoteException;

}
