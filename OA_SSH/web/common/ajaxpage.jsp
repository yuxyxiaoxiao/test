<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/common/common.jsp"%>
<c:if test="${page.pageIndex == 1 }">
<font color="red">首页</font>
上一页
</c:if>

<c:if test="${page.pageIndex != 1}">
<a href="javascript:;" onclick="turnPage(1)">
首页
</a>
<a href="javascript:;" onclick="turnPage(${page.pageIndex - 1})">上一页</a>
</c:if>



<c:if test="${page.totalCount > 0 && page.pageIndex != page.pageCount }">
<a href="javascript:;" onclick="turnPage(${page.pageIndex + 1 })">下一页</a>
<a href="javascript:;" onclick="turnPage(${page.pageCount})">尾页</a>
</c:if>



<c:if test="${page.totalCount == 0 || page.pageIndex == page.pageCount }">
下一页
<font color='red'>尾页</font>
</c:if>

当前为${page.pageIndex}/${page.pageCount}
共${page.totalCount}条数据
