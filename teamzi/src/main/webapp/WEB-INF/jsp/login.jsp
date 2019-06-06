<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://apis.google.com/js/platform.js?onload=renderButton" async defer></script>

<meta name="google-signin-scope" content="profile email">
<meta name="google-signin-client_id"
     content="218844300929-7b14hk9qrpnp6d6ai8eha585t8ml74lc.apps.googleusercontent.com">


</head>
<body>
<div class="connection-main-bloc">
	<h2><spring:message code="connection.label"/></h2>
	<br/>
	<div id="google-signin" > </div>
</div>  
  
     
   
   <script src="resources/js/login.js"></script>
   
   
   
</body>
</html>