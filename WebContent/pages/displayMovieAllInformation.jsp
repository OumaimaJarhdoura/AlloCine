<%@page import="daos.MovieDAO"%>
<%@page import="java.util.Iterator"%>
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
	
	<H1><bean:message key ="titre.result.movie"/></H1>

	<table class="table table-active">
			<tr>
			<th><bean:message key="movie.id"/></th>
				<th><bean:message key="movie.title"/></th>
				<th><bean:message key="movie.genre" /></th>
				<th><bean:message key="movie.duration" /></th>
				<th><bean:message key="movie.releasedate" /></th>
				<th><bean:message key="movie.language" /></th>
				<th><bean:message key="movie.director" /></th>
				<th><bean:message key="movie.cast" /></th>
				<th><bean:message key="movie.synopsis" /></th>
				<th><bean:message key="movie.link" /> </th>
				<th></th>
			</tr>
			
			<% String id = request.getParameter("movieid");
			
			MovieDAO _movieDAO = new MovieDAO();
			System.out.println(id);
			Movie movie = _movieDAO.searchById(id);
			if(movie != null)
			{
			%>
			
				<tr>
					<td><%= movie.getId()%></td>
					<td><%= movie.getTitle()%></td>
					<td><%= movie.getGenre()%></td>
					<td><%= movie.getDuration()%></td>
					<td><%= movie.getReleaseDate()%></td>
					<td><%= movie.getLanguage()%></td>
					<td><%= movie.getDirector() %></td>
					<td><%= movie.getCast()%></td>
					<td><%= movie.getSynopsis()%></td>
					<td><a href="<%= movie.getLink()%>"><bean:message key="link.ba"/></a></td>
				</tr>
				<%
				
					}	

			%>
			
			
</table>
	
							
	
</body>
</html>
