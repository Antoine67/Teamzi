<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2><spring:message code="document.yourdocuments"/></h2>

	<c:if test = "${documents == null || documents.size() < 1}">
		<p><spring:message code="document.noDocumentsFound"/></p>	
	</c:if>

	<c:if test = "${documents ne null && documents.size() > 0}">
		<ol>
		<c:forEach var="doc" items="${documents}" varStatus="status">
        	<li><a href="${doc.getRelativeUrl()}">${doc.getDocumentName()}</a></li>     
		</c:forEach> 
		</ol>    
	</c:if>