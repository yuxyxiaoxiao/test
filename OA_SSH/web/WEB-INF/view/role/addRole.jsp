<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" language="javascript" src="/js/login.js"></script>
<script type="text/javascript" src="/common/My97DatePicker/WdatePicker.js"></script>
<title>大学生实训Q班管理系统</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/role/addRole.do"method="post" enctype="multipart/form-data">
	角色名:<input type="text" id="roleName" name="role.roleName" onblur="checkName()"/>

	<input type="submit" value="增加角色" onclick="showWindow();">
</form>
<div id="edit" style="display:none;position:absolute;z-index:100;   width:124px;height:124px">
		<img src="/images/loding.gif"/>
	</div> 
</body>
</body>
<script>
function checkName(){
	var roleName = $("#roleName").val();
	if(roleName.length<=0){
		alert("角色名不能为空！");
		return false;
	}
	
	$.post(
			"<%=request.getContextPath()%>/role/selectRoleName.do",
			{"role.roleName":roleName},
			function(data){
				if(data == "no"){
					alert("用户名以存在");
				}
			});
}
</script>
</html>