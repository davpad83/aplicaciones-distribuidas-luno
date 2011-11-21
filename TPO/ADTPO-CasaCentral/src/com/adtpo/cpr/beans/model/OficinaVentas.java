package com.adtpo.cpr.beans.model;

import java.util.ArrayList;

import com.adtpo.cpr.bean.dao.ClienteDAO;

public class OficinaVentas {
	
	private ArrayList<Cliente> clientes;
	
	private static OficinaVentas instancia;
	
	public OficinaVentas(){
		clientes = new ArrayList<Cliente>();
	}
	
	public OficinaVentas getInstancia(){
		if(instancia==null){
			instancia = new OficinaVentas();
		}
		return instancia;
	}
	
	public void agregarCliente(Cliente cliente){
		clientes.add(cliente);
		ClienteDAO.getInstancia().grabarCliente(cliente);
	}
}
