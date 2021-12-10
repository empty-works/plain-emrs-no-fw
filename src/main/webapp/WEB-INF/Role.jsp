<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
	<table>
		<tr>
		<c:if test="${empty rolesList}">
			<td>No roles added yet!</td>
		</c:if>
		</tr>				
		<c:forEach items="${rolesList}" var="role">
			<tr>
				<td>ID: <c:out value="${role.getId()}" /></td>
			</tr>	
			<tr>
				<td>Name: <c:out value="${role.getName()}" /></td>
			</tr>
			<tr>
				<td>Group: <c:out value="${role.getGroup()}" /></td>
			</tr>
			<tr>
				<td>Description: <c:out value="${role.getDescription()}" /></td>
			</tr>
		</c:forEach>		
	</table>	
		
	<h2>Add Role</h2>
	<form id="addRoleForm" name="roleForm" action="RoleServlet" method="post">
	<div class="facilityBox">
		<div>Name: </div>	
		<div><input id="roleAddName" type="text" name="roleName" /></div>
		<div>Group: </div>
		<div><input type="text" name="roleGroup" /></div>
		<div>Description: </div>
		<div><input type="text" name="roleDescription" /></div>
		<div><input type="submit" value="Add Role" />
			 <input class="cancelAddButton" type="button" value="Cancel" />
		</div>
	</div>	
	</form>
</body>
</html>