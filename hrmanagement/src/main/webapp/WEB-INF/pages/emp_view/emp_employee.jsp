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
        width: 32%;
        text-overflow: ellipsis;
        white-space: nowrap;
    }
    .rbox .l1{
        float: left;
    }
    .rbox .l2{
        float: left;
    }
    .rbox .l3{
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
        alert(${requestScope.msg});
        </c:if>
    <%--************3级联动****************--%>
        <c:if test="${requestScope.departments!=null}">
        var arr=[];
        <c:if test="${requestScope.positions!=null}">
        <c:forEach items="${requestScope.departments}" var="k" >
        arr.push("${k.name}");
        arr["${k.name}"]=[]; //将元素定义为数组
        <c:forEach var="j" items="${requestScope.positions}">
        <c:if test="${j.dp_id==k.id}">
        arr["${k.name}"].push("${j.name}"); //shuzu[i][j]可以看作是一个二维数组
        arr["${k.name}"]["${j.name}"]=[];
        <c:forEach items="${requestScope.employees}" var="l">
        <c:if test="${l.p_id==j.id}">
        arr["${k.name}"]["${j.name}"].push("${l.user}");
        </c:if>
        </c:forEach>
        </c:if>
        </c:forEach>
        </c:forEach>
        </c:if>
        </c:if>

//        console.log(arr);
        <c:if test="${requestScope.positions!=null}">
        $.each(arr, function (n,e) {
            $(".s1").append("<option>" +e + "</option>");
        });
        $(".s1").change(function () {
            $(".s2").html("<option>---请选择---</option>");
            $.each(arr,function (n,e) {
                if($(".s1 option:selected").text() == e){
                    $.each(arr[e],function (n1,e1) {
                        $(".s2").append("<option>" + e1 + "</option>");
                    });
                    $(".s2").change(function () {
                        $(".s3").html("<option>---请选择---</option>");
                        $.each(arr[e],function (n1,e1) {
                            if($(".s2 option:selected").text() == e1){
                                $.each(arr[e][e1],function (n2,e2) {
                                    $(".s3").append("<option>" + e2 + "</option>");
                                });
                            }
                        })
                    })
                }
            })
        })
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
                <li class="on">员工</li>
            </ul>
        </div>
        <%--*******************************部门信息*************************************--%>
        <div class="rbox">
            <div class="tit">
                <ul class="clearfix">
                    <li class="l1">部门</li>
                    <li class="l2">职位</li>
                    <li class="l3">人员</li>
                </ul>
            </div>
            <%--<c:if test="${requestScope.departments==null}">--%>
                <%--<span>暂无部门</span>--%>
            <%--</c:if>--%>
            <%--****************部门列表****************--%>
            <c:if test="${not empty requestScope.departments}">
                <div class="rli">
                    <form action="" method="post">
                    <li class="l1"><select name="dep" class="s1"><option>---请选择---</option></select></li>
                    <li class="l2"><select name="pos" class="s2"><option>---请选择---</option></select></li>
                    <li class="l3"><select name="emp" class="s3"><option>---请选择---</option></select></li>
                    </form>
                </div>
                <script>
                    $(function () {
                        $("#b3").click(function () {
                            var href1="/employee_info_e?user="+$(".s3").val();
                            window.location.href=href1;
                        });
                    })
                </script>
                <div class="rli">
                    <button id="b3" class="sub">查看信息</button>
                </div>
            </c:if>
            <%--****************信息****************--%>
            <c:if test="${employee_info!=null}">
                <div class="rli">
                        <table>
                            <tr>
                                <td>名字(编号)：</td>
                                <td><input type="text" value="${requestScope.employee_info.user}" disabled></td>
                                <td>手机</td>
                                <td><input type="text" value="${requestScope.employee_info.phone}" disabled></td>
                            </tr>
                            <tr>
                                <td>邮件：</td>
                                <td><input type="text" value="${requestScope.employee_info.mail}" disabled></td>
                                <td>部门：</td>
                                <td><input type="text" value="${requestScope.department.name}" disabled></td>
                            </tr>
                            <tr>
                                <td>职位：</td>
                                <td><input type="text" value="${requestScope.position.name}" disabled></td>
                                <td>状态：</td>
                                <td><input type="text" value="${requestScope.employee_info.state}" disabled></td>
                            </tr>
                        </table>
                        <a class="sub" href="/employee_e">返回</a>
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
