<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="bloc-1">
	<table class="table-1">
		<tr>
			<th><p><spring:message code="info.yourinfos"/></p></th>
		</tr>
		<tr>
			<td><p><spring:message code="info.yourname"/></p></td>
			<td><p>${userName}</p></td>
		</tr>
		<tr>
			<td><p><spring:message code="info.youremail"/></p></td>
			<td><p>${userEmail}</p></td>
		</tr>
	</table>
</div>


<div class="bloc-2">
	<table class="table-1">
		<tr>
			<th><p><spring:message code="template.yourtemplates"/></p></th>
		</tr>
		<%-- 
		<c:forEach var="name"  items="${requestScope['ListName']}" >
		   <option value="<c:out value='${name.nom}'/>"><c:out value="${name.nom}"/></option>
		
			<tr>
				<td><p><spring:message code="info.yourname"/></p></td>
				<td><p>${userName}</p></td>
			</tr>
		
		</c:forEach>
		--%>
		
	</table>
</div>


<div class="bloc-1">
	<form method="POST" class="center">
		<button type="submit" class="button_1"><spring:message code="connection.logout"/></button>
	</form>
</div>


 