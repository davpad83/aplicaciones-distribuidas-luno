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

	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idLista;

	private String nombre;
	private float descuento;

	@OneToMany
	@JoinColumn(name = "idCondicion")
	private List<CondicionVenta> condVenta = new ArrayList<CondicionVenta>();

	@ManyToOne()
	@JoinColumn(name = "idProveedor")
	private Proveedor proveedor;

	@Embedded
	@JoinColumn(name="rodamiento")
	private ArrayList<MapaRodamientoPrecio> mapaRodamientos;

	public int getIdLista() {
		return idLista;
	}

	public List<CondicionVenta> getCondVenta() {
		return condVenta;
	}

	public void setCondVenta(List<CondicionVenta> condVenta) {
		this.condVenta = condVenta;
	}

	public ArrayList<MapaRodamientoPrecio> getMapaRodamientoPrecio() {
		return mapaRodamientos;
	}

	public void setMapaRodamientoPrecio(ArrayList<MapaRodamientoPrecio> rodamientos) {
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
		Float precio = mapaRodamientos.get(buscarMapaRodamientoIndex(rodamiento))
				.getPrecio();
		if (precio == null)
			return -1;
		return precio.floatValue() * (1 - descuento);
	}

	public float calcularPrecioMinimo(Rodamiento rodamiento, String metodoPago) {
		// TODO calcularPrecioMinimo(Rodamiento rodamiento, String metodoPago)
		return -1;
	}

	private int buscarMapaRodamientoIndex(Rodamiento rod) {
		int index = 0;
		for (MapaRodamientoPrecio mrp : mapaRodamientos) {
			if (rod.equals(mrp.getRodamiento())) {
				index = mapaRodamientos.indexOf(mrp.getRodamiento());
			}
		}
		return index;
	}
}
