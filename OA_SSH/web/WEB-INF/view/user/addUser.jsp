<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" language="javascript" src="/js/login.js"></script>
<script type="text/javascript" src="/common/My97DatePicker/WdatePicker.js"></script>
<title>大学生实训Q班管理系统</title>
</head>
<body onkeydown="keydown()">
<form action="<%=request.getContextPath() %>/user/addUser.do"method="post" onsubmit="return fun()" enctype="multipart/form-data">
	用户名:<input type="text" id="userName"name="user.userName" onblur="checkName()"/><br>
	实际名字:<input type="text" id="chineseName"name="user.chineseName" /><br>
	密码:<input type="password" id="password"name="user.password"/><br>
	确认密码:<input type="password" id="affrimpassword"/><br>
	年龄:<input type="text" name="user.userAge"/><br>
	性别：<input type="text" name="user.userSex"/><br>
	级别：<select name="user.rank">
		<s:iterator var="rank" value="rankList">
			<option > <s:property value="#rank.name"/></option>
		</s:iterator>
	     </select><br>
	生日:<input type="text" name="user.userBirthday"class="Wdate" onfocus="showTime()"/><br>
	入职时间:<input type="text" name="user.userEntryDate" class="Wdate" onfocus="showTime()"><br>
	上传头像:<input type="file" name="headPhoto"><br>
	附件:<input type="button"onclick="addInputFile()" value="++"/><input type="file" name="uploadFiles"/><br>
	<div id="showfile">
	
	</div>
	
	<input type="submit" value="增加用户">
</form>
 <div id="edit" style="display:none;position:absolute;z-index:100;   width:124px;height:124px">
		<img src="/images/loding.gif"/>
	</div> 
</body>
<script>
	function checkName(){
		var userName = $("#userName").val();
		if(userName.length<=0){
			alert("用户名不能为空！");
			return false;
		}
		
		$.post(
				"<%=request.getContextPath()%>/user/selectUserName.do",
				{"user.userName":userName},
				function(data){
					if(data == "no"){
						alert("用户名以存在");
					}
				});
	}
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
	showWindow();
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
	
	
	
function keydown() {
    if (event.keyCode == 38) {
        check(-1);
    }
    else if (event.keyCode == 40) {
        check(1);
    }
}
function check(step) {
    var ckboxes = document.getElementById("mytable").getElementsByTagName("input");
    for (var i = 0; i < ckboxes.length; i++) {
        if (ckboxes[i].checked && (i + step) > -1 && (i + step) < ckboxes.length) {
            ckboxes[i].checked = false;
            ckboxes[i + step].checked = true;
            break;
        }
    }
}
</script>
</html>