<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/role.css" />
<title>Roles</title>
</head>
<body>

	<h2>Roles</h2>
	
	<form id="addRoleForm" name="roleForm" action="RoleServlet" method="post">
	<div class="facilityBox">
		<div>Name: </div>	
		<div><input id="roleAddName" type="text" name="roleName" /></div>
		<div>Group: </div>
		<div><input type="text" name="roleGroup" /></div>
		<div>Description: </div>
		<div><input type="text" name="roleDescription" /></div>
		<div><input type="submit" value="Submit" />
			 <input class="cancelAddButton" type="button" value="Cancel" />
		</div>
	</div>	
	</form>
</body>
</html>