<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<style type="text/css">
	    <%@include file="bootstrap/css/bootstrap.css" %>
	    <%@include file="bootstrap/css/bootstrap-theme.css" %>
	    .partie
	    {
	    	margin-right:1%;
	    }
	    h1
	    {
	    	text-align:center;
	    }
	</style>
	<script src="bootstrap/js/jquery.js"></script>
	<script src="bootstrap/js/bootstrap.js"></script>
		
	<title><bean:message key="titre.site" /></title>
</head>
<body>
	<h1><bean:message key="titre.movie.search" /></h1>
		<html:form action="/SearchMovie" styleClass="form-horizontal">
				<div class="form-group">
					<label for="title"><bean:message key="form.movie.title" /></label>
					<html:text property="title" styleClass="form-control"/>		
					<html:submit styleClass="btn btn-default">
						<bean:message key="form.movie.button.search" />
					</html:submit>
				</div>
			</html:form>
</body>
</html>