package uade.ejercicio.clase4.controlador;

import java.util.ArrayList;
import java.util.List;

import uade.ejercicio.clase4.interfaces.IConsultas;
import uade.ejercicio.clase4.negocio.Alumno;
import uade.ejercicio.clase4.negocio.BaseDeDatos;
import uade.ejercicio.clase4.negocio.Curso;
import uade.ejercicio.clase4.negocio.Materia;
import uade.ejercicio.clase4.negocio.Profesor;
import uade.ejercicio.clase4.beans.AlumnoView;
import uade.ejercicio.clase4.beans.CursoView;
import uade.ejercicio.clase4.beans.MateriaView;
import uade.ejercicio.clase4.beans.ProfesorView;



public class ConsultasImpl implements IConsultas {

	public ArrayList<AlumnoView> listarAlumnos() {
//
//		ArrayList<Alumno> a = BaseDeDatos.getAlumnos();
//		return new ArrayList<AlumnoView> 
		return null;

	}

	public ArrayList<AlumnoView> listarAlumnosCurso(int numCurso) {
		
		CursoView c = mostrarCursoPorClave(numCurso);
		return c.getAlumnos();
	}

	public ArrayList<ProfesorView> listarProfesores() {
//		return BaseDeDatos.getProfesores();
		return null;
	}

	public ArrayList<MateriaView> listarMateriasProfesor(int legajo) {
		ProfesorView p = mostrarProfesorPorClave(legajo);
		return p.getVinculado();
	}

	public ArrayList<MateriaView> listarMaterias() {
//		return BaseDeDatos.getMaterias();
		return null;

	}

	public ArrayList<CursoView> listarCursos() {
//		return BaseDeDatos.getCursos();
		return null;

	}

	public AlumnoView mostrarAlumnoPorClave(int legajo) {
		
//		AlumnoView a = BaseDeDatos.buscarAlumno(legajo);
//		AlumnoView av = new AlumnoView(a.getLegajo(), a.getNombre(), a.getEstado());
//		return av;
		return null;

	}

	public CursoView mostrarCursoPorClave(int numCurso) {
		
//		return BaseDeDatos.buscarCurso(numCurso);
		return null;

	}

	public ProfesorView mostrarProfesorPorClave(int legajo) {
//		return BaseDeDatos.buscarProfesor(legajo);
		return null;

	}

	public MateriaView mostrarMateriaPorClave(String numero) {
//		return BaseDeDatos.buscarMateria(numero);
		return null;
	}

}
