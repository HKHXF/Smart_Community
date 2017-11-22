var mode1Chart = echarts.init(document.getElementById('mode1chatrs'),'macarons');
option = {
    title : {
        text: '',
        subtext: ''
    },
    tooltip : {
        trigger: 'axis'
    },
    legend: {
        data:['蒸发量','降水量']
    },
    grid:{
                    x:25,
                    y:45,
                    x2:5,
                    y2:20,
                    borderWidth:1
                },
    // toolbox: {
    //     show : true,
    //     feature : {
    //         dataView : {show: true, readOnly: false},
    //         magicType : {show: true, type: ['line', 'bar']},
    //         restore : {show: true},
    //         saveAsImage : {show: true}
    //     }
    // },
    calculable : true,
    xAxis : [
        {
            type : 'category',
            data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    series : [
        {
            name:'蒸发量',
            type:'bar',
            data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3],
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        },
        {
            name:'降水量',
            type:'bar',
            data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3],
            markPoint : {
                data : [
                    {name : '年最高', value : 182.2, xAxis: 7, yAxis: 183},
                    {name : '年最低', value : 2.3, xAxis: 11, yAxis: 3}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name : '平均值'}
                ]
            }
        }
    ]
};

mode1Chart.setOption(option);







//<<<<<<< HEAD
//=======
//var mode2Chart = echarts.init(document.getElementById('mode2chatrs'),'macarons');
//option = {
//    tooltip : {
//        trigger: 'axis',
//        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
//            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
//        }
//    },
//    legend: {
//        data:['直接访问','邮件营销','联盟广告','视频广告']
//    },
//    grid: {
//        left: '3%',
//        right: '4%',
//        bottom: '3%',
//        containLabel: true
//    },
//    xAxis : [
//        {
//            type : 'category',
//            data : ['周一','周二','周三','周四','周五','周六','周日']
//        }
//    ],
//    yAxis : [
//        {
//            type : 'value'
//        }
//    ],
//    series : [
//        {
//            name:'直接访问',
//            type:'bar',
//            data:[320, 332, 301, 334, 390, 330, 320]
//        },
//        {
//            name:'邮件营销',
//            type:'bar',
//            stack: '广告',
//            data:[120, 132, 101, 134, 90, 230, 210]
//        },
//        {
//            name:'联盟广告',
//            type:'bar',
//            stack: '广告',
//            data:[220, 182, 191, 234, 290, 330, 310]
//        },
//        {
//            name:'视频广告',
//            type:'bar',
//            stack: '广告',
//            data:[150, 232, 201, 154, 190, 330, 410]
//        },
//        
//    ]
//};
//mode2Chart.setOption(option);
////用于使chart自适应高度和宽度
//window.onresize = function () {
//    //重置容器高宽
//    resizeWorldMapContainer();
//    myChart.resize();
//};
//>>>>>>> e86ad6d6bfe39c4a5c238e839376dfca3b9e723b




var mode3Chart = echarts.init(document.getElementById('mode3chatrs'),'macarons');
option = {
    color: ['#4acdce'],
    tooltip : {
        trigger: 'axis',
        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        }
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis : [
        {
            type : 'category',
            data : ['五月', '六月', '七月', '八月', '九月', '十月', '十一月'],
            axisTick: {
                alignWithLabel: true
            }
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    series : [
        {
            name:'直接访问',
            type:'bar',
            barWidth: '60%',
            data:[100, 150, 200, 250, 300, 350, 400]
        }
    ]
};

mode3Chart.setOption(option);

var mode4Chart = echarts.init(document.getElementById('mode4chatrs'),'macarons');
option = {
    title: {
        text: '',
        subtext: '',
        sublink: 'http://e.weibo.com/1341556070/Aj1J2x5a5'
    },
    tooltip : {
        trigger: 'axis',
        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        },
        formatter: function (params) {
            var tar;
            if (params[1].value != '-') {
                tar = params[1];
            }
            else {
                tar = params[0];
            }
            return tar.name + '<br/>' + tar.seriesName + ' : ' + tar.value;
        }
    },
    legend: {
        data:['支出','收入']
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis: {
        type : 'category',
        splitLine: {show:false},
        data :  function (){
            var list = [];
            for (var i = 1; i <= 11; i++) {
                list.push('11月' + i + '日');
            }
            return list;
        }()
    },
    yAxis: {
        type : 'value'
    },
    series: [
        {
            name: '辅助',
            type: 'bar',
            stack: '总量',
            itemStyle: {
                normal: {
                    barBorderColor: 'rgba(0,0,0,0)',
                    color: 'rgba(0,0,0,0)'
                },
                emphasis: {
                    barBorderColor: 'rgba(0,0,0,0)',
                    color: 'rgba(0,0,0,0)'
                }
            },
            data: [0, 900, 1245, 1530, 1376, 1376, 1511, 1689, 1856, 1495, 1292]
        },
        {
            name: '收入',
            type: 'bar',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: 'top'
                }
            },
            data: [900, 345, 393, '-', '-', 135, 178, 286, '-', '-', '-']
        },
        {
            name: '支出',
            type: 'bar',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: 'bottom'
                }
            },
            data: ['-', '-', '-', 108, 154, '-', '-', '-', 119, 361, 203]
        }
    ]
};
mode4Chart.setOption(option);

var mode5Chart = echarts.init(document.getElementById('mode5chatrs'),'macarons');
option = {
    title: {
        text: '',
        left: 'center'
    },
    tooltip: {
        trigger: 'item',
        formatter: '{a} <br/>{b} : {c}'
    },
    legend: {
        left: 'left',
        data: ['2的指数', '3的指数']
    },
    xAxis: {
        type: 'category',
        name: 'x',
        splitLine: {show: false},
        data: ['一', '二', '三', '四', '五', '六', '七', '八', '九']
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    yAxis: {
        type: 'log',
        name: 'y'
    },
    series: [
        {
            name: '3的指数',
            type: 'line',
            data: [1, 3, 9, 27, 81, 247, 741, 2223, 6669]
        },
        {
            name: '2的指数',
            type: 'line',
            data: [1, 2, 4, 8, 16, 32, 64, 128, 256]
        },
        {
            name: '1/2的指数',
            type: 'line',
            data: [1/2, 1/4, 1/8, 1/16, 1/32, 1/64, 1/128, 1/256, 1/512]
        }
    ]
};
mode5Chart.setOption(option);






function showTime()
{
 //创建Date对象
 var today = new Date();
 //分别取出年、月、日、时、分、秒
 var year = today.getFullYear();
 var month = today.getMonth()+1;
 var day = today.getDate();
 var hours = today.getHours();
 var minutes = today.getMinutes();
 var seconds = today.getSeconds();
 //如果是单个数，则前面补0
 month  = month<10  ? "0"+month : month;
 day  = day <10  ? "0"+day : day;
 hours  = hours<10  ? "0"+hours : hours;
 minutes = minutes<10 ? "0"+minutes : minutes;
 seconds = seconds<10 ? "0"+seconds : seconds;
  
 //构建要输出的字符串
 var str = year+"年"+month+"月"+day+"日 "+hours+":"+minutes+":"+seconds;
  
 //获取id=result的对象
 var obj = document.getElementById("result");
 //将str的内容写入到id=result的<div>中去
 obj.innerHTML = str;
 //延时器
 window.setTimeout("showTime()",1000);
}





