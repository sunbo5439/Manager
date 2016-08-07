/**
 * Created by wangdongsheng on 16/7/31.
 */

/**
 * 画柱状图
 */
function drawColumnChart(id, title, legend, xAxis, data, chartType) {
    var myChart = echarts.init(document.getElementById(id));

    // 指定图表的配置项和数据
    var option = {
        color: ['#3398DB'],
        title: {
            text: title
        },
        tooltip: {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            data:legend
        },
        xAxis: {
            data: xAxis,
            axisTick: {
                alignWithLabel: true
            }
        },
        yAxis: {},
        series: [{
            name: legend[0],
            type: chartType,
            barWidth: '50%',
            data: data,
            label: {
                normal: {
                    show: true,
                    position: 'top',
                    textStyle: {
                        color: '#000'
                    }
                }
            }
        }],
        dataZoom: [
            {   // 这个dataZoom组件，默认控制x轴。
                type: 'slider', // 这个 dataZoom 组件是 slider 型 dataZoom 组件
                xAxisIndex: 0,
                start: 0,      // 左边在 10% 的位置。
                end: 100,         // 右边在 60% 的位置。
                handleSize: '50%'
            },
            {   // 这个dataZoom组件，也控制x轴。
                type: 'inside', // 这个 dataZoom 组件是 inside 型 dataZoom 组件
                xAxisIndex: 0,
                start: 0,      // 左边在 10% 的位置。
                end: 100,         // 右边在 60% 的位置。
                handleSize: '50%'
            },
            // {
            //     type: 'slider',
            //     yAxisIndex: 0,
            //     start: 0,
            //     end: 100
            // },
            // {
            //     type: 'inside',
            //     yAxisIndex: 0,
            //     start: 0,
            //     end: 100
            // }
        ],
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}