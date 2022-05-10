<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>These are the books:</title>
<style>
table, th, td {
  border: 1px solid white;
  border-collapse: collapse;
}
th, td {
  background-color: #96D4D4;
}
</style>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Book Title</th>
				<th>Author</th>
				<th>Book Description</th>
				<th>Delete</th>
				<th>Edit</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${books}">
				<tr>
					<td>
						${book.title}
					</td>
					<td>
						${book.author}
					</td>
					<td>
						${book.description}
					</td>
					<td>
						<a href="book-delete?id=${book.id}">Delete the book: ${book.title}</a>
					</td>
					<td>
						<a href="book-form-update?id=${book.id}">Edit the book: ${book.title}</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<a href="book-form">Add New Book</a>
	
</body>
</html>