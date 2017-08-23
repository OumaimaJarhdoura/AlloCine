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
	<form action ="/src/actionform/CreateSessionForm.java">
  <div class="form-horizontal">
    <label for="title"><bean:message key="form.movie.title" /></label>
    <input type="text" class="form-control" id="title">
    <label for="theatre"><bean:message key="form.session.theatre" /></label>
    <select class="form-control" id="theatre" >
		<?php
try
{
        $bdd = new PDO('mysql:host=localhost;dbname=allocinedb', 'root', 'root');
}
catch(Exception $e)
{
            die('Erreur : '.$e->getMessage());
}
 
 
$reponse = $bdd->query('SELECT * FROM theatre');
 
while ($donnees = $reponse->fetch())
{
	?>
		           <option value=" <?php echo $donnees['nom']; ?>"> <?php echo $donnees['nom']; ?></option>
		<?php
}
 
$reponse->closeCursor();
 
	?>
    </select>
  </div>
  <button type="submit" class="btn btn-default"><bean:message key="form.movie.button.create" /></button>
  <button type="reset"  class="btn btn-default"><bean:message key="form.movie.button.reset" /></button>
</form>
	
</body>
</html>