<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<button class="button_2 cyan" onclick="saveAsDraft('template-content')"><spring:message code="template.saveAsDraft"/></button>
<button class="button_2 green" onclick="finalizeDoc('template-content')"><spring:message code="template.finalize"/></button>