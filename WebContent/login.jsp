<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="bootstrap.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Harrison College - Login</title>
</head>
<body>
<h1>Log in:</h1>
<form action="Login" method="get">
Email:<input type="text" name="email" id="email" value=""></input>
Password:<input type="password" name="password" id="password" value=""></input>
<input type="submit" name="submit" id="submit" value="Log In"></input>
</form>
<p>New here? <a href="createaccount.jsp">Create account</a></p>
</body>
</html>