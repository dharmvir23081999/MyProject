<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<body>
	<h1>Borrow book</h1>
	<form:form method="post" action="/library/borrow">
		<table border="2" width="70%" cellpadding="2">
			<tr>
				<th>Id</th>
				<th>Book Name</th>
				<th>Author</th>
				<th>Price</th>
				<th>Status</th>
			</tr>
			<tr>
				<td>${book.id}</td>
				<td>${book.name}</td>
				<td>${book.author}</td>
				<td>${book.price}</td>
				<td>${book.status}</td>
			</tr>
		</table>
		<br /> <input type="submit" value="Borrow">
		<input type="hidden" name="id" value="${book.id}" />
	</form:form>
</body>
</html>