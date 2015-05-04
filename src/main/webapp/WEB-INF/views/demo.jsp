<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Demo</title>
</head>
<body>
<table border="1">	
	<th>Id</th>
	<th>Name</th>
	<th>Address</th>
	<c:forEach var="person" items="${persons}">
		<tr>
			<td>${person.id}</td>
			<td>${person.name}</td>
			<td>${person.address}</td>
		</tr>
	</c:forEach>
</table>
<form action="add">
	<input type="submit" value="add">
</form>
<hr>
</body>
</html>
