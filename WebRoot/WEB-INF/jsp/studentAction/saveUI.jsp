<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
    <title>修改学生信息</title>
    <script type="text/javascript">
    	
    	function showRoom(name) {
			$("#room").load("bill_room.action?dormName=" + name);	
        }
    </script>
  </head>
   
  <body>
  
  <div style="width: 500px;text-align: center;margin:0 auto;">
  <h1>学生详细信息</h1>
  	<s:form cssClass="form-horizontal" action="student_%{id == 0?'add':'edit'}">
		<s:hidden name="id"></s:hidden>
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">姓名</label>
			<div class="col-sm-10">
				<s:textfield name="name" cssClass="form-control" id="inputPassword"></s:textfield>
			</div>
		</div>
		
		<div class="form-group">
			<label for="cardId" class="col-sm-2 control-label">卡号</label>
			<div class="col-sm-10">
				<s:textfield name="cardId" cssClass="form-control" id="cardId"></s:textfield>
			</div>
		</div>
		
		<div class="form-group">
			<label for="major" class="col-sm-2 control-label">专业</label>
			<div class="col-sm-10">
				<s:textfield name="major" cssClass="form-control" id="major"></s:textfield>
			</div>
		</div>
		
		<div class="form-group">
			<label for="college" class="col-sm-2 control-label">学院</label>
			<div class="col-sm-10">
				<s:textfield name="college" cssClass="form-control" id="college"></s:textfield>
			</div>
		</div>
		
		<div class="form-group">
			<label for="grade" class="col-sm-2 control-label">年级</label>
			<div class="col-sm-10">
				<s:textfield name="grade" cssClass="form-control" id="grade"></s:textfield>
			</div>
		</div>
		
		<div class="form-group">
			<label for="gender" class="col-sm-2 control-label">性别</label>
			<div class="col-sm-10">
				<s:radio list="#{'男':'男 ','女':'女'}" name="gender"/>
			</div>
		</div>
		
		<div class="form-group">
			<label for="resource" class="col-sm-2 control-label">招生类别</label>
			<div class="col-sm-10">
				<s:textfield name="resource" cssClass="form-control" id="resource"></s:textfield>
			</div>
		</div>
		
		<div class="form-group">
			<label for="type" class="col-sm-2 control-label">类型</label>
			<div class="col-sm-10">
				<s:textfield name="type" cssClass="form-control" id="type"></s:textfield>
			</div>
		</div>
		
		<div class="form-group">
			<label for="yearLength" class="col-sm-2 control-label">学制</label>
			<div class="col-sm-10">
				<s:textfield name="yearLength" cssClass="form-control" id="yearLength"></s:textfield>
			</div>
		</div>
		
		<div class="form-group">
			<label for="campus" class="col-sm-2 control-label">校区</label>
			<div class="col-sm-10">
				<s:textfield name="campus" cssClass="form-control" id="campus"></s:textfield>
			</div>
		</div>
		
		<div class="form-group">
			<label for="dorm" class="col-sm-2 control-label">宿舍</label>
			<div class="col-sm-10">
				<s:select name="dormId" onchange="showRoom(this.value)" list="#dormInfoList" listKey="name" listValue="name" headerKey="" headerValue="请选择"></s:select>
				<div id="room">
					<select><option selected>请选择</option></select>
				</div>
				</p>
			</div>
		</div>
		
		<div class="form-group">
			<label for="inDate" class="col-sm-2 control-label">入住日期</label>
			<div class="col-sm-10">
				<s:textfield name="inDate" cssClass="form-control" id="inDate"></s:textfield>
			</div>
		</div>
		
		<div class="form-group">
			<label for="outDate" class="col-sm-2 control-label">离校日期</label>
			<div class="col-sm-10">
				<s:textfield name="outDate" cssClass="form-control" id="outDate"></s:textfield>
			</div>
		</div>

    	<s:submit cssClass="btn btn-primary"></s:submit>
   	</s:form>
   	</div>
  </body>
</html>
  