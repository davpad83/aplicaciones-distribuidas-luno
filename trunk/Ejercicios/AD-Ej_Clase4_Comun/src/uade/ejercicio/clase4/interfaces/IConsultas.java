package uade.ejercicio.clase4.interfaces;

import java.util.ArrayList;
import java.util.List;

import uade.ejercicio.clase4.beans.AlumnoBean;
import uade.ejercicio.clase4.beans.CursoBean;
import uade.ejercicio.clase4.beans.MateriaBean;
import uade.ejercicio.clase4.beans.ProfesorBean;



public interface IConsultas {
	
	public ArrayList<AlumnoBean> listarAlumnos();
	
	public ArrayList<AlumnoBean> listarAlumnosCurso(int numCurso);
	
	public ArrayList<ProfesorBean> listarProfesores();
	
	public ArrayList<MateriaBean> listarMateriasProfesor(int legajo);
	
	public ArrayList<MateriaBean> listarMaterias();
	
	public ArrayList<CursoBean> listarCursos();
	
	public AlumnoBean mostrarAlumnoPorClave(int legajo);
	
//	public Alumno mostrarAlumno(String nombre, String estado);
	
	public CursoBean mostrarCursoPorClave(int numCurso);
	
//	public Curso mostrarCurso(int numCurso);
	
	public ProfesorBean mostrarProfesorPorClave(int legajo);
	
//	public Profesor mostrarProfesor(int legajo);
	
	public MateriaBean mostrarMateriaPorClave(String numero);
	
//	public Materia mostrarMateria(String numero);

}
