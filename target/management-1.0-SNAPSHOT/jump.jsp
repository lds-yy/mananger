<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/13
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    response.sendRedirect("/index?pageIndex=1&sex&name");
%>
</body>
</html>
