<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

	<head>
		<title>Save Customer</title>
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
		<div id="container" align="center">
			<h3>Save Customer</h3>
		
			<form:form action="saveCust" modelAttribute="customer" method="POST">
			
				<table>
					<tbody>
						<tr>
							<td><label>First name:</label></td>
							<td><form:input path="firstName" /></td>
						</tr>
					
						<tr>
							<td><label>Last name:</label></td>
							<td><form:input path="lastName" /></td>
						</tr>
	
						<tr>
							<td><label>Email:</label></td>
							<td><form:input path="email" /></td>
						</tr>
	
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Save" class="save" /></td>
						</tr>
	
					
					</tbody>
				</table>
			
			
			</form:form>
		
			<div style="clear; both;"></div>
			
			<p>
				<a href="${pageContext.request.contextPath}/listCustomer">Back to List</a>
			</p>
		
		</div>
		<jsp:include page="footer.jsp"/>
	</body>

</html>