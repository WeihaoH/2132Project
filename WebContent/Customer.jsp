<%@page import="java.util.ArrayList"%>
<%@page import="table.hotel_chain"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer page</title>
<link rel="stylesheet" type="text/css" href="customer.css">

</head>
<body>
		<form method="post" action="hotel_chain">

				<select name = "roomno">
					<%
						Object obj = request.getAttribute("allchains");
						ArrayList<String> chainlist = null;
						if (obj instanceof ArrayList) {
							chainlist = (ArrayList<String>) obj;
						}
						if (chainlist != null) {
							for (String chain : chainlist) {
								System.out.println(chain);
								
								/* String roominfo = room.getRoom_no() + "---" + room.getRoom_status(); */
					%>					
						<option><%=chain%></option>

					<%
						}
						}
					%>
				</select>
				<button type="submit" onclick="return confirm('book?');">book</button>
	</form>
</body>
</html>