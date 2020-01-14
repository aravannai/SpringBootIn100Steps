<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Todo's of ${name}</title>
</head>
<body>
<h1>
Your todos are
	<table>
		<caption>Your todo's are</caption>
		<thead>
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is it Completed</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
			<tr>
				<td>${todo.desc}</td>
				<td>${todo.targetDate}</td>
				<td>${todo.isDone}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</h1>
<br/>
<a href="/add-todo">Add todo's</a>
</body>
</html>