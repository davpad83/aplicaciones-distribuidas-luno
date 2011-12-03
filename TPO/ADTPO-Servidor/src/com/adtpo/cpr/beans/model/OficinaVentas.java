package com.adtpo.cpr.beans.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;
import com.adtpo.cpr.bean.dao.OficinaVentaDAO;
import com.adtpo.cpr.bean.gui.ClienteBean;
import com.adtpo.cpr.excepciones.DataBaseInvalidDataException;

@Embeddable
public class OficinaVentas implements Serializable {

	@Transient private static final long serialVersionUID = 1L;

	private int codigoOV;
	private String nombre;
	
	@Transient private ArrayList<Cliente> clientes;
	@Transient private ArrayList<Factura> facturas;

	/**
	 * Lista de solicitud de cotizaciones, comienza en estado pendiente.	 * 
	 * No se persiste en el base de datos, solo se guarda en memoria, 
	 * ya que una vez que se genera, se encola para ser procesada y generar la cotizacion.
	 * 
	 * Una vez generada la cotizacion, la solicitud pasa a estado "procesada"
	 */
	@Transient private ArrayList<SolicitudCotizacion> solicitudes;
	
	private static OficinaVentas instancia;

	public OficinaVentas() {
		clientes = new ArrayList<Cliente>();
		facturas = new ArrayList<Factura>();
		solicitudes = new ArrayList<SolicitudCotizacion>();
		//TODO Cargar clientes.
	}

	public static OficinaVentas getInstancia() {
		if (instancia == null) {
			instancia = new OficinaVentas();
		}
		return instancia;
	}
	
	public void generarSolicitudDeCotizacion(int idCliente, ArrayList<ItemRodamiento> items) throws DataBaseInvalidDataException{
		Cliente cliente = getClientePorId(idCliente);
		SolicitudCotizacion sc = new SolicitudCotizacion();
		sc.setCliente(cliente);
		sc.setRodamientos(items);
	}
	
	
	public void agregarCliente(Cliente cliente) {
		clientes.add(cliente);
		OficinaVentaDAO.getInstancia().grabarCliente(cliente);
	}
	
	public void modificarCliente(Cliente cliente) throws DataBaseInvalidDataException {
		if(getCliente(cliente)!=null){
			OficinaVentaDAO.getInstancia().grabarCliente(cliente);
			clientes.remove(cliente);
			clientes.add(cliente);
		}
	}

	
	public void eliminarCliente(Cliente cliente) throws DataBaseInvalidDataException{
		if(getCliente(cliente) != null){
			clientes.remove(cliente);
			OficinaVentaDAO.getInstancia().eliminarCliente(cliente);
		}
	}

	
	public Cliente getCliente(Cliente cl) throws DataBaseInvalidDataException {
		for(Cliente c: clientes)
			if(c.equals(cl))
				return c;
		return OficinaVentaDAO.getInstancia().getCliente(cl);
	}

	private Cliente getClientePorId(int idCliente) throws DataBaseInvalidDataException {
		for(Cliente cli : clientes)
			if(cli.getIdCliente() == idCliente)
				return cli;
		Cliente cliente = new Cliente();
		cliente.setIdCliente(idCliente);
		return OficinaVentaDAO.getInstancia().getCliente(cliente);
	}
	
	public int getCodigoOV() {
		return codigoOV;
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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void procesarSolicitudVenta ("path XML"){
		ArrayList<ItemRodamiento> rodamientos = new ArrayList<ItemRodamiento>();
		int clienteId = 0;
		CasaCentral.getInstancia().procesarSolicitudVenta(rodamientos, clienteId);
	}
}
