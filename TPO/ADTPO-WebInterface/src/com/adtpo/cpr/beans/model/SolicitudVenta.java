package com.adtpo.cpr.beans.model;

import java.util.ArrayList;
import java.util.Date;

public class SolicitudVenta {
	 private Cliente cliente;
	 private ArrayList<ItemRodamiento> rodamientos;
	 private Integer idCotizacion;
	 private Date fecha; 
	 
	 
	public Integer getIdCotizacion() {
		return idCotizacion;
	}
	public void setIdCotizacion(Integer idCotizacion) {
		this.idCotizacion = idCotizacion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public ArrayList<ItemRodamiento> getRodamientos() {
		return rodamientos;
	}
	public void setRodamientos(ArrayList<ItemRodamiento> rodamientos) {
		this.rodamientos = rodamientos;
	}
	public void agregarRodamiento(ItemRodamiento itemRod) {
		rodamientos.add(itemRod);
	}
	
}
	
