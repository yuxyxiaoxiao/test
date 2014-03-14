<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../common/css/demo.css" type="text/css">
<link rel="stylesheet" href="../common/css/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="../js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="../js/jquery.ztree.all-3.3.js"></script>
<script type="text/javascript" src="../js/jj.js"></script>

 </head>
<body>
	<h1>权限菜单管理</h1>
	
	<div id="treeClass" class="ztree">
		
	</div>
	<div id="menu">
		id:<input type="text" id="menuId" readonly="true"/><br>
		pid:<input type="text" id="menuPid" readonly="true"/><br>
		name:<input type="text" id="menuName" readonly="true"/><br>
		url:<input type="text" id="menuURL" readonly="true"/><br>
		<input type="button" value="添加"  onclick="addNode();"/>
		<input type="button" value="修改" onclick="updateNode();"/>
	</div>
	<div id="rMenu">
		<ul>
			<li id="m_add" onclick="addTreeNode();">增加节点</li>
			<li id="m_del" onclick="removeTreeNode();">删除节点</li>
			<li id="m_del" onclick="updateTreeNode();">编辑节点</li>
		</ul>
	</div>
	
	
</body>
<script type="text/javascript">
	var setting = {
			view: {
				showLine: true
			},
			data: {
				simpleData: {
					enable: true, //开启树的层级结构
					idKey : "id", //设置id
					pIdKey:"pid" //设置pid
				}
			},
			callback: {
				onRightClick: zTreeOnRightClick
			}
			
		};
	var zNodes = ${json};
	
	//右键操作
	var rMenu = $("#rMenu"); 
	var currentSelectedNode;
	function zTreeOnRightClick(event, treeId, treeNode){
		if (treeNode) {
		    // 在点击右键菜单的同时选中该节点
		    var treeObj = $.fn.zTree.getZTreeObj("treeClass");
		    treeObj.selectNode(treeNode);
		    //得到当前得到选中节点的ID
			currentSelectedNode = treeObj.getNodeByTId(treeNode.tId);
			
			// 显示右键菜单
			showRMenu(event.clientX, event.clientY);
		}
	}
	function showRMenu(x, y) {
	    // 将菜单的div显示出来
		$("#rMenu ul").show();
		// 定位	
		rMenu.css({"top":y+"px", "left":x+"px", "visibility":"visible"});
		// 绑定整个body页面点击鼠标的时候，触发的函数onBodyMouseDown
		$("body").bind("mousedown", onBodyMouseDown);
	}
	function onBodyMouseDown(event){
	    // 如果点击的是弹出右键菜单上的选项则执行完事件之后隐藏
		// 如果点击的是body的其他部分则直接隐藏
		if (!($(event.target).parents("#rMenu").length>0)) {
			rMenu.css({"visibility" : "hidden"});
		}
	}
	function hideRMenu() {
	    // 隐藏menu
		if (rMenu) rMenu.css({"visibility": "hidden"});
		// 取消body的绑定事件
		$("body").unbind("mousedown", onBodyMouseDown);
	}

	var pid;
	var menuName;
	var menuURL;
	
	//得到当前增加子节点的父节点
	function addTreeNode(){
		hideRMenu();
		$("#menuPid").val(currentSelectedNode.id);
		$("#menuName").removeAttr("readonly");
		$("#menuURL").removeAttr("readonly");
	}
	//添加节点
	function addNode(){
		pid = $("#menuPid").val();
		menuName = $("#menuName").val();
		menuURL = $("#menuURL").val();
		$.post(
				"/menu2/addMenu.do",
				{"menu.pid":pid,"menu.name":menuName,"menu.url":menuURL},
				function(data){
					alert(data);
					var id = data.id;
					var treeObj = $.fn.zTree.getZTreeObj("treeClass");
					var newNode = {"id":id,"name":menuName,"url":menuURL,"pid":pid,"checked":"","target":"main"};
					alert(newNode);
					treeObj.addNodes(currentSelectedNode, newNode); 
					shixiao();
				},"json"
		);
	}
	//删除节点
	function removeTreeNode(){
		hideRMenu();
		alert(0);
		var id = currentSelectedNode.id;
		 $.post(
				"/menu2/deleteById.do",
				{"menu.id":id},
				function(data){
					var treeObj = $.fn.zTree.getZTreeObj("treeClass");
					var nodes = treeObj.getSelectedNodes();
					for (var i=0;i < nodes.length; i++) {
						treeObj.removeNode(nodes[i]);
					}
				}
		) 
	}
	//修改节点
	function updateTreeNode(){
		hideRMenu();
		var id = currentSelectedNode.id;
		var pid = currentSelectedNode.pid;
		$("#menuId").val(id);
		$("#menuPid").val(pid);
		$("#menuName").val(currentSelectedNode.name);
		$("#menuURL").val(currentSelectedNode.menuURL);
		$("#menuName").removeAttr("readonly");
		$("#menuURL").removeAttr("readonly");
		
		
	}
	
	function updateNode(){
		var id = currentSelectedNode.id;
		var pid = currentSelectedNode.pid;
		menuName = $("#menuName").val();
		menuURL = $("#menuURL").val();
		 $.post(
					"/menu2/updateByid.do",
					{"menu.id":id,"menu.pid":pid,"menu.name":menuName,"menu.url":menuURL},
					function(data){
						 var treeObj = $.fn.zTree.getZTreeObj("treeClass");
						var selectedNode = treeObj.getSelectedNodes()[0];
						selectedNode.name = menuName;
						selectedNode.menuURL = menuURL;
						treeObj.updateNode(selectedNode); 
						shixiao();
					}
					
			);
	}
	function shixiao(){
		$("#menuId").val("");
		$("#menuPid").val("");
		$("#menuName").val("");
		$("#menuURL").val("");
		$("#menuName").attr("readonly","true");
		$("#menuURL").attr("readonly","true");
	}
	
	//查看权限菜单
	$(document).ready(function(){
		$.fn.zTree.init($("#treeClass"), setting, zNodes);
	});

</script>
<style type="text/css">
div#rMenu {position:absolute; visibility:hidden; top:0;padding: 2px;}
div#rMenu ul li{
	margin: 1px 0;
	padding: 0 5px;
	cursor: pointer;
	list-style: none outside none;
	background-color: #DFDFDF;
}
</style>

</html>