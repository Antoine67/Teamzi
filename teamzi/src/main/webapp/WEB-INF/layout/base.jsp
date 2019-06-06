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
	<title><tiles:getAsString name="title"/></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/header.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/utils/button.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/utils/loading.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/<% out.print(pageName); %>.css">
    <meta name="google-signin-client_id" content="218844300929-7b14hk9qrpnp6d6ai8eha585t8ml74lc.apps.googleusercontent.com">
</head>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="resources/js/utils/loading.js"></script>

<header>
	<nav class="navbar navbar-default" id="navigation-purple">
        <div class="container" style="width:100%">
        
        <% if (logged_in) { %>
            <a href="/profile"><img class="img-responsive img-circle avatar" src="${sessionScope.userPicture}" alt="Avatar"></a>
        <% } else { // Not logged in %>
            <a class="login-button" href="/login"><spring:message code="connection.label"/></a>
		<% } %>
            
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#top-navbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="collapse navbar-collapse" id="top-navbar">
                <ul class="nav navbar-nav">
                    <li><a href="/template"><spring:message code="template.label"/></a></li>
                    <li><a href="/document"><spring:message code="document.label"/></a></li>
                    <li><a href="#">...</a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>


<%-- Eventually display a message on top --%>
<c:if test="${error ne null}">
  <div class="alert alert-danger"><spring:message code="${error}"/>
  	<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  </div>
  
  <c:remove var="error"/>
</c:if>

<c:if test="${success ne null}">
  <div class="alert alert-success"><spring:message code="${success}"/>
  	<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  </div>
  <c:remove var="success"/>
</c:if>



<body>
	<tilesx:useAttribute name="current" />
    <tiles:insertAttribute name="body" />
    
    <%-- 
      <% if (logged_in) { %>
     <%-- Tchat only when logged in 
     	<tiles:insertAttribute name="chat" />
     <% } //End if logged in %>
    --%>
    
    
    
    
</body>

</html>
