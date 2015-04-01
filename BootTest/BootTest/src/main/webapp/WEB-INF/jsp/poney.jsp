<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<title>List des poneys</title>
 <link href="css/bootstrap.css" rel="stylesheet"></link>
</head>

<body>
<table class="table">
		<thead>
			<tr>
			
				<th>Name</th>
				<th>Nombre de pommes englouties</th>
			</tr>
		</thead>
		<c:forEach var="p" items="${poney}">
			<tbody>
				<tr>
					<td><c:out value="${p.name}"></c:out></td>
					<td><c:out value="${p.apples}"></c:out></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
</body>
</html>