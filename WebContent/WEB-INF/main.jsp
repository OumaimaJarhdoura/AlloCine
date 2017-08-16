<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<style type="text/css">
	    <%@include file="bootstrap/css/bootstrap.css" %>
	    <%@include file="bootstrap/css/bootstrap-theme.css" %>
	    h1
	    {
	    	text-align:center;
	    }
	    .center
	    {
	    	margin-top:5%;
	    }
	</style>
	<script src="bootstrap/js/jquery.js"></script>
	<script src="bootstrap/js/bootstrap.js"></script>
	<title><bean:message key="site.titre" /></title>
</head>
<body>
	<div class="row center">
		<div class="col-md-4 col-md-offset-4">
			<h1><bean:message key = "main.menu" /></h1>
				<a href="CreateMovie.jsp" class="btn btn-default btn-lg btn-block" role="button">
					<bean:message key="main.movie.create" />
				</a>
		</div>
	</div>
</body>
</html>