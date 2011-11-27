package com.adtpo.ov.test;

import com.adtpo.cpr.bean.gui.ClienteBean;
import com.adtpo.ov.clienteRmi.ClienteRmi;


public class Test {

	private static ClienteRmi rmi;
	
	public static void main(String[] args){
		
		try {
			rmi = new ClienteRmi();
			
		//Agrego 4 clientes:
		ClienteBean c0 = new ClienteBean();
		c0.setApellido("Eliminar");
		c0.setNombre("Cliente Para");
		c0.setEmail("eliminar@x.com");
		c0.setTelefono("4979-7979");
		rmi.agregarCliente(c0.getNombre(), c0.getApellido(), c0.getTelefono(), c0.getEmail());
			
		ClienteBean c1 = new ClienteBean();
		c1.setApellido("Attanasio");
		c1.setNombre("Joaquin tarado");
		c1.setEmail("melacomo@yque.com");
		c1.setTelefono("0-800-telachupo");
		rmi.agregarCliente(c1.getNombre(), c1.getApellido(), c1.getTelefono(), c1.getEmail());
		System.out.print("Cliente 1 agregado");
		
		ClienteBean c2 = new ClienteBean();
		c2.setApellido("Favale");
		c2.setNombre("Matias Alejandro");
		c2.setEmail("matiasfavale@gmail.com");
		c2.setTelefono("4799-8799");
		rmi.agregarCliente(c2.getNombre(), c2.getApellido(), c2.getTelefono(), c2.getEmail());
		System.out.print("Cliente 2 agregado");
		
		ClienteBean c3 = new ClienteBean();
		c3.setApellido("Onabehere");
		c3.setNombre("Joanna");
		c3.setEmail("joanna.onabehere@gmail.com");
		c3.setTelefono("4654-8763");
		rmi.agregarCliente(c3.getNombre(), c3.getApellido(), c3.getTelefono(), c3.getEmail());
		System.out.print("Cliente 3 agregado");
		
		ClienteBean c4 = new ClienteBean();
		c4.setApellido("Pisano");
		c4.setNombre("Silvana");
		c4.setEmail("sil.pisano@gmail.com");
		c4.setTelefono("4684-3658");
		rmi.agregarCliente(c4.getNombre(), c4.getApellido(), c4.getTelefono(), c4.getEmail());
		System.out.print("Cliente 4 agregado");
		
		Runtime.getRuntime().exec("pause");
		
		//Elimino 1 Cliente		
		rmi.eliminarCliente(1);
		System.out.print("Cliente con id 1 eliminado");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.print("Operacion finalizada");
	}	
}
