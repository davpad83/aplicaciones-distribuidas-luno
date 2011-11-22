package com.adtpo.ov.clienteRmi;

import java.rmi.Naming;
import java.rmi.RemoteException;

import com.adtpo.cpr.bean.gui.ClienteBean;
import com.adtpo.cpr.rmi.IServicios;

public class ClienteRmi {
	
	private IServicios servicios;
	
	public ClienteRmi(){
	}
	
	private boolean connect(){
		try{
			servicios = (IServicios) Naming.lookup("//localhost/servicios");
			return true;
		}catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public void agregarCliente(String nombre, String apellido, String telefono, String email){
		if (connect()) {
			ClienteBean cl = new ClienteBean();
			cl.setNombre(nombre);
			cl.setApellido(apellido);
			cl.setTelefono(telefono);
			cl.setEmail(email);
			try {
				servicios.agregarCliente(cl);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}else{
			System.out.print("No se pudo encontrar el objeto remoto");
		}
	}
	
	public void agregarProveedor(String nombre, Float descuento){
		
	}

}
