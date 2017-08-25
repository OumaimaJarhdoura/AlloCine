<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.util.ArrayList, java.util.Iterator, entities.Movie"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<style type="text/css">
	    <%@include file="bootstrap/css/bootstrap.css" %>
	    <%@include file="bootstrap/css/bootstrap-theme.css" %>
	    .centrer
	    {
	    	margin-top : 10%;
	    }
	    h1
	    {
	    	margin-bottom : 5%;
	    	text-align : center;
	    }
	    body
	    {
	    	margin-left : 5%;
	    	margin-right : 5%;
	    }
	</style>
	<script src="bootstrap/js/jquery.js"></script>
	<script src="bootstrap/js/bootstrap.js"></script>
<title><bean:message key="titre.site"/></title>
<script>
	
	
	</script>
	
	</head>
<body>
<H1><bean:message key ="titre.result.search"/></H1>

<table class="table table-active">
			<tr>
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
			
			<% @SuppressWarnings("unchecked") 
			ArrayList<Movie> movies = (ArrayList<Movie>) request.getAttribute("movies");
			if(movies != null)
			{
				Iterator<Movie> it = movies.iterator();
				while(it.hasNext())
				{
					Movie movie = (Movie) it.next();
					if(movie != null)
					{
					%>
				<tr>
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
				}
			}
			%>
			
			
</table>			
</body>
</html>
