<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${course.coursename}</title>
<jsp:include page="bootstrap.jsp"/>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<h1>${course.coursename}</h1>
<p>${course.description}</p>
<p>Credit hours: ${course.credits}</p>
<h4>Current Sections</h4>
<table class="table table-bordered table-striped table-hover">
<tr><td>CRN</td><td>Instructor</td><td>Class Days</td><td>Start time</td><td></td></tr>
<c:forEach var="section" items="${course.hcsections}">
<tr>
<td><c:out value ="${section.crn}"/></td>
<td><c:out value ="${section.hcinstructor.hcuser.firstname} ${section.hcinstructor.hcuser.lastname}"/></td>
<td><c:out value ="${section.daysofweek}"/></td>
<td><c:out value ="${section.starttime}"/></td>
<c:if test="${user.usertype!=1}">
<td><form action="Enroll">
<input type="hidden" name="crn" id="crn" value="${section.crn}"/>
<input type="submit" name="submit" id="submit" value="Enroll"/>
</form></td>
</c:if>
</tr>
</c:forEach>
</table>
</body>
</html>