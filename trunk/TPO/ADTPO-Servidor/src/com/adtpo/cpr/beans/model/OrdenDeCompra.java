package com.adtpo.cpr.beans.model;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

@Entity
public class OrdenDeCompra implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idOrdenDeCompra;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Proveedor proveedor;
	private Date fecha;

	@OneToMany
	@JoinColumn(name = "idOrdenDeCompra")
	private List<ItemRodamiento> items;

	public int getIdOrdenDeCompra() {
		return idOrdenDeCompra;
	}

	public void setIdOrdenDeCompra(int idOrdenDeCompra) {
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

	public List<ItemRodamiento> getItems() {
		return items;
	}

	public void setItems(List<ItemRodamiento> items) {
		this.items = items;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + idOrdenDeCompra;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result
				+ ((proveedor == null) ? 0 : proveedor.hashCode());
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
		OrdenDeCompra other = (OrdenDeCompra) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (idOrdenDeCompra != other.idOrdenDeCompra)
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (proveedor == null) {
			if (other.proveedor != null)
				return false;
		} else if (!proveedor.equals(other.proveedor))
			return false;
		return true;
	}


}
