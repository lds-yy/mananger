<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>软件一班用户管理中心</title>
    <link rel="stylesheet" href="lib/css/brackgroundcss.css">
    <link rel="stylesheet" href="lib/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="lib/jquery-3.2.1.min.js"></script>
    <script src="lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body background="image/2.jpg">
<div class="container">
    <div class="row">
        <div class="page-header">
            <h1>潮汕职业技术学院网用户管理后台 <small>用户数据管理中心</small></h1>
            <h1> <a href="${pageContext.request.contextPath}/jump.jsp">主页</a></h1>
        </div>
    </div>
    <div class="row">
        <div class="jumbotron">
            <h1>管理后台:日志记录</h1>
        </div>
    </div>
    <div class="row">
        <table class="table table-hover table-striped">
            <tr>
                <th>${opera}</th>
                <th>类名</th>
                <th>类方法</th>
                <th>操作</th>
                <th>管理员</th>
                <th>操作时间</th>
                <th>状态</th>
            </tr>
            <c:forEach var="Operating" items="${Operating}">
                <tr>
                    <td></td>
                    <td>${Operating.moudle}</td>
                    <td>${Operating.operator}</td>
                    <td>${Operating.operator}</td>
                    <td>${Operating.opration}</td>
                    <td><fmt:formatDate value="${Operating.oprTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>${Operating.result}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="row">
        <table class="table table-hover table-striped">
            <tr>
                <th>${Lo}</th>
                <th>类名</th>
                <th>类方法</th>
                <th>操作</th>
                <th>管理员</th>
                <th>操作时间</th>
                <th>状态</th>
            </tr>
            <c:forEach var="login" items="${login}">
                <tr>
                    <td></td>
                    <td>${login.moudle}</td>
                    <td>${login.operator}</td>
                    <td>${login.operator}</td>
                    <td>${login.opration}</td>
                    <td><fmt:formatDate value="${login.oprTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>${login.result}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="row">
        <table class="table table-hover table-striped">
            <tr>
                <th>${th}</th>
                <th>类名</th>
                <th>类方法</th>
                <th>操作</th>
                <th>管理员</th>
                <th>操作时间</th>
                <th>状态</th>
            </tr>
            <c:forEach var="Throw" items="${Throw}">
                <tr>
                    <td></td>
                    <td>${Throw.moudle}</td>
                    <td>${Throw.operator}</td>
                    <td>${Throw.operator}</td>
                    <td>${Throw.opration}</td>
                    <td><fmt:formatDate value="${Throw.oprTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>${Throw.result}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
