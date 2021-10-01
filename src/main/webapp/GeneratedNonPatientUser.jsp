<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Plain EMRS - Generated User</title>
</head>
<body>
	<h2>New User Input by User</h2>
	<table>
		<tr>
		<td>Given Name: </td>
		<td><c:out value="${npbean.givenName}"></c:out></td>
		</tr>
		<tr>
		<td>Middle Name: </td>
		<td><c:out value="${npbean.middleName}"></c:out></td>
		</tr>
		<tr>
		<td>Last Name: </td>
		<td><c:out value="${npbean.lastName}"></c:out></td>
		</tr>
		<tr>
		<td>Email Address: </td>
		<td><c:out value="${npbean.emailAddress}"></c:out></td>
		</tr>
		<tr>
		<td>Date of Birth: </td>
		<td><c:out value="${npbean.dateOfBirth}"></c:out></td>
		</tr>
		<tr>
		<td>Organization: </td>
		<td><c:out value="${npbean.organization}"></c:out></td>
		</tr>
		<tr>
		<td>Description: </td>
		<td><c:out value="${npbean.description}"></c:out></td>
		</tr>
	</table>
	<form action="" method="post">
	</form>
</body>
</html>