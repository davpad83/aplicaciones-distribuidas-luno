<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.adtpo.cpr.bean.gui.*"%>
<%
	ListaComparativaBean lista = (ListaComparativaBean) session.getAttribute("listaFiltrada");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel=STYLESHEET
      href="estilos.css"
      type="text/css">
<title>Comparativa de Precios</title>
</head>
<body>
<form action="FiltrarListadoSVL" method="post">
	<p class="title" style="TEXT-DECORATION: underline; COLOR: #008000;">
		Cotizacion realizada:
	</p>
	
	<br>
	<center>
	<input type="submit" value="Ver Lista" name="action"  >
	</center>
	<br>
	
	<%if (lista != null) { %>
	<table width="70%" align="center">
		<tr>
			<th>Codigo</th>
			<th>Marca</th>
			<th>Origen</th>
			<th>Característica</th>
			<th>Precio</th>
			<th>Id de Lista</th>
			<th>Nombre de la lista</th>
		</tr>
		
		<% for(ItemListaComparativaBean il : lista.getItems()){ %>
	
		<tr>
			<td><%=il.getRodamiento().getCodigo()%></td>
			<td><%=il.getRodamiento().getMarca()%></td>
			<td><%=il.getRodamiento().getPais()%></td>
			<td><%=il.getRodamiento().getCaracteristica()%></td>
			<td>$ <%=il.getPrecio()%></td>
			<td><%=il.getListaProveedor().getNombre()%> 
			<td><%=il.getListaProveedor().getIdLista()%>
		</tr>
		<%
			}
		%>
		
	</table>
<br>
	<center>
		<br><u>Aplicar Filtro:</u>
		<br><input type="text" value="" name="filtro">
		<br><input type="submit" value="Filtrar por Origen" name="action" >
		<br><input type="submit" value="Filtrar por Marca" name="action" >
		
	</center>
	<br>
		<%
			}
		%>
	</form>	

</body>
</html>