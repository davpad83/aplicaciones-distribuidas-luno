package com.adtpo.cpr.bean.gui;


public class ItemListaComparativaBean {


	private RodamientoBean rodamiento;
	private float precio;	
	private ListasProveedorBean listaProveedor;
	
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((listaProveedor == null) ? 0 : listaProveedor.hashCode());
		result = prime * result + Float.floatToIntBits(precio);
		result = prime * result
				+ ((rodamiento == null) ? 0 : rodamiento.hashCode());
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
		if (listaProveedor == null) {
			if (other.listaProveedor != null)
				return false;
		} else if (!listaProveedor.equals(other.listaProveedor))
			return false;
		if (Float.floatToIntBits(precio) != Float.floatToIntBits(other.precio))
			return false;
		if (rodamiento == null) {
			if (other.rodamiento != null)
				return false;
		} else if (!rodamiento.equals(other.rodamiento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemListaComparativaBean \n[listaProveedor=" + listaProveedor
				+ ", \nprecio=" + precio + ", \nrodamiento=" + rodamiento + "]";
	}
}
