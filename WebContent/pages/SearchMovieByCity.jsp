<%@page import="java.util.Iterator"%>
<%@page import="entities.Theatre"%>
<%@page import="java.util.ArrayList"%>
<%@page import="services.FactoryServices"%>
<%@page import="services.TheatreServices"%>
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
	<h1><bean:message key="titre.movie.search" /></h1>
		<html:form action="/SearchMovieByCity" styleClass="form-horizontal">
				<div class="form-group">
					<label for="city"><bean:message key="form.session.theatre.city" /></label>
					<html:select property="city" styleClass="form-control">	
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
					String affich = theatre.getCity();
					

		%>

			
					
	
				<html:option value="<%=ID%>"><%=affich%></html:option>
				
				<%
					}
					}}
				%>
				</html:select>
					<html:submit styleClass="btn btn-default">
						<bean:message key="form.session.create" />
					</html:submit>
				</div>
			</html:form>
</body>
</html>