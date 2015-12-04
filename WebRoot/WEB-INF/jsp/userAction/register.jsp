<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
    <title>用户列表</title>
    <script type="text/javascript">
    	function checkUserName(userName) {
    		$.post("user_checkUserName",
   				{ userName: userName }, //要传递的数据
   				function(data){
   				alert("返回的数据: " + data);
   				}
   				) 
        }
    </script>
    
  </head>
  
  <body>
  <div style="width: 600px;text-align: center;margin:0 auto;">
  
  <div style="width: 400px;text-align: center;margin:0 auto;float:left;">
  	<h1>用户注册</h1>
  	<s:form action="user_register" cssClass="form-horizontal">
  		
  		<s:if test="hasFieldErrors()">
  		<div class="form-group has-error">
  		</s:if>
  		<s:else><div class="form-group"></s:else>
			<label for="name" class="col-sm-3 control-label">用户名</label>
			<div class="col-xs-9">
				<s:textfield name="name" cssClass="form-control" id="name" onblur="checkUserName(this.value)"></s:textfield>
				
			</div>
		</div>
		
		<div class="form-group">
			<label for="email" class="col-sm-3 control-label">邮箱</label>
			<div class="col-xs-9">
				<s:textfield name="email" cssClass="form-control" id="email"></s:textfield>
			</div>
		</div>
		
		<div class="form-group">
			<label for="password" class="col-sm-3 control-label">密码</label>
			<div class="col-xs-9">
				<s:password name="password" cssClass="form-control" id="password"></s:password>
			</div>
		</div>
		<s:submit cssClass="btn btn-primary" value="提交"></s:submit>
  	</s:form>
  	</div>
  	<div style="width: 200px;text-align: center;margin:0 auto;float:left; margin-top: 80px">
  		<s:fielderror fieldName="name" cssClass="text-danger"/> 
  	</div>
  	</div>
  </body>
</html>
