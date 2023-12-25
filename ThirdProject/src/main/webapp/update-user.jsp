<%@page import="com.jsp.entity.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="updated-employee" method="post">
		<%
		Employee emp = (Employee) request.getAttribute("emp");
		%>
		<div>
			<label>Id: </label> <input type="tel" value="<%= emp.getEmpId()%>" name="id">
		</div>
		<div>
			<label>Username: </label> <input type="text" value="<%= emp.getEmpName()%>" name="name">
		</div>
		<div>
			<label>Salary: </label> <input type="number" value="<%= emp.getEmpSal()%>" name="sal">
		</div>
		<input type="submit">
	</form>
</body>
</html>