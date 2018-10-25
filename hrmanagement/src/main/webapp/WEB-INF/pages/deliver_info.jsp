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
    #sub{
        text-align: center;
        background: orange;
        width: 80px;
        height: 40px;
        margin-top: 30px;
    }
    #ref{
        text-align: center;
        background: orange;
        width: 80px;
        height: 40px;
        margin-top: 30px;
    }
    .strong{
        height: 30px;
        line-height: 30px;
        font-size: 16px;
        font-weight: bold;
        color: #ff6000;
        vertical-align: baseline;
        padding: 14px 0;
        background: none;
    }
</style>
<script type="text/javascript" src="../../js/jquery-3.2.1.js"></script>
<script>

</script>

<body id="sojob">
<div class="p-wrap">
    <div class="header">
        <div class="bar">
            <div class="in">
                <p class="left">欢迎来到XX公司</p>
                <p class="right">
                    <a href="/view" >招聘信息</a>
                    <span class="l">|</span>
                    <a href="/resume">简历信息</a>
                </p>
                <div class="uer">
                    <p class="op">
                        <c:if test="${sessionScope.user==null}">
                            <a href="/login" >登录</a> /
                            <a href="/register">注册</a>
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
    <div class="wrap" style="text-align: center">
            <table>
                <tr>
                    <td colspan="4" style="float: none;text-align: center">
                        <input type="text" name="r_name" value="${requestScope.resume.r_name}" style="height: 40px;text-align: center;font-size: 20px">
                    </td>
                </tr>
                <tr>
                    <td colspan="4" class="strong" style="float: none;text-align: center">基本信息</td>
                </tr>
                <tr>
                    <td>姓名：</td>
                    <td><input type="text" name="name" value="${requestScope.resume.name}" disabled="disabled"></td>
                    <td>出生日期：</td>
                    <td><input type="text" name="birth" value="${requestScope.resume.birth}" disabled="disabled"></td>
                </tr>
                <tr>
                    <td>性别：</td>
                    <td><input type="radio" name="sex" value="男" checked>男
                        <input type="radio" name="sex" value="女">女</td>
                    <td>邮箱：</td>
                    <td><input type="text" name="mail" value="${requestScope.resume.mail}" disabled="disabled"></td>
                </tr>
                <tr>
                    <td>开始工作时间：</td>
                    <td><input type="text" name="startwork" value="${requestScope.resume.startwork}" disabled="disabled"></td>
                    <td>目前状态：</td>
                    <td><select id="l2" name="state">
                        <option value="目前不想换工作" selected>目前不想换工作</option>
                        <option value="有好机会会考虑">有好机会会考虑</option>
                        <option value="正在找工作">正在找工作</option>
                    </select></td>
                </tr>
                <tr>
                    <td>居住地：</td>
                    <td><input type="text" name="live" value="${requestScope.resume.live}" disabled="disabled"></td>
                    <td>电话：</td>
                    <td><input type="text" name="phone" value="${requestScope.resume.phone}" disabled="disabled"></td>
                </tr>
                <tr>
                    <td>目前薪资：</td>
                    <td><input type="text" name="salary" value="${requestScope.resume.salary}" disabled="disabled"></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td colspan="4" class="strong" style="float: none;text-align: center">求职意向</td>
                </tr>
                <tr>
                    <td>期望薪资：</td>
                    <td><input type="text" name="aim_salary" value="${requestScope.resume.aim_salary}" disabled="disabled">/月 </td>
                    <td>期望工作地点</td>
                    <td><input type="text" name="aim_workspace" value="${requestScope.resume.aim_workspace}" disabled="disabled"></td>
                </tr>
                <tr>
                    <td>期望工作职位：</td>
                    <td><input type="text" name="aim_work" value="${requestScope.resume.aim_work}" disabled="disabled"></td>
                    <td>期望的行业：</td>
                    <td><input type="text" name="aim_profession" value="${requestScope.resume.aim_profession}" disabled="disabled"></td>
                </tr>
                <tr>
                    <td>自我介绍：</td>
                    <td colspan="3"><textarea name="aim_introduce" cols="60" rows="10" disabled="disabled">${requestScope.resume.aim_introduce} </textarea></td>
                </tr>
                <tr>
                    <td>期望工作时间：</td>
                    <td><input type="text" name="aim_worktime" value="${requestScope.resume.aim_worktime}" disabled="disabled"></td>
                    <td>期望的工作性质：</td>
                    <td><select id="l3" name="aim_workstyle">
                        <option value="全职" selected>全职</option>
                        <option value="兼职">兼职</option>
                        <option value="实习">实习</option>
                        <option value="全/兼职">全/兼职</option>
                    </select></td>
                </tr>
            </table>

        <form action="deliver_2">
            <table>
                <tr>
                    <td>面试时间：</td>
                    <td><input type="text" name="interv_date"></td>
                    <td>面试地点：</td>
                    <td><input type="text" name="place"></td>
                </tr>
            </table>
            <input type="hidden" name="id" value="${d_id}">
            <input id="sub" type="submit" value="同意">&nbsp;&nbsp;&nbsp;&nbsp;
            <a id="ref" href="/deliver_0?id=${d_id}">拒绝</a>
        </form>
    </div>
</div>
</body>
<script>
    <c:if test="${requestScope.msg!=null}">
        alert("${requestScope.msg}")
    </c:if>
</script>
</html>
