package uade.ejercicio.clase5.controlador;

import java.util.ArrayList;
import java.util.List;

import uade.ejercicio.clase5.interfaces.IConsultas;
import uade.ejercicio.clase5.negocio.Alumno;
import uade.ejercicio.clase5.negocio.BaseDeDatos;
import uade.ejercicio.clase5.negocio.Curso;
import uade.ejercicio.clase5.negocio.Materia;
import uade.ejercicio.clase5.negocio.Profesor;
import uade.ejercicio.clase5.beans.AlumnoBean;
import uade.ejercicio.clase5.beans.CursoBean;
import uade.ejercicio.clase5.beans.MateriaBean;
import uade.ejercicio.clase5.beans.ProfesorBean;



public class ConsultasImpl implements IConsultas {

	public ArrayList<AlumnoBean> listarAlumnos() {
//
//		ArrayList<Alumno> a = BaseDeDatos.getAlumnos();
//		return new ArrayList<AlumnoView> 
		return null;

	}

	public ArrayList<AlumnoBean> listarAlumnosCurso(int numCurso) {
		
		CursoBean c = mostrarCursoPorClave(numCurso);
		return c.getAlumnos();
	}

	public ArrayList<ProfesorBean> listarProfesores() {
//		return BaseDeDatos.getProfesores();
		return null;
	}

	public ArrayList<MateriaBean> listarMateriasProfesor(int legajo) {
		ProfesorBean p = mostrarProfesorPorClave(legajo);
		return p.getVinculado();
	}

	public ArrayList<MateriaBean> listarMaterias() {
//		return BaseDeDatos.getMaterias();
		return null;

	}

	public ArrayList<CursoBean> listarCursos() {
//		return BaseDeDatos.getCursos();
		return null;

	}

	public AlumnoBean mostrarAlumnoPorClave(int legajo) {
		
//		AlumnoView a = BaseDeDatos.buscarAlumno(legajo);
//		AlumnoView av = new AlumnoView(a.getLegajo(), a.getNombre(), a.getEstado());
//		return av;
		return null;

	}

	public CursoBean mostrarCursoPorClave(int numCurso) {
		
//		return BaseDeDatos.buscarCurso(numCurso);
		return null;

	}

	public ProfesorBean mostrarProfesorPorClave(int legajo) {
//		return BaseDeDatos.buscarProfesor(legajo);
		return null;

	}

	public MateriaBean mostrarMateriaPorClave(String numero) {
//		return BaseDeDatos.buscarMateria(numero);
		return null;
	}

}
