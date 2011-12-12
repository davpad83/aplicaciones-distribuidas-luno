package com.adtpo.cpr.test;

import com.adtpo.cpr.beans.model.CasaCentral;
import com.adtpo.cpr.beans.model.ListaComparativa;

public class Test {

	
	public static void main(String[] args){
	
		ListaComparativa lista = CasaCentral.getInstancia().getListaComparativa();
		System.out.print(lista.toString());
	}
}

