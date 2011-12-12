package com.adtpo.cpr.bean.gui;

import java.io.Serializable;


public class ItemListaComparativaBean implements Serializable {

	private static final long serialVersionUID = -3119534177439294866L;

	private int idItemListaComparativa;
	private RodamientoBean rodamiento;
	private float precio;	
	private ListasProveedorBean listaProveedor;
	
	public ItemListaComparativaBean(){
		//Empty
	}
	
	public RodamientoBean getRodamiento() {
		return rodamiento;
	}
	public void setRodamiento(RodamientoBean rodamiento) {
		this.rodamiento = rodamiento;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public ListasProveedorBean getListaProveedor() {
		return listaProveedor;
	}
	public void setListaProveedor(ListasProveedorBean listaProveedor) {
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
		ItemListaComparativaBean other = (ItemListaComparativaBean) obj;
		if (idItemListaComparativa != other.idItemListaComparativa)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemListaComparativaBean \n[idItemListaComparativa="
				+ idItemListaComparativa + ", \nlistaProveedor="
				+ listaProveedor + ", \nprecio=" + precio + ", \nrodamiento="
				+ rodamiento + "]";
	}
}
