<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>SpringMVC<spring:message code="internationalisation"/></title>
</head>
<body>
    <a href="myJsp.action">跳转</a>
    Language:
    <a href="?lang=zh_CN"><spring:message code="language.cn"/></a> &nbsp;&nbsp;&nbsp;
    <a href="?lang=en_US"><spring:message code="language.en"/></a>
    <button id="submit" onclick="is()">提交</button>
    <h1>
        <spring:message code="welcome"/>
    </h1>
    当前语言: ${pageContext.response.locale }
</body>

</html>
<script type="text/javascript" src="${pageContext.request.contextPath}/holle.js">
alert();
</script>