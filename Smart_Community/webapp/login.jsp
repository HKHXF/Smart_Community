<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
   <head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
            <title>
                科技社区管理平台
            </title>
            <link href="./css/style_log.css" rel="stylesheet" type="text/css">
            <link rel="stylesheet" type="text/css" href="../../css/bootstrap.min.css">

            </link>
<!--             <link rel="icon" href="/images/toubu.png" sizes="32x32"> -->
             <link rel="icon" href="/images/toubu.png" >
             <script type="text/javascript" src="../../js/bootstrap.min.js"></script>
        </meta>
</head>
 <body class="login" mycollectionplug="bind" style="overflow:-Scroll;overflow-y:hidden">
                     
                      
                      <video autoplay="autoplay" loop="loop" style="width: 100%;">
                        <source src="/video/keji_login.mp4" type="video/mp4">
                        
                      </video>
                     
     
        <div class="login_m" style="position: absolute;top:30%;">
            <div class="login_logo">
                <img height="68" src="./img/login-logo.png" width="230"/>
            </div>
            <div class="login_boder">
                <form id="defaultForm" onsubmit="return checkSbumitData()"style="height: 300px;">
                    <div class="login_padding" id="login_model"style="height: 300px;">
                      <p style="height: 20px;width: 160px;margin: 0 auto;font-size: 20px;margin-top: 5px;color:#333; ">科技社区管理平台
                      </p>
                        <h2>
                            
                        </h2>
                        <label>
                            <input class="txt_input txt_input2" id="username" maxlength="15" name="username"  placeholder="请输入您的账号" type="text" style=" border: 1px solid #5cc0c0; ">
                            </input>
                        </label>
                        <h2>
                            
                        </h2>
                        <label>
                            <input class="txt_input" id="password" maxlength="6" name="password" placeholder="请输入您的密码" type="password"style=" border: 1px solid #5cc0c0;">
                            </input>
                        </label>
                        <!--<p class="forgot"><a id="iforget" href="javascript:void(0);">Forgot your password?</a></p>-->
                        <p id="tipMsg" style="width: 260px;height: 1px; color: #f97065;">
                        </p>
                        <div class="rem_sub" style="width:310px;">
                            <div class="rem_sub_l">
                                
                            </div>
                            
                            <label>
                                <input class="sub_button" id="button" name="submit" placeholder="登录" value="登录" style="" type="submit">
                                </input>
                            </label>
                        </div>
                    </div>
                    <div class="login_padding" id="forget_model" style="display:none">
                        <br>
                            <h1>
                                Forgot password
                            </h1>
                            <br>
                                <div class="forget_model_h2">
                                    (Please enter your registered email below and the system will automatically reset users’ password and send it to user’s registered email address.)
                                </div>
                                <label>
                                    <input class="txt_input txt_input2" id="usrmail" type="text">
                                    </input>
                                </label>
                                <div class="rem_sub">
                                    <div class="rem_sub_l">
                                    </div>
                                    <label>
                                        <input class="sub_buttons" id="Retrievenow" name="button" style="" type="submit" value="Retrieve now">
                                            <input class="sub_button" id="denglou" name="button" style="" type="submit" value="Return">
                                            </input>
                                        </input>
                                    </label>
                                </div>
                            </br>
                        </br>
                    </div>
                    <!--login_padding  Sign up end-->
                </form>
            </div>
            <!--login_boder end-->
        </div>
        <!--login_m end-->
      
        <script src="./js/jquery-1.12.3.min.js" type="text/javascript"></script>
        <script src="./js/check-login.js" type="text/javascript"></script>
        <script type="text/javascript" src="/layer/layer.js"></script>
        
    </body>
</html>