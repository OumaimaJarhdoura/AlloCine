<%@page import="java.util.ArrayList"%>
<%@page import="entities.Movie"%>
<%@page import="services.MovieServices"%>
<%@page import="services.FactoryServices"%>
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

	<a href="pages/Login.jsp" class="btn btn-success pull-right btn-fyi"><bean:message key="connection.admin"/></a>
	
	<html:form action="/SearchMovieUser" styleClass="form-horizontal">
				<div class="form-horizontal">
					<label for="title"><bean:message key="form.movie.title" /></label>
					<html:text property="title" styleClass="form-sm"/>		
					<html:submit styleClass="btn btn-default">
						<bean:message key="form.movie.button.search" />
					</html:submit>
				</div>
			</html:form>
	
							
	<div class="container">
		<%
		MovieServices movieservices = (MovieServices) FactoryServices.getService("Movie");
		ArrayList<Movie> movies = movieservices.findAllMovies();
			if (movies.isEmpty()) {
		%>
		<p><bean:message key="error.movie.null"/></p>
		
		<%
			} else {
		%>

		<table class="table table-hover">
			<thead>
				<tr>
					<th><bean:message key="movie.title"/></th>
					<th><bean:message key="movie.genre"/></th>
					<th><bean:message key="movie.director"/></th>
					<th><bean:message key="movie.cast"/></th>
				</tr>
			</thead>
			<tbody>

				<%
					for (Movie movie : movies) {
				%>
				<tr>
					<td><%=movie.getTitle()%></td>
					<td><%=movie.getGenre()%></td>
					<td><%=movie.getDirector()%></td>
					<td><%=movie.getCast() %></td>
				</tr>

				<%
					}
					}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>
