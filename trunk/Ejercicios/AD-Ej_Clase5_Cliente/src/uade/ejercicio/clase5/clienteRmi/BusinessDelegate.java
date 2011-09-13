package uade.ejercicio.clase5.clienteRmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import uade.ejercicio.clase5.beans.AlumnoBean;
import uade.ejercicio.clase5.beans.DireccionBean;
import uade.ejercicio.clase5.beans.MateriaBean;
import uade.ejercicio.clase5.beans.ProfesorBean;
import uade.ejercicio.clase5.interfaces.IAdministracion;
import uade.ejercicio.clase5.interfaces.IAsociaciones;
import uade.ejercicio.clase5.interfaces.IConsultas;

public class BusinessDelegate {

	private IAdministracion admin;
	private IConsultas consultas;
	private IAsociaciones asociaciones;
	
	public BusinessDelegate(){
	}
	
	private boolean conecto(){
		try {
			admin= (IAdministracion) Naming.lookup("//localhost/admin");
			consultas = (IConsultas) Naming.lookup("//localhost/consultas");
			asociaciones = (IAsociaciones) Naming.lookup("//localhost/asociaciones");
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void agregarAlumno(AlumnoBean alumno){
		if(conecto()){
			try {
				admin.agregarAlumno(alumno);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void agregarMateria(String nombre, String numero){
		if(conecto()){
			try {
				MateriaBean materia = new MateriaBean();
				materia.setNombre(nombre);
				materia.setNumero(numero);
				
				admin.agregarMateria(materia);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void agregarProfesor(int numeroLegajo, DireccionBean direccion){
		if(conecto()){
			try {
				ProfesorBean profesor = new ProfesorBean();
				profesor.setNumeroLegajo(numeroLegajo);
				profesor.setDireccion(direccion);	
				
				admin.agregarProfesor(profesor);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void eliminarAlumnoEvent(int legajo) {
		if(conecto()){
			try {
				AlumnoBean alumno = new AlumnoBean();
				alumno.setLegajo(legajo);
				
				admin.eliminarAlumno(alumno);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void eliminarMateriaEvent(String numero) {
		if(conecto()){
			try {
				MateriaBean materia = new MateriaBean();
				materia.setNumero(numero);
				admin.eliminarMateria(materia);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void eliminarProfesorEvent(int numeroLegajo) {
		if(conecto()){
			try {
				ProfesorBean profesor = new ProfesorBean();
				profesor.setNumeroLegajo(numeroLegajo);
				admin.eliminarProfesor(profesor);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public AlumnoBean obtenerAlumno(int legajo){
		AlumnoBean alumno = new AlumnoBean();
		if(conecto()){
			try {
				alumno = consultas.mostrarAlumnoPorClave(legajo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return alumno;
	}
	
	public ArrayList<AlumnoBean> listarAlumnos(){
		ArrayList<AlumnoBean> alumnos = new ArrayList<AlumnoBean>();
		if(conecto()){
			try{
				alumnos = consultas.listarAlumnos();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return alumnos;
	}
	
}

