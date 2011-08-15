package uade.ejercicio.clase1.controlador;

import uade.ejercicio.clase1.negocio.Alumno;
import uade.ejercicio.clase1.negocio.Curso;
import uade.ejercicio.clase1.negocio.Materia;
import uade.ejercicio.clase1.negocio.Profesor;


public interface IAsociaciones {
	
	public void nuevoCurso(Materia materia, Profesor profesor, int cantidadMaxima);
	
	public void eliminarCurso(Curso curso);
	
	public void asignarAlumnoCurso(Curso curso, Alumno alumno);
	
	public void asignarMateriaProfesor(Materia materia, Profesor profesor);

}
