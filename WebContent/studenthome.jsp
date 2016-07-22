<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Home</title>
<jsp:include page="bootstrap.jsp"/>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<h1>Student Home</h1>
<h4>Your courses</h4>
<table class="table table-bordered table-striped table-hover">
<tr><td>CRN</td><td>Class</td><td>Title</td><td>Instructor</td><td></td></tr>
<c:forEach var="section" items="${user.hcstudent.hcsections}">
<tr>
<td><c:out value ="${section.crn}"/></td>
<td><c:out value ="${section.hccourse.subject}${section.hccourse.coursenumber}"/></td>
<td><c:out value ="${section.hccourse.coursename}"/></td>
<td><c:out value ="${section.hcinstructor.hcuser.lastname}"/></td>
<td><form action="Drop">
<input type="hidden" name="crn" id="crn" value="${section.crn}"/>
<input type="submit" name="submit" id="submit" value="Drop"/>
</form></td>
<td>
</tr>
</c:forEach>
</table>
</body>
</html>