package com.adtpo.cpr.beans.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

@Entity
public class ListasProveedor implements Serializable {

	@Transient private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idLista;

	private String nombre;
	private float descuento;
	
	@ManyToOne()
	@JoinColumn(referencedColumnName="idProveedor")
	private Proveedor proveedor;
	
	@ManyToMany()
	@JoinColumn(referencedColumnName="idRodamiento")
	private Map<Rodamiento, Float> rodamientos;

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

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public void setListaRodamientos(Map<Rodamiento, Float> listaRodamientos) {
		this.rodamientos = listaRodamientos;
	}

	public Map<Rodamiento, Float> getListaRodamientos() {
		return rodamientos;
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
		ListasProveedor other = (ListasProveedor) obj;
		if (idLista != other.idLista)
			return false;
		return true;
	}

	public float calcularPrecioMinimo(Rodamiento rodamiento) {
		Float precio = rodamientos.get(rodamiento);
		if(precio == null)
			return -1;
		return precio.floatValue()*(1-descuento);
	}
	
	public float calcularPrecioMinimo(Rodamiento rodamiento, String metodoPago){
		//TODO 
		return -1;
	}

}
