<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Employee</title>
</head>
<body>
<form action="addEmployee">
<table>
<tr>
<td>Name</td>
<td><input type="text" name="empName"></td>
</tr>
<tr>
<td>Department</td>
<td><select name="empDept">
<c:forEach items="${deptlist}" var="dept">
	<option value="${dept.deptId}">${dept.deptName}</option>
</c:forEach>
</select></td>
</tr>
</table>
</form>

</body>
</html>