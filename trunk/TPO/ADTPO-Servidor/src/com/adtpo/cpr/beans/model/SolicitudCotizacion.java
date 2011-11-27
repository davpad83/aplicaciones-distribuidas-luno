package com.adtpo.cpr.beans.model;

import java.util.ArrayList;

public class SolicitudCotizacion {
 private Cliente cliente;
 private ArrayList<ItemRodamiento> rodamientos;
public Cliente getCliente() {
	return cliente;
}
public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}
public ArrayList<ItemRodamiento> getRodamientos() {
	return rodamientos;
}
public void setRodamientos(ArrayList<ItemRodamiento> rodamientos) {
	this.rodamientos = rodamientos;
}
public void agregarRodamiento(ItemRodamiento itemRod) {
	rodamientos.add(itemRod);	
}
public void setCliente(int idcliente) {
	
	this.cliente = cliente;
}
  
}
