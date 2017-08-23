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
	<h1><bean:message key="titre.movie.create" /></h1>
	<html:form action ="/CreateMovie">
  <div class="form-horizontal">
  
  	
    <label for="title"><bean:message key="form.movie.title" /></label>
    <html:text property="title" styleClass="form-control"/>
 	<label for ="duration"><bean:message key="form.movie.duration" /></label>
 	<html:text property="duration" styleClass="form-control"/>
 	<label for="genre"><bean:message key ="form.movie.genre" /></label>
 	<html:text property="genre" styleClass="form-control"/>
 	<label for ="releasedate"><bean:message key="form.movie.releasedate" /></label>
 	<html:text property="releaseDate" styleClass="form-control"/>
 	<label for="synopsis"><bean:message key="form.movie.synopsis" /></label>
 	<html:text property="synopsis" styleClass="form-control"/>
 	<label for="language"><bean:message key="form.movie.language" /></label>
  	<html:text property="language" styleClass="form-control"/>
 	<label for="director"><bean:message key ="form.movie.director" /></label>
 	<html:text property="director" styleClass="form-control"/>
 	<label for="cast"><bean:message key="form.movie.cast" /></label>
  	<html:text property="cast" styleClass="form-control"/>
 	<label for="age"><bean:message key="form.movie.age" /></label>
  	<html:text property="age" styleClass="form-control"/>
  	<label for="starts"><bean:message key="form.movie.starts" /></label>
  	<html:text property="starts" styleClass="form-control" />
  	<label for="ends"><bean:message key="form.movie.ends" /></label>
  	<html:text property="ends" styleClass="form-control" />
  	<label for="link"><bean:message key="form.movie.link" /></label>
  	<html:text property="link" styleClass ="form-control"/>
  </div>
  <html:submit styleClass="btn btn-default">
		<bean:message key="form.movie.button.create" />
  </html:submit>
  <button type="reset"  class="btn btn-default"><bean:message key="form.movie.button.reset" /></button>
	</html:form>
	
</body>
</html>