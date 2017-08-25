<%@page import="entities.Session"%>
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
		function redirection(a)
		{
			<%
				HttpSession s = request.getSession();
				request.setCharacterEncoding("utf8");
				s.setAttribute("sessionsFounded", request.getAttribute("sessionsFounded"));
			%>
			//var id = a.parentNode.parentNode.childNodes[1].innerHTML;
			location.href="index.jsp";
		}
	
	</script>
	
	</head>
<body>
<H1><bean:message key ="display.session.admin"/></H1>

<table class="table table-active">
			<tr>
				<th><bean:message key="movie.id"/></th>
				<th><bean:message key="movie.title"/></th>
				<th><bean:message key="theatre.name" /></th>
				<th><bean:message key="theatre.city" /></th>
				<th><bean:message key="session.date" /></th>
				<th></th>
			</tr>
			
			<% @SuppressWarnings("unchecked") 
			ArrayList<Session> sessions = (ArrayList<Session>) request.getAttribute("sessions");
			if(sessions != null)
			{
				Iterator<Session> it = sessions.iterator();
				while(it.hasNext())
				{
					Session _session = (Session) it.next();
					if(s != null)
					{
					%>
				<tr>
					<td><%= _session.getId()%></td>
					<td><%= _session.getMovie().getTitle()%></td>
					<td><%= _session.getTheatre().getName()%></td>
					<td><%= _session.getTheatre().getCity()%></td>
					<td><%= _session.getBegindate()%></td>
					
					<td><a href="pages/UpdateSession.jsp?sessionid=<%=_session.getId()%>" class="btn btn-warning pull-right btn-fyi">
						<bean:message key="form.search.button.update"/></a>
					</td>
					<td><a href="pages/DeleteSession.jsp?sessionid=<%=_session.getId()%>" class="btn btn-danger pull-right btn-fyi">
						<bean:message key="button.delete.session"/></a>
					</td>
				</tr>
				<%
				
					}	
				}
			}
			%>
			
			
</table>			
</body>
</html>
