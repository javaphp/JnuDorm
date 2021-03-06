<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
    <title>角色列表</title>
    <script type="text/javascript">
    	function createRole() {
        	location.href="role_addUI.action";
        	}
    </script>
    
  </head>
  
  <body>
  	<h1>角色列表</h1>
  	<input type="button" id="newRole" onclick="createRole()" class="btn btn-primary" value="创建新记录">
    
	<table class="table">
		<tr>
		  	<td>id</td>
		  	<td>名称</td>
		  	
	  	</tr>
	  <s:iterator value="#roleList">
    	<tr>
    		<td>${id}</td>
    		<td>${name }</td>
    		<td><s:a action="role_editUI?id=%{id}">修改</s:a></td>
    		<td><s:a action="role_delete?id=%{id}">删除</s:a></td>
    		<td><s:a action="role_setPrivilegeUI?id=%{id}">设置权限</s:a></td>
    	</tr>
    </s:iterator>
	</table>

  </body>
</html>
