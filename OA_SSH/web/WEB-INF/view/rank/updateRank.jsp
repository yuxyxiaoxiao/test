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
	<form action="<%=request.getContextPath() %>/rank/updateRank.do" method="post">
		<input type="hidden" name="rank.id" value="${rank.id}">
		<input type="text" name="rank.name" value="<s:property value="rank.name"/>">
		<input type="submit" value="确认修改">
	</form>
</body>
</html>