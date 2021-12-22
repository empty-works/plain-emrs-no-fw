<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />

<title>Welcome! Please log in.</title>
</head>
<body class="text-center">
	<main class="form-signin">
	<form action="LoginServlet" method="post">
	<h1 class="h3 mb-3 fw-normal">Please sign in</h1>	
	
	<div class="form-floating">
		<label for="floatingInput">Username</label>
		<input type="text" id="floatingInput" class="form-control" name="username" />
	</div>
	<div class="form-floating">
		<label for="floatingInput">Password</label>
		<input type="password" id="floatingPassword" class="form-control" name="password" />
	</div>
	
	<button type="submit" class="w-100 btn btn-lg btn-primary">Sign in</button>
	</form>	
	</main>	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>	
</body>
</html>