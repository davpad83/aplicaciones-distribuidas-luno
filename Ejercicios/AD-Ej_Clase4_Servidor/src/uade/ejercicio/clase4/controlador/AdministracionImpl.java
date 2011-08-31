package uade.ejercicio.clase4.controlador;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.xml.sax.SAXException;

import uade.ejercicio.clase4.beans.AlumnoBean;
import uade.ejercicio.clase4.beans.DireccionBean;
import uade.ejercicio.clase4.beans.MateriaBean;
import uade.ejercicio.clase4.beans.ProfesorBean;
import uade.ejercicio.clase4.interfaces.IAdministracion;
import uade.ejercicio.clase4.negocio.Alumno;
import uade.ejercicio.clase4.negocio.BaseDeDatos;
import uade.ejercicio.clase4.negocio.Direccion;
import uade.ejercicio.clase4.negocio.Materia;
import uade.ejercicio.clase4.negocio.Profesor;

//import com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator;


public class AdministracionImpl extends UnicastRemoteObject implements IAdministracion {
		
	public AdministracionImpl() throws RemoteException {
		//empty
	}

	@Override
	public void agregarAlumno(AlumnoBean alumno) throws RemoteException{
		Alumno alu = new Alumno(alumno.getLegajo(), alumno.getNombre(), alumno.getEstado());
		if(BaseDeDatos.buscarAlumno(alumno.getLegajo())==null)
			BaseDeDatos.addAlumno(alu);		
	}

	@Override
	public void agregarMateria(MateriaBean materia) throws RemoteException {
		Materia mat = new Materia(materia.getNombre(), materia.getNumero());
		if(BaseDeDatos.buscarMateria(materia.getNumero())==null)
			BaseDeDatos.addMateria(mat);	
	}

	@Override
	public void agregarProfesor(ProfesorBean profesor)throws RemoteException {
//		Profesor prof = null;
//		if(buscarProfesor(numeroLegajo)==null)
//			prof = new Profesor(numeroLegajo, direccion);
//		profesores.add(prof);
	}
//
//	@Override
	public void eliminarAlumno(AlumnoBean alumno) throws RemoteException{
//		
//		Alumno alu = null;
//		if(buscarAlumno(legajo)!= null)
//			alumnos.remove(alu);
	}
//	
//	@Override
	public void eliminarMateria(MateriaBean materia) throws RemoteException{
//		Materia mat = null;
//		if(buscarMateria(numero)!= null)
//			alumnos.remove(mat);		
	}
//
//	@Override
	public void eliminarProfesor(ProfesorBean profesor) throws RemoteException{
//		Profesor prof = null;
//		if(buscarProfesor(numeroLegajo)!= null)
//			alumnos.remove(prof);
	}
	
	@Override
	public boolean exists(Object obj) throws RemoteException{
		return exists(obj);
	}
}
