<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/jquery-treeview/jquery.treeview.css"/>
    <script  src="js/jquery-treeview/jquery.treeview.js"></script>
    <title>设置权限</title>
    <script type="text/javascript">
    	
    	$(function(){
    	//$(document).ready(function() {
			$("[name=privilegeIds]").click(function(){
				
				$(this).siblings("ul").find("input").attr("checked", this.checked);
				
				if(this.checked == true){
					$(this).parents("li").children("input").attr("checked", true);
				}
				
			});
		});
    </script>
    
  </head>
  
  <body>
  
  <div style="width: 500px;margin:0 auto;">
  <h1>设置权限</h1>
  	<s:form cssClass="form-horizontal" action="role_setPrivilege">
		<s:hidden name="id"></s:hidden>
		<ul id="tree">
		<s:iterator value="#topPrivilegeList">
	        <li><input type="checkbox" name="privilegeIds" value="${id}" id="cb_${id}" <s:property value="%{id in privilegeIds ? 'checked' : ''}"/>/>
	        <s:property value="id"/>
	        <label for="cb_${id}">${name }</label>
			<ul>
			<s:iterator value="children">
				<li><input type="checkbox" name="privilegeIds" value="${id}" id="cb_${id}" <s:property value="%{id in privilegeIds ? 'checked' : ''}"/>/>
				<s:property value="id"/>
				<label for="cb_${id}">${name }</label>
					<ul>
					<s:iterator value="children">
						<li><input type="checkbox" name="privilegeIds" value="${id}" id="cb_${id}" <s:property value="%{id in privilegeIds ? 'checked' : ''}"/>/>
						<s:property value="id"/>
						<label for="cb_${id}">${name }</label></li>
					</s:iterator>
					</ul>
				</li>
			</s:iterator>
			</ul>
			</li>
		</s:iterator>
		</ul>
    	<s:submit cssClass="btn btn-primary"></s:submit>
    	
   	</s:form>
   	<script type="text/javascript">
	  	$("#tree").treeview();
	</script>
	</div>
  </body>
</html>
  