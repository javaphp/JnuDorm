<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
    <title>用户列表</title>
    <script type="text/javascript">
    	function createDormInfo() {
        	location.href="dormInfo_addUI.action";
        	}
    </script>
    
  </head>
  
  <body>
  	<h1>用户列表</h1>
  	<input type="button" id="newUser" onclick="createUser()" class="btn btn-primary" value="创建新用户">
    
	<table class="table">
		<tr>
		  	<td>id</td>
		  	<td>用户名</td>
		  	<td>邮箱</td>
		  	<td>操作</td>
	  	</tr>
	  	<s:iterator value="#userList">
	  		<tr>
	  			<td>${id }</td>
	  			<td>${name }</td>
	  			<td>${email }</td>
	  			<td><s:a action="user_setRoleUI?id=%{id}" >设置角色</s:a>
	  			<s:a action="user_delete?id=%{id}" >删除</s:a></td>
	  		</tr>
	  	</s:iterator>
	  
	</table>

  </body>
</html>
