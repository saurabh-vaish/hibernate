<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Welcome to Employee Register</h2>

<pre>

	<form action="register" method="post">
	
		Id   	   : <input type="text" name="empId" />
		Name  	   : <input type="text" name="empName" />
		Salary     : <input type="text" name="empSal" />
		Department : <input type="text" name="empDept" />
	
		<input type="submit" value="Register" >
	</form> 

</pre>

${msg}

<a href="data">View All</a>

</body>
</html>