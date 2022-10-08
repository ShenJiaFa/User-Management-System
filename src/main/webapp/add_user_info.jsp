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
    <input type="radio" name="gender" value="1" id="male"><label for="male">男</label>
    <input type="radio" name="gender" value="0" id="female"><label for="female">女</label>
    <br>
    <label for="age">年龄:</label>
    <input name="age" id="age">
    <br>
    学历:
    <select name="education">
        <option value="博士"/>
        博士
        <option value="研究生"/>
        研究生
        <option value="本科"/>
        本科
        <option value="专科"/>
        专科
        <option value="高中"/>
        高中
        <option value="初中"/>
        初中
        <option value="小学"/>
        小学
    </select>
    <br>
    <label for="height">身高:</label>
    <input name="height" id="height">
    <br>
    爱好:
    <input type="checkbox" name="hobby" value="摄影" id="photo"><label for="photo">摄影</label>
    <input type="checkbox" name="hobby" value="读书" id="read"><label for="read">读书</label>
    <input type="checkbox" name="hobby" value="旅行" id="travel"><label for="travel">旅行</label>
    <br>
    <input type="checkbox" name="hobby" value="美食" id="food"><label for="food">美食</label>
    <input type="checkbox" name="hobby" value="运动" id="sport"><label for="sport">运动</label>
    <input type="checkbox" name="hobby" value="音乐" id="music"><label for="music">音乐</label>
    <input type="checkbox" name="hobby" value="电影" id="movie"><label for="movie">电影</label>
    <br>
    <label for="address">地址:</label>
    <input name="address" id="address">
    <br>
    <input type="submit" value="提交">
</form>
</body>
</html>
