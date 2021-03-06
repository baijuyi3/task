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
    p{ text-align: left}
</style>
<body>
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
                        ${sessionScope.user.u_name}:已登录
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="wrap">
    <div class="side">
        <span><a href="/resume">我的简历</a></span>
        <span><a href="/receive">我的信息</a></span>
        <span><a href="/deliver">我的投递</a></span>
    </div>
    <div class="content">
        <div class="mt">
            <ul class="mt_l">
                <li class="on">信息中心</li>
            </ul>
        </div>
        <%--*******************************面试消息*************************************--%>
        <div class="rbox">
            <div class="tit">
                <ul class="clearfix">
                    <li class="l1">消息</li>
                    <li class="l2">职位</li>
                </ul>
            </div>
            <c:if test="${requestScope.deliver_2==null&&requestScope.deliver_4==null&&requestScope.employee!=null}">
                <span>暂无消息</span>
            </c:if>
            <%--*******************************offer消息*************************************--%>
            <c:if test="${requestScope.deliver_4!=null}">
                <c:forEach items="${requestScope.deliver_4}" var="i" >
                    <div class="rli">
                        <li class="l1"><a href="/offer?id=${i.id}">offer!</a></li>
                        <li class="l2">${i.rc_name}</li>
                    </div>
                </c:forEach>
                </table>
                <hr>
            </c:if>
            <%----------------------------------------------%>
            <c:if test="${requestScope.deliver_2!=null}">
                    <c:forEach items="${requestScope.deliver_2}" var="i" >
                        <div class="rli">
                            <li class="l1"><a href="/interview?id=${i.id}">新的面试消息</a></li>
                            <li class="l2">${i.rc_name}</li>
                        </div>
                    </c:forEach>
                </table>
            </c:if>
            <%--*******************************消息详细*************************************--%>
            <c:if test="${requestScope.deliver2!=null}">
                    <div class="rli">
                        <p>Dear:${sessionScope.user.u_name}</p>
                        <p></p>
                        <p>你好，真诚邀请您参加我司的面试，请回复确认以下面试安排！</p>
                        <p></p>
                        <p>面试安排：</p>
                        <p>面试地点：${requestScope.deliver2.place}</p>
                        <p>面试岗位：${requestScope.deliver2.rc_name}</p>
                        <p>时间：${requestScope.deliver2.interv_date}</p>
                        <p>请及时回复，是否能准时参加面试！</p>
                        <button onclick="window.location.href='/deliverto3?id=${requestScope.deliver2.id}'" class="sub">同意</button>
                        <button onclick="window.location.href='/deliver_5?id=${requestScope.deliver2.id}'" class="sub">拒绝</button>
                    </div>
                </table>
            </c:if>
            <%--*******************************offer详细*************************************--%>
            <c:if test="${requestScope.employee!=null}">
                <div class="rli">
                    <p>Dear:${sessionScope.employee.name}</p>
                    <p></p>
                    <p>您已经被我司录用，以下是您的用户名和密码：</p>
                    <p></p>
                    <p>账户：${requestScope.employee.user}</p>
                    <p>密码：${requestScope.employee.pass}</p>
                    <p>请及时确认！</p>
                    <a href="/receive" class="sub">返回</a>
                </div>
                </table>
            </c:if>
    </div>
</div>
</div>
</body>
<script>
    <c:if test="${requestScope.msg!=null}">
    alert("${requestScope.msg}")
    </c:if>
</script>
</html>
