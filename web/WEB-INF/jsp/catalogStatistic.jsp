<%--
  Created by IntelliJ IDEA.
  User: wangdongsheng
  Date: 16/7/25
  Time: 下午2:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编目统计</title>
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
        <div id="catalogTimeStatistic" style="width: 650px;height:500px;"></div>
        <div style="position: fixed; right: 2%; top: 2%; font-size: 16px;">
            <button id="toLine" style="cursor: pointer;">折线图</button>
            <button id="toBar" style="cursor: pointer;">柱状图</button>
        </div>
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
            catalogTimeStatistic();
        }

        function catalogTimeStatistic() {
            var catalogTimeStatistic = ${requestScope.catalogTimeStatistic};
            var title = '按编目时间统计编目';
            var legend = ['编目数'];
            var xAxis = catalogTimeStatistic[0];
            var data = catalogTimeStatistic[1];

            $(document).ready(function () {
                drawColumnChart('catalogTimeStatistic', title, legend, xAxis, data, chartType);
            });
        }

    </script>

</body>
</html>
