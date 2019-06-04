<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>



   
<div>header</div>

<div class="wrapper">
  <div id="left-sidebar" class="box"><%@include file="../includes/document_left_sidebar.jsp" %></div>
  <div id="handler-left" class="handler"></div>
  <div id="main-container" class="box">Middle</div>
  <div id="handler-right" class="handler" ></div>
  <div id="right-sidebar" class="box">Right</div>
</div>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/template_main.js"></script>
