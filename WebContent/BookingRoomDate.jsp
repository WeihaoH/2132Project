<%@page import="java.util.ArrayList"%>
<%@page import="entities.Room"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="BookingRoomDate.css">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
 <script src="https://code.jquery.com/jquery-2.2.4.js"></script>
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <link rel="stylesheet" href="https://code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">

<title>Customer Booking Date page</title>
<script>
	$(document).ready(function(){
		var minDate=new Date();
		$("#checkIn").datepicker({
			showAnim: 'drop',
			numberOfMonth: 1,
			minDate: minDate,
			dateFormat:'yy/mm/dd',
			onClose: function(selectedDate){
				$("#checkOut").datepicker("option","minDate", selectedDate);
			}
		});

		$("#checkOut").datepicker({
			showAnim: 'drop',
			numberOfMonth: 1,
			minDate: minDate,
			dateFormat:'yy/mm/dd',
			onClose: function(selectedDate){
				$("#checkIn").datepicker("option","maxDate", selectedDate);
			}
		});
	});
</script>

</head>
<body>

	<h4>Please Select Date</h4>
	<form method="post" action="getdate">
		<div class="select-box">
			<select name = "room" class="form-control form-control-lg">
				 <option value = "">Room Number</option>
 				 <%
						Object obj = request.getAttribute("roomList");
						ArrayList<Room> Roomlist = null;
						if (obj instanceof ArrayList) {
							Roomlist = (ArrayList<Room>) obj;
						}
						if (Roomlist != null) {
							for (Room room : Roomlist) {
								
								
								/* String roominfo = room.getRoom_no() + "---" + room.getRoom_status(); */
					%>					
						<option ><%=room.getroom_num()%></option>

					<%
						}
						}
					%>
			</select>
		</div>
		
		<div class="select-box">
  			<input type="text" name="check_in" id="checkIn" placeholder="Enter check in date">
		</div>	
			<div class="select-box">
  			<input type="text" name="check_out" id="checkOut" placeholder="Enter check out date">
		</div>

		<div >
			<button class="button-box">Book</button>
		</div>
	
	</form>
</body>
</html>

