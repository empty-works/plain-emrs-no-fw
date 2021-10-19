<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Facility Overview</title>
</head>
<body>
	<h2>Facility Overview</h2>
	<br><br>	
	<table>
	<tr>
	<td>ID: </td>	
	<td><c:out value="${fbean.getId()}"></c:out></td>
	</tr>	
	<tr>
	<td>Name: </td>
	<td><c:out value="${fbean.getName()}"></c:out></td>
	</tr>
	<tr>
	<td>Street Address: </td>
	<td><c:out value="${fbean.getStreetAddress()}"></c:out></td>
	</tr>
	<tr>
	<td>City: </td>
	<td><c:out value="${fbean.getCity()}"></c:out></td>
	</tr>
	<tr>
	<td>Country: </td>
	<td><c:out value="${fbean.getCountry()}"></c:out></td>
	</tr>
	<tr>
	<td>Zip Code: </td>
	<td><c:out value="${fbean.getZipCode()}"></c:out></td>
	</tr>
	</table>
</body>
</html>