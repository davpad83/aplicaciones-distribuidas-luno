package com.adtpo.web.servlets;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.adtpo.cpr.bean.gui.*;
import com.adtpo.web.controlador.BussinessDelegate;
import com.thoughtworks.xstream.XStream;


public class SolicitarVentaSVL extends HttpServlet implements javax.servlet.Servlet  {
	   private static final long serialVersionUID = 1L;

	   private SolicitudVentaBean solicitud ;
	   private BussinessDelegate bDel = new BussinessDelegate();

		public SolicitarVentaSVL() {
		}
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request,response);
		}
	
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			this.solicitud = new SolicitudVentaBean();
				
		String action = (String) request.getParameter("action"); 
	    
	    // Agregar rodamiento
	    if(action.equals("Agregar")){
	           	try {
					this.agregarRodamiento(request,response);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	   if (action.equals("Guardar Solicitud")){
		   try {
			this.guardarSolicitud(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	   }
	 
	}   
	
	private void guardarSolicitud(HttpServletRequest request,HttpServletResponse response) throws NumberFormatException, Exception {
		HttpSession session = request.getSession(true);
		
	    String idcliente = request.getParameter("idcliente");
//	    ClienteBean cli = bDel.getCliente(Integer.parseInt(idcliente));
//	    
//	    solicitud.setCliente(cli);
	    solicitud.setFecha(Calendar.getInstance().getTime());
		
	    //Generar el XML
		XStream xstream = new XStream();
		String tempxml = xstream.toXML(solicitud);
	    
	    // Create file 
		File xml = new File(tempxml);
	    
	    session.setAttribute("solicitudVenta", solicitud);
	  
		FacturaBean factura = bDel.enviarSolicitudVenta(xml);
	    
		session.setAttribute("factura", factura);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/VerFactura.jsp");
	    try {
	        dispatcher.forward(request, response);
		} catch (ServletException e) {
		        e.printStackTrace();
		} catch (IOException e) {
		        e.printStackTrace();
		}	
	}
	
	public void agregarRodamiento (HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, Exception{
		
		HttpSession session = request.getSession(true);
	
	    String codigo = request.getParameter("codigo");
	    String marca = request.getParameter("marca");
	    String caracteristicas = request.getParameter("caracteristicas");
	    String origen = request.getParameter("origen");
	    String cantidad = request.getParameter("cantidad");
	    
	    RodamientoBean rod = new RodamientoBean ();
	    rod.setCodigo(codigo);
	    rod.setMarca(marca);
	    rod.setCaracteristica(caracteristicas);
	    rod.setPais(origen);
	    
	    ItemRodamientoBean itemRod = new ItemRodamientoBean ();
	    itemRod.setRodamiento(rod);
	    itemRod.setCantidad(Integer.parseInt(cantidad));
	     
        if(solicitud.getRodamientos()==null){
        	ArrayList<ItemRodamientoBean> irb = new ArrayList<ItemRodamientoBean>();
        	solicitud.setRodamientos(irb);
        }
        
        ArrayList<ItemRodamientoBean> lista = solicitud.getRodamientos();
        lista.add(itemRod);
        solicitud.setRodamientos(lista);
	    
	    session.setAttribute("solicitudVenta", solicitud);
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/SolicitarVenta.jsp");
	    try {
	            dispatcher.forward(request, response);
	    } catch (ServletException e) {
	            e.printStackTrace();
	    } catch (IOException e) {
	            e.printStackTrace();
	    }
	}
}
