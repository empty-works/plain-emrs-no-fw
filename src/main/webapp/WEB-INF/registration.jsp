<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMRS Registration</title>
<script>
	function validate() {
		var username = document.form.username.value;
		var email = document.form.email.value;
		var password = document.form.password.value;
		var conpassword = document.form.conpassword.value;
		
		if(username == null || username == "")	{
			alert("Username cannot be blank.");
			return false;
		}
		else if(email == null || email == "") {
			alert("Email cannot be blank.");
			return false;
		}
		else if(password.length < 6) {
			alert("Password should be at least six characters long.");
			return false;
		}
		else if(password != conpassword) {
			alert("Confirmation passwords does not match password.");
			return false;
		}
	}
</script>
</head>
<body>

	<h2>Plain EMRS User Registration</h2>	
	<form name="form" action="PlainEmrsRegistrationServlet" method="post" onsubmit="return validate()">
		<table>
			<tr>
			<td>Username</td>
			</tr>	
		</table>	
	</form>	
</body>
</html>