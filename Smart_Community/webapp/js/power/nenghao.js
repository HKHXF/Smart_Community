
var myChart = echarts.init(document.getElementById('chart-one'),'macarons');
option = {
    tooltip: {
        trigger: 'item',
        formatter: "{a} <br/>{b}: {c} ({d}%)"
    },
    
    series: [
        {
            name:'访问来源',
            type:'pie',
            radius: ['50%', '70%'],
            avoidLabelOverlap: false,
            label: {
                normal: {
                    show: false,
                    position: 'center'
                },
                emphasis: {
                    show: true,
                    textStyle: {
                        fontSize: '30',
                        fontWeight: 'bold'
                    }
                }
            },
            labelLine: {
                normal: {
                    show: false
                }
            },
            data:[
                {value:335, name:'直接访问'},
                {value:310, name:'邮件营销'},
                {value:234, name:'联盟广告'},
                
            ]
        }
    ]
}
myChart.setOption(option);

var myChart = echarts.init(document.getElementById('chart-two'),'macarons');
option = {
    tooltip: {
        trigger: 'item',
        formatter: "{a} <br/>{b}: {c} ({d}%)"
    },
    
    series: [
        {
            name:'访问来源',
            type:'pie',
            radius: ['50%', '70%'],
            avoidLabelOverlap: false,
            label: {
                normal: {
                    show: false,
                    position: 'center'
                },
                emphasis: {
                    show: true,
                    textStyle: {
                        fontSize: '30',
                        fontWeight: 'bold'
                    }
                }
            },
            labelLine: {
                normal: {
                    show: false
                }
            },
            data:[
                {value:335, name:'直接访问'},
                {value:310, name:'邮件营销'},
                {value:234, name:'联盟广告'},
                
            ]
        }
    ]
}
myChart.setOption(option);


 var myChart = echarts.init(document.getElementById('chart-five'),'macarons');
option = {
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            data:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎','百度','谷歌','必应','其他']
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
                data : ['周一','周二','周三','周四','周五','周六','周日']
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
                data:[320, 332, 301, 334, 390, 330, 320]
            },
            {
                name:'邮件营销',
                type:'bar',
                stack: '广告',
                data:[120, 132, 101, 134, 90, 230, 210]
            },
            {
                name:'联盟广告',
                type:'bar',
                stack: '广告',
                data:[220, 182, 191, 234, 290, 330, 310]
            },
            {
                name:'视频广告',
                type:'bar',
                stack: '广告',
                data:[150, 232, 201, 154, 190, 330, 410]
            },
            {
                name:'搜索引擎',
                type:'bar',
                data:[862, 1018, 964, 1026, 1679, 1600, 1570],
                markLine : {
                    lineStyle: {
                        normal: {
                            type: 'dashed'
                        }
                    },
                    data : [
                        [{type : 'min'}, {type : 'max'}]
                    ]
                }
            },
            {
                name:'百度',
                type:'bar',
                barWidth : 5,
                stack: '搜索引擎',
                data:[620, 732, 701, 734, 1090, 1130, 1120]
            },
            {
                name:'谷歌',
                type:'bar',
                stack: '搜索引擎',
                data:[120, 132, 101, 134, 290, 230, 220]
            },
            {
                name:'必应',
                type:'bar',
                stack: '搜索引擎',
                data:[60, 72, 71, 74, 190, 130, 110]
            },
            {
                name:'其他',
                type:'bar',
                stack: '搜索引擎',
                data:[62, 82, 91, 84, 109, 110, 120]
            }
        ]
    };

myChart.setOption(option);

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
			
			
			
			function GetQueryString(name)
			{
			     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
			     var r = window.location.search.substr(1).match(reg);
			     if(r!=null)return  unescape(r[2]); return null;
			}
			var projectId = GetQueryString("projectId");
			var tableName = GetQueryString("tableName");

			if(projectId == null || projectId == ""){
				var projectId = $("#toID").val();
			}
			var projectName = $("#toName").val();
			$("#projectNameOr").html(projectName);
			if(tableName == null || tableName == ""){
				var tableName = $("#tableName").val();
			}

			
			
			
			$.ajax({  
			    type: "POST",   
			    url: "/powerProjectJson/xitong", 
			    dataType: 'json',
			    data:{"projectId":projectId},
			    success: function(result) {  
			    	    if(tableName == null || tableName == ""){
			            	//在这里面输入任何合法的js语句
			            	var index = layer.open({
			        		  type: 1 //Page层类型
			        		  ,area: ['500px', '300px']
//			        		  ,title: '提示'
			        		  ,shade: 0.8 //遮罩透明度
			        		  ,maxmin: false //允许全屏最小化
			        		  ,anim: 3 //0-6的动画形式，-1不开启
			        		  ,content: '<div style="padding:50px;">敬请期待</div><br><button type="button"  class="btn btn-primary" style="margin-left: 409px;margin-top: 79px;" id="jinqingqidai">返回</button><script type="text/javascript">$("#jinqingqidai").click(function(){window.location.href="/homepage/delSession";});</script>'
			        		});   
			            }else{
			            	var msg = result.data.tianqi;
			        	    var powerName = result.data.projectName;
			        	    $("#powerName").html(powerName);
			        	    $("#city").val(msg);
			        	    showTianqi();
			            }
			    	    
			    	    
			    },
			    error:function(result){
			    	layer.msg('系统异常,请稍后再试!!!', {icon: 5});
			    },
			}); 

			
			
			
			
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
        
        function showTianqi(){
            var city = $("#city").val();
            $.ajax({  
                type: "GET",   
                url: "/weatherAliBaba/weatherToAliBaba", 
                dataType: 'json',
                data:{"city":city},
                success: function(result) {
                    var data = result.result;
                    console.log(data);
                    
                    //第一天开始
                    var daty = data.date.substring(8); //今天
                    var dayDuring = data.daily[0].day.img; //白天图
                    var dayNight = data.daily[0].night.img;  //晚上图
                    var tianqiType1 = data.daily[0].day.weather;  //白天天气状态
                    var tianqiType2 = data.daily[0].night.weather;  //晚上天气状态
                    if(tianqiType1 == tianqiType2){
                        var tianqiType = tianqiType1;
                    }else{
                        var tianqiType = tianqiType1+"转"+tianqiType2;
                    }
                    var zuigao = data.temphigh;  //最高气温
                    var zuiDi = data.templow;  //最低气温
                    
                    
                    
                    //赋值
                    $("#day").html(daty+"日（今天）");
                    $("#dayDuring").attr("src","/images/"+dayDuring+".png");
                    $("#dayNight").attr("src","/images/"+dayNight+".png");
                    $("#tianqiType").html(tianqiType);
                    $("#zuigao").html(zuigao+"&nbsp");
                    $("#zuiDi").html("&nbsp/&nbsp"+zuiDi+"&nbsp");
                    
                    
                    


                    //第二天开始
                    var daty1 = data.daily[1].date.substring(8); //明天
                    var dayDuring2 = data.daily[1].day.img; //白天图
                    var dayNight2 = data.daily[1].night.img;  //晚上图
                    var tianqiType3 = data.daily[1].day.weather;  //白天天气状态
                    var tianqiType4 = data.daily[1].night.weather;  //晚上天气状态
                    if(tianqiType3 == tianqiType4){
                        var tianqiTypeTwo = tianqiType4;
                    }else{
                        var tianqiTypeTwo = tianqiType3+"转"+tianqiType4;
                    }
                    var zuigaoTwo = data.daily[1].day.temphigh;  //最高气温
                    var zuiDiTwo = data.daily[1].night.templow;  //最低气温
                    
                    
                    //赋值
                    $("#dayTwo").html(daty1+"日（明天）");
                    $("#dayDuring2").attr("src","/images/"+dayDuring2+".png");
                    $("#dayNight2").attr("src","/images/"+dayNight2+".png");
                    $("#tianqiTypeTwo").html(tianqiTypeTwo);
                    $("#zuigaoTwo").html(zuigaoTwo+"&nbsp");
                    $("#zuiDiTwo").html("&nbsp/&nbsp"+zuiDiTwo+"&nbsp");
                    

                    //第三天开始
                    var daty3 = data.daily[2].date.substring(8); //后天
                    var dayDuring3 = data.daily[2].day.img; //白天图
                    var dayNight3 = data.daily[2].night.img;  //晚上图
                    var tianqiType5 = data.daily[2].day.weather;  //白天天气状态
                    var tianqiType6 = data.daily[2].night.weather;  //晚上天气状态
                    if(tianqiType5 == tianqiType6){
                        var tianqiTypeThree = tianqiType6;
                    }else{
                        var tianqiTypeThree = tianqiType5+"转"+tianqiType6;
                    }
                    var zuigaoThree = data.daily[2].day.temphigh;  //最高气温
                    var zuiDiThree = data.daily[2].night.templow;  //最低气温
                    
                    
                    //赋值
                    $("#dayThree").html(daty3+"日（后天）");
                    $("#dayDuring3").attr("src","/images/"+dayDuring3+".png");
                    $("#dayNight3").attr("src","/images/"+dayNight3+".png");
                    $("#tianqiTypeThree").html(tianqiTypeThree);
                    $("#zuigaoThree").html(zuigaoThree+"&nbsp");
                    $("#zuiDiThree").html("&nbsp/&nbsp"+zuiDiThree+"&nbsp");



                    
                    
                    
                    
                    
                     $("#wendu").html(result.result.temp + '&nbsp;<img src="../../img/cc.png" style="width: 20px; height: 20px;" />');
                     $("#humidity").html(result.result.humidity + '&nbsp<img src="../../img/bb.png" style="width: 20px; height: 20px;" />');
                     $("#pm25").html(result.result.aqi.pm2_5);
                     $("#pm25").css({color:result.result.aqi.aqiinfo.color});
                },
                complete:function(){
                    layer.closeAll();
                }
            }); 
            
        }
        setInterval("showTianqi()",3600000);//60分钟一次执行




			
			