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
    <title>招聘</title>
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
<body>
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
                        ${sessionScope.user}:已登录
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="wrap">
    <div class="side">
        <span><a href="showGood?currentPage=1">我的简历</a></span>
        <span><a href="showAddress?currentPage=1">地址分页</a></span>
        <span><a href="pagingBuyCar?currentPage=1">购物车分页</a></span>
        <span><a href="noPay">未付款</a></span>
        <span><a href="noSend">未发货</a></span>
        <span><a href="noGet">未收货</a></span>
        <span><a href="noComment">未评价</a></span>
    </div>
    <div class="content">
        <div class="mt">
            <ul class="mt_l">
                <li class="on">简历中心</li>
            </ul>
            <ul class="mt_r">
                <li>
                    <a class="a" track-type="trackButtonClick" event-type="3">创建简历</a>
                </li>
            </ul>
        </div>
        <%--*******************************简历*************************************--%>
        <div class="rbox">
            <div class="tit">
                <ul class="clearfix">
                    <li class="l1">简历名称</li>
                    <li class="l2">操作</li>
                </ul>
            </div>
            <c:if test="${requestScope.resumes==null}">
                <span>暂无简历</span>
            </c:if>
            <c:if test="${requestScope.resumes!=null}">
                    <c:forEach items="${requestScope.resumes}" var="i" >
                        <input type="hidden" name="id" value="${i.id}">
                        <div class="rli">
                            <li class="l1">${i.name}</li>
                            <li class="l2"><a href="/update_resume?id=${i.id}">编辑</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="javascript:void(0);">删除</a></li>
                        </div>
                    </c:forEach>
                </table>
            </c:if>
    </div>
</div>
</div>
</body>
</html>
