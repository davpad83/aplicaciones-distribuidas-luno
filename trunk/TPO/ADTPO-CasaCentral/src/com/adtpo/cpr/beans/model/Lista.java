package com.adtpo.cpr.beans.model;

import java.util.List;
import java.util.Map;

import javax.persistence.*;

public class Lista {
	@Id private int idLista;
	private String nombre;
	private int descuento;
	
	@OneToMany (cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private List<Proveedor> proveedores;
	
	@OneToMany
	public List<CondicionVenta> condVenta;
	
	private Map<Rodamiento, Float > listaRodamientos;
	
	public int getIdLista() {
		return idLista;
	}
	public void setIdLista(int idLista) {
		this.idLista = idLista;
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
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public List<CondicionVenta> getCondVenta() {
		return condVenta;
	}
	public void setCondVenta(List<CondicionVenta> condVenta) {
		this.condVenta = condVenta;
	}

}
