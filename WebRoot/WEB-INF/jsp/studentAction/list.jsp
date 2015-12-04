<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
    <title>学生信息列表</title>
    <script type="text/javascript">
    	function createStudent() {
        	location.href="student_addUI.action";
        	}
    </script>
    
  </head>
  
  <body>
  	<h1>学生列表</h1>
  	<input type="button" id="newStudent" onclick="createStudent()" class="btn btn-primary" value="创建新记录">
    
	<table class="table">
		<tr>
    		<td>id</td>
    		<td>卡号</td>
    		<td>姓名</td>
    		<td>专业</td>
    		<td>学院</td>
    		<td>年级</td>
    		<td>性别</td>
    		<td>招生类别</td>
    		<td>类型</td>
    		<td>学制</td>
    		<td>校区</td>
    		<td>入住日期</td>
    		<td>离校日期</td>
    		<td>操作</td>
    	</tr>
	  <s:iterator value="#studentList">
    	<tr>
    		<td>${id}</td>
    		<td>${cardId }</td>
    		<td>${name }</td>
    		<td>${major }</td>
    		<td>${college }</td>
    		<td>${grade }</td>
    		<td>${gender }</td>
    		<td>${resource }</td>
    		<td>${type }</td>
    		<td>${yearlength }</td>
    		<td>${campus }</td>
    		<td>${inDate }</td>
    		<td>${outDate }</td>
    		<td><s:a action="student_editUI?id=%{id}">修改</s:a></td>
    		<td><s:a action="student_delete?id=%{id}">删除</s:a></td>
    	</tr>
    	
    </s:iterator>
	</table>

  </body>
</html>
