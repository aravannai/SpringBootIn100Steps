<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>My First Web Application</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>
<body>
<div class="container">
Add Todo Page for ${name}
<form:form method="post" modelAttribute="todo">
	<fieldset class="form-group">
		<form:label path="desc">Description</form:label>
		<form:input path="desc" type="text" class="form-control" required="required"/>
	</fieldset>
	<input type="submit"/>
</form:form>
</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>