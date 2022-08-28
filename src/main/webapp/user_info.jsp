<%--
  Created by IntelliJ IDEA.
  User: shenjiafa
  Date: 2022/8/22
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户管理系统</title>
</head>
<body>
<span style="padding-left:856px;"/>
<input type="button" value="新增" id="add_user_info"><br>
<hr>
<table border="1" cellspacing="0" width="900">
    <tr>
        <th>序号</th>
        <th>用户id</th>
        <th>用户名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>身高</th>
        <th>地址</th>
        <th>插入时间</th>
        <th>更新时间</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${userInfos}" var="userInfo" varStatus="status">
        <tr align="center">
            <td>${status.count}</td>
            <td>${userInfo.userId}</td>
            <td>${userInfo.userName}</td>
            <td>${userInfo.gender}</td>
            <td>${userInfo.age}</td>
            <td>${userInfo.height}</td>
            <td>${userInfo.address}</td>
            <td>${userInfo.insertTime}</td>
            <td>${userInfo.updateTime}</td>
            <td><a href="/user-management-system/queryUserInfoByUserIdServlet?userId=${userInfo.userId}">修改</a> | <a href="#">删除</a></td>
        </tr>
    </c:forEach>
</table>
<script>
    document.getElementById("add_user_info").onclick = function () {
        location.href = "/user-management-system/add_user_info.jsp";
    }
</script>
</body>
</html>
