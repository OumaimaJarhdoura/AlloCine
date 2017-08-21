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
	    <%@include file="WEB-INF/bootstrap/css/bootstrap.css" %>
	    <%@include file="WEB-INF/bootstrap/css/bootstrap-theme.css" %>
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
	<h1><bean:message key="titre.movie.create" /></h1>
	<html:form action="CreateMovie" styleClass="form-horizontal">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
				<html:errors/>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4 partie">
					<h2><bean:message key="movie.create.infobasic" /></h2>
					<div class="form-group">
						<label class="control-label"><bean:message key="form.movie.title" /></label>
						<html:text property="title" styleClass="form-control"/>
					</div>
					<div class="form-group">
						<label class="control-label"><bean:message key="form.movie.genre" /></label>
						<html:text property="genre" styleClass="form-control"/>
					</div>
					<div class="form-group">
						<label class="control-label"><bean:message key="form.movie.duration" /></label>
						<html:text property="duration" styleClass="form-control"/>
					</div>
					<div class="form-group">
						<label class="control-label"><bean:message key="form.movie.releasedate" /></label>
						<html:text property="releasedate" styleClass="form-control"/>
					</div>
					<div class="form-group">
						<label class="control-label"><bean:message key="form.movie.synopsis" /></label>
						<html:text property="synopsis" styleClass="form-control"/>
					</div>
					<div class="form-group">
						<label class="control-label"><bean:message key="form.movie.cast" /></label>
						<html:text property="cast" styleClass="form-control"/>
					</div>
					<div class="form-group">
						<label class="control-label"><bean:message key="form.movie.director" /></label>
						<html:text property="director" styleClass="form-control"/>
					</div>
					<div class="form-group">
						<label class="control-label"><bean:message key="form.movie.nationality" /></label>
						<html:text property="nationality" styleClass="form-control"/>
					</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<button type="submit" class="btn btn-default"><bean:message key="form.movie.button.create" /></button>
				<button type="reset" class="btn btn-default"><bean:message key="form.movie.button.reset" /></button>
			</div>
		</div>		
	</div>
	</html:form>
</body>
</html>