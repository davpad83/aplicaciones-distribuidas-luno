package com.adtpo.web.servlets;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
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
	private BussinessDelegate bDel = new BussinessDelegate();

	private ListaComparativaBean lista;//getLista();
	

    public FiltrarListadoSVL() throws RemoteException {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			lista = bDel.getListaComparativa();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
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
	
	
	private ListaComparativaBean getLista() {

		ProveedorBean pr2 = new ProveedorBean();
		pr2.setCuit("34536542");
//		pr2.setDescuento(1.5f);
		pr2.setNombre("Rodriguez s.a.");
		pr2.setId(2);
		ProveedorBean pr1 = new ProveedorBean();
		pr1.setCuit("34538792");
//		pr1.setDescuento(7.2f);
		pr1.setNombre("sanchez s.a.");
		pr1.setId(1);

		RodamientoBean r1 = new RodamientoBean();
		r1.setCaracteristica("Permeable");
		r1.setCodigo("AAA001");
		r1.setMarca("Yamaha");
		r1.setPais("Japon");

		RodamientoBean r2 = new RodamientoBean();
		r2.setCaracteristica("Flexible");
		r2.setCodigo("XYZ127");
		r2.setMarca("Yamaha");
		r2.setPais("Argentina");

		RodamientoBean r3 = new RodamientoBean();
		r3.setCaracteristica("Acero Inoxidable");
		r3.setCodigo("AZZ012");
		r3.setMarca("Taranto");
		r3.setPais("Japon");

		MapaRodamientoPrecioBean mrp1 = new MapaRodamientoPrecioBean(r1, 15f);
		MapaRodamientoPrecioBean mrp2 = new MapaRodamientoPrecioBean(r2, 85f);
		MapaRodamientoPrecioBean mrp3 = new MapaRodamientoPrecioBean(r3, 11f);

		ArrayList<MapaRodamientoPrecioBean> Rodamientos1 = new ArrayList<MapaRodamientoPrecioBean>();
		Rodamientos1.add(mrp1);
		Rodamientos1.add(mrp2);
		Rodamientos1.add(mrp3);

		ArrayList<CondicionVentaBean> cvs = new ArrayList<CondicionVentaBean>();

		ListasProveedorBean lpb = new ListasProveedorBean();
		lpb.setNombre("lista a");
		lpb.setProveedor(pr2);
		lpb.setDescuento(0.21f);
		lpb.setIdLista(1);
		lpb.setMapaRodamientoPrecio(Rodamientos1);
//		lpb.setCondVenta(cvs);

		ListasProveedorBean lpb2 = new ListasProveedorBean();
		lpb2.setNombre("lista b");
		lpb2.setProveedor(pr1);
		lpb2.setDescuento(0.17f);
		lpb2.setIdLista(2);
		lpb2.setMapaRodamientoPrecio(Rodamientos1);
//		lpb2.setCondVenta(cvs);

		ItemListaComparativaBean ilc1 = new ItemListaComparativaBean();
		ilc1.setPrecio(3.6f);
		ilc1.setListaProveedor(lpb);
		ilc1.setRodamiento(r1);

		ItemListaComparativaBean ilc2 = new ItemListaComparativaBean();
		ilc2.setPrecio(7.2f);
		ilc2.setListaProveedor(lpb2);
		ilc2.setRodamiento(r2);

		ItemListaComparativaBean ilc3 = new ItemListaComparativaBean();
		ilc3.setPrecio(2.12f);
		ilc3.setListaProveedor(lpb2);
		ilc3.setRodamiento(r3);

		ArrayList<ItemListaComparativaBean> lilc = new ArrayList<ItemListaComparativaBean>();
		lilc.add(ilc1);
		lilc.add(ilc2);
		lilc.add(ilc3);

		ListaComparativaBean lc = new ListaComparativaBean();
		lc.setFechaLista(new Date());
		lc.setItems(lilc);

		return lc;
	}

}
