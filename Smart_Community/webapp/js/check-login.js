var ajaxReturnData;
function checkSbumitData(){
	var regEn = /[`~!@#$%^&*()_+<>?:"{},.\/;'[\]]/im,
	regCn = /[·！#￥（——）：；“”‘、，|《。》？、【】[\]]/im;
	var username = document.getElementById("username");
	var password = document.getElementById("password");
	var tipMsg = document.getElementById("tipMsg");
	if(username.value.length>15 || username.value.length==0){
		tipMsg.innerHTML = "用户名不能为空";
		username.style.border = "1px solid red";
		return false;
	
	}else if(regEn.test(username.value) || regCn.test(username.value)){
		tipMsg.innerHTML = "用户名不能包含特殊字符";
		username.style.border = "1px solid red";
		return false;
	}

    username.style.border = "1px solid green";
	if(password.value.length>15 || password.value.length<=0 || password.value.length <6){
		tipMsg.innerHTML = "密码长度为0-6位";
		password.style.border = "1px solid red";
		return false; 
	}else if(regEn.test(password.value) || regCn.test(password.value)){
		tipMsg.innerHTML = "密码不能包含特殊字符";
		password.style.border = "1px solid red";
		return false;
	}
	password.style.border = "1px solid green";
	ajaxCheck(username.value,password.value);
	tipMsg.innerHTML = ajaxReturnData.message;
	if(ajaxReturnData.code!=0){
		return false;
	}
	tipMsg.innerHTML = "";
	
	layer.msg('欢迎光临科技社区管理平台', {
		  icon: 6,
		  time: 2000 
		}, function(){
			var abc = ajaxReturnData.message; 
			location.href=abc;
		});  
	
	return false; 
}

function ajaxCheck(username,password){
	var url = "/userjson/loginToJson"
	$.ajax({
		url:url,
		type:"post",
		data:{'username':username,'password':password},
		async:false,
		success:function(e){
		    ajaxReturnData = e;
		},
		error:function(){   
			alert("系统错误，请稍后再试");
		}
	});
}