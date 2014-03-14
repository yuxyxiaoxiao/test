package org.leopard.interceptor;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.StrutsStatics;
import org.leopard.model.menu.Menu;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class AdminIntercetor extends MethodFilterInterceptor {
	public String dynamicURL;
	public int flag = 0;
	@Override
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		// TODO Auto-generated method stub
	ActionContext ioc = actionInvocation.getInvocationContext();
	 HttpServletRequest request = (HttpServletRequest) ioc.get(StrutsStatics.HTTP_REQUEST);
	 HttpSession session = request.getSession();
	 HttpServletResponse response = (HttpServletResponse) ioc.get(StrutsStatics.HTTP_RESPONSE);
	
	 String queryString = request.getQueryString();
	 if(null != queryString && queryString.length() > 0){
		dynamicURL = request.getRequestURI()+"?"+queryString;
	 }else{
		 dynamicURL = request.getRequestURI();
	 }
	 List<Menu> menuList = (List<Menu>) session.getAttribute("menuList");
	 if(dynamicURL.contains("to")){
		 flag = 1;
	 }
	 if(null != menuList){
	 	for(Menu menu : menuList){
	 		if(dynamicURL.equals(menu.getUrl())){
	 			flag = 1;
	 			break;
	 		}
	 	}
	 }
	 String header = request.getHeader("x-requested-with");
	 if( null == session.getAttribute("user")){
		//如果是ajax请求响应头会有，x-requested-with； 
		 if (request.getHeader("x-requested-with") != null  
                 && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){  
             response.setHeader("sessionstatus", "timeout");//在响应头设置session状态  
             response.setHeader("x-requested-with","XMLHttpRequest");//"x-requested-with","XMLHttpRequest"
             return null;
         }  
		// response.sendRedirect(dynamicURL);
		 session.setAttribute("dynamicURL",dynamicURL);
		 return "error";
	 }else{
//		 if(flag == 0){
//		 		return "error";
//		}
//		 
		 actionInvocation.invoke(); 
	 }
	 return null;
	}
	
	
	
	
	public String getDynamicURL() {
		return dynamicURL;
	}
	public void setDynamicURL(String dynamicURL) {
		this.dynamicURL = dynamicURL;
	}

	

}
