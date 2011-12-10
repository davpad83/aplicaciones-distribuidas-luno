package com.adtpo.cpr.beans.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.MapKey;
import org.hibernate.annotations.MapKeyManyToMany;

@Entity
public class ListasProveedor implements Serializable {

	@Transient private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idLista;

	private String nombre;
	private float descuento;

	@OneToMany(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private List<CondicionVenta> condVenta = new ArrayList<CondicionVenta>();

//	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name = "idProveedor")
	private Proveedor proveedor;

	 @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	// @JoinColumn(name="idLista", updatable=false)
	private List<MapaRodamientoPrecio> mapaRodamientos = new ArrayList<MapaRodamientoPrecio>();

	public int getIdLista() {
		return idLista;
	}

	public List<CondicionVenta> getCondVenta() {
		return condVenta;
	}

	public void setCondVenta(List<CondicionVenta> condVenta) {
		this.condVenta = condVenta;
	}

	public List<MapaRodamientoPrecio> getMapaRodamientoPrecio() {
		return mapaRodamientos;
	}

	public void setMapaRodamientoPrecio(List<MapaRodamientoPrecio> rodamientos) {
		this.mapaRodamientos = rodamientos;
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
		float precio = buscarMapaRodamientoPrecio(rodamiento).getPrecio();

		if (precio <= 0)
			return -1;
		return precio * (1 - descuento);
	}

	public float calcularPrecioMinimo(Rodamiento rodamiento, String metodoPago) {
		// TODO calcularPrecioMinimo(Rodamiento rodamiento, String metodoPago)
		return -1;
	}

	private MapaRodamientoPrecio buscarMapaRodamientoPrecio(Rodamiento rod) {
		MapaRodamientoPrecio mrp = null;
		for (MapaRodamientoPrecio mrpTemp : mapaRodamientos) {
			if (rod.equals(mrpTemp.getRodamiento())) {
				 mrp = mrpTemp;
			}
		}
		return mrp;
	}
}
