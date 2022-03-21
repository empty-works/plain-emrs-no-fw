<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/general.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />

<title>Welcome! Please log in.</title>
</head>

<body>

<div class="login-grid-container">
	<div class="sidenav">
		<div class="login-main-text">
			<h2 class="font-weight-bold">Plain EMRS<br> by Empty Works</h2>
			<p>Login or register from here to access.</p>
		</div>
	</div>
	<div class="main">
		<div class="login-form">
			<form action="LoginServlet" method="post">
				<div class="form-group">
					<label for="loginUsername">Username:</label>
					<input type="text" class="form-control" id="loginUsername" name="username">
					<span class="error-message">${errorMessages.username}</span>
				</div>
				<div class="form-group">
					<label for="loginPassword">Password:</label>
					<input type="password" class="form-control" id="loginPassword" name="password">
					<span class="error-message">${errorMessages.password}</span>
				</div>
				<button type="submit" class="btn btn-space">Login</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>