<%--
  Created by IntelliJ IDEA.
  User: youngz
  Date: 16-8-24
  Time: 下午9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Create Product</title>
</head>
<body>
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>

    <h3>Create Product</h3>

    <p style="color: red;">${errorString}</p>

    <form method="post" actioin="doCreateProduct">
        <table border="0">
            <tr>
                <td>Code</td>
                <td><input type="text" name="code" value="${product.code}"></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" value="${product.name}"></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="text" name="price" value="${product.price}"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Submit"/>
                    <a href="productList">Cancel</a>
                </td>
            </tr>
        </table>
    </form>

    <jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>
