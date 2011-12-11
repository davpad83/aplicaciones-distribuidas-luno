package com.adtpo.cpr.beans.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class ItemListaComparativa implements Serializable {

	@Transient private static final long serialVersionUID = -314067622085452275L;

	@Id @GeneratedValue(strategy= GenerationType.AUTO)
	private int idItemListaComparativa;
		
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumns({
		@JoinColumn(name="codigo_fk", referencedColumnName="codigo"),
		@JoinColumn(name="marca_fk", referencedColumnName="marca"),
		@JoinColumn(name="caracteristica_fk", referencedColumnName="caracteristica"),
		@JoinColumn(name="pais_fk", referencedColumnName="pais")})
	private Rodamiento rodamiento;
	
	private float precio;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="idListaProveedor")
	private ListasProveedor listaProveedor;
	
	public ItemListaComparativa(){
		//Empty
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
	public ListasProveedor getListaProveedor() {
		return listaProveedor;
	}
	public void setListaProveedor(ListasProveedor listaProveedor) {
		this.listaProveedor = listaProveedor;
	}

	public void setIdItemListaComparativa(int idItemListaComparativa) {
		this.idItemListaComparativa = idItemListaComparativa;
	}

	public int getIdItemListaComparativa() {
		return idItemListaComparativa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idItemListaComparativa;
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
		ItemListaComparativa other = (ItemListaComparativa) obj;
		if (idItemListaComparativa != other.idItemListaComparativa)
			return false;
		return true;
	}
}
