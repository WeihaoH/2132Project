<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="BookingRoom.css">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
 <script src="https://code.jquery.com/jquery-2.2.4.js"></script>
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <link rel="stylesheet" href="https://code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">

<title>Customer Booking page</title>


</head>
<body>
	<div class="login-box">
	<h4>Please Select Room</h4>
	<%
		try{
			Object obj = request.getAttribute("no_that_room");
			boolean chainlist = (boolean) obj;
			if (chainlist == true) {
				out.println("<h4>This hotel do not have that room</h4>");
			}
			}catch(Exception e){}
	%>
	<br>
		<form method="post" action="getroom">
		<div class="select-box">
			<select name = room_cap class="form-control form-control-lg">
  				<option>Room Capacity</option>
 				 <option>1</option>
 				 <option>2</option>
 				 <option>3</option>
 				 <option>4</option>
 				 <option>5</option>
			</select>
		</div>
		<div class="select-box">
			<select name = amenities class="form-control form-control-lg">
 		      <option>Amenities</option>
			  <option>TV</option>
			  <option>Air_condition</option>
			  <option>heater</option>
			  <option>Air_condition,TV</option>
			  <option>Air_condition,heater,TV</option>
			</select>
		</div>
		<div class="select-box">
			<select name = view class="form-control form-control-lg">
			  <option>View</option>
			  <option>sea</option>
			  <option>mountain</option>
			  <option>none</option>
			</select>
		</div>

		<div >
			<button class="button-box"">Book</button>
		</div>
		
	</form>
</body>
</html>




