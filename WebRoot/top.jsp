<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
		<title>主面板</title>

	</head>

	<body>
		
		<header style="color:white; background-color: #563D7C;"
			class="navbar navbar-inverse navbar-fixed-top" role="banner">
		<h3 style="margin-left: 20px; width: 500px; float: left">
			暨南大学宿舍水电管理系统
		</h3>
		<div style="color:white; float: right; width: 200px; text-align: center; margin-top: 30px">
			欢迎你，${session.user.name }　　<a href="${pageContext.request.contextPath}/user_logout.action" target="_parent">退出</a>
		</div>
		</header>
		
	</body>
</html>
