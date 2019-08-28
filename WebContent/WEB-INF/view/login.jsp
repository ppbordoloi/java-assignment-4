<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Admin Login</title>
	</head>
	
	<body style="margin: 0 auto;">
		<jsp:include page="header.jsp"/>
		
		<form action="loginCheck" method="post">
			<table align="center">
		
				<tr>
					<td>User Id: </td>
					<td><input type="text" name="id"/></td>
				</tr>
				<tr>
					<td>Password: </td>
					<td><input type="text" name="pass"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Login" /></td>
				</tr>
		
			</table>
		</form>
		<div align="center">
			<i>Use credentials admin/admin for log in</i>
		</div>
		<jsp:include page="footer.jsp"/>
	</body>
</html>