<%--
  Created by IntelliJ IDEA.
  User: sunbo
  Date: 16/6/25
  Time: 上午10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单编辑页面</title>
    <style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>
<div id="global">
    <form:form commandName="order" action="/orderupdate" method="post">
    <fieldset>
        <legend>Edit a order</legend>
        <p>
            <label>订单ID:</label>
            <form:input path="id" readonly="true"/>
        </p>

        <p>
            <label for="uuid">订单编号: </label>
            <form:input id="uuid" path="uuid" readonly="true"/>
        </p>

        <p>
            <label for="gender">状态:</label>
            <form:select id="gender" path="status"  items="${status}"/>
        </p>

        <p>
            <label for="status">支付状态: </label>
            <form:select id="status" path="pay_type" items="${paytype}" />
        </p>

        <p>
            <label for="invoice_inf">发票信息: </label>
            <form:input id="invoice_inf" path="invoice_inf"/>
        </p>
        <p>
            <label for="price">单价: </label>
            <form:input id="price" path="price"/>
        </p>
        <p id="buttons">
            <input id="reset" type="reset" tabindex="4">
            <input id="submit" type="submit" tabindex="5"
                   value="更新">
        </p>
    </fieldset>
    </form:form>
</body>
</html>
