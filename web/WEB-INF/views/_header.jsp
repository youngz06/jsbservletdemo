<%--
  Created by IntelliJ IDEA.
  User: youngz
  Date: 16-8-24
  Time: 下午2:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="background: #E0E0E0;height: 55px;padding: 5px;">
    <div style="float:left">
        <h1>My Site</h1>
    </div>

    <div style="float: right;padding:10px;text-align:right;">
        <!--User store in session with atrribute: logingedUser-->
        Hello <b>${loginedUser.userName}</b>
        <br/>
        Search <input name="search"/>
    </div>
</div>