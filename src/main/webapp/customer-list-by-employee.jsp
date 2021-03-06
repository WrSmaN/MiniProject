<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer List</title>
</head>
<body>
<form method="post" action="listnavigationServlet">
<table>
<c:forEach items="${requestScope.allLists}" var="currentlist">
<tr>
	<td><input type="radio" name="id" value="${currentlist.id}"></td>
	<td><h2>${currentlist.groupName}</h2></td>
</tr>
	
<tr>
	<td colspan="3">Visit Date: ${currentlist.visitDate}</td>
</tr>

<tr>
	<td colspan="3">List Name: ${currentlist.employee}</td>
</tr>
<c:forEach var="listVal" items="${currentlist.listOfItems}">
<tr><td></td>
<td colspan="3">
${listVal.groupName}, ${listVal.groupSize}
</td>
</tr>
</c:forEach>
</c:forEach>
</table>
<input type="submit" value="edit" name="doThisToList">
<input type="submit" value="delete" name="doThisToList">
<input type="submit" value="add" name="doThisToList">

</form>
<a href="addItemsForListServlet">Create a new group</a><br />
<a href="Index.html">Add a customer</a>
</body>
</html>