 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.adtpo.cpr.bean.gui.*"%>

<%
	FacturaBean factura = (FacturaBean) session.getAttribute("factura");
%>

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

<div id="content">
<p class="title" style="TEXT-DECORATION: underline; COLOR: #008000;"><center>
<h2>
	Ver factura
</h2>
</center></p>

<table class="facturaTable" align="center">
	<tr><td>Fecha:</td><%=factura.getFechaFactura().toString()%></tr>
</table>

		<table class="itemsFactura" width="70%" align="center">
			<tr>
				<th>Codigo</th>
				<th>Marca</th>
				<th>Origen</th>
				<th>Característica</th>
				<th>Cantidad</th>
				<th>Precio unitario</th>
			</tr>
	
			<%
				for(ItemRodamientoBean crp: factura.getVenta().getCotizacion().getItems()){
			%>
			<tr>
				<td><%=crp.getRodamiento().getCodigo()%></td>
				<td><%=crp.getRodamiento().getMarca()%></td>
				<td><%=crp.getRodamiento().getPais()%></td>
				<td><%=crp.getRodamiento().getCaracteristica()%></td>
				<td><%=crp.getCantidad()%></td>
				<td><%=crp.getPrecio()%></td>
			</tr>
			<%
				}
			%>
		</table>
		
		
</div>

<H3>
Total:<%= factura.calcularTotal()%>
</H3>

</body>
</html> 