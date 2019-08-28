<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

	<head>
		<title>Update Booking</title>
	</head>
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
	<body>
		<jsp:include page="header.jsp"/>
		<jsp:include page="menu.jsp"/>
		
		<div id="header" align="center">
			<h2>Update Booking</h2>
		</div>
	
		<div id="container" align="center">
			<h3>Booking Details</h3>
			
			<form action="bookingUpdate" method="post">
				<table>
					<input type="hidden" name="id" value=${book22.id}>
					<tr>
						<td>Booking Id: </td>
						<td><input type="text" name="bookingId" value=${book22.id} readonly="readonly"></td>
					</tr>
					<tr>
						<td>Customer Id: </td>
						<td><input type="text" name="cId" value=${book22.customer.id}></td>
					</tr>
					<tr>
						<td>Room Id: </td>
						<td><input type="text" name="rId" value=${book22.room.roomId}></td>
					</tr>
					<tr>
						<td>Check In Date: </td>
						<td><input type="text" name="ciDate" value=${book22.checkInDate}></td>
					</tr>
					<tr>
						<td>Check Out Date: </td>
						<td><input type="text" name="coDate" value=${book22.checkInDate}></td>
					</tr>
					<tr>
						<td><input type="submit" name="Update"></td>
					</tr>
				</table>
			</form>
			<div style="clear; both;"></div>
		</div>
		<jsp:include page="footer.jsp"/>
	</body>

</html>