<%--
  Created by IntelliJ IDEA.
  User: sunbo
  Date: 16/6/18
  Time: 上午10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户</title>
    <style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body background="image/a.jpg">
<div id="global">
    <a href="gowelcome">返回主页</a>
    <fieldset>
        <h1>查找用户</h1>
        <form action="searchUser">
            <p>
                <label for="username">用户名/电话/邮箱: </label>
                <input id="username" name="nameTelEmail"/>
                <input id="submit" type="submit" tabindex="5"
                       value="查找">
            </p>
            <label>${errMessage}</label>
        </form>
        <h1>用户信息</h1>
        <p><label><b>用 户 名: </b></label>${user.userName}</p>
        <p><label><b>状 态: </b>${user.status.name} </label></p>
        <p><label><b>创建时间: </b>${user.cDate.toLocaleString()} </label></p>
        <p><label><b>修改时间: </b>${user.mDate.toLocaleString()} </label></p>
        <p><label><b>电子邮箱: </b>${user.email} </label></p>
        <p><label><b>手 机: </b>${user.mobile} </label></p>
        <p><label>公司: ${user.company}</label></p>
        <p><label>角 色: ${user.role.display_name}</label></p>
        <p><label>省份: ${user.province_code.PROVINCE_NAME}</label></p>
        <p><label>城市: ${user.city_code.CITY_NAME}</label></p>
        <p><label>地区: ${user.area_code.AREA_NAME}</label></p>
        <p><label>地址: ${user.address}</label></p>
        <p><label>QQ: ${user.qq}</label></p>
        <p><label>真实姓名: ${user.realname}</label></p>
        <p><label>供应商编号: ${user.vendor_id}</label></p>
        <p><label>身份证号: ${user.id_card_no}</label></p>
        <p><label>用户名更改次数: ${user.username_change_times}</label></p>
        <p><label>邮件是否激活: ${user.email_activated}</label></p>
        <p><label>电话是否激活: ${user.mobile_activated}</label></p>
    </fieldset>
</div>
</body>
</html>
