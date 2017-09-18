<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Employee</title>
<script type="text/javascript">
function getTotal(){

	 var basic = document.getElementById("basic").value;
	 var hra = document.getElementById("hra").value;
	 var splpay = document.getElementById("splPay").value;
	 var total = Number(basic) + Number(hra) + Number(splpay);
	 document.getElementById("total").value = total;
	
}
</script>
</head>
<body>
<form action="viewAllEmp"><button type="submit">View All Employee</button>


</form><br>
<form action="getCity">City Name:<input type="text" name="citySearch"><br>

<button type="submit">Search</button>

</form><br>


	<form action="addEmployee" method="post">
	
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
			<tr>
				<td><b>SALARY</b></td>
			</tr>
			<tr>
				<td>Basic pay</td>
				<td><input type="text" name="basic" id="basic"></td>
			</tr>
			<tr>
				<td>HRA</td>
				<td><input type="text" name="hra" id="hra"></td>
			</tr>
			<tr>
				<td>Spl Pay</td>
				<td><input type="text" name="splPay" id="splPay"></td>
			</tr>
			<tr>
				<td>Total Salary</td>
				<td><input type="text" name="total" id="total" onclick="getTotal()"></td>
			</tr>
			<tr>
				<td><b>ADDRESS</b></td>
			</tr>
			<tr>
				<td>Street</td>
				<td><input type="text" name="street"></td>
			</tr>
			<tr>
				<td>Area</td>
				<td><input type="text" name="area"></td>
			</tr>
			<tr>
				<td>City</td>
				<td><select name="city">
						<c:forEach items="${citylist}" var="city">
							<option value="${city.cityId}">${city.cityName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>State</td>
				<td><select name="state">
						<c:forEach items="${statelist}" var="state">
							<option value="${state.stateId}">${state.stateName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Country</td>
				<td><select name="country">
						<c:forEach items="${countrylist}" var="country">
							<option value="${country.countryId}">${country.countryName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Pincode</td>
				<td><input type="text" name="pincode"></td>
			</tr>

		</table>
		<input type="submit" value="Save"> <input type="reset"
			value="reset">
	</form>

</body>
</html>