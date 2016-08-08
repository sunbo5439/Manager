<%--
  Created by IntelliJ IDEA.
  User: sunbo
  Date: 16/7/7
  Time: 下午4:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>审核通过</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script src="../resources/js/jquery-1.6.js" type="text/javascript"></script>
    <script type="text/javaScript">
        $(document).ready(function () {
            var pagede = ${pageModel.currPage};
            var pages = ${pageModel.pageCount};
            if (pagede == 0) {
                $("#firstPage").attr("disabled", "disabled");
                $("#firstPage").css("cursor", "text");
            } else if (pagede == (pages - 1)) {
                $("#lastPage").attr("disabled", "disabled");
                $("#lastPage").css("cursor", "text");
            }


        })
        function changePage(page) {
            page += 1;
            var param = "?page=" + page;
            param += "&rows=20";
            location.href = "listMedia1" + param;
        }
    </script>
    <style type="text/css">
        body {
            font-size: 15px;
        }
    </style>
</head>
<br/>
<body background="image/a.jpg">
<a href="/media">返回</a>
<table width="98%" border="0" cellpadding="2" cellspacing="1"
       bgcolor="#D1DDAA" align="center"
       style="position: relative; margin-top: 0px;">
    <tr align="center" bgcolor="#EEF4EA">
        <th>文件名</th>
        <th>当前状态</th>
        <th>历史审核信息</th>
        <th>&nbsp;</th>
    </tr>

    <c:if test="${(pageModel.datas != null) && (!empty pageModel.datas)}">
        <c:forEach items="${pageModel.datas}" var="item">
            <tr align="center">
                <td>${item.title}</td>
                <td>${item.status.name}</td>
                <td><a href="checkHistory/${item.id}">审核历史</a></td>
                <td><a href="mediaCheck/${item.id}">审核</a></td>
            </tr>
        </c:forEach>
    </c:if>
</table>
<div>
    <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="position: relative; margin-top: 0px;">
        <tr align="center" bgcolor="#EEF4EA">
            <td height="36">
                <span style="margin-top: 10px; margin-right: 50px">
						共有${pageModel.totals }条数据， 每页显示${pageModel.pageSize }条数据，
						当前是第${pageModel.currPage + 1}/${pageModel.pageCount }页
                </span>
                <button type="button" onclick="javaScript:changePage(0)">首页</button>
                <c:choose>
                    <c:when test="${pagaModel.currPage!=0}">
                        <button type="button"  onclick="javaScript:changePage(${pageModel.currPage-1})">上一页</button>
                    </c:when>
                    <c:otherwise>
                        <button type="button" disabled="disabled" onclick="javaScript:changePage(${pageModel.currPage-1})">上一页</button>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${pagaModel.currPage != pageModel.pageCount-1}">
                        <button type="button"  onclick="javaScript:changePage(${pageModel.currPage+1})">下一页</button>
                    </c:when>
                    <c:otherwise>
                        <button type="button" disabled="disabled" onclick="javaScript:changePage(${pageModel.currPage+1})">下一页</button>
                    </c:otherwise>
                </c:choose>
                <button type="button" onclick="javaScript:changePage(${pageModel.pageCount-1})">最后一页</button>
                <span class="STYLE1"> 转到第 <input style="cursor: Pointer"
                                                 id="inputPage" name="textfield" type="text" size="4"
                                                 style="height:12px; width:20px; border:1px solid #999999;"/> 页
				</span>
                <span> <button type="button" onclick='javaScript:changePage(document.getElementById("inputPage").value-1)'>go</button>
				</span>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
