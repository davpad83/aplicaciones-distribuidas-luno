package com.adtpo.ov.test;

import com.adtpo.cpr.bean.gui.ClienteBean;
import com.adtpo.ov.clienteRmi.ClienteRmi;


public class Test {

	private static ClienteRmi rmi;
	
	public static void main(String[] args){
		
		try {
			rmi = new ClienteRmi();
		ClienteBean c = new ClienteBean();
		c.setApellido("Attanasio");
		c.setNombre("Joaquin tarado");
		c.setEmail("melacomo@yque.com");
		c.setTelefono("0-800-telachupo");

		rmi.agregarCliente(c.getNombre(), c.getApellido(), c.getTelefono(), c.getEmail());
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.print("Operacion finalizada");
	}	
}
