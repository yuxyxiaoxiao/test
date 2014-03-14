<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/role/updateRole.do" method="post">
		<input type="hidden" value="${role.id}" name="role.id">
roleName:<input type="text" id="roleName"value="${role.roleName}" name="role.roleName" onblur="checkName()">
		<input type="submit" value="确认修改">
</form>
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