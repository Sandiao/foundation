<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" session="true" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>问卷调查系统</title>
</head>

<body>
	<div>
		<h1>登录状态失效，请<a href="javascript:parent.location.href='index.jsp'">重新登录</a></h1>
	</div>
</body>
	
</html>