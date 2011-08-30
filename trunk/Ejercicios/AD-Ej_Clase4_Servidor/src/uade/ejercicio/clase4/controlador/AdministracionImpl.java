package uade.ejercicio.clase4.controlador;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.xml.sax.SAXException;

import uade.ejercicio.clase4.beans.DireccionView;
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
	public void agregarAlumno(int legajo, String nombre, String estado) throws RemoteException{
		Alumno alu = null;
		if(BaseDeDatos.buscarAlumno(legajo)==null)
		BaseDeDatos.addAlumno(alu);		
	}

	@Override
	public void agregarMateria(String nombre, String numero) throws RemoteException {
		Materia mat = null;
		if(BaseDeDatos.buscarMateria(numero)==null)
			mat = new Materia(nombre, numero);
		BaseDeDatos.addMateria(mat);	
	}

	@Override
	public void agregarProfesor(int numeroLegajo, DireccionView direccion)throws RemoteException {
//		Profesor prof = null;
//		if(buscarProfesor(numeroLegajo)==null)
//			prof = new Profesor(numeroLegajo, direccion);
//		profesores.add(prof);
	}
//
//	@Override
	public void eliminarAlumno(int legajo) throws RemoteException{
//		
//		Alumno alu = null;
//		if(buscarAlumno(legajo)!= null)
//			alumnos.remove(alu);
	}
//	
//	@Override
	public void eliminarMateria(String numero) throws RemoteException{
//		Materia mat = null;
//		if(buscarMateria(numero)!= null)
//			alumnos.remove(mat);		
	}
//
//	@Override
	public void eliminarProfesor(int numeroLegajo) throws RemoteException{
//		Profesor prof = null;
//		if(buscarProfesor(numeroLegajo)!= null)
//			alumnos.remove(prof);
	}
	
	@Override
	public boolean exists(Object obj) throws RemoteException{
		return exists(obj);
	}
}
