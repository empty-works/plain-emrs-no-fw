<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
		
</body>
</html>