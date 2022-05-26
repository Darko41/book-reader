<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit the selected book</title>
</head>
<body>
	<form:form action="book-save" modelAttribute="book" role="form">
	<form:hidden path="id"/>
		<div class="row">
        	<div class="col-md-6">
				<div class="form-group">
                	<label>Book Title</label>
                    	<form:input type="text" class="form-control" placeholder="Enter Book Title" path="title"/>
                        <form:errors path="title" cssClass="text-danger"/>
                </div>
            </div>
         </div>
         <div class="row">
        	<div class="col-md-6">
				<div class="form-group">
                	<label>Book Author</label>
                    	<form:input type="text" class="form-control" placeholder="Enter Book Author" path="author"/>
                        <form:errors path="author" cssClass="text-danger"/>
                </div>
            </div>
         </div>
         <div class="row">
        	<div class="col-md-6">
				<div class="form-group">
                	<label>Book Description</label>
                    	<form:input type="text" class="form-control" placeholder="Enter Book Description" path="description"/>
                        <form:errors path="description" cssClass="text-danger"/>
                </div>
            </div>
         </div>
         <div class="card-footer">
         	<button type="submit" class="btn btn-primary">Save</button>
            <a href="book-listed" class="btn btn-outline-secondary">Cancel</a>
         </div>
	</form:form>
</body>
</html>