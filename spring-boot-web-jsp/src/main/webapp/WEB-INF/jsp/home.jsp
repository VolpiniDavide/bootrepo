<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="it.onyx.bootapp.dao.UserDao" %>
<%@ page import="java.util.ArrayList" %>



	<p> your first name : ${ firstName } </p>
	<p> your last name : ${ lastName } </p>
	<p> your email : ${ email } </p>
	<p> your phone number : ${ number } </p>
	<p> your password : ${ password } </p>
	<p> your id : ${ id } </p>
		
	
</body>
</html>