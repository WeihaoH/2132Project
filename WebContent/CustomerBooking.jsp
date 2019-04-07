<%@page import="java.util.ArrayList"%>
<%@page import="table.hotel_chain"%>
<%@page import="entities.area_info"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="customer_booking.css">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
 <script src="https://code.jquery.com/jquery-2.2.4.js"></script>
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <link rel="stylesheet" href="https://code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">

<title>Customer Booking page</title>


</head>
<body>
	<div class="login-box">
	<h4>Please Select Room</h4>
	<br>
		<form method="post" name = "location_form" action="hotel_chain">
		<div class="select-box">
			<select class="form-control form-control-lg" name = "area">
  				<option value = "">Area</option>
  				<%
						Object obj = request.getAttribute("allareas");
						ArrayList<area_info> arealist = null;
						if (obj instanceof ArrayList) {
							arealist = (ArrayList<area_info>) obj;
						}
						if (arealist != null) {
							for (area_info area : arealist) {
								System.out.println(area);
								
								String areainfo = area.getArea_name() + "---" + area.getAvailableroom()+"/"+area.getTotal_rooms(); 
					%>					
						<option><%=areainfo%></option>

					<%
						}
						}
					%>
			</select>
		</div>
		<div class="select-box">
			<select name = "chain" class="form-control form-control-lg">
				 <option value = "">Hotel Chain</option>
 				 <%
						Object obj2 = request.getAttribute("allchains");
						ArrayList<String> chainlist = null;
						if (obj instanceof ArrayList) {
							chainlist = (ArrayList<String>) obj2;
						}
						if (chainlist != null) {
							for (String chain : chainlist) {
								System.out.println(chain);
								
								/* String roominfo = room.getRoom_no() + "---" + room.getRoom_status(); */
					%>					
						<option ><%=chain%></option>

					<%
						}
						}
					%>
			</select>
		</div>
		<div >
			<button class="button-box"">Submit</button>
		</div>
	
	</form>
	<button class="button-box" onclick="location.href='index.html'">back</button>
</body>
</html>