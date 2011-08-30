package uade.ejercicio.clase4.interfaces;

import java.util.ArrayList;
import java.util.List;

import uade.ejercicio.clase4.beans.AlumnoView;
import uade.ejercicio.clase4.beans.CursoView;
import uade.ejercicio.clase4.beans.MateriaView;
import uade.ejercicio.clase4.beans.ProfesorView;



public interface IConsultas {
	
	public ArrayList<AlumnoView> listarAlumnos();
	
	public ArrayList<AlumnoView> listarAlumnosCurso(int numCurso);
	
	public ArrayList<ProfesorView> listarProfesores();
	
	public ArrayList<MateriaView> listarMateriasProfesor(int legajo);
	
	public ArrayList<MateriaView> listarMaterias();
	
	public ArrayList<CursoView> listarCursos();
	
	public AlumnoView mostrarAlumnoPorClave(int legajo);
	
//	public Alumno mostrarAlumno(String nombre, String estado);
	
	public CursoView mostrarCursoPorClave(int numCurso);
	
//	public Curso mostrarCurso(int numCurso);
	
	public ProfesorView mostrarProfesorPorClave(int legajo);
	
//	public Profesor mostrarProfesor(int legajo);
	
	public MateriaView mostrarMateriaPorClave(String numero);
	
//	public Materia mostrarMateria(String numero);

}
