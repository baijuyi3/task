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
<link rel="stylesheet" href="../../css/style_view.css" type="text/css"/>
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
<script type="text/javascript" src="../../js/jquery-3.2.1.js"></script>
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
                    <a href="/emp_login" >注销</a>
                </p>
                <div class="uer">
                    <p class="op">
                        ${sessionScope.employee.user}:已登录
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="wrap">
    <div class="side">
        <span><a href="/attend">打卡</a></span>
        <span><a href="/train_e">培训信息</a></span>
        <span><a href="/employee_e">其他员工</a></span>
        <span><a href="/reward_e">奖惩</a></span>
        <span><a href="/salary">薪资</a></span>
        <span><a href="/quit_e">离职</a></span>
    </div>
    <div class="content">
        <div class="mt">
            <ul class="mt_l">
                <li class="on">培训信息</li>
            </ul>
        </div>
        <%--*******************************简历*************************************--%>
        <div class="rbox">
            <div class="tit">
                <ul class="clearfix">
                    <li class="l1">标题</li>
                    <li class="l1">开始时间</li>
                    <li class="l1">结束时间</li>
                    <li class="l1">地点</li>
                    <li class="l1">操作</li>
                </ul>
            </div>
            <c:if test="${not empty requestScope.trainRecords}">
                    <c:forEach items="${requestScope.trainRecords}" var="i" >
                        <c:forEach items="${requestScope.trains}" var="j" >
                            <c:if test="${i.t_id==j.id}">
                        <div class="rli">
                            <li class="l1">${j.name}</li>
                            <li class="l1">${j.start}</li>
                            <li class="l1">${j.end}</li>
                            <li class="l1">${j.place}</li>
                            <li class="l1">
                                <c:if test="${i.state==1}">
                                    <a href="/train_e_update?id=${i.id}&state=2">同意</a>&nbsp;&nbsp;|&nbsp;&nbsp;
                                    <a  href="/train_e_update?id=${i.id}&state=0">拒绝</a>
                                </c:if>
                                <c:if test="${i.state==0}">
                                    已拒绝
                                </c:if>
                                <c:if test="${i.state==2}">
                                    已同意
                                </c:if>
                            </li>
                        </div>
                        <div class="rli">
                            <li class="l1">详细描述</li>
                            <li class="l1" style="width: 80%">${j.describe}</li>
                        </div>
                            </c:if>
                        </c:forEach>
                    </c:forEach>
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
