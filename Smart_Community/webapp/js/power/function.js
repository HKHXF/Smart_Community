
  //设备调节记录数据

function jilu(){
	
	 $.ajax({  
 	    type: "GET",   
 	    url: "/powerProjectJson/shebeiTiaojieDate", 
 	    async:false,
 	    dataType: 'json',
 	    success: function(result) {   
                 var dataGo = result.data;
//                 console.log(dataGo);
                 var xAxisDate = []; //X
                 var cTSp1 = [];  //低区1#热泵制冷温度设定
                 var cTSp2 = [];  //低区2#热泵制冷温度设定
                 var cTSp3 = [];  //高区1#热泵制冷温度设定
                 var cTSp4 = [];  //高区冷水机组制冷温度设定
                 var cTSp5 = [];  //高区海尔磁悬浮制冷温度设定
     	        $.each(dataGo,function(i,n){
// 	        		alert("索引:"+i+"对应值为："+n.timeGo);
     	        	xAxisDate.push(n.timeGo);
     	        	cTSp1.push(n.ctSp1d);
     	        	cTSp2.push(n.ctSp2d);
     	        	cTSp3.push(n.ctSp3d);
     	        	cTSp4.push(n.ctSp4d);
     	        	cTSp5.push(n.ctSp5d);
 	        		
 	            });
//     	        xAxisDate = xAxisDate.slice(0,-1);
//     	        var xAxisDateGO = xAxisDate.split(","); 
//     	        cTSp1Date = cTSp1.slice(0,-1);
//     	        var cTSp1DateGO = cTSp1Date.split(","); 
     	        
     	        
                 var mode1Chart = echarts.init(document.getElementById('mode1chatrs'),"XTYX");
                 option = {
                 	    title: {
//                 	        text: '夏季'
                 	    },
                 	    tooltip: {
                 	        trigger: 'axis'
                 	    },
                 	    legend: {
                 	        data:['低区1#热泵制冷温度设定', '低区2#热泵制冷温度设定', '高区1#热泵制冷温度设定','高区冷水机组制冷温度设定','高区海尔磁悬浮制冷温度设定']
                 	    },
                 	    grid: {
                 	        left: '3%',
                 	        right: '4%',
                 	        bottom: '3%',
                 	        containLabel: true
                 	    },
                 	    toolbox: {
                 	        feature: {
                 	            saveAsImage: {}
                 	        }
                 	    },
                 	    xAxis: {
                 	        type: 'category',
                 	        data: xAxisDate
                 	    },
                 	    yAxis: {
                 	        type: 'value'
                 	    },
                 	    series: [
                 	        {
                 	            name:'低区1#热泵制冷温度设定',
                 	            type:'line',
                 	            step: 'start',
                 	            data:cTSp1
                 	        },
                 	        {
                 	            name:'低区2#热泵制冷温度设定',
                 	            type:'line',
                 	            step: 'start',
                 	            data:cTSp2
                 	        },
                 	        {
                 	            name:'高区1#热泵制冷温度设定',
                 	            type:'line',
                 	            step: 'start',
                 	            data:cTSp3
                 	        },
                 	        {
                 	            name:'高区冷水机组制冷温度设定',
                 	            type:'line',
                 	            step: 'start',
                 	            data:cTSp4
                 	        },
                 	        {
                 	            name:'高区海尔磁悬浮制冷温度设定',
                 	            type:'line',
                 	            step: 'start',
                 	            data:cTSp5
                 	        }
                 	    ]
                 	};


                 mode1Chart.setOption(option);
                 
                 
                 var xAxisDateH = []; //X
                 var thTSp1 = [];  //低区1#热泵热泵温度设定
                 var thTSp2 = [];  //低区2#热泵热泵温度设定
                 var thTSp3 = [];  //高区1#热泵热泵温度设定
                 var thTSp5 = [];  //高区海尔磁悬浮热泵温度设定
     	        $.each(dataGo,function(i,n){
// 	        		alert("索引:"+i+"对应值为："+n.timeGo);
     	        	xAxisDateH.push(n.timeGo);
     	        	thTSp1.push(n.thTSp1d);
     	        	thTSp2.push(n.thTSp2d);
     	        	thTSp3.push(n.thTSp3d);
     	        	thTSp5.push(n.thTSp5d);
 	        		
 	            });
//     	        xAxisDate = xAxisDate.slice(0,-1);
//     	        var xAxisDateGO = xAxisDate.split(","); 
//     	        cTSp1Date = cTSp1.slice(0,-1);
//     	        var cTSp1DateGO = cTSp1Date.split(","); 
                 
                 
                 var mode8Chart = echarts.init(document.getElementById('mode8chatrs'),"XTYX");
                 option = {
                 	    title: {
//                 	        text: '冬季'
                 	    },
                 	    tooltip: {
                 	        trigger: 'axis'
                 	    },
//                 	    dataZoom: [
//             	        {
//             	            id: 'dataZoomX',
//             	            type: 'slider',
//             	            xAxisIndex: [0],
//             	            filterMode: 'filter', // 设定为 'filter' 从而 X 的窗口变化会影响 Y 的范围。
//             	            start: 90,
//             	            end: 100
//             	        },
//             	        {
//             	            id: 'dataZoomY',
//             	            type: 'slider',
//             	            yAxisIndex: [0],
//             	            filterMode: 'empty',
//             	            start: 0,
//             	            end: 100
//             	        }
//             	    ],
                 	    legend: {
                 	        data:['低区1#热泵热泵温度设定', '低区2#热泵热泵温度设定', '高区1#热泵热泵温度设定', '高区海尔磁悬浮热泵温度设定']
                 	    },
                 	    grid: {
                 	        left: '3%',
                 	        right: '4%',
                 	        bottom: '3%',
                 	        containLabel: true
                 	    },
                 	    toolbox: {
                 	        feature: {
                 	            saveAsImage: {}
                 	        }
                 	    },
                 	    xAxis: {
                 	        type: 'category',
                 	        data: xAxisDateH
                 	    },
                 	    yAxis: {
                 	        type: 'value'
                 	    },
                 	    series: [
                 	        {
                 	            name:'低区1#热泵热泵温度设定',
                 	            type:'line',
                 	            step: 'start',
                 	            data:thTSp1
                 	        },
                 	        {
                 	            name:'低区2#热泵热泵温度设定',
                 	            type:'line',
                 	            step: 'start',
                 	            data:thTSp2
                 	        },
                 	        {
                 	            name:'高区1#热泵热泵温度设定',
                 	            type:'line',
                 	            step: 'start',
                 	            data:thTSp3
                 	        },
                 	        {
                 	            name:'高区海尔磁悬浮热泵温度设定',
                 	            type:'line',
                 	            step: 'start',
                 	            data:thTSp5
                 	        }
                 	    ]
                 	};

                 mode8Chart.setOption(option);
                 
                 

                 
 	    },
 	    error:function(result){
 	    	layer.msg('系统异常,请稍后再试!!!', {icon: 5});
 	    }
 	}); 
	
}
       


//运行记录  /powerProject/yunxinJilu
   $("#yunxinJilu").click(function(){
	   var city = $("#city").val();
	   window.location.href="/powerProject/yunxinJilu?projectId="+projectId+"&city="+city;
   });










function yunxingOk(){
	
	$.ajax({  
	    type: "GET",   
	    url: "/powerProjectJson/selectListTime", 
	    dataType: 'json',
	    success: function(result) {   
//	    	console.log(result);
	    	var myChart3 = echarts.init(document.getElementById('chart-three'),'macarons');
	    	data = result.data;
//	    	data = [];
//	    	console.log(data);
//	    	{2017-11-14 18:27:41: 1069}
//	    	["2000-06-05",116],["2000-06-06",129],["2000-06-07",135],["2000-06-08",86],["2000-06-09",73],["2000-06-10",85],["2000-06-11",73],["2000-06-12",68],["2000-06-13",92],["2000-06-14",130],["2000-06-15",245],["2000-06-16",139],["2000-06-17",115],["2000-06-18",111],["2000-06-19",309],["2000-06-20",206],["2000-06-21",137],["2000-06-22",128],["2000-06-23",85],["2000-06-24",94],["2000-06-25",71],["2000-06-26",106],["2000-06-27",84],["2000-06-28",93],["2000-06-29",85],["2000-06-30",73],["2000-07-01",83],["2000-07-02",125],["2000-07-03",107],["2000-07-04",82],["2000-07-05",44],["2000-07-06",72],["2000-07-07",106],["2000-07-08",107],["2000-07-09",66],["2000-07-10",91],["2000-07-11",92],["2000-07-12",113],["2000-07-13",107],["2000-07-14",131],["2000-07-15",111],["2000-07-16",64],["2000-07-17",69],["2000-07-18",88],["2000-07-19",77],["2000-07-20",83],["2000-07-21",111],["2000-07-22",57],["2000-07-23",55],["2000-07-24",60]
	    	var dateList = data.map(function (item) {
	    	    return item.timeGo;
	    	});
	    	var valueList = data.map(function (item) {
	    		if(item.loadTotal == null){
	    			return 0;
	    		}else{
	    			return item.loadTotal;
	    		}
	    	    
	    	});

	    	option = {

	    	    // Make gradient line here
	    	    visualMap: [{
	    	        show: false,
	    	        type: 'continuous',
	    	        seriesIndex: 0,
	    	        min: 0,
	    	        max: 400
	    	    }, {
	    	        show: false,
	    	        type: 'continuous',
	    	        seriesIndex: 1,
	    	        dimension: 0,
	    	        min: 0,
	    	        max: dateList.length - 1
	    	    }],


	    	    title: [{
	    	        left: 'center',
	    	        text: ''
	    	    
	    	    }],
	    	    tooltip: {
	    	        trigger: 'axis'
	    	    },
	    	    xAxis: [{
	    	        data: dateList
	    	    }, {
	    	        
	    	    }],
	    	    yAxis: [{
	    	    	name:"单位(kW)",
	    	        splitLine: {show: false}
	    	    }, {
	    	       
	    	    }],
	    	    grid: [{
	    	        bottom: '15%'
	    	    }, {
	    	        top: '20%'
	    	    }],
	    	    series: [{
	    	        type: 'line',
	    	        showSymbol: false,
	    	        data: valueList
	    	    }, {
	    	        type: 'line',
	    	        showSymbol: false,
	    	        data: valueList,
	    	        xAxisIndex: 1,
	    	        yAxisIndex: 1
	    	    }]
	    	};
	    	myChart3.setOption(option);
	    },
	    error:function(result){
	    	layer.msg('系统异常,请稍后再试!!!', {icon: 5});
	    }
	}); 


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
if(tableName == null || tableName == ""){
	var tableName = $("#tableName").val();
}




    
    
    








$.ajax({  
    type: "POST",   
    url: "/powerProjectJson/xitong", 
    dataType: 'json',
    data:{"projectId":projectId},
//    beforeSend: function () {
//     	layer.load(2);
//     },
    success: function(result) {   
        if(tableName == null || tableName == ""){
        	//在这里面输入任何合法的js语句
        	var index = layer.open({
    		  type: 1 //Page层类型
    		  ,area: ['500px', '300px']
//    		  ,title: '提示'
    		  ,shade: 0.8 //遮罩透明度
    		  ,maxmin: false //允许全屏最小化
    		  ,anim: 3 //0-6的动画形式，-1不开启
    		  ,content: '<div style="padding:50px;">敬请期待</div><br><button type="button"  class="btn btn-primary" style="margin-left: 409px;margin-top: 79px;" id="jinqingqidai">返回</button><script type="text/javascript">$("#jinqingqidai").click(function(){window.location.href="/homepage/delSession";});</script>'
    		});   
        }else{
        	var msg = result.data.tianqi;
//    	    $("#demo1").html('<iframe scrolling="no" id="aaa" style="width: 100%;" src="http://tianqiapi.com/api.php?style=tr&skin=pitaya&city='+msg+'" frameborder="0" width="100%" height="230" allowtransparency="true"></iframe>');
    	    var powerName = result.data.projectName;
    	    $("#powerName").html(powerName);
    	    $("#city").val(msg);
    	    
    	    showTianqi();
    	    all();
    	    yunxingOk();
    	    jilu();
    	    timeSelect();
        }

    },
    
    error:function(result){
    	layer.msg('系统异常,请稍后再试!!!', {icon: 5});
    },
//    complete:function(){
//    	layer.closeAll();
//    }
}); 



			function all(){
				$.ajax({  
				    type: "GET",   
				    url: "/powerProjectJson/xitongyinxingAll", 
				    dataType: 'json',
				    data:{"tableName":tableName,"projectId":projectId},
				    success: function(result) { 
				    	
				    	$("#fuheNow").html(result.data.fuheNow+"KW");
				    	$("#fuheLast").html(result.data.fuheLast+"KW");
				    	
				    	if(result.data.fuheLastBai > 0){
				    		$("#fuheLastBai").html("+"+result.data.fuheLastBai+"%");
				    	}else if(result.data.fuheLastBai < 0){
				    		$("#fuheLastBai").html(result.data.fuheLastBai+"%");
				    	}else{
				    		$("#fuheLastBai").html(0+"%");
				    	}
				    	$("#runningTime").html(result.data.runningTime);
				    	
				    	
				    	$("#timeGo").html(result.data.timeGo);
				    	$("#areaHVAC").html(result.data.areaHVAC+"&nbsp&nbsp <img src='../../img/m2.png' style='width: 12px; height: 12px;margin-top: -5px;' />");
				    	if(result.data.l1Tt01 == -9999 || result.data.l1Tt03 == -9999){
				    		$("#loadTotal").html("-"+"&nbsp&nbspkw");
				    	}else{
				    		$("#loadTotal").html(result.data.loadTotal+"&nbsp&nbspkw");
				    	}
				    	if(result.data.l1Tt01 != -9999 && result.data.l1Tt02 != -9999 && result.data.l1Ft01 != -9999){
				    		$("#loadDQTP").html(result.data.loadDQTP+"&nbsp&nbspkw");
				    	}else{
				    		$("#loadDQTP").html("-"+"&nbsp&nbspkw");
				    	}
				    	if(result.data.l1Tt03 != -9999 && result.data.l1Tt04 != -9999 && result.data.l1Ft02 != -9999){
				    		$("#loadGQXF").html(result.data.loadGQXF+"&nbsp&nbspkw");
				    	}else{
				    		$("#loadGQXF").html("-"+"&nbsp&nbspkw");
				    	}
				    	if(result.data.loadAvg == null || result.data.loadAvg == "" || result.data.loadAvg == undefined){
				    		$("#loadAvg").html("-"+"&nbsp&nbspW/<img src='../../img/m2.png' style='width: 12px; height: 12px;margin-top: -5px;' />");
				    	}else{
				    		$("#loadAvg").html(result.data.loadAvg+"&nbsp&nbspW/<img src='../../img/m2.png' style='width: 12px; height: 12px;margin-top: -5px;' />");
				    	}
				    	
				    	
				    	
				    	
				    	
				    	
				    	
				    	
				    	
				    	
				    	if(result.data.l1Ft01 == -9999){
				    		$("#l1Ft01").html("-"+"&nbsp&nbsp<img src='../../img/m3.png' style='width: 12px; height: 12px;margin-top: -5px;' />/h");
				    	}else{
				    		$("#l1Ft01").html(result.data.l1Ft01+"&nbsp&nbsp<img src='../../img/m3.png' style='width: 12px; height: 12px;margin-top: -5px;' />/h");
				    	}
				    	if(result.data.l1Ft02 == -9999){
				    		$("#l1Ft02").html("-"+"&nbsp&nbsp<img src='../../img/m3.png' style='width: 12px; height: 12px;margin-top: -5px;' />/h");
				    	}else{
				    		$("#l1Ft02").html(result.data.l1Ft02+"&nbsp&nbsp<img src='../../img/m3.png' style='width: 12px; height: 12px;margin-top: -5px;' />/h");
				    	}
				    	if(result.data.l1Ft03 == -9999){
				    		$("#l1Ft03").html("-"+"&nbsp&nbsp<img src='../../img/m3.png' style='width: 12px; height: 12px;margin-top: -5px;' />/h");
				    	}else{
				    		$("#l1Ft03").html(result.data.l1Ft03+"&nbsp&nbsp<img src='../../img/m3.png' style='width: 12px; height: 12px;margin-top: -5px;' />/h");
				    	}
				    	if(result.data.l1Tt01 == -9999){
				    		$("#l1Tt01").html("-"+"&nbsp&nbsp<img src='../../img/cc.png'>");
				    	}else{
				    		$("#l1Tt01").html(result.data.l1Tt01+"&nbsp&nbsp<img src='../../img/cc.png'>");
				    	}
				    	if(result.data.l1Tt02 == -9999){
				    		$("#l1Tt02").html("-"+"&nbsp&nbsp<img src='../../img/cc.png'>");
				    	}else{
				    		$("#l1Tt02").html(result.data.l1Tt02+"&nbsp&nbsp<img src='../../img/cc.png'>");
				    	}
				    	if(result.data.l1Tt03 == -9999){
				    		$("#l1Tt03").html("-"+"&nbsp&nbsp<img src='../../img/cc.png'>");
				    	}else{
				    		$("#l1Tt03").html(result.data.l1Tt03+"&nbsp&nbsp<img src='../../img/cc.png'>");	
				    	}
				    	if(result.data.l1Tt04 == -9999){
				    		$("#l1Tt04").html("-"+"&nbsp&nbsp<img src='../../img/cc.png'>");
				    	}else{
				    		$("#l1Tt04").html(result.data.l1Tt04+"&nbsp&nbsp<img src='../../img/cc.png'>");	
				    	}
				    	if(result.data.l1Tt06 == -9999){
				    		$("#l1Tt06").html("-"+"&nbsp&nbsp<img src='../../img/cc.png'>");
				    	}else{
				    		$("#l1Tt06").html(result.data.l1Tt06+"&nbsp&nbsp<img src='../../img/cc.png'>");
				    	}
				    	if(result.data.l1Tt05 == -9999){
				    		$("#l1Tt05").html("-"+"&nbsp&nbsp<img src='../../img/cc.png'>");
				    	}else{
				    		$("#l1Tt05").html(result.data.l1Tt05+"&nbsp&nbsp<img src='../../img/cc.png'>");
				    	}
				    	if(result.data.l1Tt07 == -9999){
				    		$("#l1Tt07").html("-"+"&nbsp&nbsp<img src='../../img/cc.png'>");
				    	}else{
				    		$("#l1Tt07").html(result.data.l1Tt07+"&nbsp&nbsp<img src='../../img/cc.png'>");
				    	}
				    	if(result.data.l1Tt08 == -9999){
				    		$("#l1Tt08").html("-"+"&nbsp&nbsp<img src='../../img/cc.png'>");
				    	}else{
				    		$("#l1Tt08").html(result.data.l1Tt08+"&nbsp&nbsp<img src='../../img/cc.png'>");
				    	}
				    	if(result.data.l1tpbD6 == -9999){
				    		$("#l1tpbD6").html("&nbsp&nbsp"+"-"+"&nbsp&nbspHz");
				    	}else{
				    		$("#l1tpbD6").html("&nbsp&nbsp"+result.data.l1tpbD6+"&nbsp&nbspHz");
				    	}
				    	if(result.data.l1xfbD6 == -9999){
				    		$("#l1xfbD6").html("&nbsp&nbsp"+"-"+"&nbsp&nbspHz");
				    	}else{
				    		$("#l1xfbD6").html("&nbsp&nbsp"+result.data.l1xfbD6+"&nbsp&nbspHz");
				    	}
				    	if(result.data.l1dybD6 == -9999){
				    		$("#l1dybD6").html("&nbsp&nbsp"+"-"+"&nbsp&nbspHz");
				    	}else{
				    		$("#l1dybD6").html("&nbsp&nbsp"+result.data.l1dybD6+"&nbsp&nbspHz");
				    	}
				    	if(result.data.l1lqbD6 == -9999){
				    		$("#l1lqbD6").html("&nbsp&nbsp"+"-"+"&nbsp&nbspHz");
				    	}else{
				    		$("#l1lqbD6").html("&nbsp&nbsp"+result.data.l1lqbD6+"&nbsp&nbspHz");
				    	}
				    	
				    	tableData(result.data);
				    	
				    	
				    },
				    error:function(result){
				    	layer.msg('系统异常,请稍后再试!!!', {icon: 5});
				    },
				}); 
			}



			function tableData(result){
				result = eval(result);
				console.log(result);
			    var tab=$(".tab");
			    for(var i=0;i<tab.length;i++){ //找页面内的表格
				    var title_tr = tab.eq(i).find("thead").find("tr").find("th"); //每个表格内的title
				    for(var x=1;x<title_tr.length;x++){ //循环title
				    	var tr = title_tr.eq(x).parent().parent().parent().find("tbody").find("tr"); //通过title找对应的tr
				    	for(var y=0;y<tr.length;y++){ //循环对应的tr针对每个 td进行操作
				    		var type = tr.eq(y).find('td').eq(0).text(); //找数据的类型 也就是左边第一列的数据
				    		var title = title_tr.eq(x).html(); //对应的表格上方的title
				    		var td = tr.eq(y).find('td').eq(x); //通过y和x定位到td


				    		var data = title.substring(0,title.length-3); //去除title后面的 AHU
				    		var floor = "t"+data.substring(0,data.indexOf('#')); //分割出楼层号
				    		var topOrbottom = data.substring(data.indexOf('#')+1,data.indexOf('#')+2); //分割出顶还是底
				    		if(topOrbottom =="顶"){ topOrbottom = "Rf"; }
				    		if(topOrbottom =="底"){ topOrbottom = "B1"; }
				    		var serial = data.substring(data.indexOf('#')+2); //分割出序号
				    		if(!serial){ serial = 1; }
				    		if(type=="送风温度"){ type="T3"; }
				    		if(type=="送风湿度"){ type="H1"; }
				    		if(type=="回风温度"){ type="T4"; }
				    		if(type=="回风湿度"){ type="H2"; }
				    		if(type=="二氧化碳浓度"){ type="Co2"; }
						    
						var key = floor+topOrbottom+serial+type;
				    		if(result.hasOwnProperty(key)){ //判断数据内有无数据
				    			var data = result[key];
				    			if(data == null || data == -9999){ data = '-'; }
				    		}else{
				    			data = "-";
				    		}
				    		
				    		td.text(data);
				    	}

				    }
				}
			}








// showTianqi();


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
        
        
        
        
        
        
        
        function timeSelect(){
        	//设备调节记录
            $.ajax({  
	        	    type: "GET",   
	        	    url: "/powerProjectJson/shebeiTiaojie", 
	        	    async:false,
	        	    dataType: 'json',
	        	    success: function(result) {   
	                        var yue = result.data;
	                        if(yue >= 5 && yue <= 10){ //夏季
	                        	$("#xiaji").click();
	                        }else{  //冬季
	                        	$("#dongji").click();
	                        }
	        	    },
	        	    error:function(result){
	        	    	layer.msg('系统异常,请稍后再试!!!', {icon: 5});
	        	    }
	        	}); 
        }
        

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        setInterval("showTianqi()",3600000);//60分钟一次执行
        setInterval("all()",300000);//5分钟一次执行
        setInterval("yunxingOk()",1800000);//30分钟一次执行
        setInterval("jilu()",1800000);//30分钟一次执行
//        setInterval("yunxingOk()",10000);//5分钟一次执行

