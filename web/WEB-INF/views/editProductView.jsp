<%--
  Created by IntelliJ IDEA.
  User: youngz
  Date: 16-8-24
  Time: 下午10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta charset="UTF-8"/>
    <title>Edit Product</title>
</head>
<body>

    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_footer.jsp"></jsp:include>

    <h3>Edit Product</h3>
    <p style="color:red;">${errorString}</p>

    <c:if test="${not empty product}">
        <form method="POST" action="doEditProduct">
            <input type="hidden" name="code" value="${product.code}"/>
            <table border="0">
                <tr>
                    <td>Code</td>
                    <td style="color:red;">${product.code}</td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name" value="${product.name}"/></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="text" name="price" value="${product.price}"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Submit" />
                        <a href="${pageContext.request.contextPath}/productList">Cancel</a>
                    </td>
                </tr>
            </table>
        </form>
    </c:if>
    <jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
