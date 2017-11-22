 //上一页
    function start(){
    	var userName=$("#name").val().trim();
    	var userPhone=$("#phone").val().trim();
    	var start = Number($("#start").val())-1;
    	$.ajax({
			type:"post",
			url:"/userjson/userListJson",
			data:{'userName':userName,"userPhone":userPhone,"page":start},
			dataType:"json",
			async:false,
			success:function(msg){
				console.log(msg);
				if( msg.data.pageNum == 0){
					document.getElementById("start").disabled = true;
				}else{
					pinjie(msg);
				}
				
				
			}
	     });

    }
    
    //下一页
    
   	function next(){
   		var userName=$("#name").val().trim();
   		var userPhone=$("#phone").val().trim();
    	 var next = Number($("#next").val())+1;
    	
    	$.ajax({
			type:"post",
			url:"/userjson/userListJson",
			data:{'userName':userName,"userPhone":userPhone,"page":next},
			dataType:"json",
			async:false,
			success:function(msg){
				if(msg.data.pages < msg.data.pageNum){
					document.getElementById("next").disabled = true;
				}else{
					pinjie(msg);
				}
				
				
			}
	     });
    	
    };
    
    
    
  //首页
    function topd(){
    	var userName=$("#name").val().trim();
    	var userPhone=$("#phone").val().trim();
    	var top = $("#top").val();
    	$.ajax({
			type:"post",
			url:"/userjson/userListJson",
			data:{'userName':userName,"userPhone":userPhone,"page":top},
			dataType:"json",
			async:false,
			success:function(msg){
				console.log(msg);
				pinjie(msg);
			}
	     });
    };	
    
    //末页
     function shartdom(){
   		var userName=$("#name").val().trim();
   		var userPhone=$("#phone").val().trim();
    	var end = $("#end").val();
    	$.ajax({
			type:"post",
			url:"/userjson/userListJson",
			data:{"userName":userName,"userPhone":userPhone,"page":end},
			dataType:"json",
			async:false,
			success:function(msg){
				console.log(msg);
				pinjie(msg);
			}
	     });
    };
    
    
    
    
    //模糊查询
    function mohu(){
    	var userName=$("#name").val().trim();
    	var userPhone=$("#phone").val().trim();
    	$.ajax({
			type:"post",
			url:"/userjson/userListJson",
			data:{'userName':userName,"userPhone":userPhone},
			dataType:"json",
			async:false,
			success:function(msg){
				console.log(msg);
				pinjie(msg);
			}
	     });
    };
    
    
    
    //异步刷新拼接数据
    function pinjie(msg){
    	var item="";
		var itemabc="";
		item +='<table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%"><thead><tr><th>#</th><th>用户名</th><th>密码</th><th>真实姓名</th><th>联系方式</th><th>创建时间</th></tr></thead><tbody>';
        $.each(msg.data.list,function(i,result){
        	item +='<tr>';
        	item +='<td><input type="checkbox" value="'+result["userId"]+'" name="chk_uid"></td>';
        	item =item+'<td>'+(result["userName"]==undefined?'':result["userName"])+'</td>';
        	item =item+'<td>'+(result["password"]==undefined?'':result["password"])+'</td>';
        	item =item+'<td>'+(result["realName"]==undefined?'':result["realName"])+'</td>';
        	item =item+'<td>'+(result["userPhone"]==undefined?'':result["userPhone"])+'</td>';
        	item =item+'<td>'+(result["createTime"]==undefined?'':result["createTime"])+'</td>';
        	item +='</tr>';
        	
        });
        var data = msg.data.pageNum;
        itemabc += '</tbody></table>';
        itemabc +=' &nbsp;&nbsp;&nbsp;&nbsp;<button type="button" onclick="topd()" id="top" value="1">首页</button>';
        itemabc += '<button type="button" id="start" onclick="start()" value="'+msg.data.pageNum+'" >上一页</button>';
        itemabc += '<button type="button" id="next" onclick="next()" value="'+msg.data.pageNum+'">下一页</button>';
        itemabc += '<button type="button" id="end" onclick="shartdom()" value="'+msg.data.pages+'">末页</button>';	
        itemabc += '当前第['+msg.data.pageNum+']页共['+msg.data.pages+']页共['+msg.data.total+']条';	
//	        alert(itemabc);	
//	        alert(item+itemabc);
		$("#exampleTwo").html(item+itemabc);
    }
    
   //新增 
    function insertUser(){
    	
    	var uname=$("#uname").val();
    	var pass=$("#pass").val();
    	if((uname.trim() != '' && uname.trim() != null) && (pass.trim() != '' && pass.trim() != null)){

        	var formData = $("#insertFrom").serialize();
        	$.ajax({
    			type:"post",
    			url:"/userjson/insert",
    			data:formData,
    			dataType:"json",
    			async:false,
    			success:function(msg){
    				if(msg.errcode == 0){
    					pinjie(msg);
    					$('#myModal').modal('hide');
    					$(".form-control").val('');
    					alert("新增成功");
    				}else{
    					alert(msg.message);
    				}
    			},
    			error:function(msg){
    				slert("服务异常!!!");
    			}
    	     });
    	}else if(uname.trim() == '' || uname.trim() == null){
    		alert("用户名不能为空!!!");
    	}else if(pass.trim() == '' || pass.trim() == null){
    		alert("密码不能为空!!!");
    	}
    	
    	
    }
    
    
    
    
    
		//删除
		function shanchu(){
		    	
		    	var fruit = new Array();
		    	var chackBox = $("input[name='chk_uid']:checked").val();
		    	if(chackBox == null || chackBox == ""){
		    		alert("请选择要删除的选项!!!");
		    		$('#myModald').modal('hide');
		    	}else{
		    		$("input:checkbox[name='chk_uid']:checked").each(function() {
		    			fruit.push($(this).val()) ;
		    		});
		//     		var fruitto = JSON.stringify(fruit);
		    		$.ajax({
		    			type:"post",
		    			url:"/userjson/deleteUser",
		    			data:{'userId':JSON.stringify(fruit)},
		    			dataType:"json",
		    			async:false,
		    			success:function(msg){
		    				if(msg.errcode == 0){
		    					alert("删除成功");
		    					$('#myModald').modal('hide');
		    					pinjie(msg);
		    				}else{
		    					alert(msg.message);
		    				}
		    			},
		    			error:function(msg){
		    				alert("服务异常!!!");
		    				$('#myModald').modal('hide');
		    			}
		    	     });
		    	}
		    };
    
		   
		    
    //修改时回显
  function updateSelect(){
//     	data-toggle="modal" data-target="#myModalup"
	   	var fruit = new Array();
    	var chackBox = $("input[name='chk_uid']:checked").val();
    	if(chackBox == null || chackBox == ""){
    		alert("请选择要修改的选项!!!");
    		$('#myModalup').modal('hide');
    		$("#rem").removeAttr("data-target");
    		$("#rem").removeAttr("data-toggle");
    		
    	}else{
    		$("input:checkbox[name='chk_uid']:checked").each(function() {
    			fruit.push($(this).val()) ;
    		});
    	
    	if(fruit.length > 1){
    		alert("一次只能修改一个");
    		$('#myModalup').modal('hide');
    		$("#rem").removeAttr("data-target");
    		$("#rem").removeAttr("data-toggle");
    	}else{
    		$("#rem").attr("data-toggle","modal");
    		$("#rem").attr("data-target","#myModalup");


    		$.ajax({
    			type:"post",
    			url:"/userjson/selectOne",
    			data:{'userId':chackBox},
    			dataType:"json",
    			async:false,
    			success:function(msg){
    				if(msg.errcode == 0){
    					$("#userId").val(msg.data.userId);
    					$("#unameup").val(msg.data.userName);
    					$("#passup").val(msg.data.password);
    					$("#realNameup").val(msg.data.realName);
    					$("#userPhoneup").val(msg.data.userPhone);
    				}else{
    					alert(msg.message);
    				}
    			},
    			error:function(msg){
    				alert("服务异常!!!");
    				$('#myModalup').modal('hide');
    			}
    	     });
    	}
    }	
    	
    	
   }
    
    
    //修改
    function xiugai(){
    	var formData = $("#updateFrom").serialize();
    	$.ajax({
			type:"post",
			url:"/userjson/updateOne",
			data:formData,
			dataType:"json",
			async:false,
			success:function(msg){
				if(msg.errcode == 0){
					alert("修改成功");
					$('#myModalup').modal('hide');
					pinjie(msg);
				}else{
					alert(msg.message);
				}
			},
			error:function(msg){
				alert("服务异常!!!");
				$('#myModalup').modal('hide');
			}
	     });
    	
    }