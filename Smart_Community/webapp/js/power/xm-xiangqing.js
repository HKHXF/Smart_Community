
			
			
			$(document).ready(function(){
				function GetQueryString(name)
				{
				     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
				     var r = window.location.search.substr(1).match(reg);
				     if(r!=null)return  unescape(r[2]); return null;
				}
				var projectId = GetQueryString("projectId");
				
				
				$.ajax({  
	                type: "POST",   
	                url: "/powerProjectJson/selectOne", 
	                data:{"projectId":projectId},
	                dataType: 'json',  
	                success: function(result) {   

	                	console.log(result);
	                	
	                	$("#xiugaiId").val(projectId);
	                	
	                	document.getElementById("image").src=result.data.projectImage;
	         			$("#projectName").html(result.data.projectName);
	         			$("#proName").html(result.data.proName);
	         			$("#projectAddress").html(result.data.projectAddress);
	         			$("#projectIntroduce").html(result.data.projectIntroduce);
	         			$("#conditionerArea").html(result.data.conditionerArea);
	         			$("#contractCustomer").html(result.data.contractCustomer);
	         			$("#trusteeshipTime").html(result.data.trusteeshipTime);
	         			$("#expireTime").html(result.data.expireTime);
	         			$("#contractLife").html(result.data.contractLife);
	         			
	         			if(result.data.energyPrice == 0){
	         				$("#energyPrice").html("");
	         			}else{
	         				$("#energyPrice").html(result.data.energyPrice);
	         			}
	         			
	         			if(result.data.chargingArea == 0){
	         				$("#chargingArea").html("");
	         			}else{
	         				$("#chargingArea").html(result.data.chargingArea);
	         			}
	         			
	         			if(result.data.projectArea == 0){
	         				$("#projectArea").html("");
	         			}else{
	         				$("#projectArea").html(result.data.projectArea);
	         			}
	         			
	         			
	         			if(result.data.designHeatingLoad == 0){
	         				$("#designHeatingLoad").html("");
	         			}else{
	         				$("#designHeatingLoad").html(result.data.designHeatingLoad);
	         			}
	         			
	         			if(result.data.designCoolingLoad == 0){
	         				$("#designCoolingLoad").html("");
	         			}else{
	         				$("#designCoolingLoad").html(result.data.designCoolingLoad);
	         			}
	         			
	         			if(result.data.companyHeatingLoad == 0){
	         				$("#companyHeatingLoad").html("");
	         			}else{
	         				$("#companyHeatingLoad").html(result.data.companyHeatingLoad);
	         			}
	         			
	         			if(result.data.companyCoolingLoad == 0){
	         				$("#companyCoolingLoad").html("");
	         			}else{
	         				$("#companyCoolingLoad").html(result.data.companyCoolingLoad);
	         			}
	         			
	         			
	         			$("#hostOnly").html(result.data.hostOnly);
	         			
	         			
	         			if(result.data.electricPrice == 0){
	         				$("#electricPrice").html("");
	         			}else{
	         				$("#electricPrice").html(result.data.electricPrice);
	         			}
	         			
	         			if(result.data.waterPrice == 0){
	         				$("#waterPrice").html("");
	         			}else{
	         				$("#waterPrice").html(result.data.waterPrice);
	         			}
	         			
	         			if(result.data.gasPrice == 0){
	         				$("#gasPrice").html("");
	         			}else{
	         				$("#gasPrice").html(result.data.gasPrice);
	         			}
	         			
	         			
	                },
	                error:function(result){
	                	layer.msg('服务异常,请稍后再试', {icon: 5});
	                }
	            }); 
				
			});
			
			
			//修改入口
			$("#xiugaixinx").click(function(){
				
				var projectId = $("#xiugaiId").val();
				window.location.href="/powerProject/update?projectId="+projectId;
				
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

			
			
			