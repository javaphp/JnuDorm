<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
    <title>账单列表</title>
    
  </head>
  
  <body>
  	
  	<s:select name="dormId" list="#dormInfoList" listKey="id" listValue="room"></s:select>

  </body>
</html>
