<%@page import="com.jsp.entity.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Employee list</h1>

	<table>
		<tr>
			<th style="padding: 20px">Employee Id</th>
			<th style="padding: 20px">Employee Name</th>
			<th style="padding: 20px">Employee Salary</th>
		</tr>
		<%
		List<Employee> emps = (List<Employee>) request.getAttribute("emps");
		for (Employee emp : emps) {
		%>
		<tr>
			<td style="padding: 20px"><%=emp.getEmpId()%></td>
			<td style="padding: 20px"><%=emp.getEmpName()%></td>
			<td style="padding: 20px"><%=emp.getEmpSal()%></td>
			<td style="padding: 20px"><a href="delete-employee?id=<%=emp.getEmpId()%>">Delete</td>
			<td style="padding: 20px"><a href="update-employee?id=<%=emp.getEmpId()%>">Update</td>
		</tr>
		<%
		}
		%>
	</table>
	<a href="/index.jsp">Back</a>
</body>
</html>