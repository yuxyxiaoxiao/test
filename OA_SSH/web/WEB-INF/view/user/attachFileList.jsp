<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="/common/My97DatePicker/WdatePicker.js"></script>
<title>大学生实训Q班管理系统</title>
</head>
<body>
<table>
	<tr>
		<th>全选：<input type="checkbox" id="sel"  onclick="check1()"></th>
		<th>文件名</th>
	</tr>
	<s:iterator var="userFile" value="attachFileList">
		<tr>
			<tr><td><input type="checkbox" name="check" value="<s:property value="#userFile.id"/>"></td>
			<td><a href="<%= request.getContextPath() %>/user/downFile.do?userAttachFile.id=<s:property value="#userFile.id"/>"><s:property value="#userFile.attachFileName"/></a></td>
		</tr>
	</s:iterator>
</table>

	<button onclick="downFile()">下载</button>
</body>
<script>
function downFile(){
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
		window.location.href="<%= request.getContextPath() %>/user/downFile.do?userAttachFile.downIds="+id;
  		
}
function check1(){
	var pros = document.getElementsByName("check");
	var sel = document.getElementById("sel").checked;
	for (var i=0;i<pros.length ;i++ ){
		pros[i].checked = sel;
	}
}

</script>
</html>