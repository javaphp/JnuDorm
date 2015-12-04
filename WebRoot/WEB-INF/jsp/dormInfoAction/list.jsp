<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
    <title>学生宿舍列表</title>
    <script type="text/javascript">
    	function createDormInfo() {
        	location.href="dormInfo_addUI.action";
        	}
    </script>
    
  </head>
  
  <body>
  	<h1>学生宿舍列表</h1>
  	<input type="button" id="newDormInfo" onclick="createDormInfo()" class="btn btn-primary" value="创建新记录">
    
	<table class="table">
		<tr>
		  	<td>id</td>
		  	<td>名称</td>
		  	<td>楼层</td>
		  	<td>房间号</td>
		  	<td>操作</td>
	  	</tr>
	  <s:iterator value="#dormInfoList">
    	<tr>
    		<td>${id}</td>
    		<td>${name }</td>
    		<td>${floor }</td>
    		<td>${room }</td>
    		<td><s:a action="dormInfo_editUI?id=%{id}">修改</s:a></td>
    		<td><s:a action="dormInfo_delete?id=%{id}">删除</s:a></td>
    	</tr>
    	
    </s:iterator>
	</table>

  </body>
</html>
