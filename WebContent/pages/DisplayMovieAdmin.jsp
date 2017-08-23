<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bean:message key="titre.site"/></title>
</head>
<body>


<table class="table table-striped">
			<tr>
				<th><bean:message key="movie.title"/></th>
				<th><bean:message key="movie.genre" /></th>
				<th><bean:message key="movie.duration" /></th>
				<th><bean:message key="movie.releasedate" /></th>
				<th><bean:message key="movie.language" /></th>
				<th><bean:message key="movie.director" /></th>
				<th><bean:message key="movie.cast" /></th>
				<th><bean:message key="movie.synopsis" /></th>
				<th></th>
			</tr>
</table>			
</body>
</html>