<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Secure QA Submission</title>

<!-- Inline CSS -->
<style type="text/css">.error {color:red}</style>

</head>
<body>

	<h2> Question and answer functionality available to lecturers only </h2>
	<form:form action="${pageContext.request.contextPath}/submission-result" modelAttribute="question">
		Question: <form:input path="questioncontent"/>
		<form:errors path="questioncontent" cssClass = "error"/>
		<br><br>
		Answer: <form:input path="answer"/>
		<form:errors path="answer" cssClass = "error"/>
		<br><br>
		Knowledge Area: <form:input path="knowledgearea"/>
		<form:errors path="knowledgearea" cssClass = "error"/>
		<br><br>
		<input type="submit" value = "Submit" style="height:35px; width:100px" size="40"/>
	</form:form>
	
	<hr>
	
	<a href ="${pageContext.request.contextPath}/"> Back to Home Page </a> 
	
</body>
</html>