<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/10
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>用户管理中心</title>
    <link rel="stylesheet" href="lib/css/brackgroundcss.css">
    <link rel="stylesheet" href="lib/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="lib/jquery-3.2.1.min.js"></script>
    <script src="lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body background="image/2.jpg">
<div class="container">
    <div class="row">
        <div class="page-header">
            <h1>潮汕职业技术学院用户管理后台 <small>用户数据管理中心</small></h1>
        </div>
    </div>
    <c:set var="staff" value="${staff}"></c:set>
    <div class="row">
        <div class="jumbotron">
            <h1>潮汕职业技术学院网用户管理后台</h1>
            <p><a class="btn btn-primary btn-lg" href="#" role="button">欢迎您,管理人员:${staff.username}</a>
            <a class="btn btn-primary btn-lg" href="${pageConText.request.contextPath}/exit" role="button">退出</a></p>
            <p><a class="btn btn-primary btn-lg" href="${pageConText.request.contextPath}/addusers.jsp" role="button">新增用户</a>
                <a class="btn btn-primary btn-lg" href="${pageConText.request.contextPath}/log" role="button">日志记录</a>
            </p>
        </div>
    </div>
    <div class="row">
        <div class="row">
            类型:
            <nav>
                <ul class="pagination">
                    <li><a href="${pageContext.request.contextPath}/index?pageIndex=${pager.pageIndex}&sex=男&name">男</a></li>
                    <li><a href="${pageContext.request.contextPath}/index?pageIndex=${pager.pageIndex}&sex=女&name">女</a></li>
                </ul>
            </nav>
            <form class="form-horizontal" action="${pageContext.request.contextPath}/index">
                <div class="form-group">
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="name" name="name" placeholder="搜索..." width="10">
                        <input type="hidden" name="sex" value="">
                        <input type="hidden" name="pageIndex" value="${pager.pageIndex}">
                        <input type="submit" value="搜索" class="btn btn-primary">
                    </div>
                </div>
            </form>
        </div>
        <table class="table table-hover table-striped">
            <tr>
                <th>用户编号</th>
                <th>登录帐号</th>
                <th>用户昵称</th>
                <th>联系方式</th>
                <th>账户创建时间</th>
                <th>用户状态</th>
                <th>操作</th>
            </tr>
<c:forEach var="user" items="${usersList}">
            <tr>
                <td>${user.uid}</td>
                <td>${user.name}</td>
                <td>${user.nickname}</td>
                <td>${user.phone}</td>
                <td><fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <c:if test="${user.userStatus == 1}">
                    <td>锁定</td>
                </c:if>
                <c:if test="${user.userStatus == 2}">
                    <td>删除</td>
                </c:if>
                <c:if test="${user.userStatus == 0}">
                    <td>正常</td>
                </c:if>
                <td>
                    <a href="${pageContext.request.contextPath}/detail?uid=${user.uid}">查看</a>
                    <c:if test="${user.userStatus == 1}">
                    <a href="${pageContext.request.contextPath}/deluser?uid=${user.uid}&type=lock">解锁</a>
                    </c:if>
                    <c:if test="${user.userStatus == 0}">
                        <a href="${pageContext.request.contextPath}/deluser?uid=${user.uid}&type=unlock">锁定</a>
                    </c:if>
                    <a href="${pageContext.request.contextPath}/deluser?uid=${user.uid}&type=del">删除</a>
                </td>
            </tr>
</c:forEach>
        </table>
    </div>
    <div class="row">
        <c:set var="pager" value="${pager}"></c:set>
        <nav>
            <ul class="pagination">
                <li><a href="${pageContext.request.contextPath}/index?pageIndex=1&sex&name">首页</a></li>
                <li><a href="${pageContext.request.contextPath}/index?pageIndex=${pager.pageIndex-1}&sex&name">上一页</a></li>
                <li><a href="${pageContext.request.contextPath}/index?pageIndex=${pager.pageIndex+1}&sex&name">下一页</a></li>
                <li><a href="${pageContext.request.contextPath}/index?pageIndex=${pager.totalPages}&sex&name">尾页</a></li>
                <li>
                    <a >总数据量${pager.totalCount},当前<span style="color:red">${pager.pageIndex}</span>总页数${pager.totalPages}</a>
                </li>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>
