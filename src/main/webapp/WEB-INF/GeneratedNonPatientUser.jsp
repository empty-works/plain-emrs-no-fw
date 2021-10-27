<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Plain EMRS - Generated User</title>
</head>
<body>
	<h2>Non-patient Info</h2>
	<form action="" method="post">
	<table>
		<tr>
		<td>Non-patient ID: </td>
		<td><c:out value="${npbean.getId()}"></c:out></td>
		</tr>
		<tr>
		<td>Given Name: </td>
		<td><c:out value="${npbean.getGivenName()}"></c:out></td>
		</tr>
		<tr>
		<td>Middle Name: </td>
		<td><c:out value="${npbean.getMiddleName()}"></c:out></td>
		</tr>
		<tr>
		<td>Last Name: </td>
		<td><c:out value="${npbean.getLastName()}"></c:out></td>
		</tr>
		<tr>
		<td>Email Address: </td>
		<td><c:out value="${npbean.getEmailAddress()}"></c:out></td>
		</tr>
		<tr>
		<td>Date of Birth: </td>
		<td><c:out value="${npbean.getDateOfBirth()}"></c:out></td>
		</tr>
		<tr>
		<td>Organization: </td>
		<td><c:out value="${npbean.getOrganization()}"></c:out></td>
		</tr>
		<tr>
		<td>Description: </td>
		<td><c:out value="${npbean.getDescription()}"></c:out></td>
		</tr>
		<tr>
		<td>Ward: </td>
		</tr>
	</table>
	<h2>Generated Non-patient User Info</h2>	
	<table>
		<tr>
		<td>Non-patient ID: </td>
		<td><c:out value="${gubean.getNonPatientId()} "></c:out>
		</tr>
		<tr>
		<td>Username: </td>
		<td><c:out value="${gubean.getUsername()}"></c:out></td>
		</tr>	
		<tr>
		<td>Password: </td>
		<td><c:out value="${gubean.getPassword()}"></c:out></td>
		</tr>
		<tr>
		<td>Created: </td>
		<td><c:out value="${gubean.getCreatedOn()}"></c:out>
		</tr>
	</table>
	</form>
</body>
</html>