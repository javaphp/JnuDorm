<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
    <title>设置角色</title>
  </head>
   
  <body>
  
  <div style="width: 500px;margin:0 auto;">
  <h1>为${name }设置角色</h1>
  	<s:form cssClass="form-horizontal" action="user_setRole">
		<s:hidden name="id"></s:hidden>
		<s:iterator value="#roleList">
			<input type="checkbox" name="roleIds" value="${id }" id="cb_${id }" <s:property value="%{id in roleIds?'checked':''}"/> />
			<label for="cb_${id }">${name }</label><br/>
		</s:iterator>
    	<s:submit cssClass="btn btn-primary"></s:submit>
   	</s:form>
   	</div>
  </body>
</html>
  