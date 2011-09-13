package uade.ejercicio.clase5.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import uade.ejercicio.clase5.beans.AlumnoBean;
import uade.ejercicio.clase5.beans.CursoBean;
import uade.ejercicio.clase5.beans.MateriaBean;
import uade.ejercicio.clase5.beans.ProfesorBean;



public interface IConsultas extends Remote{
	
	public ArrayList<AlumnoBean> listarAlumnos() throws RemoteException;
	
	public ArrayList<AlumnoBean> listarAlumnosCurso(int numCurso) throws RemoteException;
	
	public ArrayList<ProfesorBean> listarProfesores() throws RemoteException;
	
	public ArrayList<MateriaBean> listarMateriasProfesor(int legajo) throws RemoteException;
	
	public ArrayList<MateriaBean> listarMaterias() throws RemoteException;
	
	public ArrayList<CursoBean> listarCursos() throws RemoteException;
	
	public AlumnoBean mostrarAlumnoPorClave(int legajo) throws RemoteException;
	
//	public Alumno mostrarAlumno(String nombre, String estado) throws RemoteException;
	
	public CursoBean mostrarCursoPorClave(int numCurso) throws RemoteException;
	
//	public Curso mostrarCurso(int numCurso) throws RemoteException;
	
	public ProfesorBean mostrarProfesorPorClave(int legajo) throws RemoteException;
	
//	public Profesor mostrarProfesor(int legajo) throws RemoteException;
	
	public MateriaBean mostrarMateriaPorClave(String numero) throws RemoteException;
	
//	public Materia mostrarMateria(String numero) throws RemoteException;

}
