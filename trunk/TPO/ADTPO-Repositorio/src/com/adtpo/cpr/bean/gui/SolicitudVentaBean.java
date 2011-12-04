package com.adtpo.cpr.bean.gui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class SolicitudVentaBean implements Serializable {

	private static final long serialVersionUID = 7607536803866847592L;

	private ClienteBean cliente;
	private ArrayList<ItemRodamientoBean> rodamientos;
	private int idCotizacion;
	private Date fecha;

	public SolicitudVentaBean() {
		// Empty
	}

	public ClienteBean getCliente() {
		return cliente;
	}

	public void setCliente(ClienteBean cliente) {
		this.cliente = cliente;
	}

	public ArrayList<ItemRodamientoBean> getRodamientos() {
		return rodamientos;
	}

	public void setRodamientos(ArrayList<ItemRodamientoBean> rodamientos) {
		this.rodamientos = rodamientos;
	}

	public int getIdCotizacion() {
		return idCotizacion;
	}

	public void setIdCotizacion(int idCotizacion) {
		this.idCotizacion = idCotizacion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
