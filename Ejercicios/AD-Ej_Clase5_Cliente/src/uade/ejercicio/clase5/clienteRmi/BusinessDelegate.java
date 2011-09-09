package uade.ejercicio.clase5.clienteRmi;

import java.rmi.Naming;
import java.rmi.RemoteException;

import uade.ejercicio.clase5.beans.AlumnoBean;
import uade.ejercicio.clase5.beans.MateriaBean;
import uade.ejercicio.clase5.interfaces.IAdministracion;

public class BusinessDelegate {

	private IAdministracion admin;
	
	public BusinessDelegate(){
	}
	
	private boolean conecto(){
		try {
			admin= (IAdministracion) Naming.lookup("//localhost/admin");
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void agregarAlumno(int legajo, String nombre, String estado){
		if(conecto()){
			try {
				AlumnoBean alumno = new AlumnoBean();
				alumno.setLegajo(legajo);
				alumno.setNombre(nombre);
				alumno.setEstado(estado);
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
	
}
