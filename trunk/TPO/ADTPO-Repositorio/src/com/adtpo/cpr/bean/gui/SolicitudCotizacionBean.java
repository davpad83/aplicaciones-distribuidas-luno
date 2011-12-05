package com.adtpo.cpr.bean.gui;

import java.io.Serializable;
import java.util.ArrayList;

public class SolicitudCotizacionBean implements Serializable{

	private static final long serialVersionUID = -5431535876752077704L;

	private ClienteBean cliente;
	private ArrayList<ItemRodamientoBean> rodamientos;

	public ClienteBean getCliente() {
		return cliente;
	}

	public void setCliente(ClienteBean cliente) {
		this.cliente = cliente;
	}

	public ArrayList<ItemRodamientoBean> getRodamientos() {
		return rodamientos;
	}

	public void setRodamientos(ArrayList<ItemRodamientoBean> rodamientos) {
		this.rodamientos = rodamientos;
	}
	
}
