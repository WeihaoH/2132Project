<%@page import="java.util.ArrayList"%>
<%@page import="table.hotel_chain"%>
<%@page import="entities.area_info"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" name = "location_form" action="rent">
<div class="text-box">
please input hotel chain:<input type="text" id="custSSN" name="hotel_chain"><br><br>
</div>
<div class="text-box">
please input hotel_id:<input type="text" id="custName" name="hotel_id"><br><br>
</div>
<div class="text-box">
please input room_num:<input type="text" id="custPwd" name="room_num"><br><br>
</div>
<div class="text-box">
please input Customer SSN:<input type="text" id="custPwdagain" name="custSSN"><br><br>
</div>

		
		<div >
			<button class="button-box"">Submit</button>
		</div>
	
	</form>
	
	
</body>
</html>