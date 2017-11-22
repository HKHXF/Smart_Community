
function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  decodeURI(r[2]); return null;
}
var projectId = GetQueryString("projectId");
var city = GetQueryString("city");

$.ajax({  
    type: "GET",   
    url: "/weatherAliBaba/weatherToAliBaba", 
    dataType: 'json',
    data:{"city":city},
    success: function(result) {
    	var data = result.result;
    	$("#wendu").html(result.result.temp+'℃');
    	$("#shidu").html(result.result.humidity+'%');
    }
}); 




function jilu(){
    	var result;
    	$.ajax({  
    	    type: "GET",   
    	    url: "/powerProjectJson/yunxingCanshu", 
    	    dataType: 'json',
    	    async:false,
    	    data:{"projectId":projectId},
    	    success: function(msg) {   
    	    	result = msg.data;
    	    },
    	    error:function(msg){
    	    	layer.msg('系统异常,请稍后再试!!!', {icon: 5});
    	    }
    	}); 
    	result = eval(result);
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
    	    		if(type=="CO2浓度"){ type="Co2"; }
    			    
    			var key = floor+topOrbottom+serial+type;
    	    		if(result.hasOwnProperty(key)){ //判断数据内有无数据
    	    			var data = result[key];
    	    			if(data == null || data == -9999){ data = '-'; }
    	    		}else{
    	    			data = "-";
    	    		}
    	    		
//    	    		if(data>100){
//    	    			td.css({"background":"red","color":"#f1f1f1"});
//    	    		}
    	    		td.text(data);
    	    	}

    	    }
    	}
}
window.onload = jilu;
setInterval("jilu()",300000);//30分钟一次执行
