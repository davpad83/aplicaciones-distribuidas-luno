package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.adtpo.cpr.beans.model.ItemRodamiento;
import com.adtpo.cpr.beans.model.OficinaVentas;
import com.adtpo.cpr.beans.model.Rodamiento;
import com.adtpo.cpr.beans.model.SolicitudCotizacion;





 public class SolicitarCotizacionSVL extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	 
   static final long serialVersionUID = 1L;
   
   private SolicitudCotizacion solicitud ;
   
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
                this.agregarRodamiento(request,response);
        }
     
}   
	
	public void agregarRodamiento (HttpServletRequest request, HttpServletResponse response){
		
		HttpSession session = request.getSession(true);
		
		String idcliente = request.getParameter("idcliente");
        String codigo = request.getParameter("codigo");
        String marca = request.getParameter("marca");
        String caracteristicas = request.getParameter("caracteristicas");
        String origen = request.getParameter("origen");
        String cantidad = request.getParameter("cantidad");
        
        Rodamiento rod = new Rodamiento (codigo, marca, caracteristicas, origen);
        
        ItemRodamiento itemRod = new ItemRodamiento (rod, Integer.parseInt(cantidad));
        

        
        solicitud.agregarRodamiento(itemRod);
        solicitud.setCliente(cliente);
        
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