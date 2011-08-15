package uade.ejercicio.clase1.controlador;

import java.util.ArrayList;
import java.util.List;

import uade.ejercicio.clase1.negocio.Alumno;
import uade.ejercicio.clase1.negocio.Curso;
import uade.ejercicio.clase1.negocio.Materia;
import uade.ejercicio.clase1.negocio.Profesor;
import uade.ejercicio.clase1.vista.AlumnoView;



public interface IConsultas {
	
	public ArrayList<Alumno> listarAlumnos();
	
	public ArrayList<Alumno> listarAlumnosCurso(int numCurso);
	
	public ArrayList<Profesor> listarProfesores();
	
	public ArrayList<Materia> listarMateriasProfesor(int legajo);
	
	public ArrayList<Materia> listarMaterias();
	
	public ArrayList<Curso> listarCursos();
	
	public AlumnoView mostrarAlumnoPorClave(int legajo);
	
//	public Alumno mostrarAlumno(String nombre, String estado);
	
	public Curso mostrarCursoPorClave(int numCurso);
	
//	public Curso mostrarCurso(int numCurso);
	
	public Profesor mostrarProfesorPorClave(int legajo);
	
//	public Profesor mostrarProfesor(int legajo);
	
	public Materia mostrarMateriaPorClave(String numero);
	
//	public Materia mostrarMateria(String numero);

}
