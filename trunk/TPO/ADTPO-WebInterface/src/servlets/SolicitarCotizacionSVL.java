package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.adtpo.cpr.beans.model.Cliente;
import com.adtpo.cpr.beans.model.Cotizacion;
import com.adtpo.cpr.beans.model.ItemRodamiento;
import com.adtpo.cpr.beans.model.Rodamiento;
import com.adtpo.cpr.beans.model.SolicitudCotizacion;

import controlador.BussinessDelegate;

 public class SolicitarCotizacionSVL extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	 
   static final long serialVersionUID = 1L;
   
   private SolicitudCotizacion solicitud ;
   private BussinessDelegate bd = new BussinessDelegate();
   
 //  private HashMap<String, SolicitudCotizacion> solicitudes;
   
	public SolicitarCotizacionSVL() {
		super();
		this.solicitud = new SolicitudCotizacion();
	
	}   	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = (String) request.getParameter("action"); 
        
        // Agregar rodamiento
        if(action.equals("Agregar")){
               	try {
					this.agregarRodamiento(request,response);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
       if (action.equals("Guardar Solicitud")){
    	   
    	   this.guardarSolicitud(request, response);
       }
     
}   
	
	private void guardarSolicitud(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		
	    String idcliente = request.getParameter("idcliente");
	    Cliente cli = bd.getCliente(Integer.parseInt(idcliente));
	    solicitud.setCliente(cli);
	    session.setAttribute("solicitudVenta", solicitud);
	    
	    //Generar el XML
//		XStream xstream = new XStream();
//		xstream.toXML(solicitud);
		
		Cotizacion cotizado = new Cotizacion();
			//cotizado = bd.RecibirCotizacion();
		cotizado.setIdCotizazion(12);
		
		ItemRodamiento a = new ItemRodamiento(new Rodamiento("654", "ford", "choto", "china"), 22);
		a.setPrecio(51);
		solicitud.agregarRodamiento(a);
		cotizado.setItems((ArrayList<ItemRodamiento>) solicitud.getRodamientos());
		cotizado.setVencimiento(new Date(2011,12,31));
		
		session.setAttribute("cotizacion", cotizado);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/VerCotizacion.jsp");
	//	response.sendRedirect("confirmacionSolicitarCotizacion.jsp"); //despues cambia por requestDispathcer a VerCotizacion
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
        
        Rodamiento rod = new Rodamiento (codigo, marca, caracteristicas, origen);
        ItemRodamiento itemRod = new ItemRodamiento (rod, Integer.parseInt(cantidad));
     
        solicitud.agregarRodamiento(itemRod);
      
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