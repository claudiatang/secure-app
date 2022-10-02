<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Secure Exam Generation </title>
</head>
<body>

	<h2> Exam generation functionality available to lecturers and students </h2>
	
	<form:form action="${pageContext.request.contextPath}/retrieve-result" method="post" modelAttribute="knowledgearea">
		Queried Knowledge Area: <form:input path="knowledgearea" required="true"/>
		<form:errors path="knowledgearea" cssClass = "error"/>
		<br><br>
		<input type="submit" value = "Generate Exam" style="height:35px; width:120px" size="40"/>
	</form:form>
	
	<hr>
	
	<a href ="${pageContext.request.contextPath}/"> Back to Home Page </a> 
	
</body>
</html>




