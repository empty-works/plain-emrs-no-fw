<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Facilities</title>
</head>
<body>
	<h3><a href="<c:url value="/LoginServlet" />">Back to admin</a></h3>
	<h2><a href="<c:url value="/AddFacilityServlet" />">Add Facility</a></h2>
	<h2>Facility List</h2>	
	<table>
		<c:forEach items="${facilitiesList}" var="facility">
			<tr>
			<td>--------------------------------------------------------------
				<br><br>	
			</td>
			</tr>
			<tr>
				<td>ID: <c:out value="${facility.getId()}" /></td>	
			<tr>
				<td>Name: <a href="<c:url value="/FacilityServlet" > 
				
					<c:param name="facId" value="${facility.getId()}" />		
					<c:param name="facNam" value="${facility.getName()}" />		
					<c:param name="facCity" value="${facility.getCity()}" />		
					<c:param name="facCountry" value="${facility.getCountry()}" />		
				</c:url>"> <c:out value="${facility.getName()}" /></a>
			</td>
			</tr>
			<tr>
				<td>City: <c:out value="${facility.getCity()}" /></td>
			</tr>
			<tr>
				<td>Country: <c:out value="${facility.getCountry()}" /></td>
			</tr>	
		</c:forEach>
	</table>
</body>
</html>