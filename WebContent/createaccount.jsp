<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Account</title>
</head>
<body>
<form action="CreateAccount" method="get">		
		First name: <input type="text" name="firstname" id="firstname" value=""/>
		Last name: <input type="text" name="lastname" id="lastname" value=""/>
		Email: <input type="text" name="email" id="email" value=""/>
		Major: <input type="text" name="major" id="major" value=""/>
		Entry year: <input type="text" name="entryyear" id="entryyear" value=""/>
		Password: <input type="password" name="password" id="password" value=""/>
		<input type="submit" name="submit" id="submit" value="Submit"/>
	</form>	
</body>
</html>