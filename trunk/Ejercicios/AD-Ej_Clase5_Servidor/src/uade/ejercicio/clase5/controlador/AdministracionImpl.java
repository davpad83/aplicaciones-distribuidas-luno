package uade.ejercicio.clase5.controlador;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import uade.ejercicio.clase5.beans.AlumnoBean;
import uade.ejercicio.clase5.beans.MateriaBean;
import uade.ejercicio.clase5.beans.ProfesorBean;
import uade.ejercicio.clase5.excepciones.DatabaseException;
import uade.ejercicio.clase5.interfaces.IAdministracion;
import uade.ejercicio.clase5.negocio.Alumno;
import uade.ejercicio.clase5.negocio.BaseDeDatos;
import uade.ejercicio.clase5.negocio.Materia;
import uade.ejercicio.clase5.negocio.Profesor;


public class AdministracionImpl extends UnicastRemoteObject implements IAdministracion {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 5713642679890457376L;

	public AdministracionImpl() throws RemoteException {
		//empty
	}

	@Override
	public void agregarAlumno(AlumnoBean alumno) throws RemoteException{
		Alumno alu = Converciones.alumnoBeanToAlumno(alumno);
		try {
			if(BaseDeDatos.buscarAlumno(alumno.getLegajo())==null)
				BaseDeDatos.addAlumno(alu);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}		
	}


	@Override
	public void agregarMateria(MateriaBean materia) throws RemoteException {
		Materia mat = Converciones.materiaBeanToMateria(materia);
		try {
			if(BaseDeDatos.buscarMateria(materia.getNumero())==null)
				BaseDeDatos.addMateria(mat);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}	
	}


	@Override
	public void agregarProfesor(ProfesorBean profesor)throws RemoteException {
		Profesor profe = Converciones.profesorBeanToProfesor(profesor);
		try {
			if(BaseDeDatos.buscarProfesor(profe.getNumeroLegajo())==null)
				BaseDeDatos.addProfesor(profe);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void eliminarAlumno(AlumnoBean alumno) throws RemoteException{
		Alumno alu = Converciones.alumnoBeanToAlumno(alumno);
		try {
			if(BaseDeDatos.buscarAlumno(alu.getLegajo())!= null)
				BaseDeDatos.removerAlumno(alu);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}	
	}
	
	@Override
	public void eliminarMateria(MateriaBean materia) throws RemoteException{
		Materia mate = Converciones.materiaBeanToMateria(materia);
		try {
			if(BaseDeDatos.buscarMateria(mate.getNumero())!= null)
				BaseDeDatos.removerMateria(mate);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void eliminarProfesor(ProfesorBean profesor) throws RemoteException{
		Profesor profe = Converciones.profesorBeanToProfesor(profesor);
		try {
			if(BaseDeDatos.buscarProfesor(profe.getNumeroLegajo())!= null)
				BaseDeDatos.removerProfesor(profe);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean exists(Object obj) throws RemoteException{
		return exists(obj);
	}
}
