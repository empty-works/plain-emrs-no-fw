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
		<c:out value="${npbean.givenName}"></c:out>
		</tr>
	</table>
	<form action="GeneratedUserServlet" method="post">
	</form>
</body>
</html>