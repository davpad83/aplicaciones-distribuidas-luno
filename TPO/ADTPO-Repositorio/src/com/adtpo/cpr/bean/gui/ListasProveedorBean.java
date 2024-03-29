package com.adtpo.cpr.bean.gui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListasProveedorBean implements Serializable{

	private static final long serialVersionUID = 5992750817213863394L;

	private int idLista;
	private String nombre;
	private float descuento;
	
	private ProveedorBean proveedor;
//	private ArrayList<CondicionVentaBean> condVenta;


	private List<MapaRodamientoPrecioBean> Rodamientos;

	public ListasProveedorBean(){
		//empty
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public ProveedorBean getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorBean proveedor) {
		this.proveedor = proveedor;
	}


//	public ArrayList<CondicionVentaBean> getCondVenta() {
//		return condVenta;
//	}
//
//	public void setCondVenta(ArrayList<CondicionVentaBean> condVenta) {
//		this.condVenta = condVenta;
//	}

	public List<MapaRodamientoPrecioBean> getMapaRodamientoPrecio() {
		return Rodamientos;
	}

	public void setMapaRodamientoPrecio(List<MapaRodamientoPrecioBean> rodamientos) {
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

	@Override
	public String toString() {
		return "ListasProveedorBean \n[Rodamientos=" + Rodamientos
//				+ ", \ncondVenta=" + condVenta 
				+ ", \ndescuento=" + descuento
				+ ", \nidLista=" + idLista + ", \nnombre=" + nombre
				+ ", \nproveedor=" + proveedor + "]";
	}
}
