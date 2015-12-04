<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
		<title>主面板</title>
		<script type="text/javascript">
	function createDormInfo() {
		location.href = "bill_addUI.action";
	}
</script>

	</head>
	<frameset rows="59,*,59" cols="*" frameborder="no" border="0"
		framespacing="0">
		<frame src="${pageContext.request.contextPath}/top.jsp"
			name="topFrame" scrolling="No" noresize="noresize" id="topFrame" />
		<frameset cols="20%,*" frameborder="no" border="0" framespacing="0">
			<frame src="${pageContext.request.contextPath}/left.jsp"
				name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" />
			<frame src=""
				name="mainFrame" id="mainFrame" />
		</frameset>
		<frame src="${pageContext.request.contextPath}/bottom.jsp" />
	</frameset>
	<body>

	</body>
</html>
