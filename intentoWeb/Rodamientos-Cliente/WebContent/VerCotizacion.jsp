<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="entitiesVO.*"%>

<%
	Cotizacion cotizacion = (Cotizacion) session.getAttribute("cotizacion");
%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Oficina de venta</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>


<!-- Content -->
<div id="content">
<p class="title">Ver Cotización</p>

<table class="facturaTable" align="center">
	<tr>
		<td>Fecha: <%=cotizacion.getFechaEmision().toString()%></td>
	</tr>
	<tr>
		<td>Vigencia: <%=cotizacion.getVigencia()%></td>
	</tr>
	<tr>
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
		for (int i = 0; i < cotizacion.getRodamientos().size(); i++) {
			CantidadRodamientoPrecioVO crp = cotizacion.getRodamientos().get(i);
	%>
	<tr>
		<td><%=crp.getCantidadRodamiento().getRodamiento().getCodigo()%></td>
		<td><%=crp.getCantidadRodamiento().getRodamiento().getMarca()%></td>
		<td><%=crp.getCantidadRodamiento().getRodamiento().getOrigen()%></td>
		<td><%=crp.getCantidadRodamiento().getRodamiento().getCaracteristicas()%></td>
		<td><%=crp.getCantidadRodamiento().getCantidad()%></td>
		<td><%=crp.getPrecio()%></td>
		<td><%=crp.getCantidadRodamiento().getCantidad() * crp.getPrecio()%>
	</tr>
	<%
		}
	%>
</table>

</div>
<!-- End content -->


</body>
</html>