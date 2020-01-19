<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<title>Todo's of ${name}</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>
<body>
<h1>
Your todos are
	<table class="table table-striped">
		<div class="container">
		<thead>
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is it Completed</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
			<tr>
				<td>${todo.desc}</td>
				<td><fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy"/></td>
				<td>${todo.done}</td>
				<td><a type="button"class="btn btn-success" href="/update-todo?id=${todo.id}">Update </a></td>
				<td><a type="button"class="btn btn-warning" href="/delete-todo?id=${todo.id}">Delete </a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</h1>
<div><a class="button" href="/add-todo">Add todo's</a></div>
</div>
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		
</body>
</html>