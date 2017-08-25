<%@page import="daos.SessionDAO"%>
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
	
	<H1><bean:message key="titre.session.update" /></H1>
	
	<% String id = request.getParameter("sessionid");
			
			SessionDAO _sessionDAO = new SessionDAO();
			System.out.println(id);
			Session session = _sessionDAO.searchById(id);
			if(session)
			{ 
			%>				
	<div class="container">
	<html:form action="/UpdateSession" styleClass="form-horizontal">
				<div class="form-horizontal">
				<label for="begindate"><bean:message key="form.session.begindate"/></label>
				<html:text value="<%=session.getBegindate()%>" property="begindate" styleClass="form-control"/>
				
				
				
				<html:submit styleClass="btn btn-default">
						<bean:message key="form.session.create" />
					</html:submit>
				</div>
			</html:form>
			
	</div>
</body>
</html>
