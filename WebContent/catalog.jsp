<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Course Catalog</title>
<jsp:include page="bootstrap.jsp"/>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<table class="table table-bordered table-striped table-hover">
<tr><td>Class</td><td>Title</td><td>Description</td><td>Credits</td></tr>
<c:forEach var="course" items="${courses}">
<tr>
<td><form action="Course">
<input type="submit" name="submit" id="submit" value="${course.subject}${course.coursenumber}"/>
<input type="hidden" name="courseid" id="courseid" value="${course.courseid}"/>
</form>
</td>
<td><c:out value ="${course.coursename}"/></td>
<td><c:out value ="${course.description}"/></td>
<td><c:out value ="${course.credits}"/></td>
</tr>
</c:forEach>
</table>
</body>
</html>