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
<body onload="isHobbyInclude()">
<b>修改用户信息</b>
<form action="/user-management-system/updateUserInfoServlet" method="post">
    <input type="hidden" name="userId" value="${userInfo.userId}">
    用户名:<input name="userName" value="${userInfo.userName}"><br>
    <c:if test="${userInfo.gender=='1'}">
        性别:
        <input type="radio" name="gender" value="1" checked>男
        <input type="radio" name="gender" value="0">女<br>
    </c:if>
    <c:if test="${userInfo.gender=='0'}">
        性别:
        <input type="radio" name="gender" value="1">男
        <input type="radio" name="gender" value="0" checked>女<br>
    </c:if>
    年龄:<input name="age" value="${userInfo.age}"><br>
    学历:<input name="education" value="${userInfo.education}" id="education" onblur="isEduInclude()"><br>
    身高:<input name="height" value="${userInfo.height}"><br>
    爱好:
    <input value="${userInfo.hobby}" id="hobby" hidden>
    <input type="checkbox" name="hobby" value="摄影" id="photo"><label for="photo">摄影</label>
    <input type="checkbox" name="hobby" value="读书" id="read"><label for="read">读书</label>
    <input type="checkbox" name="hobby" value="旅行" id="travel"><label for="travel">旅行</label>
    <br>
    <input type="checkbox" name="hobby" value="美食" id="food"><label for="food">美食</label>
    <input type="checkbox" name="hobby" value="运动" id="sport"><label for="sport">运动</label>
    <input type="checkbox" name="hobby" value="音乐" id="music"><label for="music">音乐</label>
    <input type="checkbox" name="hobby" value="电影" id="movie"><label for="movie">电影</label>
    <br>
    地址:<input name="address" value="${userInfo.address}"><br>
    <input type="submit" value="提交">
</form>
<script>
    function isHobbyInclude() {
        let userHobbyArray = document.getElementById("hobby").value.split(",");
        let hobbyArray = document.getElementsByName("hobby");
        for (let i = 0; i < hobbyArray.length; i++) {
            if (userHobbyArray.includes(hobbyArray[i].value))
                hobbyArray[i].checked = true;
        }
    }

    function isEduInclude() {
        let eduArray = ["博士", "研究生", "本科", "专科", "高中", "初中", "小学", "文盲", ""];
        let edu = document.getElementById("education");
        if (!eduArray.includes(edu.value)) {
            alert("学历必须是[博士,研究生,本科,专科,高中,初中,小学,文盲]中的一种!")
            edu.value = "";
            edu.focus();
        }
    }
</script>
</body>
</html>
