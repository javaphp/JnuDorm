<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/js/jquery-treeview/jquery.treeview.css"/>
    	<script  src="js/jquery-treeview/jquery.treeview.js"></script>
		<title>主面板</title>

	</head>

	<body>
	<ul id="tree">
		<li>
		<s:iterator value="#privilegeList">
			<s:if test="#session.user.hasPrivilegeByName(name)">
				<a target="mainFrame">${name }</a><br/>
			</s:if>
			<ul>
			<li>
				<s:iterator value="children">
					<s:if test="#session.user.hasPrivilegeByName(name)">
					<a href="${pageContext.request.contextPath}${url}.action" target="mainFrame">${name }</a><br/>
				</s:if>
				</s:iterator>
			</li>
			</ul>
		</s:iterator>
		</li>
	</ul>
	
	<script type="text/javascript">
		$(function() {
			$("#tree").treeview();
		})
	</script>
	</body>
</html>
