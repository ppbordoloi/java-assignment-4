<div class="page-header" 
	style="height: 30px;
    border-bottom: 3px solid #0909e4;
    border-top: 3px solid #0909e4;
    padding: 20px;
    font-size: 24px;
    background-color: #d2d6e0;">
	<%
String loggedInUsername = (String) session.getAttribute("loggedInUsername");
if (loggedInUsername != null) {
%>
Welcome <%= loggedInUsername %> to Booking Management Application
<div style="float:right"><a href="logout">Logout</a></div>
<%
}
else {
%>
    <a href="<%= request.getContextPath() %>">Booking Management Application:</a>
<%
}
%>
</div>
<div  class="page-content" style="padding: 30px;">