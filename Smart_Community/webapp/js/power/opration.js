var phpLocal = 0;
if(phpLocal) var wycLocal = "http://localhost?apiUrl=http://192.168.10.182";
if(!phpLocal) var wycLocal = "";
var orderType,projectType,projectPid,page=1,interfaceUrl=wycLocal+"/powerProjectJson/queryList";

$(".changeData").on('click',function(){
	coreHandle(this)
})
function changeData(the){
	coreHandle(the)
}

function coreHandle(the){
	var title = $(the).attr("data-title");
	var projectDetails = $(the).attr("data-projectDetails");
	var point = $(the).attr("data-point");
	var img = $(the).attr("data-img");
	var point = $(the).attr("data-point");
	var id = $(the).attr("id");
	var runtime = $(the).attr("runtime");
	var tableName = $(the).attr("tableName");
	$(".data-title").text(title);
	$(".data-content").text(projectDetails);
	$(".data-img").attr("src",img);

	$("#id").val(id);
	$("#name").val(title);
	$("#runtime").val(runtime);
	$("#tableName").val(tableName);
	
	var mapHeight = $(".map").height();
	var mapWidth = $(".map").width();
	//$("#map").attr("src","http://api.map.baidu.com/staticimage/v2?ak=hUh8Bvxgc1akD7yrxNGNfQR0bUOQVL0w&mcode=666666&center="+point+"width=370&height=250&zoom=11");
	$("#map").attr("src","http://api.map.baidu.com/staticimage/v2?ak=hUh8Bvxgc1akD7yrxNGNfQR0bUOQVL0w&mcode=666666&markers="+point+"&width="+mapWidth+"&height="+mapHeight+"&zoom=16");

}

/**
 * oprationLoadData 数据加工 async
 * @returns
 */
function oprationLoadData(page = 1){
	var html = "<tr>"+
			   "<td class='number'></td>"+
			   "<td class='changeData' onclick='changeData(this)' id='value.projectId' tableName='value.tableName' runtime='value.projectAddress' data-projectDetails='value.projectIntroduce' data-img='value.projectImage' data-point='value.projectAddress' data-title='value.projectName' data-content='value.projectAddress'>value.projectName</td>"+
			   "<td>value.proName</td>"+
			   "<td>value.projectArea</td>"+
			   "<td>value.conditionerArea</td>"+
			   "<td>value.hostOnly</td>"+
			   "<td>value.designCoolingLoad</td>"+
			   "<td>value.designHeatingLoad</td>"+
			   "</tr>";
	//var interfaceUrl = "/PowerProjectJson/queryListAll";
	var structure = ['projectId','projectAddress','projectIntroduce','projectImage','projectName','projectArea','projectType','hostOnly','designCoolingLoad','designHeatingLoad',"proName","conditionerArea","tableName"];
	getAjaxPageList_new(html,interfaceUrl,page,structure);
	locaOne();
	numberLoad();
}

/**
 * numberLoad 编号
 * @returns
 */
function numberLoad(){
	var num = $('.number');
	//alert(num.length);
	for(i=0;i<num.length;i++)
	{
		num.eq(i).text(i+1)
	}
}

function pageLocation(nextPage){
	oprationLoadData(nextPage)
}

oprationLoadData();
function locaOne(){
	$(".changeData").eq(0).click();
}



$("#bun").click(function(){
	var projectId = $("#id").val();
	var projectName = $("#name").val();
	var projectruntime = $("#runtime").val();
	var tableName = $("#tableName").val();
	
	window.location.href="/homepage/function?projectId="+projectId+"&projectName="+projectName+"&tableName="+tableName+"&projectruntime="+projectruntime+"";
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

