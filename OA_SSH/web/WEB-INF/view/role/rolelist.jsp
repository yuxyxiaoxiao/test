<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>大学生实训Q班管理系统</title>
</head>
<body>
<table>
	<tr>
		<td>角色名:</td>
		<td><input type="text"  id="roleName"/></td>
		<td><input type="button" value="搜索" onclick="search(1)"/></td>
	</tr>
</table>

<div id="rolePageList">
<jsp:include page="/WEB-INF/view/role/rolepagelist.jsp"></jsp:include>
</div>
	
</body>
<script>
function search(page) {
	var roleName = $("#roleName").val();
	$.post("/role/roleList.do",
			{"userRole.roleName":roleName,"flag":1,"userRole.pageIndex":page},
			function(data){
		$("#rolePageList").html(data);
	})
}

function turnPage(page) {
	search(page);
} 

function check1(){
	var pros = document.getElementsByName("check");
	var sel = document.getElementById("sel").checked;
	for (var i=0;i<pros.length ;i++ ){
		pros[i].checked = sel;
	}
}
function check2(){
	var pros = document.getElementsByName("check");
	var sel = document.getElementById("sel2").checked;
	for (var i=0;i<pros.length ;i++ ){
		pros[i].checked = !pros[i].checked;
	}
}
function del(page){
	var id = "";
  	var check =	document.getElementsByName("check");
  		for(var i=0;i<check.length;i++){
  			if(check[i].checked){
  				if(id == ""){
  					id = check[i].value;
  				}else{
  					id+=","+check[i].value;
  				}
  				
  			}
  		}
  		if(id==""){
  			alert("至少选择一个");
  			return false;
  		}
  		$.post("<%= request.getContextPath() %>/role/delRole.do",
  				{"role.delId":id},
  				function(data){
  					search(page);
  		});
}
function add(){
	window.location.href="<%= request.getContextPath() %>/role/toaddRole.do";
	
}
</script>
</html>