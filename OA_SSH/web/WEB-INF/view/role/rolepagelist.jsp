<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp"%>
<html>
 <head>
 
	<link rel="stylesheet" href="../common/css/demo.css" type="text/css">
<link rel="stylesheet" href="../common/css/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="../js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="../js/jquery.ztree.all-3.3.js"></script>
<script type="text/javascript">

		var setting = {
			check: {
				isSimpleData : true,	//是否使用简单的数组结构
		    	showLine: true,	//是否显示线，true为显示，false为不显示
		    	enable: true
			},
			data: {
				simpleData: {
					idKey : "id", //设置id
					pIdKey:"pid", //设置pid
					enable: true
				}
			}
		};
		var currentRoleId;
		function showRoleMenu(roleId){
			currentRoleId = roleId;
			$.post(
				"<%=request.getContextPath() %>/roleMenu/toaddRoleMenu.do",
				{"role.id":roleId},
				function(data){
					zNodes = data;
					$.fn.zTree.init($("#treeDemo"), setting, zNodes);
				},'json');
			
		}
		function addRoleMenu(){
			var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
			var nodes = treeObj.getCheckedNodes(true);
			var menuIds = "";
		 	for (var i = 0; i < nodes.length; i++) {
		 		menuIds += "," + nodes[i].id;
			}
			menuIds = menuIds.substring(1);
			 $.post(
				"/roleMenu/updateRoleMenu.do",
				{"roleMenu.menuIds":menuIds,"roleMenu.roleId":currentRoleId},
				function (data){
					alert("修改成功！");
				}); 
		}

	</script>
</head>

<body>
<form>
<table border="1">
	<tr>
		<th>全选：<input type="checkbox" id="sel"  onclick="check1()"><br>反选：<input type="checkbox" id="sel2" onclick="check2()"></th>
		<th>角色名</th>
	</tr>
		<s:iterator var="role" value="roleList">
	<tr>
		<td><input type="checkbox" name="check" value="<s:property value="#role.id"/>"></td>
		<td><s:property value="#role.roleName"/></td>
		<td><a href="javascript:;" onclick="showRoleMenu(<s:property value="#role.id"/>)">更改权限</a></td>
		<td><a href="<%=request.getContextPath()%>/role/toUpdateRole.do?role.id=<s:property value="#role.id"/>">修改</a></td>
	</tr>
	</s:iterator>
</table>
</form>
<button onclick="del(1)">删除</button ><button onclick="add()">添加</button><br>
<button onclick="addRoleMenu()">确认更改权限</button>
<div id="treeDemo" class="ztree"></div>
</body>
</html>
<!--<jsp:include page="/common/ajaxpage.jsp"></jsp:include>-->