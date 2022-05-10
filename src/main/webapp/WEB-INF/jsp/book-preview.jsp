<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book review</title>
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
			</tr>
		</thead>
		<tbody>
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
			</tr>
		</tbody>
	</table>
</body>
</html>