<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel=STYLESHEET
      href="estilos.css"
      type="text/css">
<%@page import="com.adtpo.cpr.bean.gui.*"%>

<%
	SolicitudCotizacionBean solicitud = (SolicitudCotizacionBean) session.getAttribute("solicitudCotizacion");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Solicitar Cotizacion</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<form action="SolicitarCotizacionSVL" method="post">

	<p class="title"> Solicitar Cotizacion</p>
	
	<table class="solicitudTable" align="center">
	
		<tr>
			<td>Codigo:</td>
			<td><input type="text" value="" name="codigo"></td>
		</tr>
		<tr>
			<td>Marca:</td>
			<td><input type="text" value="" name="marca"></td>
		</tr>
		<tr>
			<td>Origen:</td>
			<td><input type="text" value="" name="origen"></td>
		</tr>
		<tr>
			<td>Caracteristicas:</td>
			<td><input type="text" value="" name="caracteristicas"></td>
		</tr>
		<tr>
			<td>Cantidad:</td>
			<td><input type="text" value="" name="cantidad"></td>
		</tr>
	</table>
	
	
	<br>
	<center>
	<input type="submit" value="Agregar" name="action" >
	</center>
	<br>
	
	
	<%if (solicitud != null) { %>
	
		<table id="listadoSolicitud" width="70%" align="center">
			<tr>
				<th>Codigo</th>
				<th>Marca</th>
				<th>Origen</th>
				<th>Característica</th>
				<th>Cantidad</th>
			</tr>
		
			<% for (int i=0 ; i<solicitud.getRodamientos().size() ; i++){ 
				ItemRodamientoBean cr = (ItemRodamientoBean) solicitud.getRodamientos().get(i);%>
			<tr>
				<td align="center"><%=cr.getRodamiento().getCodigo()%></td>
				<td align="center"><%=cr.getRodamiento().getMarca() %></td>
				<td align="center"><%=cr.getRodamiento().getPais()%></td>
				<td align="center"><%=cr.getRodamiento().getCaracteristica()%></td>
				<td align="center"><%=cr.getCantidad() %></td>
			</tr>
			
			<%}%>
		
		</table>

	<br>
	<center>
	<input type="submit" value="Guardar Solicitud" name="action" >
		<tr>
			<td>ID Cliente:</td>
			<td><input type="text" value="" name="idcliente"></td>
		</tr>
	</center>
	<br>
	
	<%}%>

</form>
<br>
	<br>
	<br>
<li><a href="index.jsp">Volver al inicio</a></li>
</body>
</html>