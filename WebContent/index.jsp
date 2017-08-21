<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%> 
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%> 
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<style type="text/css">
	    <%@include file="WEB-INF/bootstrap/css/bootstrap.css" %>
	    <%@include file="WEB-INF/bootstrap/css/bootstrap-theme.css" %>
	    .center
	    {
	    	margin-top:10%;
	    }
	</style>
	<script src="WEB-INF/bootstrap/js/jquery.js"></script>
	<script src="WEB-INF/bootstrap/js/bootstrap.js"></script>
	<title><bean:message key="site.titre" /></title>
</head>
<body>
	<div class="container-fluid">
		<html:form action="/LoginForm" styleClass="form-horizontal">
			<div class="row center">
			<div class="col-md-4 col-md-offset-4">
				<h1>Bienvenue</h1>
					<div class="col-md-offset-1">
						<div class="form-group">
							<label><bean:message key="login.id" /></label><html:text property="Id" styleClass="form-control"/>
						</div>
						<div class="form-group">
							<label><bean:message key="login.pass" /></label><html:password property="pass" styleClass="form-control"/>
						</div>
						<div class="form-group">
							<html:submit styleClass="btn btn-default">
								<bean:message key="login.bouton.connexion" />
							</html:submit>
						</div>
			</div>
			</div>
		</html:form>
		<html:errors />
	</div>
</body>
</html>