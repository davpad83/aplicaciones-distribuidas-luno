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
	private Integer idOrdenDeCompra;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Proveedor proveedor;
	private Date fecha;

	@OneToMany
	@JoinColumn(name = "idOrdenDeCompra")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idOrdenDeCompra == null) ? 0 : idOrdenDeCompra.hashCode());
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
		if (idOrdenDeCompra == null) {
			if (other.idOrdenDeCompra != null)
				return false;
		} else if (!idOrdenDeCompra.equals(other.idOrdenDeCompra))
			return false;
		return true;
	}

}
