package com.adtpo.cpr.beans.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SolicitudCotizacion implements Serializable
{
	private static final long serialVersionUID = 7068820790993609615L;
	private Cliente cliente;
	private ArrayList<ItemRodamiento> rodamientos ;

	public SolicitudCotizacion (){
		super();
		this.rodamientos = new ArrayList<ItemRodamiento>();
	}
	
	public ArrayList<ItemRodamiento> getRodamientos() {
		return rodamientos;
	}

	public void setRodamientos(ArrayList<ItemRodamiento> rodamientos) {
		this.rodamientos = rodamientos;
	}
	
	public void agregarRodamiento (ItemRodamiento rod) {
		this.rodamientos.add(rod);
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
}
