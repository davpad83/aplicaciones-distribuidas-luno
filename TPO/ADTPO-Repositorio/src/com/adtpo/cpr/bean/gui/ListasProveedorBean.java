package com.adtpo.cpr.bean.gui;

import java.util.ArrayList;
import java.util.Map;

public class ListasProveedorBean {

	private int idLista;
	private String nombre;
	private int descuento;
	
	private ArrayList<ProveedorBean> proveedores;
	private ArrayList<String> condVenta;

	private Map<RodamientoBean, Float> Rodamientos;

	public ListasProveedorBean(){
		//empty
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public ArrayList<ProveedorBean> getProveedores() {
		return proveedores;
	}

	public void setProveedores(ArrayList<ProveedorBean> proveedores) {
		this.proveedores = proveedores;
	}

	public ArrayList<String> getCondVenta() {
		return condVenta;
	}

	public void setCondVenta(ArrayList<String> condVenta) {
		this.condVenta = condVenta;
	}

	public Map<RodamientoBean, Float> getRodamientos() {
		return Rodamientos;
	}

	public void setRodamientos(Map<RodamientoBean, Float> rodamientos) {
		Rodamientos = rodamientos;
	}

	public int getIdLista() {
		return idLista;
	}

	public void setIdLista(int idLista) {
		this.idLista = idLista;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idLista;
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
		ListasProveedorBean other = (ListasProveedorBean) obj;
		if (idLista != other.idLista)
			return false;
		return true;
	}
}
