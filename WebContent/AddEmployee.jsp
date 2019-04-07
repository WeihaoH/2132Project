<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Register.css">
<title>customer register page</title>
<script>

	function validate() {
		var custSSN = document.getElementById("custSSN");
		var custName = document.getElementById("custName");
		var custPwd = document.getElementById("custPwd");
		var custPwdagain = document.getElementById("custPwdagain");
		if(custSSN.value == "" || custName.value == "" || custPwd.value == "" || custPwdagain.value == "" ){
			alert("You need to fill all the information");
			return false;
		}
		
		else if(custSSN.value.length != 8){
			alert("The length of SSN needs to be 8");
			return false;
		}
		
		else if(custPwd.value != custPwdagain.value){
			alert("passwords need to be same");
			return false;
		}
		else
			return true;
	}

</script>
</head>
<body>
	<div class="register-box">
<form method = "post" action="empRegister">
	<div class="text-box">
please input your SSN:<input type="text" id="custSSN" name="custSSN"><br><br>
</div>
<div class="text-box">
please input your name:<input type="text" id="custName" name="custName"><br><br>
</div>
<div class="text-box">
please input your password:<input type="password" id="custPwd" name="custPwd"><br><br>
</div>
<div class="text-box">
please input your password again:<input type="password" id="custPwdagain" name="custPwdagain"><br><br>
</div>
<div class="submit">
			<button class="button-box" type="submit" value="submit" onclick="return validate();">submit</button>
		</div>
		<div class="reset">
			<button class="button-box" type="reset" value="reset">reset</button>
		</div>
</form>
	</div>

</body>
</html>