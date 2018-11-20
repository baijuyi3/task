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
    <title>简历中心</title>
</head>
<link rel="stylesheet" href="../../../css/style_view.css" type="text/css"/>
<style>
    .side{
        float: left;
        text-align: center;
        height: 1000px;
        background: palegoldenrod;
        width:25%;
    }
    .side span{
        display: inline-block;
        font-size: 18px;
        margin: 0;
        padding: 5px 0;
        width: 100%;
        background: palegoldenrod;
    }
    .side span:hover{
        background: orange;
        opacity:0.8;filter(alpha=80)
    }
    .content{
        float: right;
        height: 1000px;
        width: 70%;
        text-align: center;
    }

    .mt {
        height: 44px;
        line-height: 44px;
        color: #999;
        margin-bottom: 15px;
        border-bottom: 2px solid #efefef;
    }
    .mt .mt_l {
        float: left;
        font-size: 18px;
    }
    .mt .mt_r {
        float: right;
        font-size: 12px;
    }
    .mt .mt_l .on {
        color: #333;
        border-bottom: 2px solid #ff6000;
    }

    .mt .mt_l li {
        float: left;
        padding: 0 15px;
    }
    .mt .mt_r li {
        float: left;
        height: 45px;
        padding-left: 15px;
    }

    .rbox .tit {
        height: 30px;
        line-height: 30px;
        font-size: 12px;
        color: #999;
        background-color: #fafafa;
        border-top: 1px solid #eee;
        border-bottom: 1px solid #eee;
    }
    .rbox li {
        width: 30%;
        text-overflow: ellipsis;
        white-space: nowrap;
    }
    .rbox .l1{
        float: left;
    }
    .rbox .l2{
        float: right;
    }

    .rbox .rli {
        min-height: 24px;
        line-height: 24px;
        font-size: 14px;
        color: #999;
        padding: 8px 0;
        background-color: #fff;
        border-bottom: 1px solid #eee;
    }
</style>
<script type="text/javascript" src="../../../js/jquery-3.2.1.js"></script>
<script>
    $(function () {
       <c:if test="${requestScope.msg!=null}">
        alert(${requestScope.msg})
        </c:if>
    })
</script>
<body>
<div class="p-wrap">
    <div class="header">
        <div class="bar">
            <div class="in">
                <p class="left">欢迎来到XX公司</p>
                <p class="right">
                    <a href="/view" >招聘信息</a>
                    <span class="l">|</span>
                    <a href="/" >注销</a>
                </p>
                <div class="uer">
                    <p class="op">
                        ${sessionScope.user.u_name}:已登录
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="wrap">
    <div class="side">
        <span><a href="/deliver_1">面试申请</a></span>
        <span><a href="/deliver_3">员工分配</a></span>
        <span><a href="/recruit">招聘信息</a></span>
        <span><a href="/department">部门</a></span>
        <span><a href="/position">职位</a></span>
        <span><a href="/employee">员工信息</a></span>
        <span><a href="/train">培训</a></span>
        <span><a href="/reward">奖惩</a></span>
        <span><a href="/recheck">复议</a></span>
        <span><a href="/account">薪资结算</a></span>
    </div>
    <div class="content">
        <div class="mt">
            <ul class="mt_l">
                <li class="on">培训</li>
            </ul>
            <ul class="mt_r">
                <li>
                    <a class="a" href="/train_save">新建培训</a>
                </li>
            </ul>
        </div>
        <%--*******************************部门信息*************************************--%>
        <div class="rbox">
            <div class="tit">
                <ul class="clearfix">
                    <li class="l1">培训</li>
                    <li class="l2">操作</li>
                </ul>
            </div>
            <%--****************培训列表****************--%>
            <c:if test="${not empty requestScope.trains}">
                <c:forEach items="${requestScope.trains}" var="i" >
                    <div class="rli">
                        <li class="l1"><a href="/train_info?id=${i.id}">${i.name}</a></li>
                        <li class="l2">
                            <a href="/train_update?id=${i.id}">编辑</a>&nbsp;&nbsp;|&nbsp;&nbsp;
                            <a  href="/train_del?id=${i.id}">删除</a>&nbsp;&nbsp;|&nbsp;&nbsp;
                            <a  href="/train_send?id=${i.id}">发送</a>
                        </li>
                    </div>
                </c:forEach>
            </c:if>
            <%--****************培训更新****************--%>
            <c:if test="${requestScope.train_u!=null}">
                <div class="rli">
                    <form action="/update_train">
                        <table>
                            <tr>
                                <td>培训名称：</td>
                                <td><input type="text" name="name" value="${requestScope.train_u.name}"></td>
                                <td>培训开始时间</td>
                                <td><input type="text" name="start" value="${requestScope.train_u.start}"></td>
                            </tr>
                            <tr>
                                <td>培训结束时间：</td>
                                <td><input type="text" name="end" value="${requestScope.train_u.end}"></td>
                                <td>培训地点</td>
                                <td><input type="text" name="place" value="${requestScope.train_u.place}"></td>
                            </tr>
                            <tr>
                                <td>培训详细：</td>
                                <td><input type="text" name="describe" value="${requestScope.train_u.describe}"></td>
                                <td>培训对象</td>
                                <td><input type="text" name="object" value="${requestScope.train_u.object}"></td>
                            </tr>
                        </table>
                        <input class="sub" type="submit">
                        <a class="sub" href="/train">返回</a>
                    </form>
                </div>
            </c:if>
            <%--****************培训信息****************--%>
            <c:if test="${requestScope.train_info!=null}">
                <div class="rli">
                        <table>
                            <tr>
                                <td>培训名称：</td>
                                <td><input type="text" name="name" value="${requestScope.train_info.name}" disabled></td>
                                <td>培训开始时间</td>
                                <td><input type="text" name="start" value="${requestScope.train_info.start}" disabled></td>
                            </tr>
                            <tr>
                                <td>培训结束时间：</td>
                                <td><input type="text" name="end" value="${requestScope.train_info.end}" disabled></td>
                                <td>培训地点</td>
                                <td><input type="text" name="place" value="${requestScope.train_info.place}" disabled></td>
                            </tr>
                            <tr>
                                <td>培训详细：</td>
                                <td><input type="text" name="describe" value="${requestScope.train_info.describe}" disabled></td>
                                <td>培训对象</td>
                                <td><input type="text" name="object" value="${requestScope.train_info.object}" disabled></td>
                            </tr>
                        </table>
                        <a class="sub" href="/train">返回</a>
                </div>
            </c:if>
            <%--****************培训发送****************--%>
            <c:if test="${requestScope.train_id!=null}">
                <div class="rli">
                    <a href="train_dep?id=${requestScope.train_id}">按部门</a>
                    <a href="train_emp?id=${requestScope.train_id}">按人员</a>
                </div>
            </c:if>
            <%--****************部门发送****************--%>
            <c:if test="${not empty requestScope.send_departments}">
                <form action="send_d" method="post">
                    <select name="dep">
                    <c:forEach items="${requestScope.send_departments}" var="i">
                        <option>${i.name}</option>
                    </c:forEach>
                    </select>
                    <input type="hidden" name="t_id" value="${requestScope.t_id}">
                    <input type="submit">
                </form>
            </c:if>
            <%--****************员工发送****************--%>
            <c:if test="${not empty requestScope.send_emps}">
                <div class="rli">
                    <form action="send_e" method="post">
                        <c:forEach items="${requestScope.send_emps}" var="i">
                            <input type="checkbox" name="emp_ids" value="${i.id}">${i.user}<br>
                        </c:forEach>
                        <input type="hidden" name="t_id" value="${requestScope.t_id}">
                        <input type="submit">
                    </form>
                </div>
            </c:if>
            <%--****************新建培训****************--%>
            <c:if test="${requestScope.train_s!=null}">
                <div class="rli">
                    <form action="/save_train" method="post">
                        <table>
                            <tr>
                                <td>培训名称：</td>
                                <td><input type="text" name="name"></td>
                                <td>培训开始时间</td>
                                <td><input type="text" name="start"></td>
                            </tr>
                            <tr>
                                <td>培训结束时间：</td>
                                <td><input type="text" name="end"></td>
                                <td>培训地点</td>
                                <td><input type="text" name="place"></td>
                            </tr>
                            <tr>
                                <td>培训详细：</td>
                                <td><input type="text" name="describe"></td>
                                <td>培训对象</td>
                                <td><input type="text" name="object"></td>
                            </tr>
                        </table>
                        <input class="sub" type="submit">
                        <a class="sub" href="/train">返回</a>
                    </form>
                </div>
            </c:if>
        </div>
</div>
</div>
</body>
<script>
    <c:if test="${requestScope.msg!=null}">
    alert("${requestScope.msg}");
    </c:if>
</script>
</html>
