package com.adtpo.cpr.beans.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;
import com.adtpo.cpr.bean.dao.OficinaVentaDAO;

public class OficinaVentas implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer codigoOV;
	private ArrayList<Cliente> clientes;
	private ArrayList<Factura> facturas;

	private static OficinaVentas instancia;

	public OficinaVentas() {
		clientes = new ArrayList<Cliente>();
	
	}

	public static OficinaVentas getInstancia() {
		if (instancia == null) {
			instancia = new OficinaVentas();
		}
		return instancia;
	}

	public Cliente buscarCliente(int idcliente){
		Cliente c = new Cliente();
		for(int i=0 ; i< clientes.size();i++){
			c = clientes.get(i);
			if(c.getIdCliente()== idcliente)
				return c;
		}
	return null;
	}
	
	public void agregarCliente(Cliente cliente) {
		clientes.add(cliente);
		OficinaVentaDAO.getInstancia().grabarCliente(cliente);
	}
	
	public void eliminarCliente(Cliente cliente){
		clientes.remove(cliente);
		OficinaVentaDAO.getInstancia().eliminarCliente(cliente);
	}

	public Integer getCodigoOV() {
		return codigoOV;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codigoOV == null) ? 0 : codigoOV.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OficinaVentas other = (OficinaVentas) obj;
		if (codigoOV == null) {
			if (other.codigoOV != null)
				return false;
		} else if (!codigoOV.equals(other.codigoOV))
			return false;
		return true;
	}

	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}
	
	public void agregarFactura(Factura fac) {
		facturas.add(fac);
	}
	
	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

}
