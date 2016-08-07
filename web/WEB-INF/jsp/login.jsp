<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<div id="global">
    <form:form commandName="manager" action="verify" method="post">
        <fieldset>
            <legend>登陆</legend>
            <p>
                <label for="role">类别: </label>
                <form:select id="role" path="role.id"
                             items="${roles}" itemLabel="display_name"
                             itemValue="id" tabindex="0">请选择角色</form:select>
            </p>
            <p>
                <label for="managerName">登陆名: </label>
                <form:input id="managerName" path="name" tabindex="1" />
                <label>${errMessage}</label>
            </p>
            <p>
                <label for="password">密码: </label>
                <form:password id="password" path="password" tabindex="2"  />
            </p>

            <p id="buttons">
                <input id="submit" type="submit" tabindex="3" value="登陆">
                <input id="reset" type="reset" tabindex="4">
            </p>
        </fieldset>
    </form:form>
</div>
</body>
</html>
