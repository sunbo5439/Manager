<%--
  Created by IntelliJ IDEA.
  User: sunbo
  Date: 16/6/2
  Time: 下午8:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理</title>
    <style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>
<div id="manage">
    <fieldset>
        <form:form id="meizicheck" action="media" method="post">
            <input id="submit" type="submit" tabindex="3" value="视频资源审核">
        </form:form>
        <form:form id="usermanager" action="usermanager"  method="post">
            <input id="submit" type="submit" tabindex="0" value="用户管理模块">
        </form:form>
        <form:form id="ordermanage" action="ordermanager" method="post">
            <input id="submit" type="submit" tabindex="1" value="订单管理模块">
        </form:form>
    </fieldset>
</div>

<div id="statistics">
    <fieldset>
        <form:form id="program_statistics" action="program_statistics" method="post">
            <input id="submit" type="submit" tabindex="4" value="节目统计">
        </form:form>
        <form:form id="upload_statistics" action="upload_statistics" method="post">
            <input id="submit" type="submit" tabindex="4" value="上传统计">
        </form:form>
        <form:form id="download_statistics" action="download_statistics" method="post">
            <input id="submit" type="submit" tabindex="5" value="下载统计">
        </form:form>
        <form:form id="catalog_statistics" action="catalog_statistics" method="post">
            <input id="submit" type="submit" tabindex="6" value="编目统计">
        </form:form>
    </fieldset>
</div>
</body>
</html>
