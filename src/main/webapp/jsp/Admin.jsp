<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
<title>Admin Page</title>

<% 	// If Admin session is not set, redirect to the default page
	if((request.getSession(false).getAttribute("Admin") == null)) {
%>
<jsp:forward page="/default.jsp"></jsp:forward>
<%} %>

</head>
<body>
	<h2>Admin's Home</h2>
	Welcome <%=request.getAttribute("username") %>
	
	<br><br>
	<a href="<c:url value="/AddNonPatient.jsp" />">Add Non-Patient</a>
		
</body>
</html>