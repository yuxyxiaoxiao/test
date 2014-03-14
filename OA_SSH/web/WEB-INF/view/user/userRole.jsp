<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp"%>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0"><!-- #BeginLibraryItem "/Library/header.lbi" -->
<table width="100%" height="95%" border="0" cellpadding="10" cellspacing="0">
 <tr valign="top">
	<td><form name="form1" method="post" action="">
 
     <TABLE width="100%" height="10" border=0 class=top>
       <TBODY>
         <TR>
              
            <TD class=FormTitle width="100%"><B>客户用户管理—分配角色</B></TD>
         </TR>
         <TR>
           <TD width="100%" height=40 vAlign=bottom>                      <table width="100%" border="0">
             <tr>
                    
                  <td height="25" width="50%">用户：${user.id } ${user.chineseName}</td>
                    <input type="hidden" name="userId" id="userId" value="${param.id }">
                 
             </tr>
           </table>           
                <table width="100%" border="0" cellpadding="3" cellspacing="0" class="midTable1">
                  <tr> 
                    <td width="50%"  height="25" align="center" nowrap class="midTable1td1">可分配角色</td>
                    <td width="50%" align="center" class="midTable1td1">已分配角色</td>
                  </tr>
                  <tr> 
                    <td height="23" class="midTable1td2" valign="top">
                   <s:iterator var="notRole" value="userNotRoleList">
							<input type="checkbox" name="check" value="<s:property value="#notRole.id"/>">
							<s:property value="#notRole.roleName"/><br>
						</s:iterator>
                     </td>
                    <td class="midTable1td2" valign="top">
                    <s:iterator var="role" value="userRoleList">
							<input type="checkbox" name="check2" value="<s:property value="#role.id"/>">
							<s:property value="#role.roleName"/><br>
						</s:iterator>
                    </td>
                  </tr>
                  <tr> 
                    <td height="25" class="midTable1td3">
             <input type="checkbox" id="sel"  onclick="check1()">全选
<input  type="button" class="button" value="增加角色" onclick="addAlot()"></td>
                    <td class="midTable1td3">
             <input type="checkbox" id="sel2"  onclick="checkA()">全选
<input  type="button" class="button" value="刪除角色" onclick="delAlot()"></td>
                  </tr>
                </table>           
             <table width="100%" border="0" cellpadding="2" cellspacing="0" class="midTable1td4">
               <tr>
               <td align="right" height="25">
                   <div align="right"> </div>
                   
               </tr>
         </table></TD>
         </TR>
       </TBODY>
    </TABLE>
     </form>
</td>
 </tr>
 
</table>
<!-- #BeginLibraryItem "/Library/footer.lbi" -->
<table width="100%" border="0" cellpadding="0" cellspacing="0">
 <tr>
	<td class="pagefootTl"><img src="../graphics/space.gif" width="1" height="1"></td>
 </tr>
 <tr>
<td height="25" class="pagefoot"><font face="Arial, Helvetica, sans-serif">&copy;</font> 2005　 版权所有 摩托罗拉</td>
 </tr>
</table>
<!-- #EndLibraryItem --></body>
                  <script>
                  function addAlot()
                  {
                	  var allots = document.getElementsByName("check");
                	  var ids = "";
                	  for (var i = 0; i < allots.length; i++)
               		  {
               		  	if (allots[i].checked)
            		  	{
            		  		ids += allots[i].value+",";
            		  	}
               		  }
                	  
                	  	if (ids == "")
						{
						   alert("至少选一条");
						   return false;
						}
                	  	ids = ids.substring(0, ids.length-1);
                	  	var userId = ${user.id};
                	  	
                	 $.post(
                			 "<%=request.getContextPath() %>/userRoel/addUserRole.do",
                			 {"userRole.addId":ids,"userRole.userId":userId},
                			 function (data){
                			window.location.href="<%=request.getContextPath() %>/userRoel/toUserRole.do?user.id="+userId;               				 
                			 });
                  }
                  function delAlot()
                  {
                	  var allots = document.getElementsByName("check2");
                	  var ids = "";
                	  for (var i = 0; i < allots.length; i++)
               		  {
               		  	if (allots[i].checked)
            		  	{
            		  		ids += allots[i].value+",";
            		  	}
               		  }
                	  
                	  	if (ids == "")
						{
						   alert("至少选一条");
						   return false;
						}
                	  	ids = ids.substring(0, ids.length-1);
                	  	var userId = ${user.id};
                	  
                	  	 $.post(
                    			 "<%=request.getContextPath() %>/userRoel/delUserRole.do",
                    			 {"userRole.delId":ids,"userRole.userId":userId},
                    			 function (data){
                    			window.location.href="<%=request.getContextPath() %>/userRoel/toUserRole.do?user.id="+userId;               				 
                    			 });
                  }
                  function check1(){
                		var pros = document.getElementsByName("check");
                		var sel = document.getElementById("sel").checked;
                		for (var i=0;i<pros.length ;i++ ){
                			pros[i].checked = sel;
                		}
                	}
                  function checkA(){
                		var pros = document.getElementsByName("check2");
                		var sel = document.getElementById("sel2").checked;
                		for (var i=0;i<pros.length ;i++ ){
                			pros[i].checked = sel;
                		}
                	}
                  </script>
</html>
