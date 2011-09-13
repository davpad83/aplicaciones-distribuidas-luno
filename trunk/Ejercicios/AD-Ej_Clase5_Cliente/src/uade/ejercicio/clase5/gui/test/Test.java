package uade.ejercicio.clase5.gui.test;

import uade.ejercicio.clase5.beans.AlumnoBean;
import uade.ejercicio.clase5.clienteRmi.BusinessDelegate;
import junit.framework.Assert;
import junit.framework.TestCase;

public class Test extends TestCase {

	private static final BusinessDelegate cliente = new BusinessDelegate();
	
	public void test(){
		
		AlumnoBean a1 = new AlumnoBean();
		a1.setLegajo(100);
		a1.setNombre("Matias Favale");
		a1.setEstado("Activo");
		AlumnoBean a2 = new AlumnoBean();
		a1.setLegajo(101);
		a1.setNombre("Silvana Pisano");
		a1.setEstado("Activo");
		AlumnoBean a3 = new AlumnoBean();
		a1.setLegajo(102);
		a1.setNombre("Joey Onabehere");
		a1.setEstado("Inactivo");
		AlumnoBean a4 = new AlumnoBean();
		a1.setLegajo(103);
		a1.setNombre("Joaquin");
		a1.setEstado("Inactivo");
		
		cliente.agregarAlumno(a1);
		

		Assert.assertEquals(a1, cliente.obtenerAlumno(100));
//		Assert.assertEquals(a2, cliente.obtenerAlumno(101));
//		Assert.assertEquals(a3, cliente.obtenerAlumno(102));
//		Assert.assertEquals(a4, cliente.obtenerAlumno(103));
	}
}
