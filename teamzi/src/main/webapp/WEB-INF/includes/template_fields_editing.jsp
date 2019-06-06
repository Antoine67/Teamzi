<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div style="display:flex; flex-wrap: nowrap;">
	<div class="left-field-editing">
		<div class="up-static"><h3><spring:message code="template.field.setupField"/></h3></div>
		<div>gauche</div>
	</div>
	<div class="right-field-editing">
		<div class="up-static"><h3><spring:message code="template.field.addField"/></h3></div>
		<div>droite</div>
	</div>
</div>