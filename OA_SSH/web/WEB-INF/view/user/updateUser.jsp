<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="/common/My97DatePicker/WdatePicker.js"></script>
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/user/updateUser.do"method="post" onsubmit="return fun()" enctype="multipart/form-data">
	<input type="hidden" name="user.id" value="${user.id}"/>
	用户名:<input type="text" name="user.userName" value="${user.userName}"/><br>
	实际名字:<input type="text" name="user.chineseName" value="${user.chineseName}"/><br>
	密码:<input type="password" id="password"name="user.password"/><br>
	确认密码:<input type="password" id="affrimpassword"/><br>
	年龄:<input type="text" name="user.userAge"/ value="${user.userAge}"><br>
	性别：<input type="text" name="user.userSex" value="${user.userSex}"/><br>
	级别：<select name="user.rank">
			<s:set id = "urank" value="user.rank"/>
		<s:iterator var="rank" value="rankList">
   			<s:if test="#urank == #rank.name">
 				<option selected ><s:property value="#rank.name"/></option>
 			</s:if>
 			<s:if test="#urank != #rank.name">
 				<option ><s:property value="#rank.name"/></option>
 			</s:if>
		</s:iterator>
	     </select><br>
	生日:<input type="text" name="user.userBirthday" value="${user.userBirthday}"class="Wdate" onfocus="showTime()"/><br>
	入职时间:<input type="text" name="user.userEntryDate" value="${user.userEntryDate}" class="Wdate" onfocus="showTime()"><br>
	上传头像:<input type="file" name="headPhoto"><br>
	附件:<input type="button"onclick="addInputFile()" value="++"/><input type="file" name="uploadFiles"/><br>
	<div id="showfile">
	
	</div>
	<input type="submit" value="确认修改">
</form>
</body>
<script>
function  addInputFile(){
	 $("#showfile").append("<div><input type=\"button\" onclick=\"closeInputFile(this)\"value=\"--\"><input type=\"file\" name=\"uploadFiles\"></div>");
}
function closeInputFile(obj){
	$(obj).parent().remove();
}
function fun(){
	
	var pwd1 = $("#password").val();
	var pwd2 = $("#affrimpassword").val();
	
	if(pwd1 != pwd2 || pwd2 == ""){
		alert("密码不一致");
		return false;
	}
	
}
function showTime(){
	 var d, s = "";           // 声明变量。
	  d = new Date();                           // 创建 Date 对象。
	  s += d.getFullYear() +"-";
	  s += (d.getMonth() + 1) + "-";            // 获取月
	  s += d.getDate();                   // 获取日。
	  WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'1680-1-1',maxDate:s});
	//  WdatePicker({dateFmt:'星期D yyyy-MM-dd HH:mm:ss',isShowWeek:true});
	}
</script>
</html>