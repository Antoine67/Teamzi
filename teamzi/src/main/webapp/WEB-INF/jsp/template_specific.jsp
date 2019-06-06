<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<link rel="stylesheet" type="text/css" href="/resources/css/template_specific.css">
<link rel="stylesheet" type="text/css" href="/resources/css/template/template_fields_editing.css">
<link rel="stylesheet" type="text/css" href="/resources/css/template/template_formatting_tab.css">
<link rel="stylesheet" type="text/css" href="/resources/css/template/template_options_tab.css">
<link rel="stylesheet" type="text/css" href="/resources/css/template/template_saving_tab.css">

<div class="main">
	<div class="tab">
	  	<button class="tablinks" onclick="openTab(event, 'formatting')"><spring:message code="template.formatting"/></button>
	  	<button class="tablinks" onclick="openTab(event, 'fields')"><spring:message code="template.fields"/></button>
	  	<button class="tablinks" onclick="openTab(event, 'options')"><spring:message code="template.options"/></button>
	  	<button class="tablinks" onclick="openTab(event, 'saving')"><spring:message code="template.savingExport"/></button>
	</div>

	<!-- First tab : formatting part -->
	<div id="formatting" class="tabcontent">
	  	<div id="template-content">
	  		<%@include file="../includes/template_formatting_tab.jsp" %>
	  	</div>
	  
	</div>
	<!-- End first tab -->
	
	<!-- Second tab : fields part -->
	<div id="fields" class="tabcontent">
	  	<div id="fields-editing">
	  		<%@include file="../includes/template_fields_editing.jsp" %>
	  	</div>
	</div>
	<!-- End second tab -->
	
	<!-- Third tab : options part -->
	<div id="options" class="tabcontent">
	  	<%@include file="../includes/template_options_tab.jsp" %>
	</div>
	<!-- End third tab -->
	
	<!-- 4th tab : saving part -->
	<div id="saving" class="tabcontent">
		<div class="template-saving">
			<%@include file="../includes/template_saving_tab.jsp" %>
	  	</div>
	  	
	</div>
	<!-- End 4th tab -->
</div>

 <script src="/resources/js/template_specific.js"></script> 