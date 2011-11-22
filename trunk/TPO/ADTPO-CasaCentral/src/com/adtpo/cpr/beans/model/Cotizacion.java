package com.adtpo.cpr.beans.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table (name="Cotizaciones")

public class Cotizacion implements Serializable {

	@Transient private static final long serialVersionUID = -4436246431980549144L;
	
	@Id @GeneratedValue
	private Integer idCotizazion;
	private Date vencimiento;
	private Cliente cliente;
	
	@Embedded
	private ArrayList<Item> items;
	private boolean aprobada;
	
	public Integer getIdCotizazion() {
		return idCotizazion;
	}
	
	public void setIdCotizazion(Integer idCotizazion) {
		this.idCotizazion = idCotizazion;
	}
	
	public Date getVencimiento() {
		return vencimiento;
	}
	
	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}
	
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	public boolean isAprobada() {
		return aprobada;
	}
	public void setAprobada(boolean aprobada) {
		this.aprobada = aprobada;
	}
	
	public void getTotal(){
		// codigo
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idCotizazion == null) ? 0 : idCotizazion.hashCode());
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
		Cotizacion other = (Cotizacion) obj;
		if (idCotizazion == null) {
			if (other.idCotizazion != null)
				return false;
		} else if (!idCotizazion.equals(other.idCotizazion))
			return false;
		return true;
	}
}
