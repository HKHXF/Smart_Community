//初始数据配置
var phpLocal = 0;
if(phpLocal) var wycLocal = "http://localhost?apiUrl=http://192.168.10.182";
if(!phpLocal) var wycLocal = "";
var projectId,regionId,page=1,interfaceUrl=wycLocal+"/StaffInformationJson/queryList";
/**
 * filter 排序筛选
 * @param  string type 筛选方式
 * @param  int val  筛选值
 */
function filter(type,val){
    if(type="orderType") orderType = val;
    getAjaxPageList();
}

/**
 * [oprationLoadDataPre 配置请求页码
 * @param  int page 请求页码
 */
function oprationLoadDataPre(currPage){
    page = currPage;
    getAjaxPageList();
}

/**
 * selectChoose 下拉筛选
 * @param  String type 筛选方式
 * @param  obj  then 当前对象
 */
function selectChoose(type,then){
    var id = $(then).attr("data-ProjectId");
    var name = $(then).attr("data-ProjectName");
    $("."+type).val(name);
    if(type=="projectSelect") projectId=id;
    if(type=="areaSelect") regionId=id;
    getAjaxPageList();
}

/**
 * getAjaxPageList 请求接口入口
 * @param  string url       接口地址
 */
function getAjaxPageList() {
    $.ajax({
        type: "GET",
        url: interfaceUrl,
        data: {'page': page,"projectId":projectId,"regionId":regionId},
        async:false,
        dataType: 'json',
        beforeSend: function () {
           console.log("正在加载中···");
           layer.load(2);
        },
        success: function (dataObj) {
            if(!dataObj) return;
            makeList(dataObj);
        },
        complete: function(){
        	layer.closeAll();
        }
    })
}

/**
 * makeList 数据中专分发站
 * @param  obj obj 数据体
 */
function makeList(obj){
    if(obj.data){
        leibie(obj.data);
    }
    if(obj.data.staffInformationList){
        list(obj.data.staffInformationList);
    }
    

}

/**
 * list 列表生成
 * @param  obj obj 数据体
 */
function list(obj){
    var html = '<tr>'+
                    '<td class="number"></td>'+
                    '<td>value.staffName</td>'+
                    '<td>value.projectName</td>'+
                    '<td>value.regionName</td>'+
                    '<td>value.age</td>'+
                    '<td>value.position</td>'+
                    '<td>value.contactInformation</td>'+
                    '<td><a href="#" staffId="value.staffId" onclick="xiugaiss(this)" class="i_green"><i class="glyphicon glyphicon-pencil" style="color: #5cc0c0;"></i>编辑</a>'+
                    '<a href="#" class="i_red" staffId="value.staffId" onclick="deletes(this)" ><i class="glyphicon glyphicon-remove-sign" style="color: #ff8888; padding-left:10px;"></i>删除</a>'+
                    '</td>'+
                '</tr>';
   var dataArr = ["staffId","staffName","projectId","regionId","age","position","contactInformation","projectName","regionName","createTime","updateTime"];
    var htmlR = replace_str_pre(obj.list,html,dataArr);
    $('#HtmlList').html(htmlR);
    numberLoad();
    paging(obj);

}











/**
 * leibie 下拉框数据生成
 * @param  obj obj 数据体
 */
function leibie(obj){

    var areaSelect = $("#areaSelect");
    var projectSelect = $("#projectSelect");
    
    if(obj.probject){
        var structure = ["projectId","projectName"];
        var html = '<li><a onclick="selectChoose(\'projectSelect\',this)" data-projectId="value.projectId" data-projectName="value.projectName">value.projectName</a></li>';
        var htmlR = replace_str_pre(obj.probject,html,structure);
        var preHtmlR = '<li><a onclick="selectChoose(\'projectSelect\',this)" data-projectId="" data-projectName="请选择">请选择</a></li>';
        projectSelect.html(preHtmlR+htmlR);
    }
    if(obj.quyu){
        var structure = ["projectId","projectName"];
        var html = '<li><a onclick="selectChoose(\'areaSelect\',this)" data-projectId="value.projectId" data-projectName="value.projectName">value.projectName</a></li>';
        var htmlR = replace_str_pre(obj.quyu,html,structure);
        var preHtmlR = '<li><a onclick="selectChoose(\'areaSelect\',this)" data-projectId="" data-projectName="请选择">请选择</a></li>';
        areaSelect.html(preHtmlR+htmlR);
    }
    
}
function replace_str_pre(obj,str,structure){
    var html_str = "";
    for(var i in obj){
        html_str += replace_str(obj[i],str,structure);
    }
    return html_str;
}
function replace_str(obj,str,structure){
    for(var i in structure){
        var reString = obj[structure[i]];
        if(!obj[structure[i]]) reString = "";
        str = str.replace(new RegExp('value.'+structure[i], 'g'), reString);
    }
    return str;
}
/**
 * paging 分页数据生成
 * @param  obj data 数据体
 */
function paging(data){
    var total = data.pages
    var pageNum = data.pageNum;
    var pageHtml = "";
    var leftOmit = 0;
    var rightOmit = 0;
    var nextPage = data.nextPage;
    var prePage = data.prePage;
    page = data.pageNum;
    if(pageNum>1) pageHtml += "<li><a onclick='oprationLoadDataPre("+prePage+")' href='javascript:;'>&laquo;</a></li>";
    if(total>6 && pageNum>3){
        pageHtml += "<li><a class='disabled' href='javascript:;'>···</a></li>";
    }
    for(var i=1;i<=total;i++){
        if(i==pageNum)
        {
            pageHtml += "<li class='paging active'><a href='javascript:;'>"+i+"</a></li>";
        }else{
            if(pageNum>3 && pageNum-3>=i){
                continue;
            }
            else if(total-pageNum>3 && pageNum+3<=i){
                continue
            }else{
                pageHtml += "<li onclick='oprationLoadDataPre("+i+")' class='paging'><a href='javascript:;'>"+i+"</a></li>";
            }
        }
    }
    if(total>6 && total-pageNum>3){
        pageHtml += "<li><a class='disabled' href='javascript:;'>···</a></li>";
    }
    if(pageNum<total) pageHtml += "<li><a onclick='oprationLoadDataPre("+nextPage+")' href='javascript:;'>&raquo;</a></li>";
    $(".pagination").html(pageHtml);
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
getAjaxPageList();





    //新增职员

    $("#xinzeng").click(function(){
    	
    	
		$.ajax({  
            type: "POST",   
            url: "/StaffInformationJson/toquyuandxiangmu",  
            dataType: 'json',  
            success: function(result) {   
     			
     			
     			//区域HTML开始
     			var c =result.data.quyu;
     			var item="<option value='0' selected>选择区域</option>";
     			$.each(c,function(i,result){
     				item =item+'<option value="'+result["projectId"]+'">'+result["projectName"]+'</option>';
     			});
     			$("#toquyu").html(item);
     			
     			
     			//项目HTML开始
     			var d =result.data.probject;
     			var item="<option value='0' selected>选择项目</option>";
     			$.each(d,function(i,result){
     				item =item+'<option value="'+result["projectId"]+'">'+result["projectName"]+'</option>';
     			});
     			$("#toxiangmu").html(item);
     			
     			
            }   
        });
    	
    	$("#myModal22").modal("show");
    	
    });

    
    
    
    
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
     			var item="<option value='0' selected>选择项目</option>";
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
	
	
	
	//新增职员
	$("#baocun").click(function(){
		
		var formData = new FormData($("#toform")[0]);
		if(!checkFormto()) return; 
		$.ajax({
			type:"POST",
			url:"/StaffInformationJson/insert",
			data:formData,
			async: false,  
		    cache: false,  
		    contentType: false,  
		    processData: false,
			success:function(msg){
//				console.log(msg);
				if(msg.code == 0){
					  layer.msg('新增成功', {
						  icon: 6,
						  time: 1000 
						}, function(){
							window.location.href="/powerProject/zhiyuanxinxi";
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
	

function checkFormto(){
		
		var quyu = $('#toquyu option:selected').val();//选中的值
		
		var xiangmu = $('#toxiangmu option:selected').val();//选中的值
		
		var position = $('#position option:selected').val();//选中的值
		
		var staffName = $("#staffName").val();
		
		var file = $("#upFiles").val();
		if(quyu == 0){
			layer.tips('区域名称不能为空', '#toquyu');
			return false;
		}
		if(xiangmu == 0){
			layer.tips('项目名称不能为空', '#toxiangmu');
			return false;
		}
		if(position == 0){
			layer.tips('职位名称不能为空', '#position');
			return false;
		}
		if(staffName.trim() == ""){
			layer.tips('姓名不能为空', '#staffName');
			return false;
		}
		return true;
	}




function checkFormto2(){
	
	var quyu = $('#toquyu1 option:selected').val();//选中的值
	
	var xiangmu = $('#toxiangmu1 option:selected').val();//选中的值
	
	var position = $('#position1 option:selected').val();//选中的值
	
	var staffName = $("#staffName1").val();
	
	var file = $("#upFiles").val();
	if(quyu == 0){
		layer.tips('区域名称不能为空', '#toquyu1');
		return false;
	}
	if(xiangmu == 0){
		layer.tips('项目名称不能为空', '#toxiangmu1');
		return false;
	}
	if(position == 0){
		layer.tips('职位名称不能为空', '#position1');
		return false;
	}
	if(staffName.trim() == ""){
		layer.tips('姓名不能为空', '#staffName1');
		return false;
	}
	return true;
}



     //修改职员信息
     function xiugaiss(go){
    	 var staffId = $(go).attr('staffId');
    	 $("#myModal08").modal("show");
    	 
    	 $.ajax({  
             type: "POST",   
             url: "/StaffInformationJson/toquyuandxiangmu",  
             dataType: 'json',  
             success: function(result) {   
      			
      			
      			//区域HTML开始
      			var c =result.data.quyu;
      			var item="<option value='0' selected>选择区域</option>";
      			$.each(c,function(i,result){
      				item =item+'<option value="'+result["projectId"]+'">'+result["projectName"]+'</option>';
      			});
      			$("#toquyu1").html(item);
      			
      			
      			//项目HTML开始
      			var d =result.data.probject;
      			var item="<option value='0' selected>选择项目</option>";
      			$.each(d,function(i,result){
      				item =item+'<option value="'+result["projectId"]+'">'+result["projectName"]+'</option>';
      			});
      			$("#toxiangmu1").html(item);
      			
      			fuzhi(staffId);
             }   
         });
    	 
    	 
    	 
    	 
    	 //修改页面初始化
    	 function fuzhi(staffId){
    		 
        	 $.ajax({
      			type:"POST",
      			url:"/StaffInformationJson/selectOne",
      			data:{"staffId":staffId},
      			beforeSend: function () {
      	           console.log("正在加载中···");
      	           layer.load(2);
      	        },
      			success:function(msg){
      				if(msg.code == 0){
      					
      					$("#staffName1").val(msg.data.staffName);
      					$("#age1").val(msg.data.age);
      					$("#contactInformation1").val(msg.data.contactInformation);
      					$("#staffId1").val(msg.data.staffId);
      					
      					//区域
      					var d =msg.data;
              			var select = document.getElementById("toquyu1");
              			for(var i=0; i<select.options.length; i++){  
              		        if(select.options[i].value == d.regionId){  
              		            select.options[i].selected = true;  
              		            break;  
              		        }  
              		    }  
              			
              			
              			//项目
      					var v =msg.data;
              			var select = document.getElementById("toxiangmu1");
              			for(var i=0; i<select.options.length; i++){  
              		        if(select.options[i].value == v.projectId){  
              		            select.options[i].selected = true;  
              		            break;  
              		        }  
              		    }  
              			
              			
              			
              			//职位
      					var c =msg.data;
              			var select = document.getElementById("position1");
              			for(var i=0; i<select.options.length; i++){  
              		        if(select.options[i].value == c.position){  
              		            select.options[i].selected = true;  
              		            break;  
              		        }  
              		    } 
      					
      					
      				}else{
      					layer.msg(msg.message, {icon: 5});
      				}
      			},
      			error:function(msg){
      				layer.msg('服务异常,请稍后再试', {icon: 5});
      			},
      			complete: function(){
      	        	layer.closeAll();
      	        }
      	     }); 
    		 
    	 }
    	
    	 
     }
     
     
     
     
     
     
   //修改点击区域
 	$("#toquyu1").change(function(){ 
 		
 		var selelct = document.getElementById("toquyu1");
 		var projectId = selelct.value;
 		
 		$.ajax({
 			type: "POST",   
             url: "/powerProjectJson/selectProbjectByQuyu",  
             dataType: 'json',
             data:{"projectId":projectId},
             success: function(result) {   
      			
      			
             	//项目HTML开始
      			var d =result.data;
      			var item="<option value='0' selected>选择项目</option>";
      			$.each(d,function(i,result){
      				item =item+'<option value="'+result["projectId"]+'">'+result["projectName"]+'</option>';
      			});
      			$("#toxiangmu1").html(item);
      			
             }   
 		});
 		
 	});
    

 	
 	
     //修改点击项目
 	$("#toxiangmu1").change(function(){ 
 		
 		var option = document.getElementById("toxiangmu1");
 		var projectId = option.value;
 		
 		$.ajax({
 			type: "POST",   
             url: "/powerProjectJson/selectQuyuByProject",  
             dataType: 'json',
             data:{"projectId":projectId},
             success: function(result) {   
      			
      			
             	//项目HTML开始
      			var d =result.data;
      			var select = document.getElementById("toquyu1");
      			for(var i=0; i<select.options.length; i++){  
      		        if(select.options[i].value == d.projectId){  
      		            select.options[i].selected = true;  
      		            break;  
      		        }  
      		    }  
      			
      			
             }   
 		});
 		
 	});

 	
 	//修改职员信息
 	$("#xiugaigo").click(function(){
 		
 		var formData = new FormData($("#toform2")[0]);
		if(!checkFormto2()) return; 
		$.ajax({
			type:"POST",
			url:"/StaffInformationJson/update",
			data:formData,
			async: false,  
		    cache: false,  
		    contentType: false,  
		    processData: false,
			success:function(msg){
				if(msg.code == 0){
					  layer.msg('修改成功', {
						  icon: 6,
						  time: 1000 
						}, function(){
							window.location.href="/powerProject/zhiyuanxinxi";
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
 	
 	
 	
 	//删除弹窗
 	function deletes(to){
   	 var staffId = $(to).attr('staffId');
	 $("#myModal").modal("show");

	 $("#deyo").click(function(){
		 
		 $.ajax({
				type:"POST",
				url:"/StaffInformationJson/delete",
				data:{"staffId":staffId},
				success:function(msg){
					if(msg.code == 0){
						  layer.msg('删除成功', {
							  icon: 6,
							  time: 1000 
							}, function(){
								window.location.href="/powerProject/zhiyuanxinxi";
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
	 
 		
 	}
 	
 	
 	
 	//导出文件
 	$("#daochu").click(function(){
 		
 		var a ;
 		var b ;
 			if(typeof(projectId)=="undefined"){
 				a = "";
 			}else{
 				a=projectId;
 			}
 			if(typeof(regionId)=="undefined"){
 				b = "";
 			}else{
 				b=regionId;
 			}
 			
 		window.location.href="/StaffInformationController/export?page="+page+"&projectId="+a+"&regionId="+b;
 		
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

