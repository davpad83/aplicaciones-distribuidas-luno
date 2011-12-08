package com.adtpo.cpr.bean.gui;

import java.util.ArrayList;
import java.util.Date;

public class ListaComparativaBean {
	private Date fechaLista;
	private ArrayList<ItemListaComparativaBean> items;

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

	@Override
	public String toString() {
		return "ListaComparativaBean \n[fechaLista=" + fechaLista
				+ ", \nitems=" + items + "]";
	}
}
