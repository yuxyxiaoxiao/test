<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
 <head>

  <script type="text/javascript">
  <!--

	function f0(){
		var now = new Date();
		now = now.toLocaleString();
		id0.innerHTML = now;
	}

	function init(){
		f0();
		setInterval("dispdate()",1000);
	}

	function dispdate(){
		f0();
	}

  //-->
  </script>
 </head>

 <body style="background-color:#f1f1f1" onload="init()">
<!-- 	<span><iframe allowtransparency="true" frameborder="0" width="385" height="96" scrolling="no" src="http://tianqi.2345.com/plugin/widget/index.htm?s=1&v=0&f=1&b=&k=&t=0&a=1&c=54511&d=3&e=1"></iframe></span> -->
	
	<div ><span>
 <a href="<%= request.getContextPath()%>/user/secede.do">注销</a><div id="id0" align="right"></div><p  style="text-align:right;font-sixe:24px">欢迎您,${user.chineseName}</p></span></div>
 
 </body>
</html>
