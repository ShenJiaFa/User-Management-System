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
    <label for="userId">用户id:</label>
    <input name="userId" id="userId">
    <br>
    <label for="userName">用户名:</label>
    <input name="userName" id="userName">
    <br>
    性别:
    <input type="radio" name="gender" value="男" id="male"><label for="male">男</label>
    <input type="radio" name="gender" value="女" id="female"><label for="female">女</label>
    <br>
    <label for="age">年龄:</label>
    <input name="age" id="age">
    <br>
    <label for="height">身高:</label>
    <input name="height" id="height">
    <br>
    爱好:
    <input type="checkbox" name="hobby" value="摄影">摄影
    <input type="checkbox" name="hobby" value="读书">读书
    <input type="checkbox" name="hobby" value="旅行">旅行
    <br>
    <input type="checkbox" name="hobby" value="运动">美食
    <input type="checkbox" name="hobby" value="运动">运动
    <input type="checkbox" name="hobby" value="音乐">音乐
    <input type="checkbox" name="hobby" value="电影">电影
    <br>
    <label for="address">地址:</label>
    <input name="address" id="address">
    <br>
    <input type="submit" value="提交">
</form>
</body>
</html>
