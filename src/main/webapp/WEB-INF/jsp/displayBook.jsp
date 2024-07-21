<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>View Items</title>
        <link href="/static/css/style.css" rel="stylesheet">
    </head>
    <body>
        <h1>Library Book Management System</h1><br>
	<div> ${msg}  </div><br>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>Book Name</th>
			<th>Author</th>
			<th>Price</th>
			<th>Status</th>
			<th>Issue Book</th>
                        <th>Edit Book</th>
                        <th>Delete book</th>
		</tr>
		<c:forEach var="book" items="${books}">
			<tr>
				<td>${book.id}</td>
				<td>${book.name}</td>
				<td>${book.author}</td>
				<td>${book.price}</td>
				<td>${book.status}</td>
				<c:if test="${book.status == 'available'}">  
   					<td><a href="borrowForm/${book.id}">Issue Book</a></td>  
				</c:if>
                                 <td><a href="editDetails?id=${book.id}">Edit</a></td>
                                 <td><a href="deleteBook/${book.id}">Delete</a></td> 
			</tr>
		</c:forEach>
	</table>
       	<br />
        <a href="addBookForm">Add a Book</a><br>
    </body>
</html>