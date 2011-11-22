package com.adtpo.cpr.beans.model;

import java.util.*;

import javax.persistence.*;
@Entity
public class OrdenDeCompra {
	@Id 
	private Integer idOrdenDeCompra;
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Proveedor proveedor;
	private Date fecha;
	
	@OneToMany 
	@JoinColumn(name= "idOrdenDeCompra")
	private List<Item> items;
	
	public Integer getIdOrdenDeCompra() {
		return idOrdenDeCompra;
	}
	public void setIdOrdenDeCompra(Integer idOrdenDeCompra) {
		this.idOrdenDeCompra = idOrdenDeCompra;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	

}
