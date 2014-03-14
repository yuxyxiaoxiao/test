<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="/js/jquery.ztree.core-3.3.js"></script>
<script type="text/javascript" src="/common/My97DatePicker/WdatePicker.js"></script>
<title>大学生实训Q班管理系统</title>
</head>
<body>
<form >
	<input type="hidden" id="userId"value="${user.id}">
	旧密码:<input type="text" id="oldPwd"/>
	新密码:<input type="text" id="pwd1"/>
	确认密码:<input type="text" id="pwd2"/>
	
	<input type="button" onclick="revisePassword()"value="确认更改">
</form>

</body>
<script>
//action=""method="post" enctype="multipart/form-data"
	function  revisePassword(){
		var userId = $("#userId").val();
		var oldPwd = $("#oldPwd").val();
		var pwd1 = $("#pwd1").val();
		var pwd2 = $("#pwd2").val();
		if(pwd2 != pwd1){
			alert("新密码不一致");
			return false;
		}
		
		$.post(
			'<%=request.getContextPath() %>/user/updatePwd.do',
			{"user.password":oldPwd,"user.newPassword":pwd1,"user.id":userId},
			function(data){
				
			if(data == "1"){
				alert("原密码错误");
			}else{
				alert("修改成功");
				document.location.href="<%= request.getContextPath() %>/user/userList.do";
			}
			
		})
		
	}
</script>
</html>