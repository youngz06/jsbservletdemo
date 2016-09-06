<%--
  Created by IntelliJ IDEA.
  User: youngz
  Date: 16-8-24
  Time: 下午4:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta charset="UTF-8"/>
    <title>User Info</title>
</head>
<body>
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>

    <h3>Hello: <b>${user.userName}</b></h3>
    User Name: <b>${user.userName}</b>
    <b>this is a test</b>
    <b><c:out value="this is a test"></c:out></b>
    <br/>
    Gender: ${user.gender}<br/>
    <jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>