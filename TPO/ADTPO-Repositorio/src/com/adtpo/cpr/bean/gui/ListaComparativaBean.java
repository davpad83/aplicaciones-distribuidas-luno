package com.adtpo.cpr.bean.gui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class ListaComparativaBean implements Serializable{
	
	private static final long serialVersionUID = 3064130032473690640L;

	private int idListaComparativa;
	private Date fechaLista;
	private ArrayList<ItemListaComparativaBean> items;

	public ListaComparativaBean(){
		//Empty
	}
	
	public Date getFechaLista() {
		return fechaLista;
	}

	public void setFechaLista(Date fechaLista) {
		this.fechaLista = fechaLista;
	}

	public ArrayList<ItemListaComparativaBean> getItems() {
		return items;
	}

	public void setItems(ArrayList<ItemListaComparativaBean> items) {
		this.items = items;
	}

	public void setIdListaComparativa(int idListaComparativa) {
		this.idListaComparativa = idListaComparativa;
	}

	public int getIdListaComparativa() {
		return idListaComparativa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idListaComparativa;
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
		ListaComparativaBean other = (ListaComparativaBean) obj;
		if (idListaComparativa != other.idListaComparativa)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ListaComparativaBean \n[fechaLista=" + fechaLista
				+ ", \nidListaComparativa=" + idListaComparativa + ", \nitems="
				+ items + "]";
	}
}
