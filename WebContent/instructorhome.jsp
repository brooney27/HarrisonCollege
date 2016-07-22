<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Instructor Home</title>
<jsp:include page="bootstrap.jsp"/>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<h1>Instructor Home</h1>
<table class="table table-bordered table-striped table-hover">
<tr><td>CRN</td><td>Class</td><td>Title</td><td></td></tr>
<c:forEach var="section" items="${user.hcinstructor.hcsections}">
<tr>
<td><c:out value ="${section.crn}"/></td>
<td><c:out value ="${section.hccourse.subject}${section.hccourse.coursenumber}"/></td>
<td><c:out value ="${section.hccourse.coursename}"/></td>
<td><form action="Section">
<input type="hidden" name="crn" id="crn" value="${section.crn}"/>
<input type="submit" name="submit" id="submit" value="View"/>
</form></td>
<td>
</tr>
</c:forEach>
</table>
</body>
</html>