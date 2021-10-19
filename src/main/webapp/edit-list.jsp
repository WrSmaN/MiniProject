<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit The Group</title>
</head>
<body>
	<form action = "editListDetailsServlet" method = "post">
	<input type = "hidden" name = "id" value = "${listToEdit.id}">
	Group Name: <input type = "text" name = "listName" value = "${listToEdit.groupName}"><br />
	
	Trip date: <input type = "text" name = "month" placeholder = "mm" size="4" value="${month}">
	<input type = "text" name = "day" placeholder = "dd" size = "4" value = "${date}">
	<input type = "text" name = "year" placeholder = "yyyy" size = "4" value = "${year}">
	
	Employee Name: <input type = "text" name = "employeeName" value = "${listToEdit.employee.employeeName}"><br />
	Customers: <br />
	
	<select name = "allItemsToAdd" multiple size = "6">
		<c:forEach items = "${requestScope.allItems}" var = "currentitem">
			<option value = "${requestScope.allItems}">${currentitem.groupName} | ${currentitem.groupSize}</option>
		</c:forEach>
	</select>
	<br />
	<input type = "submit" value = "Edit group and add customers">
	</form>
	<a href = "Index.html">Add another customer</a>
</body>
</html>