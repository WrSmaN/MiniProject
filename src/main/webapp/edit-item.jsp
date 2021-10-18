<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit a customer</title>
</head>
<body>
	<form action = "editItemServlet" method="post">
		Group Name: <input type = "text" name = "groupName" value="${itemToEdit.groupName }">
		Group Size: <input type = "text" name = "groupSize" value="${itemToEdit.groupSize }">
		<input type = "hidden" name = "custGroupID" value="${itemToEdit.custGroupID }">
		<input type = "submit" value = "Save Edited Item">
		</form>
</body>
</html>