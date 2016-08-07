<%--
  Created by IntelliJ IDEA.
  User: wangdongsheng
  Date: 16/7/15
  Time: 下午7:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>下载统计</title>
    <script src='<c:url value="/js/jquery-3.1.0.min.js" />'></script>
    <script src='<c:url value="/js/echarts.min.js" />'></script>
    <script src='<c:url value="/js/mychart.js" />'></script>
    <style type="text/css">
        fieldset div{
            margin: 0 auto;
        }
    </style>
</head>
<body>
    <fieldset>
        <div id="totalDownload" style="width: 650px;height:500px;"></div>
        <div style="position: fixed; right: 2%; top: 2%; font-size: 16px;">
            <button id="toLine" style="cursor: pointer;">折线图</button>
            <button id="toBar" style="cursor: pointer;">柱状图</button>
        </div>
    </fieldset>
    <fieldset>
        <div id="totalMoney" style="width: 650px;height:500px;"></div>
    </fieldset>
    <%--<fieldset>--%>
        <%--<div id="sourceStatistic" style="width: 650px;height:500px;"></div>--%>
    <%--</fieldset>--%>

    <script type="text/javascript">

        var chartType = 'bar';

        $(function () {
            drawAllChart();
            $("#toLine").click(function () {
                chartType = 'line';
                drawAllChart();
            });
            $("#toBar").click(function () {
                chartType = 'bar';
                drawAllChart();
            });
        });

        function drawAllChart() {
            totalDownload();
            totalMoney();
            //sourceStatistic();
        }

        function totalDownload() {
            var totalDownload = ${requestScope.totalDownload};
            var title = '总下载量';
            var legend = ['下载视频数'];
            var xAxis = totalDownload[0];
            var data = totalDownload[1];

            $(document).ready(function () {
                drawColumnChart('totalDownload', title, legend, xAxis, data, chartType);
            });
        }

        function totalMoney() {
            var totalMoney = ${requestScope.totalMoney};
            var title = '总交易金额';
            var legend = ['交易金额'];
            var xAxis = totalMoney[0];
            var data = totalMoney[1];

            $(document).ready(function () {
                drawColumnChart('totalMoney', title, legend, xAxis, data, chartType);
            });
        }

        <%--function sourceStatistic() {--%>
            <%--var sourceStatistic = ${requestScope.sourceStatistic};--%>
            <%--var title = '不同来源下载统计';--%>
            <%--var legend = ['下载视频数'];--%>
            <%--var xAxis = sourceStatistic[0];--%>
            <%--var data = sourceStatistic[1];--%>

            <%--$(document).ready(function () {--%>
                <%--drawColumnChart('sourceStatistic', title, legend, xAxis, data, chartType);--%>
            <%--});--%>
        <%--}--%>

    </script>

</body>
</html>
