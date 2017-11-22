
//初始数据配置
var orderType,projectType,projectPid,page=1,interfaceUrl="/powerProjectJson/selectqueryList";
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
	if(type=="typeSelect") projectType=id;
	if(type=="areaSelect") projectPid=id;
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
        data: {'page': page,"projectType":projectType,"projectPid":projectPid,"orderType":orderType},
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
    if(obj.data.list){
    	list(obj.data.list);
    }
    

}

/**
 * list 列表生成
 * @param  obj obj 数据体
 */
function list(obj){
	var html = "<tr>"+
					"<td class='number'></td>"+
					"<td class='test'>value.projectName</td>"+
					"<td>value.proName</td>"+
					"<td>value.projectArea</td>"+
					"<td>value.conditionerArea</td>"+
					"<td>value.trusteeshipTime</td>"+
					"<td>value.expireTime</td>"+
					"<td>value.contractLife</td>"+
					"<td>value.energyPrice</td>"+
					"<td>value.chargingArea</td>"+
					"<td><a href='/powerProject/xiangqing?projectId=value.projectId' class='i_green'><i class='glyphicon glyphicon-info-sign' style='color: #5cc0c0;'></i>详情</a>"+
					"<a href='#' projectId='value.projectId' onclick='deleteHandler(this)' class='i_red'><i class='glyphicon glyphicon-remove-sign' style='color: #ff8888; padding-left:10px;'></i>删除</a>"+
					"</td>"+
				"</tr>";
    var dataArr = ["projectName","projectAddress","chargingArea","conditionerArea","trusteeshipTime","expireTime","contractLife","electricPrice","energyPrice","projectId","projectArea","proName"];           
	var htmlR = replace_str_pre(obj.list,html,dataArr);
	console.log(obj.list);
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
    
	if(obj.leibie){
        var structure = ["typeId","typeName"];
		var html = '<li><a onclick="selectChoose(\'typeSelect\',this)" data-projectId="value.typeId" data-projectName="value.typeName">value.typeName</a></li>';
		var htmlR = replace_str_pre(obj.leibie,html,structure);
        var preHtmlR = '<li><a onclick="selectChoose(\'typeSelect\',this)" data-projectId="" data-projectName="请选择">请选择</a></li>';
		typeSelect.html(preHtmlR+htmlR);
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


//'page': page,"projectType":projectType,"projectPid":projectPid,"orderType":orderType

///powerProject/export


//excel导出文件
$("#excel").click(function(){
	var a ;
	var b ;
	var c ;
		if(typeof(projectType)=="undefined"){
			a = "";
		}else{
			a=projectType;
		}
		if(typeof(projectPid)=="undefined"){
			b = "";
		}else{
			b=projectPid;
		}
		
		if(typeof(orderType)=="undefined"){
			c = "";
		}else{
			c=orderType;
		}
	window.location.href="/powerProject/export?page="+page+"&projectType="+a+"&projectPid="+b+"&orderType="+c;
	
});



function bule(aaa){
	  var td = $(aaa).attr('dataid');
	  var bb = $(aaa).attr('dataname');
	  $("#focusedInput").val(bb);
	  $("#focusedInput").attr("dataid",td);
	}


            //查看所有区域
			$("#quyu").click(function(){
				
				$.ajax({
					type:"GET",
					url:"/powerProjectJson/selectQuyu",
					success:function(msg){
						if(msg.code == 0){
							
							//上级机构HTML开始
		         			var c =msg.data;
		         			var item="";
		         			$.each(c,function(i,result){
		         				item +='<tr>';
		         				item +='<td><a href="#" dataname="'+result["projectName"]+'" dataid="'+result["projectId"]+'" onclick="bule(this)">'+result["projectName"]+'</a></td>';
		         				item +='</tr>';
		         			});
		         			$("#table1").html(item);
		         			$('#myModal').modal('show');
						}
					},
					error:function(msg){
						layer.msg('服务异常,请稍后再试', {icon: 5});
					}
			     });
				
				$("#focusedInput").removeAttr("dataid");
				$("#focusedInput").val("");
				
			});
			
			
			
			
			
			
			
			
			//新增项目区域
			$("#insert").click(function(){
				var a = $("#focusedInput").val(); //内容
				var b = $("#focusedInput").attr('dataid');  //id
				if(!checkInput()) return; 
				$.ajax({
	    			type:"POST",
	    			url:"/powerProjectJson/insert",
	    			data:{"projectName":a,"type":1,"projectPid":1},
	    			success:function(msg){
	    				if(msg.code == 0){
	    					layer.msg('新增成功', {
	  						  icon: 6,
	  						  time: 1000 
	  						}, function(){
	  							$('#myModal').modal('hide');
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
			
			
			//修改项目区域
			$("#update").click(function(){
				var a = $("#focusedInput").val(); //内容
				var b = $("#focusedInput").attr('dataid');  //id
				if(!checkInput()) return;
				$.ajax({
	    			type:"POST",
	    			url:"/powerProjectJson/update",
	    			data:{"projectId":b,"projectName":a},
	    			success:function(msg){
	    				if(msg.code == 0){
	    					layer.msg('修改成功', {
		  						  icon: 6,
		  						  time: 1000 
		  						}, function(){
		  							$('#myModal').modal('hide');
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
			
			
			//删除区域弹出
			$("#del").click(function(){
				var a = $("#focusedInput").val(); //内容
				var b = $("#focusedInput").attr('dataid');  //id
				if(!checkInput()) return;
				$('#myModal1').modal('show');

			});
			
			//删除区域
			$("#delete").click(function(){
				var b = $("#focusedInput").attr('dataid');  //id
				$.ajax({
    			type:"POST",
    			url:"/powerProjectJson/delete",
    			data:{"projectId":b},
    			success:function(msg){
    				if(msg.code == 0){
    					layer.msg('删除成功', {
	  						  icon: 6,
	  						  time: 1000 
	  						}, function(){
	  							$('#myModal1').modal('hide');
	  	    					$('#myModal').modal('hide');
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
					layer.msg("添加或选择类型不能为空", {icon: 5});
					return false;
				}
				return true;
			}
			
			
			
			//列表删除
			function deleteHandler(go){
				$("#myModal2").modal('show');
				//删除列表
				$("#deleteList").click(function(){
					var a = $(go).attr('projectId');  //id
					$.ajax({
		    			type:"POST",
		    			url:"/powerProjectJson/delete",
		    			data:{"projectId":a},
		    			success:function(msg){
		    				if(msg.code == 0){
		    					layer.msg('删除成功', {
			  						  icon: 6,
			  						  time: 1000 
			  						}, function(){
			  							window.location.href="/homepage/xmGuanli";
			  						}); 
		    					
		    				}
		    			},
		    			error:function(msg){
		    				layer.msg("服务异常,请稍后再试", {icon: 5});
		    			}
		    	     });
				});
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
			
			
			
			//点击世界地图
			$("#ditu").click(function(){
				
				window.location.href="/powerProject/mapWord";
				
			});
			
			