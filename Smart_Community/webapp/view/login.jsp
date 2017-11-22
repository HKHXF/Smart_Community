<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js">
<!--<![endif]-->

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>SpaceLab</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <!-- Favicon -->
    <link rel="shortcut icon" href="/assets/img/favicon.ico" type="image/x-icon">
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="/assets/plugins/bootstrap/css/bootstrap.min.css">
    <!-- Fonts from Font Awsome -->
    <link rel="stylesheet" href="/assets/css/font-awesome.min.css">
    <!-- CSS Animate -->
    <link rel="stylesheet" href="/assets/css/animate.css">
    <!-- Custom styles for this theme -->
    <link rel="stylesheet" href="/assets/css/main.css">
    <!-- Fonts -->
    <!-- <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,900,300italic,400italic,600italic,700italic,900italic' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'> -->
    <!-- Feature detection -->
    <script type="text/javascript" src="/js/jquery-1.10.2.min.js"></script>
    <script src="/assets/js/modernizr-2.6.2.min.js"></script>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="assets/js/html5shiv.js"></script>
    <script src="assets/js/respond.min.js"></script>
    <![endif]-->
</head>

<body>
    <section id="login-container">

        <div class="row">
            <div class="col-md-3" id="login-wrapper">
                <div class="panel panel-primary animated flipInY">
                    <div class="panel-heading">
                        <h3 class="panel-title">
                            Sign In
                        </h3>
                    </div>
                    <div class="panel-body">
                        <p>Login to access your account.</p>
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <div class="col-md-12">
                                    <input type="email" class="form-control" id="email" placeholder="Name">
                                    <i class="fa fa-user"></i>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12">
                                    <input type="password" class="form-control" id="password" placeholder="Password">
                                    <i class="fa fa-lock"></i>
                                    <a href="javascript:void(0)" class="help-block">login to type</a>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12">
                                    <a href="javascript:void(0)" id="into" class="btn btn-primary btn-block">Sign in</a>
                                    <hr />
                                    <a href="pages-sign-up.html" class="btn btn-default btn-block">Not a member? Sign Up</a>
                                </div>
                            </div>
                        </form>
                        
                        
                        
                    </div>
                </div>
            </div>
        </div>

    </section>
    <!--Global JS-->
    <script src="/assets/js/jquery-1.10.2.min.js"></script>
    <script src="/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="/assets/plugins/waypoints/waypoints.min.js"></script>
    <script src="/assets/plugins/nanoScroller/jquery.nanoscroller.min.js"></script>
    <script src="/assets/js/application.js"></script>

    <script type="text/javascript">
    $("#into").click(function(){
	    var username=$("#email").val();
	    var password=$("#password").val();
	    if(username.trim() != '' &&  password.trim() != ''){
// 	    	var formData = $("#toform").serialize();  
	    	$.ajax({ 
	 			type:"post", 
	 			url:"/user/loginToJson", 
//	 			dataType:"json",   //返回格式为json
//	 			data:formData,
                data:{"username":username.trim(),"password":password.trim()},
	 			async:false, 
	 		    success:function(msg){ 
	 		    		if(msg.errcode == 0){ 
	 		    		alert("欢迎光临本站"); 
	 		    		var abc = msg.message; 
	 		    		window.location.href=abc; 
			    		}else{ 
	 		    			var abc = msg.message;
	 		    		    $(".help-block").css("color","red");
	 		    			$(".help-block").css("font-size","12px");
	 		    			$(".help-block").html(abc);
	 		    			 
	 		    		} 
			    	
	 		    }, 
	 		    error:function(msg){
	 		    	alert("系统错误，请稍后再试");
	 		    } 
	 		}); 
	    }else if(username.trim() == ''){
	    	    $(".help-block").css("color","red");
  			$(".help-block").css("font-size","12px");
  			$(".help-block").html("请输入账户");
//	    	alert("请输入Username");
	    }else if(password.trim() == ''){
	    	$(".help-block").css("color","red");
  			$(".help-block").css("font-size","12px");
  			$(".help-block").html("请输入密码");
//	    	alert("请输入Password");
	    }
});
    </script>
</body>

</html>
