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
<table border="2" align="center" bordercolor="#FF0000" bgcolor="#FFFFCC">
	<tr>
	<th>全选：<input type="checkbox" id="sel"  onclick="check1()"></th>
		<th>级别名</th>
		<th>修改</th>
	</tr>

<s:iterator id="rank" value="rankList">
	<tr>
		<tr><td><input type="checkbox" name="check" value="<s:property value="#rank.id"/>"></td>
		<td>
			<s:property value="#rank.name"/>
		</td>
		<td><a href="<%= request.getContextPath() %>/rank/toUpdateRank.do?rank.id=<s:property value="#rank.id"/>">修改</a></td>
	</tr>
</s:iterator>

</table>
</body>
</html>
<jsp:include page="/common/ajaxpage.jsp"></jsp:include>