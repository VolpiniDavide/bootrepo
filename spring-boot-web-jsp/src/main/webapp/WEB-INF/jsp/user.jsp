<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url var="url" value="/user" />
<form:form action="${url}" method="post" modelAttribute="userForm">
<label>Mail:</label>
<form:input path="email" />
<label>Password:</label>
<form:input path="password" />
<input type="submit" />
</form:form>

<p> ${Message} </p>

</body>
</html>