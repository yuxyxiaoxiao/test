<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="/common/My97DatePicker/WdatePicker.js"></script>
<title>大学生实训Q班管理系统</title>
<style type="text/css">
<!--
-->
</style></head>
<body>
<table width="884" border="1" align="center"  >
  <tr>
    <td width="117" align="right" valign="middle">用户名:</td>
    <td width="171" align="left"><input type="text"  id="userName"/></td>
    <td width="113" align="right">性别:</td>
    <td width="179" align="left"><select name="userSex"  id="userSex">
      <option value="">全部</option>
      <option value="男">男</option>
      <option value="女">女</option>
    </select>
    </td>
    <td width="62" align="center">年龄:</td>
    <td width="200"><input type="text"  id="userAge"/></td>
  </tr>
  <tr align="center">
    <td align="right">生日开始时间:</td>
    <td align="left"><input type="text"  id="userStartBirthday" class="Wdate" onFocus="beginDate()"/></td>
    <td align="right">生日结束时间:</td>
    <td align="left"><input type="text"  id="userEndBirthday" class="Wdate" onFocus="endDate()"/></td>
  </tr>
  <tr align="center">
    <td align="right">入职开始时间:</td>
    <td align="left"><input type="text"  id="userStartEntry" class="Wdate" onFocus="beginEntryDate()"/></td>
    <td align="right">入职结束时间:</td>
    <td align="left"><input type="text"  id="userEndEntry" class="Wdate" onFocus="endEntryDate()"/></td>
    <td><input type="button" value="搜索" onClick="search(1)"/></td>
  </tr>
</table>
<div id="userPageList">
<jsp:include page="/WEB-INF/view/user/userpagelist.jsp"></jsp:include>
</div>
	
</body>
<script language="JavaScript" type="text/javascript">

//全局的ajax访问，处理ajax清求时sesion超时  

$.ajaxSetup({   
    contentType:"application/x-www-form-urlencoded;charset=utf-8",   
    complete:function(XMLHttpRequest,textStatus){   
            var sessionstatus=XMLHttpRequest.getResponseHeader("sessionstatus"); //通过XMLHttpRequest取得响应头，sessionstatus，  
            if(sessionstatus=="timeout"){   
                        //如果超时就处理 ，指定要跳转的页面  
                                window.location.replace("user/login.jsp");   
                        }   
             }   
    }   
  );





//创建XMLHttpRequest的函数
function createXMLHttp(){

	var request;
	//得到当前浏览器
	var browser=navigator.appName;
	//如果是IE浏览器
	if(browser=="Microsoft Internet Explorer"){
		request=new ActiveXObject("Microsoft.XMLHttp");
		return request;
	}
	//非IE浏览器
	else{
		request=new XMLHttpRequest();
		return request;
	}
}

//定义XMLHttpRequest变量
var xhr=createXMLHttp();

function search(page){
	var userName = $("#userName").val();
	var userSex = $("#userSex").val();
	var userAge = $("#userAge").val();
	var userStartBirthday = $("#userStartBirthday").val();
	var userEndBirthday = $("#userEndBirthday").val();
	
	var userStartEntry = $("#userStartEntry").val();
	var userEndEntry = $("#userEndEntry").val();
	//跳转路径
	var url="<%=request.getContextPath()%>/user/userList.do";
	//跳转
	xhr.open("post",url,true);//true开启异步
    //POST请求必须设置编码
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	//设置回调函数为getHello
	xhr.onreadystatechange=getHello;
	//将请求发送
	//xhr.send(null);
    //post传值name
    xhr.send("user.userStartEntry="+userStartEntry+"&user.userEndEntry="
    		+userEndEntry+"&user.userStartBirthday="+userStartBirthday
    		+"&user.userEndBirthday="+userEndBirthday+"&user.userName="
    		+userName+"&user.userSex="+userSex+"&user.userAge="+userAge+"&flag="+1+"&user.pageIndex="+page);
}

function getHello(){
	//判断XmlHttpRequest状态
	if(xhr.readyState==4){
		//取值 	描述
		//0		描述一种"未初始化"状态；此时，已经创建一个XMLHttpRequest对象，但是还没有初始化。
		//1		描述一种"发送"状态；此时，代码已经调用了XMLHttpRequest open()方法并且XMLHttpRequest已经准备好把一个请求发送到服务器。
		//2		描述一种"发送"状态；此时，已经通过send()方法把一个请求发送到服务器端，但是还没有收到一个响应。
		//3		描述一种"正在接收"状态；此时，已经接收到Http响应头部信息，但是消息体部分还没有完全接收结束。
		//4		描述一种"已加载"状态；此时，响应已经被完全接收。
		//设置变量helloStr的值为响应返回值
		var data = xhr.responseText;
		$("#userPageList").html(data);
		//将响应返回值显示在名为hello的div标签中
		//document.getElementById("hello").innerHTML=helloStr;
	}
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
	for (var i=1;i<pros.length ;i++ ){
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
  		var conf = window.confirm("是否删除？？");
  		if(conf == true){
  			$.post("<%= request.getContextPath() %>/user/delUser.do",
  	  				{"user.delId":id},
  	  				function(data){
  	  					alert("删除成功");
  	  					search(page);
  	  		});
  		}else{
  			return false;
  		}
}
function add(){
	window.location.href="<%= request.getContextPath() %>/user/toaddUser.do";
	
}
function funUp(obj,id,name,age,sex,birthday,index){
	var val = $(obj).text();
	if(val == ""){
		return false;
	}
	obj.innerHTML = "";
	$(obj).append("<input type='text' value="+val+" size=8>");
	$(obj).children().first().focus();
	$(obj).children().first().blur(
		function(){
			var new_val = $(obj).children().first().val();
			if(val == new_val||new_val ==""){
				obj.innerHTML = val;
				return  false;
			}
			if(index == 1){
				name = new_val;
			}else
			if(index == 2){
				age = new_val;
			}else
			if(index == 3){
				sex = new_val;
			}else
			if(index == 4){
				birthday = new_val; 
			}
			// document.location.href="login!bookUpdate ";
			$.post(
				'<%= request.getContextPath() %>/user/upUser.do',
				{'user.id':id,'user.userName':name,'user.userAge':age,'user.userSex':sex,'user.userBirthday':birthday},
				function(data){
					if(data == "ok"){
						obj.innerHTML = new_val;
					}else{
						
						obj.innerHTML = val;
					}
				}
			)
		})
}

function showTime(){
	 var d, s = "";           // 声明变量。
	  d = new Date();                           // 创建 Date 对象。
	  s += d.getFullYear() +"-";
	  s += (d.getMonth() + 1) + "-";            // 获取月份。
	  s += d.getDate();                   // 获取日。
	//  WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'1680-1-1',maxDate:s});
	  return s;
	}
function beginDate(){
	WdatePicker({maxDate:'#F{$dp.$D(\'userEndBirthday\')||\''+showTime()+'\'}'});
}

function endDate(){
	WdatePicker({minDate:'#F{$dp.$D(\'userStartBirthday\')}',maxDate:showTime()});
}
function beginEntryDate(){
	WdatePicker({maxDate:'#F{$dp.$D(\'userEndEntry\')||\''+showTime()+'\'}'});
}

function endEntryDate(){
	WdatePicker({minDate:'#F{$dp.$D(\'userStartEntry\')}',maxDate:showTime()});
}	
	
</script>
</html>