package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.adtpo.cpr.beans.model.Cliente;
import com.adtpo.cpr.beans.model.ItemRodamiento;
import com.adtpo.cpr.beans.model.Rodamiento;
import com.adtpo.cpr.beans.model.SolicitudCotizacion;
import com.adtpo.cpr.beans.model.SolicitudVenta;

import controlador.BussinessDelegate;

public class SolicitarVentaSVL extends HttpServlet implements javax.servlet.Servlet  {
	private static final long serialVersionUID = 1L;

	   private SolicitudVenta solicitud ;
	   private BussinessDelegate bd = new BussinessDelegate();

	public SolicitarVentaSVL() {
		super();
		this.solicitud = new SolicitudVenta();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
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

private void guardarSolicitud(HttpServletRequest request,
		HttpServletResponse response) {
	try {
	bd.enviarSolicitudVenta(solicitud);
	
		response.sendRedirect("confirmacionSolicitarVenta.jsp");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


}

public void agregarRodamiento (HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, Exception{
	
	HttpSession session = request.getSession(true);
	
	String idcliente = request.getParameter("idcliente");
    String codigo = request.getParameter("codigo");
    String marca = request.getParameter("marca");
    String caracteristicas = request.getParameter("caracteristicas");
    String origen = request.getParameter("origen");
    String cantidad = request.getParameter("cantidad");
    
    Rodamiento rod = new Rodamiento (codigo, marca, caracteristicas, origen);
    
    ItemRodamiento itemRod = new ItemRodamiento (rod, Integer.parseInt(cantidad));
    
    Cliente cli = bd.getCliente(Integer.parseInt(idcliente));
    
    solicitud.agregarRodamiento(itemRod);
    solicitud.setCliente(cli);
    
    session.setAttribute("solicitudCotizacion", solicitud);
    
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
