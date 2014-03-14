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
<table width="300" border="2" align="center" bordercolor="#FF0000" bgcolor="#FFFFCC">
  <tr>
    <td width="117" align="right" valign="middle">级别名:</td>
    <td width="171" align="left"><input type="text"  id="rankName"/></td>
    <td><input type="button" value="搜索" onClick="search(1)"/></td>
  </tr>
</table>
<div id="userPageList" align="center">
<jsp:include page="/WEB-INF/view/rank/rankPageList.jsp"></jsp:include>
</div>
<button onclick="addRank()">添加</button>
<button onclick="delRank(1)">删除</button>
</body>
</html>
<script>

function delRank(page){
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

  		$.post("<%= request.getContextPath() %>/rank/delRank.do",
  				{"rank.delIds":id},
  				function(data){
  					search(page);
  		});
}
function check1(){
	var pros = document.getElementsByName("check");
	var sel = document.getElementById("sel").checked;
	for (var i=0;i<pros.length ;i++ ){
		pros[i].checked = sel;
	}
}
function addRank(){
	
	window.location.href="<%= request.getContextPath()%>/rank/toaddRank.do";
}
function search(page) {
	var name = $("#rankName").val();
	$.post(
			"<%=request.getContextPath()%>/rank/rankList.do",
			{"rank.name":name,"flag":1,"rank.pageIndex":page},
			function(data){
		$("#userPageList").html(data);
	});
}

function turnPage(page) {
	search(page);
} 


</script>