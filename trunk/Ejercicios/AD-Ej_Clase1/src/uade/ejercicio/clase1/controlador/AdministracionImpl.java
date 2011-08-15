package uade.ejercicio.clase1.controlador;

import java.util.List;

import javax.xml.bind.JAXBException;

import org.xml.sax.SAXException;

import uade.ejercicio.clase1.negocio.Alumno;
import uade.ejercicio.clase1.negocio.BaseDeDatos;
import uade.ejercicio.clase1.negocio.Direccion;
import uade.ejercicio.clase1.negocio.Materia;
import uade.ejercicio.clase1.negocio.Profesor;

//import com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator;


public class AdministracionImpl implements IAdministracion {
		
	@Override
	public void agregarAlumno(int legajo, String nombre, String estado){
		Alumno alu = null;
		if(BaseDeDatos.buscarAlumno(legajo)==null)
		BaseDeDatos.addAlumno(alu);		
	}

	@Override
	public void agregarMateria(String nombre, String numero) {
		Materia mat = null;
		if(BaseDeDatos.buscarMateria(numero)==null)
			mat = new Materia(nombre, numero);
		BaseDeDatos.addMateria(mat);	
	}

	@Override
	public void agregarProfesor(int numeroLegajo, Direccion direccion) {
//		Profesor prof = null;
//		if(buscarProfesor(numeroLegajo)==null)
//			prof = new Profesor(numeroLegajo, direccion);
//		profesores.add(prof);
	}
//
//	@Override
	public void eliminarAlumno(int legajo) {
//		
//		Alumno alu = null;
//		if(buscarAlumno(legajo)!= null)
//			alumnos.remove(alu);
	}
//	
//	@Override
	public void eliminarMateria(String numero) {
//		Materia mat = null;
//		if(buscarMateria(numero)!= null)
//			alumnos.remove(mat);		
	}
//
//	@Override
	public void eliminarProfesor(int numeroLegajo) {
//		Profesor prof = null;
//		if(buscarProfesor(numeroLegajo)!= null)
//			alumnos.remove(prof);
	}
	
	@Override
	public boolean exists(Object obj){
		return exists(obj);
	}
}
