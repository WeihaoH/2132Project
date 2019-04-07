<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="hotelSelect.css">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
 <script src="https://code.jquery.com/jquery-2.2.4.js"></script>
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <link rel="stylesheet" href="https://code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">
 

<title>Hotel Select</title>


</head>
<body>
	<div class="login-box">
	<h4>Please Select Hotel Chain</h4>
	<form method="post" action="booking">
			<div class="select-box">
				<select name = "hotels" class="hname">
					<%
						Object obj = request.getAttribute("hotelinfo");
						ArrayList<String> hotelinfo = null;
						if (obj instanceof ArrayList) {
							hotelinfo = (ArrayList<String>) obj;
						}
						if (hotelinfo != null) {
							for (String info : hotelinfo) {
								System.out.println(info);
								
								/* String roominfo = room.getRoom_no() + "---" + room.getRoom_status(); */
					%>					
						<option><%=info%></option>

					<%
						}
						}
					%>
				</select>
			</div>
			<div class="select-box">
				<button class="button-box"type="submit" onclick="return confirm('book?');">Submit</button>
			</div>
	</form>
</body>
</html>