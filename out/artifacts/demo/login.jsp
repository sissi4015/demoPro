<%--
  Created by IntelliJ IDEA.
  User: sissi
  Date: 2022/3/9
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
    <title>Sis自学系统登录页</title>
</head>
<body>
    <form action="<%=basePath%>login" method="post">
        <table align="center">
            <tr>
                <td height="200"></td>
            </tr>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="userName"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="userPassword"></td>
            </tr>
            <tr>
                <td><input type="submit" value="提交"></td>
                <td><font color="red">${msg}</font></td>
            </tr>
        </table>
    </form>
</body>
</html>
