package uade.ejercicio.clase5.controlador;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import uade.ejercicio.clase5.interfaces.IConsultas;
import uade.ejercicio.clase5.negocio.Alumno;
import uade.ejercicio.clase5.negocio.BaseDeDatos;
import uade.ejercicio.clase5.negocio.Curso;
import uade.ejercicio.clase5.negocio.Materia;
import uade.ejercicio.clase5.negocio.Profesor;
import uade.ejercicio.clase5.beans.AlumnoBean;
import uade.ejercicio.clase5.beans.CursoBean;
import uade.ejercicio.clase5.beans.MateriaBean;
import uade.ejercicio.clase5.beans.ProfesorBean;
import uade.ejercicio.clase5.excepciones.DatabaseException;


public class ConsultasImpl extends UnicastRemoteObject implements IConsultas {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4750879557760968670L;

	public ConsultasImpl() throws RemoteException {
		//empty	
	}

	public ArrayList<AlumnoBean> listarAlumnos() throws RemoteException{
		ArrayList<Alumno> a = BaseDeDatos.getAlumnos();
		return Converciones.alumnosToAlumnoBeanList(a);
	}

	public ArrayList<AlumnoBean> listarAlumnosCurso(int numCurso) throws RemoteException{
		
		CursoBean c = mostrarCursoPorClave(numCurso);
		return c.getAlumnos();
	}

	public ArrayList<ProfesorBean> listarProfesores() throws RemoteException {
//		return BaseDeDatos.getProfesores();
		return null;
	}

	public ArrayList<MateriaBean> listarMateriasProfesor(int legajo) throws RemoteException{
		ProfesorBean p = mostrarProfesorPorClave(legajo);
		return p.getVinculado();
	}

	public ArrayList<MateriaBean> listarMaterias() throws RemoteException{
//		return BaseDeDatos.getMaterias();
		return null;

	}

	public ArrayList<CursoBean> listarCursos() throws RemoteException {
//		return BaseDeDatos.getCursos();
		return null;

	}

	public AlumnoBean mostrarAlumnoPorClave(int legajo) throws RemoteException{
		Alumno alumno = null;
		try {
			alumno = BaseDeDatos.buscarAlumno(legajo);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		return alumno.toBean();
	}

	public CursoBean mostrarCursoPorClave(int numCurso) throws RemoteException{
		Curso curso = null;
		try {
			curso = BaseDeDatos.buscarCurso(numCurso);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		return curso.toBean();
	}

	public ProfesorBean mostrarProfesorPorClave(int legajo) throws RemoteException {
		Profesor profesor = null;
		try {
			profesor = BaseDeDatos.buscarProfesor(legajo);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		return profesor.toBean();

	}

	public MateriaBean mostrarMateriaPorClave(String numero) throws RemoteException{
		Materia materia = null;
		try {
			materia = BaseDeDatos.buscarMateria(numero);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		return materia.toBean();
	}

}
