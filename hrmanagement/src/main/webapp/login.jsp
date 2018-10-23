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
$(function () {
    $("[name=u_name]").blur(function () {
        $.ajax({
            type:"get",
            url:"check_user",
            data:"name="+$("#name").val(),
            success:function (obj) {
                $("p").text(obj);
            },
            error:function () {
                $("p").text("error");
            }
        })
    })
})
</script>
<body class="login">
    <div class="login_main">
        <div class="login_logo"><h1>LOGIN</h1></div>
        <div class="login_border">
            <div class="login_padding">
                <form action="login" method="post">
                    <h2>USERNAME</h2>
                    <span><input type="text" name="u_name"></span>
                    <h2>PASSWORD</h2>
                    <span><input type="password" name="u_pass" ></span>
                    <h2 style="color:red;"><c:out value="${requestScope.msg}"/></h2>
                    <div class="button" onclick="$('form').submit()">&nbsp;&nbsp;登入&nbsp;&nbsp;</div>
                    <div class="button" onclick="window.location.href='register.jsp'">&nbsp;&nbsp;注册&nbsp;&nbsp;</div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>