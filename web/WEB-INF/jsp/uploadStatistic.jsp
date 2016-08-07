<%--
  Created by IntelliJ IDEA.
  User: hadoop
  Date: 2016/7/12
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传统计</title>
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
        <div id="totalStatistic" style="width: 650px;height:500px;"></div>
        <div style="position: fixed; right: 2%; top: 2%; font-size: 16px;">
            <button id="toLine" style="cursor: pointer;">折线图</button>
            <button id="toBar" style="cursor: pointer;">柱状图</button>
        </div>
    </fieldset>
    <fieldset>
        <div id="main" style="width: 650px;height:500px;"></div>
    </fieldset>
    <fieldset>
        <div id="timeStatistic" style="width: 650px;height:500px;"></div>
    </fieldset>
    <fieldset>
        <div id="copyrightStatistic" style="width: 650px;height:500px;"></div>
    </fieldset>

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
            totalStatistic();
            userStatistic();
            timeStatistic();
            copyrightStatistic();
        }

        function userStatistic() {
            var userStatistic = ${requestScope.userStatistic};
            var title = '按上传用户统计视频数';
            var legend = ['上传视频数'];
            var xAxis = userStatistic[0];
            var data = userStatistic[1];

            $(document).ready(function () {
                drawColumnChart('main', title, legend, xAxis, data, chartType);
            });
        }

        function timeStatistic() {
            var timeStatistic = ${requestScope.timeStatistic};
            var title = '按上传时间统计视频数';
            var legend = ['上传视频数'];
            var xAxis = timeStatistic[0];
            var data = timeStatistic[1];

            $(document).ready(function () {
                drawColumnChart('timeStatistic', title, legend, xAxis, data, chartType);
            });
        }
        function copyrightStatistic() {
            var copyrightStatistic = ${requestScope.copyrightStatistic};
            var title = '按视频版权统计视频数';
            var legend = ['上传视频数'];
            var xAxis = copyrightStatistic[0];
            var data = copyrightStatistic[1];

            $(document).ready(function () {
                drawColumnChart('copyrightStatistic', title, legend, xAxis, data, chartType);
            });
        }
        function totalStatistic() {
            var totalStatistic = ${requestScope.totalStatistic};
            var title = '统计上传总视频数';
            var legend = ['上传视频数'];
            var xAxis = totalStatistic[0];
            var data = totalStatistic[1];

            $(document).ready(function () {
                drawColumnChart('totalStatistic', title, legend, xAxis, data, chartType);
            });
        }

    </script>
</body>
</html>
