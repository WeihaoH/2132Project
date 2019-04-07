<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="Status.css">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
 <script src="https://code.jquery.com/jquery-2.2.4.js"></script>
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <link rel="stylesheet" href="https://code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">
 

<title>Booking View</title>

</script>
</head>
<body>
	<div class="login-box">
	<h4>Hotel Infomation</h4>
	<br>

	<button class="button-box" onclick="location.href='renting.jsp'">renting vistor</button>
	<form method="post" name = "location_form" action="live_list">
		<button class="button-box">check out vistor</button>
	</form>
	<button class="button-box" onclick="location.href='EmployeeAdmin.jsp'">back</button>
	<table >
	<tr>
		<td class="ID">
			Hotel name
		</td>
		<td>
			Hotel address
		</td>
		<td>
			Hotel star
		</td>
		<td>
			Available room / Total room
		</td>

	</tr>
	<% 
	Object obj = request.getAttribute("hoteltable");
	String chainlist = (String)obj;
	System.out.println(chainlist);
	out.println(obj);									
	%>


	</table>
	</form>
</body>
</html>


