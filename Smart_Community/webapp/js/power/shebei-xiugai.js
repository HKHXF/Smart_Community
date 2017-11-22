

$(document).ready(function(){

			$.ajax({  
                type: "POST",   
                url: "/powerProjectJson/selectQuyuAndProbjectAndType",  
                dataType: 'json',  
                success: function(result) {   
         			
         			
         			//区域HTML开始
         			var c =result.data.quyu;
         			var item="<option value='0' selected>选择上级结构</option>";
         			$.each(c,function(i,result){
//         				item +='<li>';
//         				item =item+'<a href="#" onclick="quyuxianze(this)" projectId="'+result["projectId"]+'"  projectName="'+result["projectName"]+'">'+(result["projectName"]==undefined?'':result["projectName"])+'</a>';
//         				item +='</li>';
         				item =item+'<option value="'+result["projectId"]+'">'+result["projectName"]+'</option>';
         			});
         			$("#toquyu").html(item);
         			
         			
         			//项目HTML开始
         			var d =result.data.probject;
         			var item="<option value='0' selected>选择上级结构</option>";
         			$.each(d,function(i,result){
//         				item +='<li>';
//         				item =item+'<a href="#" onclick="xiangmuxianze(this)" projectId="'+result["projectId"]+'"  projectName="'+result["projectName"]+'">'+(result["projectName"]==undefined?'':result["projectName"])+'</a>';
//         				item +='</li>';
         				item =item+'<option value="'+result["projectId"]+'">'+result["projectName"]+'</option>';
         			});
         			$("#toxiangmu").html(item);
         			
         			
         			//设备类别HTML开始
         			var d =result.data.shebeiType;
         			var item="<option value='0' selected>选择上级结构</option>";
         			$.each(d,function(i,result){
//         				item +='<li>';
//         				item =item+'<a href="#" onclick="shebeixianze(this)" equipmentTypeId="'+result["equipmentTypeId"]+'"  equipmentTypeName="'+result["equipmentTypeName"]+'">'+(result["equipmentTypeName"]==undefined?'':result["equipmentTypeName"])+'</a>';
//         				item +='</li>';
         				item =item+'<option value="'+result["equipmentTypeId"]+'">'+result["equipmentTypeName"]+'</option>';
         			});
         			$("#shebei").html(item);
         			
         			selectOne();
                }   
            });
			
			
			function GetQueryString(name)
			{
			     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
			     var r = window.location.search.substr(1).match(reg);
			     if(r!=null)return  unescape(r[2]); return null;
			}
			var equipmentIedgerId = GetQueryString("equipmentIedgerId");
			
			function selectOne(){
				
			
			
			$.ajax({  
                type: "POST",   
                url: "/equipmentIedgerJson/selectOne", 
                data:{"equipmentIedgerId":equipmentIedgerId},
                dataType: 'json',
                beforeSend: function () {
                 	layer.load(2);
                 },
                success: function(result) {   

//                	console.log(result);
                	$("#equipmentIedgerId").val(result.data.equipmentIedgerId);
                	
                	$("#equipmentName").val(result.data.equipmentName);
                	$("#regionName").val(result.data.regionName);
                	$("#projectName").val(result.data.projectName);
                	$("#installationAddress").val(result.data.installationAddress);
                	$("#manufacturer").val(result.data.manufacturer);
                	$("#manufacturerAddress").val(result.data.manufacturerAddress);
                	$("#contactNumber").val(result.data.contactNumber);
                	$("#unitModel").val(result.data.unitModel);
                	$("#factoryNumber").val(result.data.factoryNumber);
                	$("#power").val(result.data.power);
                	$("#voltage").val(result.data.voltage);
                	$("#weight").val(result.data.weight);
                	$("#lift").val(result.data.lift);
                	$("#speed").val(result.data.speed);
                	$("#flow").val(result.data.flow);
                	$("#loopNumber").val(result.data.loopNumber);
                	$("#temperatureRestriction").val(result.data.temperatureRestriction);
                	$("#capacity").val(result.data.capacity);
                	$("#electricCurrent").val(result.data.electricCurrent);
                	$("#gomanufacturerAddress").val(result.data.gomanufacturerAddress);
                	$("#remarks").val(result.data.remarks);
                	$("#ifEasyUse").val(result.data.ifEasyUse);
                	$("#ifIntact").val(result.data.ifIntact);
                	$("#usingState").val(result.data.usingState);
                	$("#intactState").val(result.data.intactState);
                	$("#installationUnit").val(result.data.installationUnit);
                	$("#installContacts").val(result.data.installContacts);
                	$("#contactInformation").val(result.data.contactInformation);
                	$("#warrantyTermination").val(result.data.warrantyTermination);
                	$("#installTime").val(result.data.installTime);
                	$("#enableTime").val(result.data.enableTime);
                	$("#handoverTimeType").val(result.data.handoverTimeType);
                	
                	
                	var toquyu = result.data.regionId;
                	var toxiangmu = result.data.projectId;
                	var shebei = result.data.equipmentTypeId;
                	
                	
                	xuanzong(toquyu,toxiangmu,shebei);
                	
                	
         			
                },
                
                error:function(result){
                	layer.msg('系统异常,请稍后再试!!!', {icon: 5});
                },
                complete:function(){
                	layer.closeAll();
                }
            }); 
	}	
			
			
});		


            //进行下拉选中
            function xuanzong(toquyu,toxiangmu,shebei){
            	
            	var select = document.getElementById("toquyu");
     			for(var i=0; i<select.options.length; i++){  
     		        if(select.options[i].value == toquyu){  
     		            select.options[i].selected = true;  
     		            break;  
     		        }  
     		    }  
     			
     			
     			var select1 = document.getElementById("toxiangmu");
     			for(var i=0; i<select1.options.length; i++){  
     		        if(select1.options[i].value == toxiangmu){  
     		            select1.options[i].selected = true;  
     		            break;  
     		        }  
     		    }  
     			
     			
     			var select2 = document.getElementById("shebei");
     			for(var i=0; i<select2.options.length; i++){  
     		        if(select2.options[i].value == shebei){  
     		            select2.options[i].selected = true;  
     		            break;  
     		        }  
     		    }  
            }


            //点击区域
			$("#toquyu").change(function(){ 
				
				var selelct = document.getElementById("toquyu");
				var projectId = selelct.value;
				
				$.ajax({
					type: "POST",   
	                url: "/powerProjectJson/selectProbjectByQuyu",  
	                dataType: 'json',
	                data:{"projectId":projectId},
	                success: function(result) {   
	         			
	         			
	                	//项目HTML开始
	         			var d =result.data;
	         			var item="<option value='0' selected>选择上级结构</option>";
	         			$.each(d,function(i,result){
	         				item =item+'<option value="'+result["projectId"]+'">'+result["projectName"]+'</option>';
	         			});
	         			$("#toxiangmu").html(item);
	         			
	                }   
				});
				
			});
           

			
			
            //点击项目
			$("#toxiangmu").change(function(){ 
				
				var option = document.getElementById("toxiangmu");
				var projectId = option.value;
				
				$.ajax({
					type: "POST",   
	                url: "/powerProjectJson/selectQuyuByProject",  
	                dataType: 'json',
	                data:{"projectId":projectId},
	                success: function(result) {   
	         			
	         			
	                	//项目HTML开始
	         			var d =result.data;
	         			var select = document.getElementById("toquyu");
	         			for(var i=0; i<select.options.length; i++){  
	         		        if(select.options[i].value == d.projectId){  
	         		            select.options[i].selected = true;  
	         		            break;  
	         		        }  
	         		    }  
	         			
	         			
	                }   
				});
				
			});
			
			
			
			//修改
			$("#xiugai").click(function(){
				var equipmentIedgerId = $("#equipmentIedgerId").val();
				var formData = new FormData($("#toform")[0]);
				if(!checkForm()) return false;
				$.ajax({
	    			type:"POST",
	    			url:"/equipmentIedgerJson/update",
	    			data:formData,
	    			async: false,  
	    		    cache: false,  
	    		    contentType: false,  
	    		    processData: false,
	    			success:function(msg){
	    				console.log(msg);
	    				if(msg.code == 0){
	    					  layer.msg('修改成功', {
	    						  icon: 6,
	    						  time: 1000 
	    						}, function(){
	    							window.location.href="/equipmentIedger/selectOne?equipmentIedgerId="+equipmentIedgerId;
	    						});   
	    					
	    				}else{
	    					layer.msg(msg.message, {icon: 5});
	    				}
	    			},
	    			error:function(msg){
	    				layer.msg('服务异常,请稍后再试', {icon: 5});
	    			}
	    	     });
				
			});
			
			//取消
			$("#quxiao").click(function(){
				var equipmentIedgerId = $("#equipmentIedgerId").val();
				window.location.href="/equipmentIedger/selectOne?equipmentIedgerId="+equipmentIedgerId;
			});

			
			
			//弹出层
			  $('.ii').on('click', function(){
				  $("#myModal").modal("show");
					$.ajax({
		    			type:"POST",
		    			url:"/equipmentTypeJson/selectAll",
		    			dataType:"json",
		    			success:function(msg){
//		    				console.log(msg);

		    				    var c = msg.data;
		    					var item="";
		             			$.each(c,function(i,result){
		             				item +='<tr>';
		             				item +='<td><a href="#" dataname="'+result["equipmentTypeName"]+'" dataid="'+result["equipmentTypeId"]+'" onclick="bule(this)">'+result["equipmentTypeName"]+'</a></td>';
		             				item +='</tr>';
		             			});
		             			$("#table1").html(item);
		    					
		             			
		    			},
		    			error:function(msg){
		    				layer.msg('服务异常,请稍后再试', {icon: 5});
		    			}
		    	     });
				  
				  
				  $("#focusedInput").removeAttr("dataid");
				  $("#focusedInput").val("");
			  });
			  
			  
				
				function bule(aaa){
					  var td = $(aaa).attr('dataid');
					  var bb = $(aaa).attr('dataname');
					  $("#focusedInput").val(bb);
					  $("#focusedInput").attr("dataid",td);
					};
					
					
					
					
					//类型新增
					$("#insert").click(function(){
						var a = $("#focusedInput").val(); //内容
						var b = $("#focusedInput").attr('dataid');  //id
						if(!checkInput()) return; 
						$.ajax({
			    			type:"POST",
			    			url:"/equipmentTypeJson/insert",
			    			data:{"equipmentTypeName":a},
			    			success:function(msg){
			    				if(msg.code == 0){
			    					if(msg.code == 0){
				    					  layer.msg('添加成功', {
				    						  icon: 6,
				    						  time: 1000 
				    						}, function(){
				    							$('#myModal').modal('hide');
				    						});  
				    				}else{
				    					layer.msg(msg.message, {icon: 5});
				    				}
			    					shuaxin();
			    				}else{
			    					layer.msg(msg.message, {icon: 5});
			    				}
			    			},
			    			error:function(msg){
			    				layer.msg("服务异常,请稍后再试!!!", {icon: 5});
			    			}
			    	     });
					});
					
					
					//修改设备类型
					$("#update").click(function(){
						var a = $("#focusedInput").val(); //内容
						var b = $("#focusedInput").attr('dataid');  //id
						if(!checkInput()) return;
						$.ajax({
			    			type:"POST",
			    			url:"/equipmentTypeJson/update",
			    			data:{"equipmentTypeId":b,"equipmentTypeName":a},
			    			success:function(msg){
			    				if(msg.code == 0){
			    					 layer.msg('修改成功', {
			    						  icon: 6,
			    						  time: 1000 
			    						}, function(){
			    							$('#myModal').modal('hide');
			    						});  
			    					shuaxin();
			    				}else{
			    					layer.msg(msg.message, {icon: 5});
			    				}
			    			},
			    			error:function(msg){
			    				layer.msg("服务异常,请稍后再试!!!", {icon: 5});
			    			}
			    	     });
					});
					
					
					//删除设备弹出
					$("#del").click(function(){
						var a = $("#focusedInput").val(); //内容
						var b = $("#focusedInput").attr('dataid');  //id
						if(!checkInput()) return;
						$('#myModal1').modal('show');

					});
					
					//删除设备
					$("#delete").click(function(){
						var b = $("#focusedInput").attr('dataid');  //id
						$.ajax({
		    			type:"POST",
		    			url:"/equipmentTypeJson/delete",
		    			data:{"equipmentTypeId":b},
		    			success:function(msg){
		    				if(msg.code == 0){
		    					 layer.msg('删除成功', {
		    						  icon: 6,
		    						  time: 1000 
		    						}, function(){
		    							$('#myModal').modal('hide');
				    					$('#myModal1').modal('hide');
				    					shuaxin();
		    						});  
		    				}else{
		    					layer.msg(msg.message, {icon: 5});
		    				}
		    			},
		    			error:function(msg){
		    				layer.msg("服务异常,请稍后再试!!!", {icon: 5});
		    			}
		    	     });
					});
					
					
					
					function checkInput(){
						var namego = $("#focusedInput").val();
						if(namego.trim() == ""){
							layer.tips('添加或选择类型不能为空!', '#focusedInput', {
								  tips: 3
							});
							return false;
						}
						return true;
					}
					
					
					
					
					//刷新下拉
					function shuaxin(){
						$.ajax({  
			                type: "POST",   
			                url: "/powerProjectJson/selectQuyuAndProbjectAndType",  
			                dataType: 'json',  
			                success: function(result) {   
			         			
			         			
			         			//设备类别HTML开始
			         			var d =result.data.shebeiType;
			         			var item="<option value='0' selected>选择上级结构</option>";
			         			$.each(d,function(i,result){
//			         				item +='<li>';
//			         				item =item+'<a href="#" onclick="shebeixianze(this)" equipmentTypeId="'+result["equipmentTypeId"]+'"  equipmentTypeName="'+result["equipmentTypeName"]+'">'+(result["equipmentTypeName"]==undefined?'':result["equipmentTypeName"])+'</a>';
//			         				item +='</li>';
			         				item =item+'<option value="'+result["equipmentTypeId"]+'">'+result["equipmentTypeName"]+'</option>';
			         			});
			         			$("#shebei").html(item);
			         			
			                }   
			            });
					}


					function checkForm(){
						if(!toform.equipmentName.value){ layer.msg('设备名称不能为空！'); return false; }

						if(toform.regionId.value==0){ layer.msg('区域名称不能为空！'); return false; }

						if(toform.projectId.value==0){ layer.msg('项目名称不能为空！'); return false; }

						if(toform.equipmentTypeId.value==0){ layer.msg('设备类型不能为空！'); return false; }

						
						return true;

					}
		    
					$('#warrantyTermination').datetimepicker({
			            format:'yyyy-mm-dd',
			            autoclose:true,//自动关闭
			            minView:2,//最精准的时间选择为日期0-分 1-时 2-日 3-月 
			            weekStart:0
			        });
			        $('#installTime').datetimepicker({
			            format:'yyyy-mm-dd',
			            autoclose:true,//自动关闭
			            minView:2,//最精准的时间选择为日期0-分 1-时 2-日 3-月 
			            weekStart:0
			        });
			        $('#enableTime').datetimepicker({
			            format:'yyyy-mm-dd',
			            autoclose:true,//自动关闭
			            minView:2,//最精准的时间选择为日期0-分 1-时 2-日 3-月 
			            weekStart:0
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
