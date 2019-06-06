<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" type="text/css" href="/resources/css/template.css">

<div class="tab">
	<button id="newTemplateButton">Nouveau template</button>
</div>

<h2><spring:message code="template.yourtemplates"/></h2>

	<c:if test = "${templates == null || templates.size() < 1}">
		<p><spring:message code="template.noTemplateFound"/></p>	
	</c:if>

	<c:if test = "${templates ne null && templates.size() > 0}">
		<ol>
		<c:forEach var="temp" items="${templates}" varStatus="status">
        	<li><a href="${temp.getRelativeUrl()}">${temp.getTemplateName()}</a></li>     
		</c:forEach>  
		</ol>   
	</c:if>
	
	
<script src="/resources/js/template.js"></script> 