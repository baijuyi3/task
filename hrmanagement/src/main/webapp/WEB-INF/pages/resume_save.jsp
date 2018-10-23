<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/20
  Time: 10:03
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
    <title>简历</title>
</head>
<link rel="stylesheet" href="../../css/style_view.css" type="text/css"/>
<style>
    .box{
        width: 100px;
        height: 150px;
    }
    table{
        margin: 0 auto;
    }
    table td:nth-child(odd){
        float: right;
    }
</style>
<body id="sojob">
<div class="p-wrap">
    <div class="header">
        <div class="bar">
            <div class="in">
                <p class="left">欢迎来到XX公司</p>
                <p class="right">
                    <a href="/" >招聘信息</a>
                    <span class="l">|</span>
                    <a href="/view">简历信息</a>
                </p>
                <div class="uer">
                    <p class="op">
                        <c:if test="${sessionScope.user==null}">
                            <a href="window.location.href='login.jsp'" >登录</a> /
                            <a href="window.location.href='register.jsp'">注册</a>
                        </c:if>
                        <c:if test="${sessionScope.user!=null}">
                            ${sessionScope.user.u_name}:已登录
                        </c:if>
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="wrap">
        <form action="save_resume">
            <table>
                <tr>
                    <td>姓名：</td>
                    <td><input type="text" name="name"></td>
                    <td>出生日期：</td>
                    <td><input type="text" name="birth"></td>
                </tr>
                <tr>
                    <td>性别：</td>
                    <td><input type="radio" name="sex" value="男">男
                        <input type="radio" name="sex" value="女">女</td>
                    <td>邮箱：</td>
                    <td><input type="text" name="mail"></td>
                </tr>
                <tr>
                    <td>开始工作时间：</td>
                    <td><input type="text" name="startwork"></td>
                    <td>目前状态：</td>
                    <td><select name="state" id="">
                        <option value="目前不想换工作">目前不想换工作</option>
                        <option value="有好机会会考虑">有好机会会考虑</option>
                        <option value="正在找工作">正在找工作</option>
                    </select></td>
                </tr>
                <tr>
                    <td>居住地：</td>
                    <td><input type="text" name="live"></td>
                    <td>电话：</td>
                    <td><input type="text" name="phone"></td>
                </tr>
                <tr>
                    <td colspan="4">求职意向：</td>
                </tr>
                <tr>
                    <td>期望薪资：</td>
                    <td><input type="text" name="aim_salary">/月 </td>
                    <td>期望工作地点</td>
                    <td><input type="text" name="aim_workspace"></td>
                </tr>
                <tr>
                    <td>期望工作职位：</td>
                    <td><input type="text" name="aim_work"></td>
                    <td>期望的行业：</td>
                    <td><input type="text" name="profession"></td>
                </tr>
                <tr>
                    <td>自我介绍：</td>
                    <td colspan="3"><textarea name="aim_introduce" cols="60" rows="10"></textarea></td>
                </tr>
                <tr>
                    <td>期望工作时间：</td>
                    <td><input type="text" name="aim_work"></td>
                    <td>期望的工作性质：</td>
                    <td><select name="aim_workstyle">
                        <option value="全职">全职</option>
                        <option value="兼职">兼职</option>
                        <option value="实习">实习</option>
                        <option value="全/兼职">全/兼职</option>
                    </select></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
