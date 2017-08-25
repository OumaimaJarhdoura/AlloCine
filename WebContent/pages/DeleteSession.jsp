<%@page import="entities.Session"%>
<%@page import="daos.SessionDAO"%>
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
			
			<% String id = request.getParameter("sessionid");
			
			SessionDAO _sessionDAO = new SessionDAO();
			System.out.println(id);
			Boolean _session = _sessionDAO.delete(Long.parseLong(id));
			if(_session)
			{ 
			%>
			<H1><bean:message key="delete.session.ok"/></H1>
			<a href="SearchSession.jsp"><bean:message key="retour.display"/></a>
			<%
			} else 
			%>
			<H1><bean:message key="delete.session.ko"/></H1>
			<a href="SearchSession.jsp"><bean:message key="retour.display"/></a>
			
						
			
	
							
	
</body>
</html>
