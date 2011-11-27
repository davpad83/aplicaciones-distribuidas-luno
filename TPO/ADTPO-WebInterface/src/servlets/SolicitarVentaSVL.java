package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adtpo.cpr.beans.model.SolicitudVenta;

public class SolicitarVentaSVL extends HttpServlet implements javax.servlet.Servlet  {
	private static final long serialVersionUID = 1L;

	private SolicitudVenta solicitudvta;

	public SolicitarVentaSVL() {
		super();
		this.solicitudvta = new SolicitudVenta();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
