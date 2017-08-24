<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Movie"%>
<%@page import="entities.Theatre"%>
<%@page import="services.MovieServices"%>
<%@page import="services.FactoryServices"%>
<%@page import="services.TheatreServices"%>
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
	
	<H1><bean:message key="titre.session.create" /></H1>
							
	<div class="container">
	<html:form action="/CreateSession" styleClass="form-horizontal">
				<div class="form-horizontal">
					<label for="movieid"><bean:message key="form.session.movie" /></label>
					<html:select property="movieid" styleClass="form-control">	
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
				
				<label for="theatreid"><bean:message key="form.session.theatre" /></label>
					<html:select property="theatreid" styleClass="form-control">	
				<%
		TheatreServices theatreservices = (TheatreServices) FactoryServices.getService("Theatre");
		ArrayList<Theatre> theatres = theatreservices.findAllTheatres();
			if (theatres.isEmpty()) {
		%>
		<p><bean:message key="error.theatre.null"/></p>
		
		<%
			} else {
				Iterator<Theatre> it = theatres.iterator();
			
			while(it.hasNext())
			{
				Theatre theatre = (Theatre) it.next();
				if(theatre != null)
				{ String ID = Long.toString(theatre.getId());
					String affich = ID+' ' + theatre.getName()+' '+ theatre.getZipcode();
					

		%>

			
					
	
				<html:option value="<%=ID%>"><%=affich%></html:option>
				
				<%
					}
					}}
				%>
				</html:select>
				<label for="begindate"><bean:message key="form.session.begindate"/></label>
				<html:text property="begindate" styleClass="form-control"/>
				
				
				
				<html:submit styleClass="btn btn-default">
						<bean:message key="form.session.create" />
					</html:submit>
				</div>
			</html:form>
			
	</div>
</body>
</html>
