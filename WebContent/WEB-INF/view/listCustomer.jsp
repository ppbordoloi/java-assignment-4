<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<style>
			body {
				margin: 0 auto;
			}
			table.zdp-data-grid {
			    border-collapse: collapse;
			    width: 50%;
			}
			table.zdp-data-grid td,th{
			    border: 1px solid #000;
			    padding: 2px 10px
			}
			table.zdp-data-grid th{
			    background-color: #716060;
			    color: black;
			    font-weight: bold;
			    height: 30px;
			}
			table.zdp-data-grid tbody tr{
				height: 25px;
			}
			table.zdp-data-grid tbody tr:nth-child(even){
			    background-color: lightgray;
			}
			table.zdp-data-grid tbody tr:nth-child(odd):hover{
			    background-color: darkgray;
			}
			table.zdp-data-grid tbody tr:nth-child(even):hover{
			    background-color: #eeeeee;
			}
			.clickable {
			    cursor: pointer;
			    text-decoration: underline;
			    color:mediumblue;
			}
		</style>
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		<jsp:include page="menu.jsp"/>
		<table class="zdp-data-grid" align="center">
			<tr>
				<th>Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
			</tr>
			<c:if test="${empty custList}">
	            <tr><td colspan="5">No Customers available!</td></tr>
		    </c:if>
			<c:if test="${not empty custList}">
				<c:forEach var="tempCustomer" items="${custList}">
					<tr>
						<td> ${tempCustomer.id} </td>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		
		<jsp:include page="footer.jsp"/>
	
	</body>
</html>