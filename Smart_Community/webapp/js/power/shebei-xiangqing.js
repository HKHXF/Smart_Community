


//$(document).ready(function(){
	

function GetQueryString(name)
				{
				     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
				     var r = window.location.search.substr(1).match(reg);
				     if(r!=null)return  unescape(r[2]); return null;
				}
				var equipmentIedgerId = GetQueryString("equipmentIedgerId");
				
				
				$.ajax({  
	                type: "POST",   
	                url: "/equipmentIedgerJson/selectOne", 
	                data:{"equipmentIedgerId":equipmentIedgerId},
	                dataType: 'json',
	                beforeSend: function () {
	                 	layer.load(2);
	                 },
	                success: function(result) {   

//	                	console.log(result);
	                	$("#xiugaiId").val(result.data.equipmentIedgerId);
	                	
	                	$("#equipmentName").html(result.data.equipmentName);
	                	$("#regionName").html(result.data.regionName);
	                	$("#projectName").html(result.data.projectName);
	                	$("#installationAddress").html(result.data.installationAddress);
	                	$("#gomanufacturerAddress").html(result.data.gomanufacturerAddress);
	                	$("#manufacturer").html(result.data.manufacturer);
	                	$("#manufacturerAddress").html(result.data.manufacturerAddress);
	                	$("#contactNumber").html(result.data.contactNumber);
	                	$("#unitModel").html(result.data.unitModel);
	                	$("#factoryNumber").html(result.data.factoryNumber);
	                	$("#power").html(result.data.power);
	                	$("#voltage").html(result.data.voltage);
	                	$("#weight").html(result.data.weight);
	                	$("#lift").html(result.data.lift);
	                	$("#speed").html(result.data.speed);
	                	$("#flow").html(result.data.flow);
	                	$("#loopNumber").html(result.data.loopNumber);
	                	$("#temperatureRestriction").html(result.data.temperatureRestriction);
	                	$("#capacity").html(result.data.capacity);
	                	$("#electricCurrent").html(result.data.electricCurrent);
	                	$("#manufacturerAddress").html(result.data.manufacturerAddress);
	                	$("#remarks").html(result.data.remarks);
	                	$("#ifEasyUse").html(result.data.ifEasyUse);
	                	$("#ifIntact").html(result.data.ifIntact);
	                	$("#usingState").html(result.data.usingState);
	                	$("#intactState").html(result.data.intactState);
	                	$("#installationUnit").html(result.data.installationUnit);
	                	$("#installContacts").html(result.data.installContacts);
	                	$("#warrantyTermination").html(result.data.warrantyTermination);
	                	$("#contactInformation").html(result.data.contactInformation);
	                	$("#installTime").html(result.data.installTime);
	                	$("#enableTime").html(result.data.enableTime);
	                	$("#handoverTimeType").html(result.data.handoverTimeType);
	         			
	                },
	                
	                error:function(result){
	                	layer.msg('系统异常,请稍后再试!!!', {icon: 5});
	                },
	                complete:function(){
	                	layer.closeAll();
	                }
	            }); 
				
				
				
				
				//跳转修改页面
				$("#update").click(function(){
					var equipmentIedgerId = $("#xiugaiId").val();
					window.location.href="/equipmentIedger/update?equipmentIedgerId="+equipmentIedgerId;
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
				
//});