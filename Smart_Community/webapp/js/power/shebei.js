
//初始数据配置
var phpLocal = 0;
if(phpLocal) var wycLocal = "http://localhost?apiUrl=http://hexiangfeng.s1.natapp.cc";
if(!phpLocal) var wycLocal = "";
var equipmentName,orderType,equipmentTypeId,regionId,page=1,interfaceUrl=wycLocal+"/equipmentIedgerJson/querylist";
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

function searchName(){
	equipmentName = $("#keywords").val();
	if(!equipmentName){
		layer.tips('搜索名称不能为空！', '#keywords', {
			  tips: 3
			});
		return;
	}
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
        data: {'page': page,"equipmentTypeId":equipmentTypeId,"regionId":regionId,"equipmentName":equipmentName},
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
        complete:function(){
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
    if(obj.data.equipmentIedgerList){
    	list(obj.data.equipmentIedgerList);
    }
    

}

/**
 * list 列表生成
 * @param  obj obj 数据体
 */
function list(obj){
	var html = '<tr>'+
					'<td class="number"></td>'+
					'<td>value.equipmentName</td>'+
					'<td>value.unitModel</td>'+
					'<td>value.factoryNumber</td>'+
					'<td>value.manufacturer</td>'+
					'<td>value.gomanufacturerAddress</td>'+
					'<td>value.contactNumber</td>'+
					'<td>value.enableTime</td>'+
					'<td><a href="/equipmentIedger/selectOne?equipmentIedgerId=value.equipmentIedgerId" class="i_green" ><i class="glyphicon glyphicon-info-sign" style="color: #5cc0c0;"></i>详情</a>'+
					'<a href="#" equipmentIedgerId="value.equipmentIedgerId" onclick="deleteHandler(this)" class="i_red"><i class="glyphicon glyphicon-remove-sign" style="color: #ff8888; padding-left:10px;"></i>删除</a>'+
					'</td>'+
				'</tr>';
    var dataArr = ["equipmentName","unitModel","factoryNumber","manufacturer","gomanufacturerAddress","contactNumber","enableTime","equipmentIedgerId"];       
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
	var typeSelect = $("#typeSelect");
    
	if(obj.shebeiType && !equipmentTypeId){
        var structure = ["equipmentTypeId","equipmentTypeName"];
		var html = '<option value="value.equipmentTypeId">value.equipmentTypeName</option>';
		var htmlR = replace_str_pre(obj.shebeiType,html,structure);
		var preHtmlR = '<option  value="">请选择</option>';
		typeSelect.html(preHtmlR+htmlR);
	}
	if(obj.quyu && !regionId){
        var structure = ["projectId","projectName"];
		var html = '<option value="value.projectId">value.projectName</option>';
		var htmlR = replace_str_pre(obj.quyu,html,structure);
		var preHtmlR = '<option value="">请选择</option>';
		areaSelect.html(preHtmlR+htmlR);
	}
}


/**
 * selectChoose 下拉筛选
 * @param  String type 筛选方式
 * @param  obj  then 当前对象
 */
function selectChoose(then){
	var type=then.getAttribute("data-type");
	var id=$(then).val();
	var name=$(then).html();
	if(type=="typeSelect") equipmentTypeId=id;
	if(type=="areaSelect") regionId=id;
	getAjaxPageList();
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
    var total = data.pages;
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






//列表删除
function deleteHandler(go){
	
	$("#myModal2").modal('show');
	//删除列表
	$("#deleteList").click(function(){
		var a = $(go).attr('equipmentIedgerId');  //id
		$.ajax({
			type:"POST",
			url:"/equipmentIedgerJson/delete",
			data:{"equipmentIedgerId":a},
			success:function(msg){
				if(msg.code == 0){
					layer.msg('删除成功', {
						  icon: 6,
						  time: 1000 
						}, function(){
							window.location.href="/homepage/shebei";
						});   
				}
			},
			error:function(msg){
				layer.msg('服务异常,请稍后再试', {icon: 5});
			}
	     });
	});
}




//excel导出文件
$("#excel").click(function(){
	var a ;
	var b ;
	var c ;
		if(typeof(regionId)=="undefined"){
			a = "";
		}else{
			a=regionId;
		}
		if(typeof(equipmentTypeId)=="undefined"){
			b = "";
		}else{
			b=equipmentTypeId;
		}
		
		if(typeof(equipmentName)=="undefined"){
			c = "";
		}else{
			c=equipmentName;
		}
	window.location.href="/equipmentIedger/export?page="+page+"&regionId="+a+"&equipmentTypeId="+b+"&equipmentName="+c;
	
});




    //导入excel
    $("#daoru").click(function(){
    	

		$.ajax({
			type: "POST",   
            url: "/equipmentIedgerJson/queryQuyuName",  
            dataType: 'json',
            beforeSend: function () {
             	layer.load(2);
             },
            success: function(result) {   
     			
     			
            	//区域HTML开始
     			var d =result.data.quyu;
     			var item="<option value='0' selected>选择区域</option>";
     			$.each(d,function(i,result){
     				item =item+'<option value="'+result["projectId"]+'">'+result["projectName"]+'</option>';
     			});
     			$("#toquyu").html(item);
     			
     			//项目开始
     			var d =result.data.probject;
     			var item="<option value='0' selected>选择项目</option>";
     			$.each(d,function(i,result){
     				item =item+'<option value="'+result["projectId"]+'">'+result["projectName"]+'</option>';
     			});
     			$("#toxiangmu").html(item);
     			
            },
            complete:function(){
            	layer.closeAll();
            }   
		});
    	
    	$('#myModal').modal('show');
    	
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

	
	
	
	
	//批量导入设备信息开始
	$("#toExcel").click(function(){
		if(!checkForm2()) return; 
		var formData = new FormData($("#toform")[0]);
		  
		$.ajax({
			type:"POST",
			url:"/equipmentIedgerJson/daoruExcel",
			data:formData,
			async: false,  
		    cache: false,  
		    contentType: false,  
		    processData: false,
            beforeSend: function () {
            	layer.msg('正在导入,请稍后', {
          		  icon: 16
          		  ,shade: 1
          		});
             },
			success:function(msg){
				if(msg.code == 0){
					layer.msg('导入成功', {
						  icon: 6,
						  time: 1000 
						}, function(){
							$('#myModal').modal('hide');
							window.location.href="/homepage/shebei";
						}); 
				}else{
					layer.msg(msg.message, {icon: 5});
//					alert(msg.message);
				}
			},
			error:function(msg){
				layer.msg('服务异常,请稍后再试', {icon: 5});
//				alert("服务异常,请稍后再试");
			},complete:function(){
            	layer.closeAll();
            }  
	     });
		
	});
		

	
	function checkForm2(){
		
		var quyu = $('#toquyu option:selected').val();//选中的值
		
		var xiangmu = $('#toxiangmu option:selected').val();//选中的值
		
		var file = $("#upFiles").val();
		if(quyu == 0){
			layer.tips('区域名称不能为空', '#toquyu');
			return false;
		}
		if(xiangmu == 0){
			layer.tips('项目名称不能为空', '#toxiangmu');
			return false;
		}
		if(file[1] == null){
			layer.tips('请选择文件', '#upFiles');
			return false;
		}
		return true;
	}
	
	
	
	
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
	


