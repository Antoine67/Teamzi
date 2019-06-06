<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>

<%

//Requested page (example : "login" or "index")
String uri = request.getAttribute("javax.servlet.forward.request_uri").toString();
String pageName = uri.substring(uri.lastIndexOf("/")+1);

boolean logged_in = false;
if (session.getAttribute("userName") != null) { logged_in = true;}
%>

<head>
	<title><tiles:getAsString name="title"></tiles:getAsString></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="resources/css/header.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/utils/loading.css">
	<link rel="stylesheet" type="text/css" href="resources/css/<% out.print(pageName); %>.css">
</head>

<script src="resources/js/utils/loading.js"></script>

<header>
	<nav class="navbar navbar-default" id="navigation-purple">
        <div class="container" style="width:100%">
        	   	<a class="back" href="/">←</a>
        </div>
    </nav>
</header>


<%-- Eventually display a message on top --%>
<c:if test="${error ne null}">
  <div class="alert alert-danger">${error}</div>
</c:if>

<c:if test="${success ne null}">
  <div class="alert alert-success">${success}</div>
</c:if>



<body>
	<tilesx:useAttribute name="current" />
    <tiles:insertAttribute name="body" />
    
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>
