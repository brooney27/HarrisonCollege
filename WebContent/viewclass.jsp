<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${section.hccourse.coursename} - ${section.crn}</title>
<jsp:include page="bootstrap.jsp"/>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<h2>${section.hccourse.coursename} - ${section.crn}</h2>
<table class="table table-bordered table-striped table-hover">
<tr><td>First name</td><td>Last name</td><td>Major</td><td>Entry year</td></tr>
<c:forEach var="student" items="${section.hcstudents}">
<td><c:out value ="${student.hcuser.firstname}"/></td>
<td><c:out value ="${student.hcuser.lastname}"/></td>
<td><c:out value ="${student.major}"/></td>
<td><c:out value ="${student.entryyear}"/></td>
</c:forEach>
</table>
</body>
</html>