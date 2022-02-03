<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/general.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sign-in.css" />
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<title>Welcome! Please log in.</title>
</head>

<body>

<div class="sidenav">
	<div class="login-main-text">
		<h2 class="font-weight-bold">Plain EMRS<br> by Empty Works</h2>
		<p>Login or register from here to access.</p>
	</div>
</div>
<div class="main">
	<div class="col-md-6 col-sm-12">
		<div class="login-form">
			<form action="LoginServlet" method="post">
				<div class="form-group">
					<label for="loginUsername">User Name</label>
					<input type="text" class="form-control" id="loginUsername" name="username" placeholder="Username">
				</div>
				<div class="form-group">
					<label for="loginPassword">Password</label>
					<input type="password" class="form-control" id="loginPassword" name="password" placeholder="Password">
				</div>
				<button type="submit" class="btn btn-black btn-primary btn-space">Login</button>
			</form>
		</div>
	 </div>
</div>
      
<!-- Bootstrap bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>