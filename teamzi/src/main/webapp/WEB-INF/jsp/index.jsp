<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

Index ! Test 2

<c:forEach var="user" items="${users}" varStatus="status">
              <tr>
                  <td>${user.userId}</td>
                  <td>${user.userName}</td>
                  <td>${user.userEmail}</td>
                            
              </tr>
              </c:forEach>     