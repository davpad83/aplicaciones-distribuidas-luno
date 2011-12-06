package com.adtpo.web.servlets;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.adtpo.cpr.bean.gui.*;
import com.adtpo.web.controlador.BussinessDelegate;
import com.thoughtworks.xstream.XStream;


 public class SolicitarCotizacionSVL extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	 
   static final long serialVersionUID = 1L;
   
   private SolicitudCotizacionBean solicitud ;
   private BussinessDelegate bDel = new BussinessDelegate();
   
   
	public SolicitarCotizacionSVL() {
		super();
		this.solicitud = new SolicitudCotizacionBean();
	
	}   	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = (String) request.getParameter("action"); 
        
        // Agregar rodamiento a la lista
        if(action.equals("Agregar")){
               	try {
					this.agregarRodamiento(request,response);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
			}
		}
		if (action.equals("Guardar Solicitud")) {

			try {
				this.guardarSolicitud(request, response);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void guardarSolicitud(HttpServletRequest request,
			HttpServletResponse response) throws NumberFormatException, Exception {
		HttpSession session = request.getSession(true);

	    String idcliente = request.getParameter("idcliente");
	    ClienteBean cli = bDel.getCliente(Integer.parseInt(idcliente));
	    solicitud.setCliente(cli);
	    session.setAttribute("solicitudVenta", solicitud);

	    
	    //Generar el XML
		XStream xstream = new XStream();
		String tempxml = xstream.toXML(solicitud);
	    
	    // Create file 
		File xml = new File(tempxml);

//	    Obtener la cotizacion para la solicitud
		CotizacionBean cotizado = bDel.enviarSolicitudDeCotizacion(xml);
		
		// Imprimir la cotizacion
		session.setAttribute("cotizacion", cotizado);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/VerCotizacion.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
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
        itemRod.setCantidad(Integer.parseInt(cantidad));
        itemRod.setRodamiento(rod);
     
        if(solicitud.getRodamientos()==null){
        	ArrayList<ItemRodamientoBean> irb = new ArrayList<ItemRodamientoBean>();
        	solicitud.setRodamientos(irb);
        }
        
        ArrayList<ItemRodamientoBean> lista = solicitud.getRodamientos();
        lista.add(itemRod);
        solicitud.setRodamientos(lista);
        
        session.setAttribute("solicitudCotizacion", solicitud);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/SolicitarCotizacion.jsp");
        try {
                dispatcher.forward(request, response);
        } catch (ServletException e) {
                e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        }
	}
}