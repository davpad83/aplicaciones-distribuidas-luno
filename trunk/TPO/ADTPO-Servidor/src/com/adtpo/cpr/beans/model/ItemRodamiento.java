package com.adtpo.cpr.beans.model;

import javax.persistence.*;


@Entity
public class ItemRodamiento {
	
	@Id @GeneratedValue(strategy= GenerationType.AUTO)
	private int idItemRodamiento;
	
	private int cantidad;
	
	@OneToOne
	@JoinColumns({
		@JoinColumn(name="codigo_fk", referencedColumnName="codigo"),
		@JoinColumn(name="marca_fk", referencedColumnName="marca"),
		@JoinColumn(name="caracteristica_fk", referencedColumnName="caracteristica"),
		@JoinColumn(name="pais_fk", referencedColumnName="pais")})	
	private Rodamiento rodamiento;
	
	private float precio;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idProveedor")
	private Proveedor proveedor;
	
	public ItemRodamiento() {
		//Empty
	}
	
	public ItemRodamiento( Rodamiento rodamiento, int cantidad) {
		this.cantidad = cantidad;
		this.rodamiento = rodamiento;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Rodamiento getRodamiento() {
		return rodamiento;
	}
	public void setRodamiento(Rodamiento rodamiento) {
		this.rodamiento = rodamiento;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setIdItemRodamiento(int idItemRodamiento) {
		this.idItemRodamiento = idItemRodamiento;
	}

	public int getIdItemRodamiento() {
		return idItemRodamiento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idItemRodamiento;
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
		ItemRodamiento other = (ItemRodamiento) obj;
		if (idItemRodamiento != other.idItemRodamiento)
			return false;
		return true;
	}
}
