<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="entidades.*"%>

<%
	SolicitudCotizacion solicitud = (SolicitudCotizacion) session.getAttribute("solicitudCotizacion");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="SolicitarCotizacionSVL" method="post">

	<p class="title"> Solicitar Cotizacion</p>
	
	<table class="solicitudTable" align="center">
		<tr>
			<td>ID Cliente:</td>
			<td><input type="text" value="" name="idcliente"></td>
		</tr>
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
				<th>CaracterÝstica</th>
				<th>Cantidad</th>
			</tr>
		
			<% for (int i=0 ; i<solicitud.getRodamientos().size() ; i++){ CantidadRodamiento cr = (CantidadRodamiento) solicitud.getRodamientos().get(i);%>
			<tr>
				<td align="center"><%=cr.getRodamiento().getCodigo()%></td>
				<td align="center"><%=cr.getRodamiento().getMarca() %></td>
				<td align="center"><%=cr.getRodamiento().getOrigen()%></td>
				<td align="center"><%=cr.getRodamiento().getCaracteristicas()%></td>
				<td align="center"><%=cr.getCantidad() %></td>
			</tr>
			<%}%>
		
		</table>

	<br>
	<center>
	<input type="submit" value="Guardar Solicitud" name="action" >
	</center>
	<br>
	
	<%}%>

</form>

</body>
</html>