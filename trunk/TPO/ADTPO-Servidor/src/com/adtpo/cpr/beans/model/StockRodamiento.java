package com.adtpo.cpr.beans.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class StockRodamiento implements Serializable{
	
	@Transient private static final long serialVersionUID = 4479344403769022879L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idStockRodamiento;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumns({
		@JoinColumn(name="codigo_fk", referencedColumnName="codigo"),
		@JoinColumn(name="marca_fk", referencedColumnName="marca"),
		@JoinColumn(name="caracteristica_fk", referencedColumnName="caracteristica"),
		@JoinColumn(name="pais_fk", referencedColumnName="pais")})
	private Rodamiento rodamiento;
	
	private int stock;

	public StockRodamiento(){
		//Empty
	}

	public Rodamiento getRodamiento() {
		return rodamiento;
	}

	public void setRodamiento(Rodamiento rodamiento) {
		this.rodamiento = rodamiento;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setIdStockRodamiento(int idStockRodamiento) {
		this.idStockRodamiento = idStockRodamiento;
	}

	public int getIdStockRodamiento() {
		return idStockRodamiento;
	}
}
