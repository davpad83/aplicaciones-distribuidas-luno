package com.adtpo.cpr.beans.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table (name="Cotizaciones")

public class Cotizacion implements Serializable {

	@Id private Integer idCotizazion;
	private Date vencimiento;
	private Cliente cliente;
	@Embedded
	private Set <Item> items;
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
	public Set<Item> getItems() {
		return items;
	}
	public void setItems(Set<Item> items) {
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
}
