<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/general.css" />

<title>Welcome! Please log in.</title>
</head>
<body id="login-grid" class="text-center main-font">
	<main class="form-signin">
	<form action="LoginServlet" method="post">
	
	<div class="item-signin-label">
		<h2 class="h5 label-text">Please sign in</h2>	
	</div>

	<div class="item-signin-username">
		<input type="text" id="floatingInput" class="form-control" name="username" placeholder="Username" />
	</div>
	<div class="item-signin-password">
		<input type="password" id="floatingPassword" class="form-control" name="password" placeholder="Password" />
	</div>
	
	<div class="item-signin-submit">
		<button type="submit" id="sign-in-btn" class="label-text">Sign in</button>
	</div>
	</form>	
	</main>	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>	
</body>
</html>