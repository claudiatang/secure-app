<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Secure Q&A Retrieve Result</title>
</head>

<body>

<c:if test="${found=='true'}">
	<h3>1. ${question1}</h3>
 	<h3>2. ${question2}</h3>
 	<h3>3. ${question3}</h3>
	<h3>4. ${question4}</h3>
	<h3>5. ${question5}</h3>
</c:if>

<c:if test="${found=='false'}">
	<h3>${message}</h3>
</c:if>

	<hr>
	<a href ="${pageContext.request.contextPath}/"> Back to Home Page </a>

</body>

</html>



