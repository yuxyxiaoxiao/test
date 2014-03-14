package org.leopard.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ServletResponseAware,ServletRequestAware{
	protected HttpServletResponse response;
	protected HttpServletRequest request;
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}
	/**
	 * 输出
	 * @param str
	 *
	 * @author 公司名 -- 用户名
	 *
	 *	       2013-7-2 下午8:25:42
	 */
	public void pwWrite(String str){
		PrintWriter pw = null;
		try {
			response.setCharacterEncoding("utf-8");
			 pw = response.getWriter();
			pw.write(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(null != pw){
				pw.close();
				pw = null;
			}
		}
	}
}
