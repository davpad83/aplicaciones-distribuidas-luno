<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Solicitud de cotizacion</title>
</head>
<body>
<form action="GenerarOrdenCompra.jsp"> 
  	<table>
  	<tr>
    	<td>Item:</td><td><input type="text" name="item"></td>
    </tr>
    <tr>
    	<td>Cantidad:</td><td><input type="text" name="cantidad"></td>
    </tr>
    <tr>
    	<td>Precio:</td><td><input type="text" name="precio"></td>
    </tr>
    </table>
    <br/><input type="submit" value="Cotizar">
</form>
</body>
</html>