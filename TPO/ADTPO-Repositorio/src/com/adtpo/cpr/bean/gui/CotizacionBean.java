package com.adtpo.cpr.bean.gui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public class CotizacionBean implements Serializable{
	
	private static final long serialVersionUID = -3630839386738564155L;

	private int idCotizacion;
	private Date vencimiento;
	private ClienteBean cliente;
	private float iva;
	private ArrayList<ItemRodamientoBean> items;
	private boolean aprobada;
	public int getIdCotizacion() {
		return idCotizacion;
	}
	public void setIdCotizacion(int idCotizacion) {
		this.idCotizacion = idCotizacion;
	}
	public Date getVencimiento() {
		return vencimiento;
	}
	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}
	public ClienteBean getCliente() {
		return cliente;
	}
	public void setCliente(ClienteBean cliente) {
		this.cliente = cliente;
	}
	public float getIva() {
		return iva;
	}
	public void setIva(float iva) {
		this.iva = iva;
	}
	public ArrayList<ItemRodamientoBean> getItems() {
		return items;
	}
	public void setItems(ArrayList<ItemRodamientoBean> items) {
		this.items = items;
	}
	public boolean isAprobada() {
		return aprobada;
	}
	public void setAprobada(boolean aprobada) {
		this.aprobada = aprobada;
	}
	public float calcularTotal() {
		float total=0;
		for(ItemRodamientoBean r : items)
			total = total + r.getPrecio();
		return 0;
	}
}
