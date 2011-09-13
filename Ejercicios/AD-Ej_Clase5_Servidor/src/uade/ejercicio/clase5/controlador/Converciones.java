package uade.ejercicio.clase5.controlador;

import java.util.ArrayList;
import java.util.Iterator;

import uade.ejercicio.clase5.beans.AlumnoBean;
import uade.ejercicio.clase5.beans.CursoBean;
import uade.ejercicio.clase5.beans.DireccionBean;
import uade.ejercicio.clase5.beans.MateriaBean;
import uade.ejercicio.clase5.beans.ProfesorBean;
import uade.ejercicio.clase5.negocio.Alumno;
import uade.ejercicio.clase5.negocio.Curso;
import uade.ejercicio.clase5.negocio.Direccion;
import uade.ejercicio.clase5.negocio.Materia;
import uade.ejercicio.clase5.negocio.Profesor;

public class Converciones {

	public static ArrayList<Materia> materiasBeanToMateriasList(ArrayList<MateriaBean> matBns){
		ArrayList<Materia> materias = new ArrayList<Materia>();
		MateriaBean ab = null;
		Iterator<MateriaBean> ite = matBns.iterator();
		while(ite.hasNext()){
			ab = ite.next();
			materias.add(materiaBeanToMateria(ab));
		}
		return materias;
	}

	public static ArrayList<Alumno> alumnosBeanToAlumnosList(ArrayList<AlumnoBean> aluBns){
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		AlumnoBean ab = null;
		Iterator<AlumnoBean> ite = aluBns.iterator();
		while(ite.hasNext()){
			ab = ite.next();
			alumnos.add(alumnoBeanToAlumno(ab));
		}
		return alumnos;
	}

	public static ArrayList<AlumnoBean> alumnosToAlumnoBeanList(ArrayList<Alumno> alumnos) {
		Alumno a = null;
		ArrayList<AlumnoBean> abs = new ArrayList<AlumnoBean>();
		for(Iterator<Alumno> it = alumnos.iterator(); it.hasNext(); a=it.next()){
			abs.add(a.toBean());
		}
		return abs;
	}
	
	public static Materia materiaBeanToMateria(MateriaBean materia) {
		Materia mat = new Materia(materia.getNombre(), materia.getNumero());
		return mat;
	}

	public static Curso cursoBeanToCurso(CursoBean cur){
		Curso curso = new Curso(cur.getNumero(), Converciones.profesorBeanToProfesor(cur.getProfesor()), 
				materiaBeanToMateria(cur.getMateria()), cur.getCapacidad(), alumnosBeanToAlumnosList(cur.getAlumnos()));
		return curso;
	}

	public static Profesor profesorBeanToProfesor(ProfesorBean prof){
		Profesor profesor = new Profesor(prof.getNumeroLegajo(), 
				Converciones.direccionBeanToDireccion(prof.getDireccion()));
		materiasBeanToMateriasList(prof.getVinculado());
		return profesor;
	}

	public static Direccion direccionBeanToDireccion(DireccionBean dir) {
		Direccion direccion = new Direccion(dir.getCalle(), dir.getNumero(), 
				dir.getCp(), dir.getLocalidad(), dir.getPiso(), dir.getDepto());
		return direccion;
	}

	public static Alumno alumnoBeanToAlumno(AlumnoBean alumno) {
		Alumno alu = new Alumno(alumno.getLegajo(), alumno.getNombre(), alumno.getEstado());
		return alu;
	}
	

}
