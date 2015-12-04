<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
    <title>账单列表</title>
    <script type="text/javascript">
    	function createDormInfo() {
        	location.href="bill_addUI.action";
        	}
    </script>
    
  </head>
  
  <body>
  	<h1>账单列表</h1>
  	<input type="button" id="newDormInfo" onclick="createDormInfo()" class="btn btn-primary" value="创建新记录">
  	<s:a action="bill_room?dormName=\"文雅阁\"">测试</s:a>
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
    		<td>${shouldPay }</td>
    		<td>${alreadyPay }</td>
    		<td><s:a action="bill_editUI?id=%{id}">修改</s:a></td>
    		<td><s:a action="bill_delete?id=%{id}">删除</s:a></td>
    	</tr>
    	
    </s:iterator>
	</table>

  </body>
</html>
