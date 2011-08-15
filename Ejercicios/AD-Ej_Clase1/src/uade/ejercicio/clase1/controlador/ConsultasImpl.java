package uade.ejercicio.clase1.controlador;

import java.util.ArrayList;
import java.util.List;

import uade.ejercicio.clase1.negocio.Alumno;
import uade.ejercicio.clase1.negocio.BaseDeDatos;
import uade.ejercicio.clase1.negocio.Curso;
import uade.ejercicio.clase1.negocio.Materia;
import uade.ejercicio.clase1.negocio.Profesor;
import uade.ejercicio.clase1.vista.AlumnoView;



public class ConsultasImpl implements IConsultas {

	public ArrayList<Alumno> listarAlumnos() {
	
		return BaseDeDatos.getAlumnos();
	}

	public ArrayList<Alumno> listarAlumnosCurso(int numCurso) {
		
		Curso c = mostrarCursoPorClave(numCurso);
		return c.getAlumnos();
	}

	public ArrayList<Profesor> listarProfesores() {
		return BaseDeDatos.getProfesores();
	}

	public ArrayList<Materia> listarMateriasProfesor(int legajo) {
		Profesor p = mostrarProfesorPorClave(legajo);
		return p.getVinculado();
	}

	public ArrayList<Materia> listarMaterias() {
		return BaseDeDatos.getMaterias();
	}

	public ArrayList<Curso> listarCursos() {
		return BaseDeDatos.getCursos();
	}

	public AlumnoView mostrarAlumnoPorClave(int legajo) {
		
		Alumno a = BaseDeDatos.buscarAlumno(legajo);
		AlumnoView av = new AlumnoView(a.getLegajo(), a.getNombre(), a.getEstado());
		return av;
	}

	public Curso mostrarCursoPorClave(int numCurso) {
		
		return BaseDeDatos.buscarCurso(numCurso);
	}

	public Profesor mostrarProfesorPorClave(int legajo) {
		return BaseDeDatos.buscarProfesor(legajo);
	}

	public Materia mostrarMateriaPorClave(String numero) {
		return BaseDeDatos.buscarMateria(numero);
	}

}
