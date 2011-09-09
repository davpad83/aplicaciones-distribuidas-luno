package uade.ejercicio.clase5.interfaces;

import uade.ejercicio.clase5.beans.AlumnoBean;
import uade.ejercicio.clase5.beans.CursoBean;
import uade.ejercicio.clase5.beans.MateriaBean;
import uade.ejercicio.clase5.beans.ProfesorBean;


public interface IAsociaciones {
	
	public void nuevoCurso(MateriaBean materia, ProfesorBean profesor, int cantidadMaxima);
	
	public void eliminarCurso(CursoBean curso);
	
	public void asignarAlumnoCurso(CursoBean curso, AlumnoBean alumno);
	
	public void asignarMateriaProfesor(MateriaBean materia, ProfesorBean profesor);

}
