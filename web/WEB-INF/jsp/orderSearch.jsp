<%--
  Created by IntelliJ IDEA.
  User: sunbo
  Date: 16/6/24
  Time: 下午10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查找订单</title>
    <style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body background="image/a.jpg">
<a href="gowelcome">返回主页</a>
<div id="global2">
    <h1>查找订单</h1>
    <form action="searchOrder">
        <p>
            <label for="uuid">订单编号: </label>
            <input id="uuid" name="uuid"/>
            <input id="submit" type="submit" tabindex="5"
                   value="查找">
        </p>
        <label>${errMessage}</label>
    </form>
    <br/>
    <h1>订单信息</h1>
    <p><label><b>订单编号: </b></label>${order.uuid}</p>
    <p><label><b>创建日期: </b></label>${order.cDate.toLocaleString()}</p>
    <p><label><b>修改日期: </b>${order.cDate.toLocaleString()} </label></p>
    <p><label><b>有效时间: </b>${order.valid_day} </label></p>
    <p><label><b>状态 </b>${order.status} </label></p>
    <p>(-2:已删除 -1:取消 1:已经生成 2:已支付 3:已申请发票 4:发票已开)</p>
    <p><label><b>单价: </b>${order.price.toString()} </label></p>
    <p><label><b>支付状态: </b>${order.pay_type.name} </label></p>
    <p>
        <%--<td><a href="orderedit/${order.id}">Edit</a></td>--%>
        <%--<td><a href="orderdelete/${order.id}">Delete</a> </td>--%>
    </p>
    <fieldset>
        <table>
            <tr>
                <th>状态</th>
                <th>价格</th>
                <%--<th>使用目标</th>
                <th>使用方式</th>
                <th>使用格式</th>
                <th>使用期限</th>--%>
                <th>供应商ID</th>
                <%--<th>media_id</th>--%>
                <th>级别</th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach items="${orderItems}" var="item">
                <tr>
                    <td>${item.status}</td>
                    <td>${item.price}</td>
                    <%--<td>${item.use_target}</td>
                    <td>${item.use_way}</td>
                    <td>${item.use_format}</td>
                    <td>${item.use_period}</td>--%>
                    <td>${item.vendor_id}</td>
                    <%--<td>${item.media_id}</td>--%>
                    <td>${item.level}</td>
                </tr>
            </c:forEach>
        </table>
    </fieldset>
</div>
</body>
</html>
