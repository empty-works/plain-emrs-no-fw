<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/general.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sidenav.css" />
</head>
<body>
	<!-- Side main menu -->
	<!-- Plus signs are temporary. Will be replaced by proper icons. -->
	<!-- TEMPORARILY disabling so the main page is the patient list for now -->
	<!--  <div><a href="<c:url value="/AdminServlet" />">+</a></div>-->
	<div><a href="<c:url value="/UserPatientListServlet" />">+</a></div>
</body>
</html>