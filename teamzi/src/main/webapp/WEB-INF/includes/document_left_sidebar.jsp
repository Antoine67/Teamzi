<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    

<link rel="stylesheet" type="text/css" href="/resources/css/document_left_sidebar.css">
 	<div class="container">
		<div class="panel panel-default">
            <div class="panel-heading top-bar">
                <div class="col-md-8 col-xs-8">
                    <h3 class="panel-title"><span class="glyphicon glyphicon-comment"></span> Chat </h3>
                </div>
                
            </div>
            <div class="panel-body msg_container_base">
                <div class="row msg_container base_sent">
                    <div class="col-md-10 col-xs-10">
                        <div class="messages msg_sent">
                            <p>lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum</p>
                            <time datetime="2009-11-13T20:00">Timothy • 51 min</time>
                        </div>
                    </div>
                    <div class="avatar">
                        <img class="chat_avatar" src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg">
                    </div>
                </div>
                <div class="row msg_container base_receive">
                    <div class="avatar">
                        <img class="chat_avatar" src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg">
                    </div>
                    <div class="col-md-10 col-xs-10">
                        <div class="messages msg_receive">
                            <p>lorem ipsum</p>
                            <time datetime="2009-11-13T20:00">Timothy • 51 min</time>
                        </div>
                    </div>
                </div>
            </div>
            <div class="panel-footer">
                <div class="input-group">
                    <input id="btn-input" type="text" class="form-control input-sm chat_input" placeholder="<spring:message code="message.write"/>" />
                    <span class="input-group-btn">
                    <button class="btn btn-primary btn-sm" id="btn-chat"><spring:message code="message.send"/></button>
                    </span>
                </div>
            </div>
    </div>
    <!--
    <div class="btn-group dropup">
        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
            <span class="glyphicon glyphicon-cog"></span>
            <span class="sr-only">Toggle Dropdown</span>
        </button>
        <ul class="dropdown-menu" role="menu">
            <li><a href="#" id="new_chat"><span class="glyphicon glyphicon-plus"></span> Novo</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-list"></span> Ver outras</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-remove"></span> Fechar Tudo</a></li>
            <li class="divider"></li>
            <li><a href="#"><span class="glyphicon glyphicon-eye-close"></span> Invisivel</a></li>
        </ul>
    </div>
	-->
</div>