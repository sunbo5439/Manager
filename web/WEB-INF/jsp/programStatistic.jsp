<%--
  Created by IntelliJ IDEA.
  User: hadoop
  Date: 2016/7/10
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>节目统计</title>
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
        <div id="tvStationStatistic" style="width: 650px;height:500px;"></div>
        <div style="position: fixed; right: 2%; top: 2%; font-size: 16px;">
            <button id="toLine" style="cursor: pointer;">折线图</button>
            <button id="toBar" style="cursor: pointer;">柱状图</button>
        </div>
    </fieldset>
    <fieldset>
        <div id="typeStatistic" style="width: 650px;height:500px;"></div>
    </fieldset>
    <fieldset>
        <div id="sourceStatistic" style="width: 650px;height:500px;"></div>
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
            tvStationStatistic();
            typeStatistic();
            sourceStatistic();
        }

        function tvStationStatistic() {
            var tvStationStatistic = ${requestScope.tvStationStatistic};
            var title = '按电视台统计节目数';
            var legend = ['节目数量'];
            var xAxis = tvStationStatistic[0];
            var data = tvStationStatistic[1];

            $(document).ready(function () {
                drawColumnChart('tvStationStatistic', title, legend, xAxis, data, chartType);
            });
        }

        function typeStatistic() {
            var typeStatistic = ${requestScope.typeStatistic};
            var title = '按节目类型统计节目数';
            var legend = ['节目数量'];
            var xAxis = typeStatistic[0];
            var data = typeStatistic[1];

            $(document).ready(function () {
                drawColumnChart('typeStatistic', title, legend, xAxis, data, chartType);
            });
        }

        function sourceStatistic() {
            var sourceStatistic = ${requestScope.sourceStatistic};
            var title = '按节目来源统计节目数';
            var legend = ['节目数量'];
            var xAxis = sourceStatistic[0];
            var data = sourceStatistic[1];

            $(document).ready(function () {
                drawColumnChart('sourceStatistic', title, legend, xAxis, data, chartType);
            });
        }
    </script>
</body>
</html>
