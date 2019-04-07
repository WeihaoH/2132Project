<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="login-box">
	<h4>Check out list</h4>
	<form method="post" action="checkout">
			<div class="select-box">
				<select name = "live" class="hname">
					<%
						Object obj = request.getAttribute("livelist");
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