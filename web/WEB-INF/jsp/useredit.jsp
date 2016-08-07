<%--
  Created by IntelliJ IDEA.
  User: sunbo
  Date: 16/6/2
  Time: 下午10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户编辑页面</title>
    <style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>
<div id="global">
    <form:form commandName="user" action="/userupdate" method="post">
    <fieldset>
        <legend>Edit a user</legend>
        <form:hidden path="id"/>
        <p>
            <label for="username">用户名: </label>
            <form:input id="username" path="userName" readonly="true"/>
        </p>
        <p>
            <label for="password">密  码: </label>
            <form:input id="password" path="password"/>
        </p>
        <p>
            <label for="gender">性  别:</label>
            <form:select id="gender" path="gender"  items="${gender}"/>
        </p>
        <p>
            <label for="level">等级: </label>
            <form:select id="level" path="level" items="${level}" />
        </p>
        <p>
            <label for="status">状态: </label>
            <form:select id="status" path="status" items="${status}" />
        </p>

        <p>
            <label for="email">电子邮件: </label>
            <form:input id="email" path="email"/>
        </p>
        <p>
            <label for="tellphone">电  话: </label>
            <form:input id="tellphone" path="tellphone"/>
        </p>
        <p>
            <label for="company">公  司: </label>
            <form:input id="company" path="company"/>
        </p>
        <p>
            <label for="address">地  址: </label>
            <form:input id="address" path="address"/>
        </p>
        <p>
            <label for="logintimes">登陆次数: </label>
            <form:input id="logintimes" path="loginTimes"/>
        </p>
        <p id="buttons">
            <input id="reset" type="reset" tabindex="4">
            <input id="submit" type="submit" tabindex="5"
                   value="Update User">
        </p>
    </fieldset>
    </form:form>
</body>
</html>
