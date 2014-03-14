<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="../common/css/demo.css" type="text/css">
<link rel="stylesheet" href="../common/css/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="../js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="../js/jquery.ztree.all-3.3.js"></script>
<script type="text/javascript" src="../js/jj.js"></script>
<script type="text/javascript">

		var setting = {
			view: {
				isSimpleData : true,	//是否使用简单的数组结构
		    	showLine: true	//是否显示线，true为显示，false为不显示
		    	
			},
			data: {
				simpleData: {
					idKey : "id", //设置id
					pIdKey:"pid", //设置pid
					enable: true
				}
			}//,
		//	callback: {
		//		onClick: onClick   //定义节点点击事件为单击事件，调用zTreeOnClick方法  默认点击节点为双击
		//	}
		};

		var zNodes = ${json };

	//	function onClick(event, treeId, treeNode) {
			//var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		//	var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
	//		var node = treeObj.getNodeByTId(treeNode.tId);
	//		alert(treeNode.tId);
	//		alert("id:"+node.id+"---name:"+node.name+"---pId:"+node.pid+"target:"+node.target);
	//	}
		var target ="_blank";
		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes,target);
		});

	</script>
	<base href="." target="main"><meta http-equiv="Content-Type" content="text/html; charset=utf-8"><style type="text/css">
<!--
body {
	background-color: #FFFF99;
}
-->
</style></head>
 </head>

<body>
		<h2><div id="treeDemo" class="ztree"></div></h2>
	
</body>
</html>