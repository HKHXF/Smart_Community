var shujudata = []; //X
var mode1Chart = echarts.init(document.getElementById('mode1chatrs'),'macarons');
//初始化表名下拉
$.ajax({
	type: "GET",   
    url: "/powerProjectJson/inintTableName",  
    dataType: 'json',
    success: function(result) {   
    	//项目HTML开始
			var d =result.data;
			var item="<option value='0' selected>选择表名</option>";
			$.each(d,function(i,result){
				item =item+'<option value="'+result["table"]+'">'+result["tableName"]+'</option>';
			});
			$("#tableMame").html(item);
    }   
});


$("#tableMame").change(function(){
	var option = document.getElementById("tableMame");
	var table = option.value;
	
	$.ajax({
		type: "GET",   
        url: "/powerProjectJson/selectByTableName",  
        dataType: 'json',
        async:false,
        data:{"table":table},
        success: function(result) {   
 			
 			var d =result.data;
 			var item='';
//		         			var item='<option value="0" selected>选择 </option>';
 			$.each(d,function(i,result){
 				item =item+'<option value="'+result["point"]+':'+result["pointName"]+'">'+result["pointName"]+'</option>';
 			});
 			$("#ms").html(item).multipleSelect({width: '100%'});
        }   
	});
	
});


$('#ms').change(function() {
	shujudata = [];
    if($(this).val() != '' || $(this).val() != null){
    	 $.each($(this).val(),function(i,n){
    		shujudata.push(n);
    	 });
    	
    	}
  
}).multipleSelect({
    width: '100%'
});

    
    //检查
function clickSelect(){
	var option = document.getElementById("tableMame");
	var table = option.value;
	if(table == "0" || table == null){
		layer.tips('请先选择表名称！', '#tableMame', {
			  tips: 3
			});
		return;
	}
	
}






//查询
$("#baocun2").click(function(){
	var option = document.getElementById("defaultTime");
	var option1 = document.getElementById("tableMame");
	var startTime = '';
	var defaultTime = '';
	
	if(option.value == '选择'){
		if(!checkForm()) return;
		startTime = $("#trusteeshipTime").val();
		defaultTime = $("#expireTime").val();
	}else{
		startTime = '1';
		defaultTime = option.value;
	}
	var tableNme = option1.value;
	$.ajax({
		type: "GET",   
        url: "/HFHySQLJson/SelectListOn",  
        dataType: 'json',
        async:false,
        data:{"startTime":startTime,"endTime":defaultTime,"table":tableNme},
        success: function(result) {   
        	console.log(result.data);
        	prepareChartData(result);
        }
	});
});

function prepareChartData(result){
	var series = [];
	var selectData = [];
	var legend = [];
	$.each(shujudata,function(i,n){
		var val = n.split(":");
		selectData[datatTransformation(val[0])] = i;
		legend.push(val[1]);
		series[i] = {data:[],name:val[1],type:"line"};
	});
	var dataGo = result.data;
	var Xdata = []; //X

	$.each(dataGo,function(i,n){
		Xdata.push(n.timeNew);
		$.each(n,function(x,da){
			if(selectData.hasOwnProperty(x.toUpperCase())){
				if(da==-9999 || da==null){
					da = "";
				}
				series[selectData[x.toUpperCase()]].data.push(da);
			}
		})
	});
	chart(Xdata,series,legend);
}

function datatTransformation(data){
	return data.replace(new RegExp("_", 'g'), "");
}
function chart(Xdata,series,legend){
//	option = {
//	    title: {
//	        text: ''
//	    },
//	    tooltip: {
//	        trigger: 'axis'
//	    },
//	    legend: {
//	        data:legend
//	    },
//	    grid: {
//	        left: '3%',
//	        right: '4%',
//	        bottom: '3%',
//	        containLabel: true
//	    },
//	    xAxis: {
//	        type: 'category',
//	        boundaryGap: false,
//	        data: Xdata
//	    },
//	    yAxis: {
//	        type: 'value'
//	    },
//	    series:series
//	};
	option = {
		    title: {
		        text: '',
		        subtext: ''
		    },
		    tooltip: {
		        trigger: 'axis'
		    },
		    legend: {
		        data:legend
		    },
		    toolbox: {
		        show: true,
		        feature: {
		            dataZoom: {
		                yAxisIndex: 'none'
		            },
		            dataView: {readOnly: false},
		            magicType: {type: ['line', 'bar']},
		            restore: {},
		            saveAsImage: {}
		        }
		    },
		    xAxis:  {
		        type: 'category',
		        boundaryGap: false,
		        data: Xdata
		    },
		    yAxis: {
		        type: 'value'
//		        axisLabel: {
//		            formatter: '{value} °C'
//		        }
		    },
		    series:series
		};

	mode1Chart.setOption(option, true);
}



//校验数据
function checkForm(){
	var option = document.getElementById("defaultTime");
	var trusteeshipTime = $("#trusteeshipTime").val();
	var expireTime = $("#expireTime").val();

	var option = document.getElementById("tableMame");
	var table = option.value;
	if(table == "0" || table == null){
		layer.tips('请选择表名称！', '#tableMame', {
			  tips: 3
			});
		return false;
	}
	if(shujudata == null || shujudata == ""){
		layer.tips('请选择数据名称！', '.ms-choice', {
			  tips: 3
			});
		return false;
	}
	if(trusteeshipTime.trim() == "" && expireTime.trim() == ""){
		layer.tips('请选择时间范围或自定义', '#defaultTime', {
			  tips: 3
			});
		return false;
	}
	if(trusteeshipTime==""){
		layer.tips('请选择开始时间！', '#trusteeshipTime', {
			  tips: 3
			});
		return false;
	}
	if(expireTime==""){
		layer.tips('请选择结束时间！', '#expireTime', {
			  tips: 3
			});
		return false;
	}


	return true;
}


$('#trusteeshipTime').datetimepicker({
    format:'yyyy-mm-dd',
    autoclose:true,//自动关闭
    minView:2,//最精准的时间选择为日期0-分 1-时 2-日 3-月 
    weekStart:0
});
$('#expireTime').datetimepicker({
    format:'yyyy-mm-dd',
    autoclose:true,//自动关闭
    minView:2,//最精准的时间选择为日期0-分 1-时 2-日 3-月 
    weekStart:0
});

			