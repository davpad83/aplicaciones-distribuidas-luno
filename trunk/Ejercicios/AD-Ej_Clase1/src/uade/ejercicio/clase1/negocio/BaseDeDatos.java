package uade.ejercicio.clase1.negocio;


import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.bind.JAXBException;

import org.xml.sax.SAXException;

import uade.ejercicio.clase1.controlador.IAdministracion;

//import com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator;


public class BaseDeDatos {

	private static ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
	private static ArrayList<Materia> materias = new ArrayList<Materia>();
	private static ArrayList<Profesor> profesores = new ArrayList<Profesor>();	
	private static ArrayList<Curso> cursos = new ArrayList<Curso>();
	
	
	public static boolean exists(Object obj){
		if(obj instanceof Alumno){
			return alumnos.contains(obj);
		}else if(obj instanceof Profesor){
			return profesores.contains(obj);
		}else if(obj instanceof Materia){
			return materias.contains(obj);
		}else if(obj instanceof Curso){
			return cursos.contains(obj);
		}else
			return false;
	}
	
	public static Alumno buscarAlumno(int legajo) {
		
		Alumno alu = null;
		if(!alumnos.isEmpty()){
			for(Iterator<Alumno> it = (Iterator<Alumno>) alumnos.iterator(); it.hasNext(); alu = it.next()){
				if(alu.getLegajo()== legajo)
					return alu;
			}		
		}
		return alu;
	}
	

	public static Materia buscarMateria(String numero) {
		Materia mat = null;
		if(!materias.isEmpty() && materias != null){
			for(Iterator<Materia> it = (Iterator<Materia>) materias.iterator(); it.hasNext(); mat = it.next()){
				if(mat.getNumero()== numero)
					return mat;
			}	
		}
		return mat;
	}
	
	public static Profesor buscarProfesor(int numeroLegajo) {
		Profesor prof = null;
		if(profesores.isEmpty()){
			for(Iterator<Profesor> it = (Iterator<Profesor>) profesores.iterator(); it.hasNext(); prof = it.next()){
				if(prof.getNumeroLegajo()== numeroLegajo)
					return prof;
			}		
		}
		return prof;
	}
	
	public static Curso buscarCurso(int numero) {
		Curso cur = null;
		if(!cursos.isEmpty()){
			for(Iterator<Curso> it = cursos.iterator(); it.hasNext(); cur = it.next()){
				if(cur.getNumero() == numero)
					return cur;
			}		
		}
		return cur;
	}
	
	public static void addAlumno(Alumno a){
		alumnos.add(a);
	}

	public static void addProfesor(Profesor p){
		profesores.add(p);
	}
	
	public static void addMateria(Materia m){
		materias.add(m);
	}
	
	public static void addCurso(Curso c){
		cursos.add(c);
	}
	public static ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public static ArrayList<Materia> getMaterias() {
		return materias;
	}

	public static ArrayList<Profesor> getProfesores() {
		return profesores;
	}

	public static ArrayList<Curso> getCursos() {
		return cursos;
	}
}
