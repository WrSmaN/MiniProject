<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new list</title>
</head>
<body>
<form action = "createNewListServlet" method="post">
Employee Name: <input type="text" name = "empName"><br />
Tour Date: <input type="text" name = "month" placeholder="mm" size="4">
<input type="text" name = "day" placeholder="dd" size="4">
<input type="text" name = "year" placeholder="yyyy" size="4">
List Name: <input type="text" name = "listName"><br />

Customer Groups:<br />
<select name = "allItemsToAdd" multiple size = "6">
<c:forEach items = "${requestScope.allItems}" var="currentitem">
<option value = "${currentitem.custGroupID}"> ${currentitem.groupSize} | ${currentitem.groupName}</option>
</c:forEach>
</select>
<br />
<input type="submit" value="Create group and add customers">

</form>
<a href="Index.html">Create a new customer instead</a>
</body>
</html>