<%--
  Created by IntelliJ IDEA.
  User: youngz
  Date: 16-8-24
  Time: 下午3:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Home Page</title>
</head>
<body>
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
    <h3>Home Page</h3>
    This is demo Simple web application using jsp,servlet &amp; JDBC.<br/><br/>
    <b>It includes the following functions:</b>
    <ul>
        <li>Login</li>
        <li>Stroing user information in cookies</li>
        <li>Product List</li>
        <li>Create Product</li>
        <li>Edit Product</li>
        <li>Delete Product</li>
    </ul>

<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
