<%--
  Created by IntelliJ IDEA.
  User: youngz
  Date: 16-8-25
  Time: 上午1:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Delete Product</title>
</head>
<body>
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>

    <h3>Delete Product</h3>

    <p style="color:red;">${errorString}</p>
    <a href="productList">Product List</a>

    <jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
