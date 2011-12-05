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
		
		//START HARDCODE====================================================================
//	    
//	    CotizacionBean cotizado = new CotizacionBean();
//		cotizado.setIdCotizacion(12);
//		cotizado.setItems(solicitud.getRodamientos());
//		cotizado.setVencimiento(new Date(2011,12,31));
		//END HARDCODE====================================================================

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
 

 /*   ListasProveedorBean lp = new ListasProveedorBean();
	lp.setDescuento((float) 0.21);
	lp.setIdLista(123);
	lp.setNombre("Lista test");
	
	ProveedorBean proveedor = new ProveedorBean();
	proveedor.setCuit("80-34453244-6");
	proveedor.setDescuento((float) 0.05);
	proveedor.setNombre("Proveo Rodamientos s.a.");
	proveedor.setId(74415);
	lp.setProveedor(proveedor);
	
	RodamientoBean b = new RodamientoBean();
	b.setCaracteristica("elastico");
	b.setCodigo("wqwe223");
	b.setMarca("Kawasaki");
	b.setPais("Japon");
	
	RodamientoBean c = new RodamientoBean();
	c.setCaracteristica("elastico");
	c.setCodigo("wqwe223");
	c.setMarca("Yamaha");
	c.setPais("Japon");
	
	RodamientoBean a = new RodamientoBean();
	a.setCaracteristica("barato");
	a.setCodigo("AC54485");
	a.setMarca("Kawasaki");
	a.setPais("Taiwan");
	
	RodamientoBean d = new RodamientoBean();
	d.setCaracteristica("expansible");
	d.setCodigo("AC54485");
	d.setMarca("chinchulancha");
	d.setPais("Taiwan");
	
	RodamientoBean e = new RodamientoBean();
	e.setCaracteristica("expansible");
	e.setCodigo("XZY233");
	e.setMarca("Kawasaki");
	e.setPais("Japon");
	
	RodamientoBean f = new RodamientoBean();
	f.setCaracteristica("acero inoxidable");
	f.setCodigo("922763");
	f.setMarca("Banana");
	f.setPais("Brasil");
	
	RodamientoBean g = new RodamientoBean();
	g.setCaracteristica("Alta Calidad");
	g.setCodigo("osi838");
	g.setMarca("Kawasaki");
	g.setPais("Argentina");
	
	RodamientoBean h = new RodamientoBean();
	h.setCaracteristica("resistencia");
	h.setCodigo("938eu");
	h.setMarca("Kawasaki");
	h.setPais("Argentina");
	
	RodamientoBean i = new RodamientoBean();
	i.setCaracteristica("Acero Inoxidable");
	i.setCodigo("658jud5");
	i.setMarca("Kawasaki");
	i.setPais("Argentina");
	
	RodamientoBean j = new RodamientoBean();
	j.setCaracteristica("Alta Resistencia Termica");
	j.setCodigo("CDC999");
	j.setMarca("Yamaha");
	j.setPais("Taiwan");
	
	RodamientoBean k = new RodamientoBean();
	k.setCaracteristica("permeable");
	k.setCodigo("PP0564");
	k.setMarca("Yamaha");
	k.setPais("Japon");
	
	RodamientoBean l = new RodamientoBean();
	l.setCaracteristica("impermeable");
	l.setCodigo("AC54485");
	l.setMarca("Yamaha");
	l.setPais("Taiwan");
	
	ArrayList <MapaRodamientoPrecioBean> rodamientos = new ArrayList<MapaRodamientoPrecioBean> ();
	
	
	MapaRodamientoPrecioBean A = new MapaRodamientoPrecioBean(a, (float) 12.00); rodamientos.add(A);
	MapaRodamientoPrecioBean B = new MapaRodamientoPrecioBean(b, (float) 5.70);rodamientos.add(B);
	MapaRodamientoPrecioBean C = new MapaRodamientoPrecioBean(c, (float) 7.50);rodamientos.add(C);
	MapaRodamientoPrecioBean D = new MapaRodamientoPrecioBean(d, (float) 12.00);rodamientos.add(D);
	MapaRodamientoPrecioBean E = new MapaRodamientoPrecioBean(e, (float) 32.70);rodamientos.add(E);
	MapaRodamientoPrecioBean F = new MapaRodamientoPrecioBean(f, (float) 7.50);rodamientos.add(F);
	MapaRodamientoPrecioBean G = new MapaRodamientoPrecioBean(g, (float) 12.00);rodamientos.add(G);
	MapaRodamientoPrecioBean H = new MapaRodamientoPrecioBean(h, (float) 59.00);rodamientos.add(H);
	MapaRodamientoPrecioBean I = new MapaRodamientoPrecioBean(i, (float) 7.50);rodamientos.add(I);
	MapaRodamientoPrecioBean J = new MapaRodamientoPrecioBean(j, (float) 30.00);rodamientos.add(J);
	MapaRodamientoPrecioBean K = new MapaRodamientoPrecioBean(k, (float) 6.75);rodamientos.add(K);
	MapaRodamientoPrecioBean L = new MapaRodamientoPrecioBean(l, (float) 10.50);rodamientos.add(L);
			
	lp.setMapaRodamientoPrecio(rodamientos);
	
	
	XStream xstream = new XStream();
	String tempxml = xstream.toXML(lp);
	System.out.println(tempxml);*/
	
 
