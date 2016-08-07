<%--
  Created by IntelliJ IDEA.
  User: sunbo
  Date: 16/7/14
  Time: 下午4:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>媒资历史审核信息</title>
    <style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>

<div id="global">
    <fieldset>
        <p>
        <h1>当前媒资信息</h1>
        <label>媒资编号:</label>${curMedia.id}
        <%--<form:input path="${curMedia.id}" readonly="true"/>--%>
        <label>名称:</label>${curMedia.title}
        <%--<form:input path="${curMedia.name}" readonly="true"/>--%>
        <label>当前状态:</label>${curMedia.status.name}
        <%--<form:input path="${curMedia.status}" readonly="true"/>--%>
        </p>
    </fieldset>
    <table>
        <tr>
            <th>审查日期</th>
            <th>审查结果</th>
            <th>审查人ID</th>
            <th>备注信息</th>
            <%--<td>其他信息</td>--%>
        </tr>
        <c:forEach items="${historyInfo}" var="info">
            <tr>
                <td>${info.checkDate}</td>
                <td>${info.checkResult.name}</td>
                <td>${info.managerId}</td>
                <td>${info.remark}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
