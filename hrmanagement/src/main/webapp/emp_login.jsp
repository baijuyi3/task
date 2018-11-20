<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/27
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>登入</title>
</head>
<link rel="stylesheet" href="css/style_log.css" type="text/css"/>
<style>
    .button{
        margin-top: 15px;
    }
</style>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script>

</script>
<body class="login">
    <div class="login_main">
        <div class="login_logo"><h1>LOGIN</h1></div>
        <div class="login_border">
            <div class="login_padding">
                <form action="emp_view" method="post">
                    <h2>USERNAME</h2>
                    <span><input type="text" name="user"></span>
                    <h2>PASSWORD</h2>
                    <span><input type="password" name="pass" ></span>
                    <h2 style="color:red;"><c:out value="${requestScope.msg}"/></h2>
                    <div class="button" onclick="$('form').submit()">&nbsp;&nbsp;登入&nbsp;&nbsp;</div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
