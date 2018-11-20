<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/5
  Time: 23:20
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
    <title>注册</title>
</head>
<link rel="stylesheet" href="css/style_log.css" type="text/css"/>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script>
    $(function () {
        $("input[name=u_name]").blur(function () {
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
    <div class="login_logo"><h1>REGIST</h1></div>
    <div class="login_border">
        <div class="login_padding">
            <form action="register_1" method="post">
                <h2>USERNAME</h2>
                <span><input type="text" name="u_name"></span>
                <p></p>
                <h2>PASSWORD</h2>
                <span><input type="password" name="u_pass" ></span>
                <div><h2>gender</h2><h2 style="color:red;"><c:out value="${requestScope.msg}"/></h2></div>
                <div class="radio"><input  type="radio" value="男" name="u_sex"/>男<input type="radio" value="女" name="u_sex"/>女</div>
                <div class="button" onclick="window.location.href='login.jsp'">&nbsp;&nbsp;返回&nbsp;&nbsp;</div>
                <div class="button" onclick="$('form').submit()">&nbsp;&nbsp;注册&nbsp;&nbsp;</div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
