<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
		<title>主面板</title>

	</head>

	<body>
		<s:iterator value="#privilegeList">
			<a href="${pageContext.request.contextPath}${url}.action" target="mainFrame">${name }</a><br/>
		</s:iterator>
	</body>
</html>
