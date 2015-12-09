<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
    <title>无权限</title>
	
  </head>
  
  <body>
  <div style="margin: auto; text-align: center">
    	无权限访问
    	<img alt="" src="style/img/noPrivilege.png">
	</div>
		<script language="JavaScript" type="text/javascript">
		function delayURL(url) {
			var delay = document.getElementById("time").innerHTML;
			if (delay > 0) {
				delay--;
				document.getElementById("time").innerHTML = delay;
			} else {
				window.top.location.href = url;
			}
			t = setTimeout("delayURL('" + url + "')", 1000);
		}
	
		function stop1() {
			t && clearTimeout(t);
		}
		</script>
		<div style="margin: auto; text-align: center">
		<span id="time" style="background: #00BFFF">10</span>秒钟后自动跳转，如果不跳转，请点击下面的链接
		<s:a action="home_index">主页</s:a>
		<input type="button" value="停止跳转" class="btn btn-danger" onclick="stop1()">
		</div>
		<script type="text/javascript">
	delayURL("home_index.action");
</script>

	</body>
</html>
