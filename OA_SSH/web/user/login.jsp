<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.awt.image.BufferedImage"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
<!--
*{
	padding:0px;
	margin:0px;
	font-family:Verdana, Arial, Helvetica, sans-serif;
}
body {
	margin: 0px;
	background:#F7F7F7;
	font-size:12px;
}
input{
	vertical-align:middle;
}
img{
	border:none;
	vertical-align:middle;
}
a{
	color:#333333;
}
a:hover{
	color:#FF3300;
	text-decoration:none;
}
.main{
	width:640px;
	margin:40px auto 0px;
	border:4px solid #EEE;
	background:#FFF;
	padding-bottom:10px;
}

.main .title{
	width:600px;
	height:50px;
	margin:0px auto;
	background:url(/images/login_toptitle.jpg) -10px 0px no-repeat;
	text-indent:326px;
	line-height:46px;
	font-size:14px;
	letter-spacing:2px;
	color:#F60;
	font-weight:bold;
}

.main .login{
	width:560px;
	margin:20px auto 0px;
	overflow:hidden;
}
.main .login .inputbox{
	width:260px;
	float:left;
	background:url(/images/login_input_hr.gif) right center no-repeat;
}
.main .login .inputbox dl{
	width:230px;
	height:41px;
	clear:both;
}
.main .login .inputbox dl dt{
	float:left;
	width:60px;
	height:31px;
	line-height:31px;
	text-align:right;
	font-weight:bold;
}
.main .login .inputbox dl dd{
	width:160px;
	float:right;
	padding-top:1px;
}
.main .login .inputbox dl dd input{
	font-size:12px;
	font-weight:bold;
	border:1px solid #888;
	padding:4px;
	background:url(/images/login_input_bg.gif) left top no-repeat;
}


.main .login .butbox{
	float:left;
	width:200px;
	margin-left:26px;
}
.main .login .butbox dl{
	width:200px;
}
.main .login .butbox dl dt{
	width:160px;
	height:41px;
	padding-top:5px;
}
.main .login .butbox dl dt input{
	width:98px;
	height:33px;
	background:url(/images/login_submit.png) no-repeat;
	border:none;
	cursor:pointer;
}
.main .login .butbox dl dd{
	height:21px;
	line-height:21px;
}
.main .login .butbox dl dd a{
	margin:5px;
}



.main .msg{
	width:560px;
	margin:10px auto;
	clear:both;
	line-height:17px;
	padding:6px;
	border:1px solid #FC9;
	background:#FFFFCC;
	color:#666;
}

.copyright{
	width:640px;
	text-align:right;
	margin:10px auto;
	font-size:10px;
	color:#999999;
}
.copyright a{
	font-weight:bold;
	color:#F63;
	text-decoration:none;
}
.copyright a:hover{
	color:#000;
}
-->
</style>
<script type="text/javascript" language="javascript" src="/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" language="javascript" src="/js/login.js"></script>
<script type="text/javascript" language="javascript">
if(window != top){
	top.location.href = location.href;
}
	function f0(){
  var		image = document.getElementById("image");
		image.src="<%=request.getContextPath()%>/image/image.do?r="+Math.random();
	}
function keydown(){
	if(event.keyCode == "13"){
		login();
	}
	
}
</script>
<title>大学生实训Q班管理系统</title>
</head>
<body onkeydown="keydown()">


	<div class="main">
		<div class="title">
			管理登陆
		</div>

		<div class="login">
		
            <div class="inputbox">
				<dl>
				
					<dt>用户名：</dt>
					<dd><input type="text" name="username"id="userName" size="20" onfocus="this.style.borderColor='#F93'" onblur="this.style.borderColor='#888'" />
					</dd>
				</dl>
				<dl>
					<dt>密码：</dt>
					<dd><input type="password" name="password" id="userPassword"size="20" onfocus="this.style.borderColor='#F93'" onblur="this.style.borderColor='#888'" />
					</dd>
				</dl>
				<dl>
					<dt>验证码：</dt>
					<dd>
						<input type="text" id="validate" size="3" onfocus="this.style.borderColor='#F90'" onblur="this.style.borderColor='#888'" />
						<img src="<%=request.getContextPath()%>/image/image.do" id="image" width="60" height="30" />
						<a href="javascript:;" onclick="f0()">看不清</a>
					</dd>
					
				</dl>
		</div>
            <div class="butbox">
            <dl>
					<dt><input  type="button"  onclick="login()"/></dt><dt><a href="<%=request.getContextPath() %>/user/registerUser.do">注册用户</a></dt>
					<dd><a href="http://www.dedecms.com">官方网站</a> | <a href="http://bbs.dedecms.com">技术论坛</a></dd>
				</dl>
			</div>
		
		</div>	
	</div>
	
	<div class="copyright">
		Powered by <a href="http://www.dedecms.com">DEDECMS V51GBK_SP1_BPW</a> Copyright &copy;2004-2008 
	</div>
	<input type="hidden" id="dynamicURL" value="<%=session.getAttribute("dynamicURL") %>"/>
	  <div id="edit" style="display:none;position:absolute;z-index:100;   width:124px;height:124px">
		<img src="/images/loding.gif"/>
	</div> 
</body>
<script>

	function login(){
		
		var name = $("#userName").val();
		var password = $("#userPassword").val();
		var validate = $("#validate").val();
		var dynamicURL = "";
		 dynamicURL +=  $("#dynamicURL").val();
	
		if( validate == ""){
			alert("验证码为空！");
			return false;
		}
		if(name == ""){
			alert("用户名为空！");
			return false;
		}
		if(password == ""){
			alert("密码为空！");
			return false;
		}
		showWindow();
		$.post(
			"<%=request.getContextPath()%>/user/login.do",
			{"user.userName":name,"user.password":password,"user.validate":validate},
			function(data){
				if(data == "1"){
					closeWindow();
					alert("验证码不正确！");
				}else
				if(data == "2"){
					closeWindow();
					alert("用户名不存在！");
				}else
				if(data == "3"){
					closeWindow();
					alert("密码错误！");
				}else{
					
					<%-- if(dynamicURL != "null" ){
						
						window.location.href="<%= request.getContextPath() %>"+dynamicURL;
					}else{ --%>
						
					window.location.href="<%= request.getContextPath() %>/user/welcome.do";
				//	}
				}
			});
	}
   
</script>
</html>