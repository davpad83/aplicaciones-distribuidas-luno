package com.adtpo.web.servlets;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.adtpo.cpr.bean.gui.*;
import com.adtpo.web.controlador.BussinessDelegate;

public class FiltrarListadoSVL extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ListaComparativaBean lista;
	private BussinessDelegate bDel = new BussinessDelegate();


    public FiltrarListadoSVL() throws RemoteException {
        super();
        this.lista = bDel.getListaComparativa();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = (String) request.getParameter("action");
		String filtro = request.getParameter("filtro");
	
		HttpSession session = request.getSession(true);
		ArrayList<ItemListaComparativaBean> lcb = new ArrayList<ItemListaComparativaBean>();
		if (action.equals("Filtrar por Marca"))
			for(ItemListaComparativaBean il : lista.getItems() ){
				if(!il.getRodamiento().getMarca().equals(filtro))
					lcb.add(il);
			}
		if (action.equals("Filtrar por Origen"))
			for(ItemListaComparativaBean il : lista.getItems() ){
				if(!il.getRodamiento().getPais().equals(filtro))
					lcb.add(il);
			}
		
		if (action.equals("Ver Lista"))
			lcb = lista.getItems();
			
		
		ListaComparativaBean listaFiltrada = new ListaComparativaBean();
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
