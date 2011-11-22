package com.adtpo.cpr.beans.model;

import java.util.ArrayList;

import javax.persistence.*;
import com.adtpo.cpr.bean.dao.OficinaVentaDAO;

@Entity
@Table(name="OficinaVentas")
public class OficinaVentas {
	
	@Id
	private Integer codigoOV;
	
	@OneToMany
	private ArrayList<Cliente> clientes;
	
//	@OneToMany
//	private ArrayList<Cotizacion> cotizaciones;
	
//	@OneToMany
//	private ArrayList<Venta> ventas;
	
//	@OneToMany
//	private ArrayList<Factura> facturas;
	
	private static OficinaVentas instancia;
	
	public OficinaVentas(){
		clientes = new ArrayList<Cliente>();
//		ventas = new ArrayList<Venta>;
//		facturas = new ArrayList<Factura>;
	}
	
	public static OficinaVentas getInstancia(){
		if(instancia==null){
			instancia = new OficinaVentas();
		}
		return instancia;
	}
	
	public void agregarCliente(Cliente cliente){
		clientes.add(cliente);
		OficinaVentaDAO.getInstancia().grabarCliente(cliente);
	}

	public Integer getCodigoOV() {
		return codigoOV;
	}
}
