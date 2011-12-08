package com.adtpo.cpr.test;

import java.rmi.Naming;

import com.adtpo.cpr.bean.gui.ListaComparativaBean;
import com.adtpo.cpr.ro.IServicios;

public class getListaComparativaTest {
	
	private IServicios servicios;
	
	public void main(String[] args){
		ListaComparativaBean lista = null;

		try {
			servicios = (IServicios) Naming.lookup("//localhost/servicios");
			lista = servicios.getListaComparativa();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.print(lista.toString());
		
	}
}
