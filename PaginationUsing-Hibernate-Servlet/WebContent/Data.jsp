<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Welcome to Employee Data</h3>
<table border="1">
	<tr>
		<th>ID</th>
		<th>NAME</th>
		<th>SALARY</th>
		<th>DEPT</th>
	</tr>
	<c:forEach items="${list}" var="ob">
		<tr>
			<td><c:out value="${ob.empId }"/> </td>
			<td><c:out value="${ob.empName }"/> </td>
			<td><c:out value="${ob.empSal }"/> </td>
			<td><c:out value="${ob.empDept }"/> </td>
		</tr>
	</c:forEach>
</table>

<a href="data?pn=1">First</a>
<c:forEach begin="1" end="${nps}" var="i">
	<a href="data?pn=${i}">${i}</a> &nbsp;&nbsp;
</c:forEach>
<a href="data?pn=${nps}">Last</a>

</body>
</html>



