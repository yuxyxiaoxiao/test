package org.leopard.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class GetHttpServletRequest extends HttpServletRequestWrapper{
	HttpServletRequest request;
	
	public GetHttpServletRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getParameter(String name) {
		// TODO Auto-generated method stub
		String parameter = request.getParameter(name);
		if(parameter !=null && parameter.length()>0){
			try {
				name = new String(parameter.getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return name;
		}else{
			
			return super.getParameter(name);
		}
	}
	
	
}
