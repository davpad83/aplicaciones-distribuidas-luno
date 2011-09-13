package uade.ejercicio.clase5.negocio;


import java.util.ArrayList;
import java.util.Iterator;
import uade.ejercicio.clase5.excepciones.DatabaseException;


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
		}else if(obj instanceof Profesor){
			return materias.contains(obj);
		}else if(obj instanceof Curso){
			return cursos.contains(obj);
		}else
			return false;
	}
	
	public static Alumno buscarAlumno(int legajo) throws DatabaseException{
		Alumno alu = null;
		if(alumnos == null){
			throw new DatabaseException();
		}else{		
			Iterator<Alumno> it = alumnos.iterator();
			while(it.hasNext()){
				 alu = it.next();
				if(alu.getLegajo()== legajo)
					return alu;
			}
		}
		return alu;
	}
	

	public static Materia buscarMateria(String numero) throws DatabaseException{
		Materia mat = null;
		if(materias == null){
			throw new DatabaseException();
		}else{		
			Iterator<Materia> it = materias.iterator();
			while(it.hasNext()){
				 mat = it.next();
				if(mat.getNumero()== numero)
					return mat;
			}
		}
		return mat;
	}
	
	public static Profesor buscarProfesor(int numeroLegajo) throws DatabaseException{
		Profesor prof = null;
		if(materias == null){
			throw new DatabaseException();
		}else{		
			Iterator<Profesor> it = profesores.iterator();
			while(it.hasNext()){
				 prof = it.next();
				if(prof.getNumeroLegajo()== numeroLegajo)
					return prof;
			}
		}
		return prof;
	}
	
	public static Curso buscarCurso(int numero) throws DatabaseException{
		Curso cur = null;
		if(materias == null){
			throw new DatabaseException();
		}else{		
			Iterator<Curso> it = cursos.iterator();
			while(it.hasNext()){
				 cur = it.next();
				if(cur.getNumero()== numero)
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
	
	public static void removerAlumno(Alumno a){
		alumnos.remove(a);
	}
	
	public static void removerProfesor(Profesor p){
		profesores.remove(p);
	}
	
	public static void removerMateria(Materia m){
		materias.remove(m);
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
