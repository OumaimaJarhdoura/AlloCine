<%@page import="java.util.Iterator"%>
<%@page import="entities.Movie"%>
<%@page import="java.util.ArrayList"%>
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
	<h1><bean:message key="titre.session.create" /></h1>
	<html:form action ="/CreateSession">
  <div class="form-horizontal">
  
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
					<td><%= movie.getId()%></td>
					<td><%= movie.getTitle()%></td>
					<td><%= movie.getGenre()%></td>
					<td><%= movie.getDuration()%></td>
					<td><%= movie.getReleaseDate()%></td>
					<td><%= movie.getLanguage()%></td>
					<td><%= movie.getDirector() %></td>
					<td><%= movie.getCast()%></td>
					<td><%= movie.getSynopsis()%></td>
					<td><button class="btn btn-default" onclick="redirection(this)"><bean:message key="form.movie.button.update" /></button></td>
				</tr>
				<%
				
					}	
				}
			}
			%>
    <label for="title"><bean:message key="form.movie.title" /></label>
    <html:text property="title" styleClass="form-control"/>
 	
  </div>
  <html:submit styleClass="btn btn-default">
		<bean:message key="form.movie.button.create" />
  </html:submit>
  <button type="reset"  class="btn btn-default"><bean:message key="form.movie.button.reset" /></button>
	</html:form>
	
</body>
</html>