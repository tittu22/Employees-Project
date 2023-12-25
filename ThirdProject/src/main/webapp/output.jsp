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
	<h1>Employee added Successfully</h1>
	<%
	List<Employee> emp = (List<Employee>) request.getAttribute("emp");
	for (Employee u : emp) {
	%>
	<table>
		<thead>
			<th>Emp ID</th>
			<th>Emp Name</th>
			<th>Emp Sal</th>
		</thead>
		<tbody>
			<tr>
				<td><%=u.getEmpId()%></td>
				<td><%=u.getEmpName()%></td>
				<td><%=u.getEmpSal()%></td>
			</tr>
		</tbody>
	</table>
	<%
	}
	%>
</body>
</html>