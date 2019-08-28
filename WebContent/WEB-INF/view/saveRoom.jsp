<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

	<head>
		<title>Save Room</title>
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
			<h3>Save Room</h3>
		</div>
		
		
		<table align="center">
			<form action="saveRoom" method="post">
				<tr>
					<td>Floor: </td>
					<td><input type="text" name="flor"></td>
				</tr>
				<tr>
					<td>Description: </td>
					<td><input type="text" name="descrp"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="Save" value="Save"></td>
				</tr>
			</form>
		</table>
	
		<jsp:include page="footer.jsp"/>
	
	</body>

</html>