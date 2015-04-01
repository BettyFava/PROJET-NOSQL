<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<title>Afficher les référents</title>

</head>

<h1> A chaque F5, une biere apparaît ! Essayez ! </h1>
<body>
	<table class=table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Label</th>
			</tr>
		</thead>
		<c:forEach var="r" items="${referents}">
			<tbody>
				<tr>
					<td><c:out value="${r.id}"></c:out></td>
					<td><c:out value="${r.label}"></c:out></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>

</body>
</html>