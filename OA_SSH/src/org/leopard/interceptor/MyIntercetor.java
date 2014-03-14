package org.leopard.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyIntercetor implements Interceptor {
	HttpServletRequest request;
	@Override
	public void destroy() {

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation inv) throws Exception {
		ActionContext ict = inv.getInvocationContext();
		 request = (HttpServletRequest) ict.get(StrutsStatics.HTTP_REQUEST);
		HttpSession session = request.getSession();
		//String projectName = request.getContentType();
		String requestName = request.getRequestURI();
		String name = requestName.substring(requestName.lastIndexOf("/")+1,requestName.lastIndexOf("."));
		if(name.equals("image")){
			inv.invoke();
		}else
		if(name.equals("login")){
			inv.invoke();
		}else
		if(session.getAttribute("user") == null){
			return "error";
		}else{
			inv.invoke();
		}
		return null;
	}
}
