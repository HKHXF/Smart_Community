<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
</head>
<body>
<!-- ${PageInfo} -->
<br>
--------数据表格-------
<br>
				<#if PageInfo.list ??>
				
						  <table align="center" width="95%" border="1" cellpadding="2" cellspacing="1" >
								   
												  <tr>
												    <th>用户名</th>
												    <th>密码</th>
												    <th>性别</th>
												    <th>权限</th>
												    <th>创建时间</th>
												  </tr>
								   <#list PageInfo.list as item>
												  <tr>
												    <td>${item.userName}</td>
												    <td>${item.password}</td>
												    <td>${item.age}</td>
												    <td>${item.useReal}</td>
												    <td>${item.createTime}</td>
												  </tr>
								   </#list>
						 </table>
				
				</#if>
<div>
<br>
<button type="button" id="top" value="1">首页</button>
<#if PageInfo.pageNum lte 1>
<button type="button" id="start" value="${PageInfo.pageNum}" disabled="true">上一页</button>
<#else>
<button type="button" id="start" value="${PageInfo.pageNum}" >上一页</button>
</#if>

<#if PageInfo.pageNum gte PageInfo.pages>
<button type="button" id="next" value="${PageInfo.pageNum}" disabled="true">下一页</button>
<#else>
<button type="button" id="next" value="${PageInfo.pageNum}">下一页</button>
</#if>
<button type="button" id="end" value="${PageInfo.pages}">末页</button>

当前第[${PageInfo.pageNum}]页
共[${PageInfo.pages}]页
共[${PageInfo.total}]条数据	

<br>
<br>
<!-- <shiro:principal property="userName"/>  -->
<!-- <@shiro.principal property="name" /> -->
<!-- <@shiro.user> -->
<!-- <shiro:guest> -->
<shiro:hasRole name="admin"> 
<div>管理员可见</div>
</shiro:hasRole>

<shiro:hasRole name="user">
<div>普通用户可见</div>
</shiro:hasRole>

<shiro:hasRole name="testuser">
<div>测试用户可见</div>
</shiro:hasRole>


<script type="text/javascript">

    //首页
    $("#top").click(function(){
    	var top = $("#top").val();
    	window.location.href="/user/SelectMohuFreemarker?page="+top;
    })
    
    //上一页
    $("#start").click(function(){
    	var start = Number($("#start").val())-1;
    	window.location.href="/user/SelectMohuFreemarker?page="+start;
    })
    
    //下一页
     $("#next").click(function(){
    	 var next = Number($("#next").val())+1;
    	window.location.href="/user/SelectMohuFreemarker?page="+next;
//     	$.ajax({
// 	     url:"/user/SelectMohuFreemarker",
// 	     type:"get",
// 	     data:{userName:"h",page:next},
// 	     success:function(data){
// 	    	 alert(data.PageInfo);
// 	//             window.clearInterval(timer);
// 	//             console.log("over..");
	
// 	     alert("success");
// 	     },
// 	     error:function(e){
// 	         alert("错误！！");
// 	//             window.clearInterval(timer);
// 	     }
//  });       
    })
    
    //末页
    $("#end").click(function(){
    	var end = $("#end").val();
    	window.location.href="/user/SelectMohuFreemarker?page="+end;
    })
    
</script>
</div>
</table>
</body>
</html>