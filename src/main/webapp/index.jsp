<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>首页</h1>

	<shiro:guest>
		<p>身份：游客</p>
		<a href="<c:url value="/login.do"/>">登录</a>
		<a href="<c:url value="/register.do"/>">注册</a>
	</shiro:guest>

	<shiro:user>
		<p>
			身份：
			<shiro:principal />
		</p>
		<a href="<c:url value="/space/view.do"/>">空间</a>
		<a href="<c:url value="/logout.do"/>">退出</a>
	</shiro:user>
</body>
</html>