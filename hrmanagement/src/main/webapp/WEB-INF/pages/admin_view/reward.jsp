<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
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
    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
    Date date=new Date();
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
        width: 20%;
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
                <li class="on">奖惩</li>
            </ul>
            <ul class="mt_r">
                <li>
                    <a class="a" href="/reward_save">新建奖惩</a>
                </li>
            </ul>
        </div>
        <%--*******************************部门信息*************************************--%>
        <div class="rbox">
            <div class="tit">
                <ul class="clearfix">
                    <li class="l1">原因</li>
                    <li class="l1">金额</li>
                    <li class="l1">员工</li>
                    <li class="l1">日期</li>
                    <li class="l1">操作</li>
                </ul>
            </div>
            <%--****************奖惩列表****************--%>
            <c:if test="${not empty requestScope.rewards}">
                <c:forEach items="${requestScope.rewards}" var="i" >
                    <div class="rli">
                        <li class="l1">${i.reason}</li>
                        <li class="l1">${i.money}</li>
                        <li class="l1">${i.e_id}</li>
                        <li class="l1">${i.date}</li>
                        <li class="l1">
                            <a href="/reward_update?id=${i.id}">编辑</a>
                        </li>
                    </div>
                </c:forEach>
            </c:if>
            <%--****************部门更新****************--%>
            <c:if test="${requestScope.reward_u!=null}">
                <div class="rli">
                    <form action="/update_reward">
                        <table>
                            <tr>
                                <td>原因：</td>
                                <td><input type="text" name="reason" value="${requestScope.reward_u.reason}"></td>
                                <td>金额：</td>
                                <td><input type="text" name="money" value="${requestScope.reward_u.money}"></td>
                            </tr>
                            <tr>
                                <td>员工id：</td>
                                <td><input type="text" name="e_id" value="${requestScope.reward_u.e_id}"></td>
                                <td>日期：</td>
                                <td><input type="text" name="date" value="${requestScope.reward_u.date}"></td>
                            </tr>
                        </table>
                        <input type="hidden" name="id" value="${requestScope.r_id}">
                        <input class="sub" type="submit">
                        <a class="sub" href="/reward">返回</a>
                    </form>
                </div>
            </c:if>
            <%--****************新建部门****************--%>
            <c:if test="${requestScope.reward_s!=null}">
                <div class="rli">
                    <form action="/save_reward" method="post">
                        <table>
                            <tr>
                                <td>原因：</td>
                                <td><input type="text" name="reason"></td>
                                <td>金额：</td>
                                <td><input type="text" name="money"></td>
                            </tr>
                            <tr>
                                <td>员工id：</td>
                                <td><input type="text" name="e_id"></td>
                                <td>日期：</td>
                                <td><input type="text" name="date" value="<%=df.format(date)%>"></td>
                            </tr>
                        </table>
                        <input class="sub" type="submit">
                        <a class="sub" href="/reward">返回</a>
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
