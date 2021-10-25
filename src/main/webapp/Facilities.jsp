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
	<h2>Add Facility</h2>
	<a href="<c:url value="/FacilitySetup.jsp" />">Add Facility</a>
	<br><br>
	<h2>Facility List</h2>	
	<table>
		<c:forEach items="${facilitiesList}" var="facility">
			<tr>
			<td>--------------------------------------------------------------</td>
			</tr>
			<tr>
			<td>ID: <c:out value="${facility.getId()}" /></td>	
			<td>Name: <a href="<c:url value="/Facility.jsp"> 
					<c:param name="facility" value="${facility}" />		
				</c:url>"> <c:out value="${facility.getName()}" /></a>
			</td>
			<td>City: <c:out value="${facility.getCity()}" /></td>
			<td>Country: <c:out value="${facility.getCountry()}" /></td>
			</tr>	
		</c:forEach>
	</table>
</body>
</html>