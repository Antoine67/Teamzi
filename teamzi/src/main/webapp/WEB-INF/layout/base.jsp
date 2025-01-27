<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>

<head>
	<title><tiles:getAsString name="title"></tiles:getAsString></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="resources/css/header.css">
    <link rel="stylesheet" type="text/css" href="resources/css/chat.css">
</head>

<%
boolean logged_in = false;
if (session.getAttribute("userName") != null) { logged_in = true;}
%>

<header>
	<nav class="navbar navbar-default" id="navigation-purple">
        <div class="container" style="width:100%">
    
        <% if (logged_in) { %>
            <a href="#"><img class="img-responsive img-circle avatar" src="${sessionScope.userPicture}" alt="Avatar"></a>
        <% } else { // Not logged in %>
            <a class="login-button" href="/login"><spring:message code="connexion.label"/></a>
		<% } %>
            
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav">
                    <li><a href="#">Abc</a></li>
                    <li><a href="#">Cde</a></li>
                    <li><a href="#">Feg</a></li>
                </ul>
            </div>
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
    
    
     <% if (logged_in) { %>
     <%-- Tchat only when logged in --%>
     	<tiles:insertAttribute name="chat" />
     <% } //End if logged in %>
    
    
    
    
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>
