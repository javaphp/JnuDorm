<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
    
    <title>账单列表</title>
    
  </head>
  
  <body>
  	<h1>[${session.student.name }]的账单列表 </h1>
  	
	<table class="table">
		<tr>
		  	<td>id</td>
		  	<td>年-月</td>
		  	<td>应付</td>
		  	<td>已付</td>
		  	<td>操作</td>
	  	</tr>
	  <s:iterator value="#billList">
    	<tr>
    		<td>${id}</td>
    		<td>${yearMonth }</td>
    		<td><fmt:formatNumber value="${shouldPay/studentCount}" pattern="0.0" type="number"/></td>
    		<td>${alreadyPay }</td>
    		<td><s:a action="">去支付(未实现)</s:a></td>
    	</tr>
    	
    </s:iterator>
	</table>

  </body>
</html>
