		var curMenu = null, zTree_Menu = null;
		var setting = {
			view: {
				showLine: false,
				showIcon: false,
				selectedMulti: false,
				dblClickExpand: false,
				addDiyDom: addDiyDom
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeClick: beforeClick
			}
		};

		var zNodes =[
//			{ id:1, pId:0, name:"文件夹", open:true},
//			{ id:11, pId:1, name:"收件箱"},
//			{ id:111, pId:11, name:"收件箱1"},
//			{ id:112, pId:111, name:"收件箱2"},
//			{ id:113, pId:112, name:"收件箱3"},
//			{ id:114, pId:113, name:"收件箱4"},
//			{ id:12, pId:1, name:"垃圾邮件"},
//			{ id:13, pId:1, name:"草稿"},
//			{ id:14, pId:1, name:"已发送邮件"},
//			{ id:15, pId:1, name:"已删除邮件"},
//			{ id:3, pId:0, name:"快速视图"},
//			{ id:31, pId:3, name:"文档"},
//			{ id:32, pId:3, name:"照片"}
		];
		
		
		
		function addDiyDom(treeId, treeNode) {
			var spaceWidth = 5;
			var switchObj = $("#" + treeNode.tId + "_switch"),
			icoObj = $("#" + treeNode.tId + "_ico");
			switchObj.remove();
			icoObj.before(switchObj);

			if (treeNode.level > 1) {
				var spaceStr = "<span style='display: inline-block;width:" + (spaceWidth * treeNode.level)+ "px'></span>";
				switchObj.before(spaceStr);
			}
		}

		function beforeClick(treeId, treeNode) {
			if (treeNode.level == 0 ) {
				var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				zTree.expandNode(treeNode);
				return false;
			}
			return true;
		}
		

		$(document).ready(function(){
			var treeObj = $("#treeDemo");
			$.ajax({  
                type: "POST",   
                url: "/powerProjectJson/tree",  
                dataType: 'json',  
                success: function(result) {   
                    var t =result.data.treeList;
                     
         			$.fn.zTree.init(treeObj, setting, t);
         			zTree_Menu = $.fn.zTree.getZTreeObj("treeDemo");
                    curMenu = zTree_Menu.getNodes()[0].children[0];
         			zTree_Menu.selectNode(curMenu);

         			treeObj.hover(function () {
         				if (!treeObj.hasClass("showIcon")) {
         					treeObj.addClass("showIcon");
         				}
         			}, function() {
         				treeObj.removeClass("showIcon");
         			});
         			
         			
         			//上级机构HTML开始
         			var c =result.data.quyu;
         			var item="<option value='0' selected>选择上级结构</option>";
         			$.each(c,function(i,result){
         				//item +='<option>';
         				//item =item+'<a href="#" projectPid="'+result["projectId"]+'"  projectPidName="'+result["projectName"]+'">'+(result["projectName"]==undefined?'':result["projectName"])+'</a>';
         				item =item+'<option value="'+result["projectId"]+'">'+result["projectName"]+'</option>';
         				//item +='</option>';
         			});
         			$("#topStructure").html(item);
         			
         			
         			//项目类型HTML开始
         			var d =result.data.leibie;
         			var item="<option value='0' selected>选择项目类型</option>";
         			$.each(d,function(i,result){
         				item =item+'<option value="'+result["typeId"]+'">'+result["typeName"]+'</option>';
         			});
         			$("#toType").html(item);
         			
                }   
            });
		});
		
		
		//提交新增保存
		$("#baocun").click(function(){
			if(!checkForm()) return; 
			var formData = new FormData($("#toform")[0]);
  
			$.ajax({
    			type:"POST",
    			url:"/powerProjectJson/insert",
    			data:formData,
    			async: false,  
    		    cache: false,  
    		    contentType: false,  
    		    processData: false,
    			success:function(msg){
    				console.log(msg);
    				if(msg.code == 0){
    					layer.msg('新增成功', {
  						  icon: 6,
  						  time: 1000 
  						}, function(){
  							window.location.href="/powerProject/insert";
  						}); 
    					
    				}else{
    					layer.msg(msg.message, {icon: 5});
    				}
    			},
    			error:function(msg){
    				layer.msg("服务异常,请稍后再试", {icon: 5});
    			}
    	     });
			
		});
		
		
		//提交新增保存
		$("#baocun2").click(function(){
			if(!checkForm2()) return; 
			var formData = new FormData($("#toform2")[0]);
  
			$.ajax({
    			type:"POST",
    			url:"/powerProjectJson/insert",
    			data:formData,
    			async: false,  
    		    cache: false,  
    		    contentType: false,  
    		    processData: false,
    			success:function(msg){
    				console.log(msg);
    				if(msg.code == 0){
    					layer.msg('新增成功', {
    						  icon: 6,
    						  time: 1000 
    						}, function(){
    							window.location.href="/powerProject/insert";
    						}); 
    					
    				}else{
    					layer.msg(msg.message, {icon: 5});
    				}
    			},
    			error:function(msg){
    				layer.msg("服务异常,请稍后再试", {icon: 5});
    			}
    	     });
			
		});
		

		function checkForm(){
			var projectName = $("#projectName").val();
			var projectPidName = $("#topStructure").val();
			var projectAddress = $("#projectAddress").val();
			var projectTypeName = $("#toType").val();
			if(projectName==""){
				layer.msg('项目名称不能为空');
				return false;
			}
			if(projectPidName==0){
				layer.msg('上级结构不能为空');
				return false;
			}
			if(projectAddress==""){
				layer.msg('项目地址不能为空');
				return false;
			}
			if(projectTypeName==0){
				layer.msg('项目类型不能为空');
				return false;
			}
			return true;
		}
		
		
		function checkForm2(){
			var projectName = $("#projectName2").val();
			if(projectName==""){
				layer.msg('区域名称不能为空');
				return false;
			}
			return true;
		}
			
			
		$(".chooseType").on('click',function(){
			var type = $(this).attr("data-type");
			$(".chooseOptions").hide();
			$("."+type).show();
		})

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
		
		
		
		
		//加载项目类型列表
		$(".ii").click(function(){
			
			$.ajax({  
                type: "GET",   
                url: "/powerTypeJson/selectLsit",  
                dataType: 'json',  
                success: function(result) {   
         			
         			
         			//上级机构HTML开始
         			var c =result.data;
//         			console.log(c);
         			var item="";
         			$.each(c,function(i,result){
         				item +='<tr>';
         				item +='<td><a href="#" dataname="'+result["typeName"]+'" dataid="'+result["typeId"]+'" onclick="bule(this)">'+result["typeName"]+'</a></td>';
         				item +='</tr>';
         			});
         			$("#table1").html(item);
         			
         			
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

			
			//新增项目类型
			$("#insert").click(function(){
				var a = $("#focusedInput").val(); //内容
				var b = $("#focusedInput").attr('dataid');  //id
				if(!checkInput()) return; 
				$.ajax({
	    			type:"POST",
	    			url:"/powerTypeJson/insert",
	    			data:{"typeName":a},
	    			success:function(msg){
	    				if(msg.code == 0){
	    					layer.msg('添加成功', {
	  						  icon: 6,
	  						  time: 1000 
	  						}, function(){
	  							$('#myModal').modal('hide');
	  							shuaxin();
	  						}); 
	    				}else{
	    					layer.msg(msg.message, {icon: 5});
	    				}
	    			},
	    			error:function(msg){
	    				layer.msg("服务异常,请稍后再试", {icon: 5});
	    			}
	    	     });
			});
			
			
			//修改项目类型
			$("#update").click(function(){
				var a = $("#focusedInput").val(); //内容
				var b = $("#focusedInput").attr('dataid');  //id
				if(!checkInput()) return;
				$.ajax({
	    			type:"POST",
	    			url:"/powerTypeJson/update",
	    			data:{"typeId":b,"typeName":a},
	    			success:function(msg){
	    				if(msg.code == 0){
	    					layer.msg('修改成功', {
		  						  icon: 6,
		  						  time: 1000 
		  						}, function(){
			    					$('#myModal').modal('hide');
			    					shuaxin();
		  						}); 
	    				}else{
	    					layer.msg(msg.message, {icon: 5});
	    				}
	    			},
	    			error:function(msg){
	    				layer.msg("服务异常,请稍后再试", {icon: 5});
	    			}
	    	     });
			});
			
			
			//删除项目弹出
			$("#del").click(function(){
				var a = $("#focusedInput").val(); //内容
				var b = $("#focusedInput").attr('dataid');  //id
				if(!checkInput()) return;
				$('#myModal1').modal('show');

			});
			
			//删除项目
			$("#delete").click(function(){
				var b = $("#focusedInput").attr('dataid');  //id
				$.ajax({
    			type:"POST",
    			url:"/powerTypeJson/deleteOne",
    			data:{"typeId":b},
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
    				layer.msg("服务异常,请稍后再试", {icon: 5});
    			}
    	     });
			});
			
			
			function checkInput(){
				var namego = $("#focusedInput").val();
				if(namego.trim() == ""){
					layer.msg('添加或选择类型不能为空');
					return false;
				}
				return true;
			}
			
			
			//刷新下拉
			function shuaxin(){
				$.ajax({  
	                type: "POST",   
	                url: "/powerProjectJson/tree",  
	                dataType: 'json',  
	                success: function(result) {   
	         			
	         			
	         			//项目类型HTML开始
	         			var d =result.data.leibie;
	         			var item="<option value='0' selected>选择项目类型</option>";
	         			$.each(d,function(i,result){
	         				item =item+'<option value="'+result["typeId"]+'">'+result["typeName"]+'</option>';
	         			});
	         			$("#toType").html(item);
	         			
	                }   
	            });
			}
			