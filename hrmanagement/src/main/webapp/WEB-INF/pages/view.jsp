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
        <div class="job-content">
            <!-- 职位列表 begin -->
            <div class="sojob-result ">
                <ul class="sojob-list">
                    <c:if test="${sessionScope.recruits!=null}">
                        <c:forEach var="i" items="${sessionScope.recruits}">
                        <li>
                        <i class="icon icon-red-triangle" title="企业急招职位+高反馈率+高入职率"><b>急</b></i>
                        <div class="sojob-item-main clearfix">
                            <div class="job-info">
                                <h3 title="招聘理财事业部投资经理（金融市场部）">
                                    <a href="#" data-promid="ims" target="_blank"
                                       onclick="tlog=window.tlog||[];tlog.push('c:w_sojob_jobclick_9')">
                                        理财事业部投资经理（金融市场部） </a>
                                </h3>
                                <p class="condition clearfix"
                                   title="24-60万_上海-陆家嘴_本科及以上_3年以上">
                                    <span class="text-warning">24-60万</span>
                                    <a href="https://www.liepin.com/sh/zhaopin/"
                                       data-selector="data-url" class="area">上海-陆家嘴</a>
                                    <span class="edu">本科及以上</span>
                                    <span>3年以上</span>
                                </p>
                                <p class="time-info clearfix">
                                    <time title="2018年10月15日">2018-10-15</time>
                                    <span title="反馈时间以工作日为准，周末和假期时间不会计算在内">投递后：5个工作日内反馈</span>
                                </p>
                            </div>
                            <div class="company-info nohover">
                                <p class="company-name">
                                    <a title="公司富邦华一" 	target="_blank"
                                       href="https://www.liepin.com/company/8324033/">富邦华一</a>
                                </p>
                                <p class="field-financing">
                                    <span>
                                        <a class="industry-link" href="/company/000-130/" onclick="return false;" target="_blank">银行</a>
                                    </span>
                                </p>
                                <p class="temptation clearfix">
                                    <span>带薪年假</span><span>绩效奖金</span><span>午餐补助</span>
                                    <span>通讯津贴</span><span>优秀员工奖</span><span>发展空间大</span>
                                    <span>五险一金</span><span>岗位晋升</span><span>年度旅游</span>
                                    <span>定期体检</span>
                                </p>
                            </div>
                        </div></li>
                        </c:forEach>
                    </c:if>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>
