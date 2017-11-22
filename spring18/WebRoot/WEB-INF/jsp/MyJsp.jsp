<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>MyJsp.jsp</title>
</head>
<body>
    <a href="hello.action">返回</a>
    <h1>
        <spring:message code="tiwen"/>
    </h1>
    当前语言: ${pageContext.response.locale }
</body>
</html>