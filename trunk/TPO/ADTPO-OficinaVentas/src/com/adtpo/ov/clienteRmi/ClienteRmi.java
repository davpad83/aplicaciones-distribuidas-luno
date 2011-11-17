package com.adtpo.ov.clienteRmi;

import java.rmi.Naming;
import java.rmi.RemoteException;

import com.adtpo.cpr.bean.gui.ClienteBean;
import com.adtpo.cpr.bean.gui.DomicilioBean;
import com.adtpo.cpr.rmi.ro.IServicios;

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
	
	public void agregarCliente(String nombre, String apellido, String telefono, String email, 
			String calle, int numero , int piso, String depto, String localidad){
		if (connect()) {
			ClienteBean cl = new ClienteBean();
			cl.setNombre(nombre);
			cl.setApellido(apellido);
			cl.setTelefono(telefono);
			DomicilioBean db = new DomicilioBean();
			db.setCalle(calle);
			db.setDepartamento(String.valueOf(piso) + depto);
			db.setLocalidad(localidad);
			cl.setDomicilio(db);
			try {
				servicios.agregarCliente(cl);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}

}
