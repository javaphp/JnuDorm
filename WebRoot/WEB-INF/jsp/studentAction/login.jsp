<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
    <title>用户登陆</title>
    
  </head>
  <body>
   <div style="width: 500px;text-align: center;margin:0 auto;">
  	<h1>学生登陆</h1>
  	<s:form action="student_login" cssClass="form-horizontal">
  		<div class="form-group">
			<label for="cardNum" class="col-sm-2 control-label">校园卡号</label>
			<div class="col-sm-10">
				<input type="text" name="cardNum" class="form-control">
			</div>
		</div>
		
		<div class="form-group">
			<label for="myPassword" class="col-sm-2 control-label">密码</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" name="myPassword" id="myPassword">
			</div>
		</div>
		<s:submit  cssClass="btn btn-primary" value="登陆"></s:submit>
  	</s:form>
	</div>
  </body>
</html>
