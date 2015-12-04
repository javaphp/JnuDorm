<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
    <title>修改宿舍信息</title>
  </head>
   
  <body>
  
  <div style="width: 500px;text-align: center;margin:0 auto;">
  <h1>宿舍详细信息</h1>
  	<s:form cssClass="form-horizontal" action="dormInfo_%{id == 0?'add':'edit'}">
		<s:hidden name="id"></s:hidden>
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">名称</label>
			<div class="col-sm-10">
				<s:textfield name="name" cssClass="form-control" id="inputPassword"></s:textfield>
			</div>
		</div>
		
		<div class="form-group">
			<label for="floor" class="col-sm-2 control-label">楼层</label>
			<div class="col-sm-10">
				<s:textfield name="floor" cssClass="form-control" id="floor"></s:textfield>
			</div>
		</div>
		
		<div class="form-group">
			<label for="room" class="col-sm-2 control-label">房间号</label>
			<div class="col-sm-10">
				<s:textfield name="room" cssClass="form-control" id="room"></s:textfield>
			</div>
		</div>
		

    	<s:submit cssClass="btn btn-primary"></s:submit>
   	</s:form>
   	</div>
  </body>
</html>
  