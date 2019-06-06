<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>


<link rel="stylesheet" type="text/css" href="/resources/css/document_specific.css">
    
<center><h2>${document.getDocumentName()}</h2></center>


<div class="main">
	<div class="wrapper">
	  	<div id="left-sidebar" class="box"><%@include file="../includes/document_left_sidebar.jsp" %></div>
	  	<div id="handler-left" class="handler"></div>
	 	<div id="main-container" class="box">
	  		<div id="doc-content">
	  			 ${document.getData()} 
	  		</div>
	  	</div>
	  	<div id="handler-right" class="handler" ></div>
	  	<div id="right-sidebar" class="box"><%@include file="../includes/document_right_sidebar.jsp" %></div>
	</div>
	
	<div class="document-saving">
		<button class="button_2 red" onclick="deleteDoc()"><spring:message code="document.delete"/></button>
		<button class="button_2 cyan" onclick="saveDoc(1,'doc-content')"><spring:message code="document.save"/></button>
		<button class="button_2 green" onclick="downloadDocx('doc-content')"><spring:message code="document.downloadFile"/></button>
	</div>
</div>


<script src="/resources/js/libs/FileSaver.js"></script>
<script src="/resources/js/libs/html-docx.js"></script> 

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/document_main.js"></script>
