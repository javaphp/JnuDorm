<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
    <title>修改账单信息</title>
    
    <script type="text/javascript">
    	
    	function showRoom(name) {
			$("#room").load("bill_room.action?dormName=" + name);	
        }
    </script>
    
  </head>
   
  <body>
  
  <div style="width: 500px;text-align: center;margin:0 auto;">
  <h1>账单详细信息</h1>
  	<s:form cssClass="form-horizontal" action="bill_%{id == 0 ? 'save' : 'edit'}">
		<s:hidden name="id"></s:hidden>
		<div class="form-group">
			<label for="yearMonth" class="col-sm-2 control-label">年-月</label>
			<div class="col-sm-10">
				<s:textfield name="yearMonth" cssClass="form-control" id="yearMonth"></s:textfield>
			</div>
		</div>
		
		<div class="form-group">
			<label for="water" class="col-sm-2 control-label">用水量</label>
			<div class="col-sm-10">
				<s:textfield name="water" cssClass="form-control" id="water"></s:textfield>
			</div>
		</div>
		
		<div class="form-group">
			<label for="electricity" class="col-sm-2 control-label">用电量</label>
			<div class="col-sm-10">
				<s:textfield name="electricity" cssClass="form-control" id="electricity"></s:textfield>
			</div>
		</div>
		
		<div class="form-group">
			<label for="waterPrice" class="col-sm-2 control-label">水价(吨)</label>
			<div class="col-sm-10">
				<s:textfield name="waterPrice" cssClass="form-control" id="waterPrice"></s:textfield>
			</div>
		</div>
		
		<div class="form-group">
			<label for="electricityPrice" class="col-sm-2 control-label">电价(千瓦时)</label>
			<div class="col-sm-10">
				<s:textfield name="electricityPrice" cssClass="form-control" id="electricityPrice"></s:textfield>
			</div>
		</div>
		
		<div class="form-group">
			<label for="dorm" class="col-sm-2 control-label">宿舍</label>
			<div class="col-sm-10">
				<s:select onchange="showRoom(this.value)" list="#dormInfoList" listKey="name" listValue="name" headerKey="" headerValue="请选择"></s:select>
				<div id="room">
					<select><option selected>请选择</option></select>
				</div>
				</p>
			</div>
		</div>
		

    	<s:submit cssClass="btn btn-primary"></s:submit>
   	</s:form>
   	</div>
  </body>
</html>
  