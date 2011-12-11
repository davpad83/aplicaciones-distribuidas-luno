package com.adtpo.cpr.beans.model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

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

	//////////////////////////////////////////////////////////
	////////Oficina de Ventas
	//////////////////////////////////////////////////////////

	public OficinaVentas() {
		clientes = new ArrayList<Cliente>();
		facturas = new ArrayList<Factura>();
		solicitudes = new ArrayList<SolicitudCotizacion>();
	}

	public static OficinaVentas getInstancia() {
		if (instancia == null) {
			instancia = new OficinaVentas();
		}
		return instancia;
	}
	
	public int getCodigoOV() {
		return codigoOV;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	//////////////////////////////////////////////////////////
	///////COTIZACION
	//////////////////////////////////////////////////////////

	public Cotizacion generarCotizacion(int idCliente, ArrayList<ItemRodamiento> items) throws DataBaseInvalidDataException{
		Cliente cliente = getClientePorId(idCliente);
		Cotizacion cotizacion = new Cotizacion();
		cotizacion.setCliente(cliente);
		cotizacion.setItems(CasaCentral.getInstancia().cotizarItemsSolicitud(items));
		cotizacion.registrarVencimiento();
		cotizacion.setIva((float) 0.21);
		
		return cotizacion;
	}
	
	
	//////////////////////////////////////////////////////////
	///////CLIENTES
	//////////////////////////////////////////////////////////

	public void agregarCliente(Cliente cliente) throws DataBaseInvalidDataException {
		if(!existeCliente(cliente)){
			clientes.add(cliente);
			OficinaVentaDAO.getInstancia().grabarCliente(cliente);
		}
	}
	
	public void modificarCliente(Cliente cliente) throws DataBaseInvalidDataException {
		if(existeCliente(cliente)){
			OficinaVentaDAO.getInstancia().grabarCliente(cliente);
			clientes.remove(cliente);
			clientes.add(cliente);
		}
	}

	
	public void eliminarCliente(Cliente cliente) throws DataBaseInvalidDataException{
		if(existeCliente(cliente)){
			clientes.remove(cliente);
			OficinaVentaDAO.getInstancia().eliminarCliente(cliente);
		}
	}

	
	public Cliente getCliente(Cliente cl) throws DataBaseInvalidDataException {
		Cliente clEncontrado = null;
		for(Cliente c: clientes)
			if(c.equals(cl))
				clEncontrado = c;
		if(clEncontrado == null)
			clEncontrado = OficinaVentaDAO.getInstancia().getCliente(cl);
		return clEncontrado;
	}

	private Cliente getClientePorId(int idCliente) throws DataBaseInvalidDataException {
		Cliente clEncontrado = null;
		for(Cliente cli : clientes)
			if(cli.getIdCliente() == idCliente)
				clEncontrado =  cli;
		if(clEncontrado==null)
			clEncontrado = OficinaVentaDAO.getInstancia().getCliente(idCliente);			
		return clEncontrado;
	}
	
	private boolean existeCliente(Cliente cliente){
		if(cliente.getIdCliente() <= 0){
			if(cliente.getNombre() != null && cliente.getApellido()!= null &&
					!cliente.getNombre().isEmpty() && !cliente.getApellido().isEmpty()){
				for(Cliente c : clientes){
					if(cliente.getNombre().equals(c.getNombre()) && 
							cliente.getApellido().equals(cliente.getApellido()))
						return true;
				}
			}
		}else{
			for(Cliente c : clientes){
				if(cliente.getIdCliente() == c.getIdCliente())
					return true;
			}
		}
		return OficinaVentaDAO.getInstancia().existeCliente(cliente);
	}
	
	//////////////////////////////////////////////////////////
	////////FACTURAS
	//////////////////////////////////////////////////////////

	
	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}
	
	public void agregarFactura(Factura fac) {
		facturas.add(fac);
	}
	
	public ArrayList<Factura> getFacturas() {
		ArrayList<Factura> facturas = null;
		if(this.facturas.isEmpty())
			return OficinaVentaDAO.getInstancia().getFacturas();
		else
			return facturas;
	}

	public Factura generarVenta(int id, ArrayList<ItemRodamiento> itemRodamientoList) throws Exception {
		Venta v = CasaCentral.getInstancia().procesarSolicitudVenta(itemRodamientoList, id);
		Factura f = new Factura();
		f.setFechaFactura(new Date());
		f.setVenta(v);
		return f;
	}

	
	//////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////
}
