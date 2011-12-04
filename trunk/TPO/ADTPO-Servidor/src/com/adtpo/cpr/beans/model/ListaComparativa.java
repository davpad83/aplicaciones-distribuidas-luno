package com.adtpo.cpr.beans.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

@Entity
public class ListaComparativa implements Serializable {

	@Transient private static final long serialVersionUID = 8157901730509347675L;

	@Id
	private Date fechaLista;
	
	@Embedded
	private ArrayList<ItemListaComparativa> items;
	
	public Date getFechaLista() {
		return fechaLista;
	}
	
	public void setFechaLista(Date fechaLista) {
		this.fechaLista = fechaLista;
	}
	
	public ArrayList<ItemListaComparativa> getItems() {
		return items;
	}
	
	public void setItems(ArrayList<ItemListaComparativa> items) {
		this.items = items;
	}
	
	public ListaComparativa(){
		//Empty
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fechaLista == null) ? 0 : fechaLista.hashCode());
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
		ListaComparativa other = (ListaComparativa) obj;
		if (fechaLista == null) {
			if (other.fechaLista != null)
				return false;
		} else if (!fechaLista.equals(other.fechaLista))
			return false;
		return true;
	}

}
