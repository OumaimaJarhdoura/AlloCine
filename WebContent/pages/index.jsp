<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>

<html><head>
	<meta charset="ISO-8859-1">
	<style type="text/css">
	    <%@include file="bootstrap/css/bootstrap.css" %>
	    <%@include file="bootstrap/css/bootstrap-theme.css" %>
	    .center
	    {
	    	margin-top:10%;
	    }
	</style>
	<script src="bootstrap/js/jquery.js"></script>
	<script src="bootstrap/js/bootstrap.js"></script>
	<title><bean:message key="titre.site" /></title>
</head>
<body>
	<div class="row center">
		<div class="col-md-4 col-md-offset-4">
			<h1><bean:message key = "main.menu" /></h1>
				<a href="pages/CreateMovie.jsp" class="btn btn-default btn-lg btn-block" role="button">
					<bean:message key="main.movie.create" />
				</a>
				<a href="pages/SearchMovie.jsp" class="btn btn-default btn-lg btn-block" role ="button">
					<bean:message key="main.movie.search" />
				</a>
				<a href="pages/CreateSession.jsp" class="btn btn-default btn-lg btn-block" role="button">
					<bean:message key="main.session.create" />
				</a>
				<a href="pages/SearchSession.jsp" class="btn btn-default btn-lg btn-block" role="button">
				<bean:message key="main.session.search"/>
				</a>
				<a href="pages/DeleteSession.jsp" class="btn btn-default btn-lg btn-block" role="button">
				<bean:message key="main.session.delete"/>
				</a>
		</div>
	</div>
</body>
</html>