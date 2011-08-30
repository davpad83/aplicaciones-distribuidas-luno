package uade.ejercicio.clase4.interfaces;

import uade.ejercicio.clase4.beans.AlumnoView;
import uade.ejercicio.clase4.beans.CursoView;
import uade.ejercicio.clase4.beans.MateriaView;
import uade.ejercicio.clase4.beans.ProfesorView;


public interface IAsociaciones {
	
	public void nuevoCurso(MateriaView materia, ProfesorView profesor, int cantidadMaxima);
	
	public void eliminarCurso(CursoView curso);
	
	public void asignarAlumnoCurso(CursoView curso, AlumnoView alumno);
	
	public void asignarMateriaProfesor(MateriaView materia, ProfesorView profesor);

}
