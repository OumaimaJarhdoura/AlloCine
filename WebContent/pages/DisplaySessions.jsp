<%@page import="entities.Session"%>
<%@page import="services.SessionServices"%>
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
	<script>
		
	
	</script>
	<title><bean:message key="titre.site" /></title>
</head>
<body>

	<H1><bean:message key="display.session.user"/></H1>
	<div class="container">
		<%
		SessionServices sessionservices = (SessionServices) FactoryServices.getService("Session");
		ArrayList<Session> sessions = sessionservices.findAllSessions();
			if (sessions.isEmpty()) {
		%>
		<p><bean:message key="error.session.null"/></p>
		
		<%
			} else {
		%>

		<table class="table table-hover">
			<thead>
				<tr>
				<th>id</th>
					<th><bean:message key="movie.title"/></th>
					<th><bean:message key="movie.genre"/></th>
					<th><bean:message key="theatre.name"/></th>
					<th><bean:message key="theatre.city"/></th>
					<th><bean:message key="session.date"/></th>
				</tr>
			</thead>
			<tbody>

				<%
					for (Session _session : sessions) {
						Movie movie = _session.getMovie();
					System.out.println(_session.getId());
				%>
				<tr>
					<td><%=_session.getMovie().getId()%></td>
					<td><%=_session.getMovie().getTitle()%></td>
					<td><%=_session.getMovie().getGenre()%></td>
					<td><%=_session.getTheatre().getName()%></td>
					<td><%= _session.getTheatre().getCity() %></td>
					<td><%=_session.getBegindate() %></td>
					
					<td><a href="displayMovieAllInformation.jsp?movieid=<%=_session.getMovie().getId()%>" class="btn btn-success pull-right btn-fyi">
						<bean:message key="form.movie.button.plus"/></a></td>
					
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
