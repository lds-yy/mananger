<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/17
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>用户管理中心</title>
    <link rel="stylesheet" href="lib/css/brackgroundcss.css">
    <link rel="stylesheet" href="lib/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="lib/3.2.1/jquery-3.2.1.min.js"></script>
    <script src="lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body background="image/2.jpg">
<div class="container">
    <div class="row">
        <div class="page-header">
            <h1>潮汕职业技术学院网用户管理后台  <small>用户数据管理中心</small></h1>
            <h1> <a href="${pageContext.request.contextPath}/jump.jsp">主页</a></h1>
        </div>
    </div>
    <div class="row">
        <div class="jumbotron">
            <h1>管理后台:用户详情资料</h1>
            <p><a class="btn btn-primary btn-lg" href="#" role="button">欢迎。</a></p>
        </div>
    </div>
    <c:set var="user" value="${user}"></c:set>
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <form class="form-horizontal" action="${pageContext.request.contextPath}/updateusers">
                <input type="hidden" name="id" value="${user.uid}">
                <div class="form-group">
                    <label class="col-sm-2 control-label">用户账号</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${user.name}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">登录密码</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">**********</p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="nickname" class="col-sm-2 control-label">昵称</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="nickname" value="${user.nickname}" name="nickname"  placeholder="请输入昵称">
                    </div>
                </div>
                <div class="form-group">
                    <label for="age" class="col-sm-2 control-label">年龄</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="age" name="age" value="${user.age}" placeholder="请输入年龄">
                    </div>
                </div>
                <div class="form-group">
                    <label for="gender" class="col-sm-2 control-label">性别</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="gender" value="${user.gender}" name="gender" placeholder="请输入性别">
                    </div>
                </div>
                <div class="form-group">
                    <label for="phone" class="col-sm-2 control-label">联系方式</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="phone" value="${user.phone}" name="phone" placeholder="请输入联系方式">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">账号创建时间</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${user.createTime}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">最后修改时间</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${user.updateTime}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">最后登录时间</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${user.lastLogin}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">用户状态</label>
                    <div class="col-sm-10">
                        <c:if test="${user.userStatus == 0}">
                        <p class="form-control-static">正常</p>
                        </c:if>
                        <c:if test="${user.userStatus == 1}">
                        <p class="form-control-static">锁定</p>
                        </c:if>
                        <c:if test="${user.userStatus == 2}">
                        <p class="form-control-static">删除</p>
                        </c:if>
                    </div>
                </div>
                <div class="form-group">
                    <label for="remark" class="col-sm-2 control-label">备注</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="remark" value="${user.remark}" name="remark" placeholder="请输入备注">
                    </div>
                </div>
                <div class="form-group">
                    <input type="submit" value="提交数据更新" class="btn btn-primary">
                </div>
            </form>
        </div>
    </div>
    <div class="row">
        <table class="table table-striped">
            <tr>
                <th>地址编号</th>
                <th>国家</th>
                <th>省</th>
                <th>市</th>
                <th>县</th>
                <th>街道</th>
                <th>详细地址</th>
                <th>是否默认</th>
            </tr>
            <c:set var="addr" value="${address}"> </c:set>
                <tr>
                    <td>${addr.uid}</td>
                    <td>${addr.nation}</td>
                    <td>${addr.province}</td>
                    <td>${addr.city}</td>
                    <td>${addr.country}</td>
                    <td>${addr.street}</td>
                    <td>${addr.remark}</td>
                    <c:if test="${addr.defaultAddr == true}">
                        <td>默认地址</td>
                    </c:if>
                    <c:if test="${addr.defaultAddr == false}">
                        <td>---------</td>
                    </c:if>
                </tr>
        </table>
    </div>
</div>
</body>
</html>
