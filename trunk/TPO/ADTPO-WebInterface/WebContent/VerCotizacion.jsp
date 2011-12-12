<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.adtpo.cpr.bean.gui.*"%>

<%
	CotizacionBean cotizacion = (CotizacionBean) session.getAttribute("cotizacion");
%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel=STYLESHEET
      href="estilos.css"
      type="text/css">
<title>Oficina de venta</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>


<!-- Content -->
<div id="content">
<p class="title" style="TEXT-DECORATION: underline; COLOR: #008000;">
	Cotizacion realizada:
</p>

<table class="facturaTable" align="center">
	
	
	<tr>
		<th>Cliente: <%=cotizacion.getCliente().getNombre()%> <%=cotizacion.getCliente().getApellido()%> - Id: <%=cotizacion.getCliente().getId()%></td>
	</tr>
	<tr>
		<td>Vigencia: <%=cotizacion.getVencimiento()%></td>
	</tr>
</table>

<table class="itemsFactura" width="70%" align="center">
	<tr>
		<th>Codigo</th>
		<th>Marca</th>
		<th>Origen</th>
		<th>Característica</th>
		<th>Cantidad</th>
		<th>Precio unitario</th>
		<th>Precio por cantidad</th>
	</tr>
	<%
		for (int i = 0; i < cotizacion.getItems().size(); i++) {
			ItemRodamientoBean crp =(ItemRodamientoBean) cotizacion.getItems().get(i);
	%>
	<tr>
		<td><%=crp.getRodamiento().getCodigo()%></td>
		<td><%=crp.getRodamiento().getMarca()%></td>
		<td><%=crp.getRodamiento().getPais()%></td>
		<td><%=crp.getRodamiento().getCaracteristica()%></td>
		<td><%=crp.getCantidad()%></td>
		<td>$ <%=crp.getPrecio() + (crp.getPrecio()* cotizacion.getIva())%></td>
		<td>$ <%=crp.getCantidad() * (crp.getPrecio()+ (crp.getPrecio()* cotizacion.getIva()))%>
	</tr>
	<%
		}
	%>
</table>

</div>
<br>
	<br>
	<br>
<li><a href="index.jsp">Volver al inicio</a></li>


</body>
</html>