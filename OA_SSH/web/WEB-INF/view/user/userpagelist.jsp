<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp"%>
<html>
 <head>
	
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"><style type="text/css">

</style></head>

<body>
<form>
<table border="1">
<tr>
		<th width="89">全选：
	  <input type="checkbox" id="sel"  onclick="check1()"><br>反选：<input type="checkbox" id="sel2" onclick="check2()"></th>
	  <th width="100">头像</th>
	  <th width="79">用户名</th>
	  <th width="80">用户年龄</th>
	  <th width="80">用户性别</th>
	  <th width="68">用户生日</th>
	  <th width="106">用户入职日期</th>
	  <th width="90">用户级别</th>
	  <th width="102">显示用户附件</th>
	  <th width="86">修改密码</th>
	  <th width="128">修改角色</th>
	  <th width="50">修改</th>
	</tr>
	<s:iterator var="user" value="userList">
		<tr><td><input type="checkbox" name="check" value="<s:property value="#user.id"/>"></td>
			<td><img src="<%=request.getContextPath() %>/<s:property value="#user.photoPath"/>" width="50" height="50" border="0" alt="aa"></td>
			<td><s:property value="#user.userName"/></td>
			<td ><s:property value="#user.userAge"/></td>
			<td ><s:property value="#user.userSex"/></td>
			<td ><s:property value="#user.userVeiwBirthday"/></td>
			<td ><s:property value="#user.userViewEntry"/></td>
			<td ><s:property value="#user.rank"/></td>
			<td><a href="<%=request.getContextPath() %>/user/attachFileList.do?user.id=<s:property value="#user.id"/>">用户附件</a></td>
			<td><a href="<%=request.getContextPath() %>/user/toUpdatePwd.do?user.id=<s:property value="#user.id"/>">修改密码</a></td>
			<td><a href="<%=request.getContextPath() %>/userRoel/toUserRole.do?user.id=<s:property value="#user.id"/>"> 用户添加角色</a></td>
			<td><a href="<%=request.getContextPath() %>/user/toUpdateUser.do?user.id=<s:property value="#user.id"/>">修改</a></td>
		</tr>
	</s:iterator>
</table>
</form>
<button onclick="del(1)">删除</button ><button onclick="add()">添加</button><br>

</body>
</html>
<jsp:include page="/common/ajaxpage.jsp"></jsp:include>