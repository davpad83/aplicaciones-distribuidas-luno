package com.adtpo.web.servlets;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.adtpo.cpr.bean.gui.*;
import com.adtpo.web.controlador.BussinessDelegate;
import com.thoughtworks.xstream.XStream;

public class FiltrarListadoSVL extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ListaComparativaBean lista;
	private BussinessDelegate bDel = new BussinessDelegate();


    public FiltrarListadoSVL() throws RemoteException {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			this.lista = bDel.getListaComparativa();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		String action = (String) request.getParameter("action");
		String filtro = request.getParameter("filtro");
	
		HttpSession session = request.getSession(true);
		ArrayList<ItemListaComparativaBean> lcb = new ArrayList<ItemListaComparativaBean>();
		
		/********************************************************/
		if (action.equals("Filtrar por Marca"))
			for(ItemListaComparativaBean il : lista.getItems() ){
				if(il.getRodamiento().getMarca().equals(filtro))
					lcb.add(il);
			}
		/********************************************************/
		if (action.equals("Filtrar por Origen"))
			for(ItemListaComparativaBean il : lista.getItems() ){
				if(il.getRodamiento().getPais().equals(filtro))
					lcb.add(il);
			}
		
		/********************************************************/
		if (action.equals("Ver Lista completa"))
			lcb = lista.getItems();
		/********************************************************/
		
		ListaComparativaBean listaFiltrada = new ListaComparativaBean();
		listaFiltrada.setFechaLista(lista.getFechaLista());
		listaFiltrada.setItems(lcb);
		
		session.setAttribute("listaFiltrada", listaFiltrada);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/verListaFiltrada.jsp");
	    try {
	        dispatcher.forward(request, response);
		} catch (ServletException e) {
		        e.printStackTrace();
		} catch (IOException e) {
		        e.printStackTrace();
		}	
	}
}
