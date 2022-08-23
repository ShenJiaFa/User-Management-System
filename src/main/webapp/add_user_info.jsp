<%--
  Created by IntelliJ IDEA.
  User: shenjiafa
  Date: 2022/8/23
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加用户信息</title>
</head>
<body>
<h5>添加用户信息</h5>
<form action="/user-management-system/addUserInfoServlet" method="post">
    用户id:<input name="userId"><br>
    用户名:<input name="userName"><br>
    性别:<input type="radio" name="gender" value="男">男
    <input type="radio" name="gender" value="女">女<br>
    年龄:<input name="age"><br>
    身高:<input name="height"><br>
    地址:<input name="address"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
