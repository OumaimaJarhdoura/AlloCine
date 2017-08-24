<%@page import="java.util.Iterator"%>
<%@page import="entities.Movie"%>
<%@page import="java.util.ArrayList"%>
<%@page import="services.FactoryServices"%>
<%@page import="services.MovieServices"%>
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
	<h1><bean:message key="titre.session.search" /></h1>
	
		<html:form action="/SearchSession" styleClass="form-horizontal">
		
				<div class="form-horizontal">
				
					<label for="movie"><bean:message key="form.session.movie" /></label>
					<html:select property="movie" styleClass="form-control">	
		<%
		MovieServices movieservices = (MovieServices) FactoryServices.getService("Movie");
		ArrayList<Movie> movies = movieservices.findAllMovies();
			if (movies.isEmpty()) {
		%>
		<p><bean:message key="error.movie.null"/></p>
		
		<%
			} else {
				Iterator<Movie> it = movies.iterator();
			
			while(it.hasNext())
			{
				Movie movie = (Movie) it.next();
				if(movie != null)
				{String affich = movie.getId()+ ' ' + movie.getTitle();
				String ID = movie.getId();
		%>

			
					
	
				<html:option value="<%=ID%>"> <%=affich%> </html:option>
				<%
					}
					}}
				%>
				</html:select>				
				<html:submit styleClass="btn btn-default">
						<bean:message key="form.session.button.search" />
					</html:submit>
				</div>
			</html:form>
</body>
</html>