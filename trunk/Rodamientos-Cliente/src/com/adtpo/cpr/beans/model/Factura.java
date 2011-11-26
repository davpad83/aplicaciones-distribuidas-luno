package com.adtpo.cpr.beans.model;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name="Factura")

public class Factura {
	
	private Integer idFactura;
	private Cliente cliente;
	private ArrayList<ItemRodamientoPrecio> items;
	private Float descuento;
	private CondicionVenta condicionDeVenta;
	private Float totalFacturado;

}
