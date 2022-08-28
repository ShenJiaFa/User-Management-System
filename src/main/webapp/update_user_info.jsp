<%--
  Created by IntelliJ IDEA.
  User: shenjiafa
  Date: 2022/8/23
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改用户信息</title>
</head>
<body>
<b>修改用户信息</b>
<form action="/user-management-system/updateUserInfoServlet" method="post">
    <input type="hidden" name="userId" value="${userInfo.userId}">
    用户名:<input name="userName" value="${userInfo.userName}"><br>
    <c:if test="${userInfo.gender=='男'}">
        性别:<input type="radio" name="gender" value="男" checked>男
        <input type="radio" name="gender" value="女">女<br>
    </c:if>
    <c:if test="${userInfo.gender=='女'}">
        性别:<input type="radio" name="gender" value="男">男
        <input type="radio" name="gender" value="女" checked>女<br>
    </c:if>
    年龄:<input name="age" value="${userInfo.age}"><br>
    身高:<input name="height" value="${userInfo.height}"><br>
    地址:<input name="address" value="${userInfo.address}"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
