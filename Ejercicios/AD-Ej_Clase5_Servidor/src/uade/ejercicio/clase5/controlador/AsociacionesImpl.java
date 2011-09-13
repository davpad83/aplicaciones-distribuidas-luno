package uade.ejercicio.clase5.controlador;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import uade.ejercicio.clase5.interfaces.IAsociaciones;
import uade.ejercicio.clase5.negocio.Alumno;
import uade.ejercicio.clase5.negocio.BaseDeDatos;
import uade.ejercicio.clase5.negocio.Curso;
import uade.ejercicio.clase5.negocio.Materia;
import uade.ejercicio.clase5.negocio.Profesor;
import uade.ejercicio.clase5.beans.AlumnoBean;
import uade.ejercicio.clase5.beans.CursoBean;
import uade.ejercicio.clase5.beans.MateriaBean;
import uade.ejercicio.clase5.beans.ProfesorBean;

public class AsociacionesImpl extends UnicastRemoteObject implements IAsociaciones{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5475258042101376470L;

	public AsociacionesImpl() throws RemoteException {
		//empty
	}

	public void asignarAlumnoCurso(CursoBean curso, AlumnoBean alumno) throws RemoteException{
		
		
	}

	public void asignarMateriaProfesor(MateriaBean materia, ProfesorBean profesor) throws RemoteException{
		
	}

	public void eliminarCurso(CursoBean curso) throws RemoteException{
		
	}

	public void nuevoCurso(MateriaBean materia, ProfesorBean profesor,
			int cantidadMaxima) throws RemoteException{
		
		
	}

}
