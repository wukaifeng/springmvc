<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>界面标题</title>
</head>
<body>
<fmt:message key="i18n.username"></fmt:message>
<fmt:message key="i18n.password"></fmt:message>
	<a href="hello">hello</a>
	<br> time: ${requestScope.time} timeSession: ${sessionScope.time}
</body>
</html>