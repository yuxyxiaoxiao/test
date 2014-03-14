package org.leopard.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.opensymphony.xwork2.util.logging.Logger;

public class PowerIntercetor extends MethodFilterInterceptor {
//	  private static final long serialVersionUID = 1L; 
//	    private Logger LOG = Logger.getLogger(AuthorityInterceptor.class.getName()); 
//	    
//	    private AuthorityUtil authorityUtil;
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
//		  if (authorityUtil == null) {
//	            authorityUtil = new AuthorityUtil();
//	        }
//	        
//	        //获取当前用户所有的权限
//	        List<OperatorPurviewDO> operatorPurviews = getCurrentOperatorPurviews();
//	        
//	        //获取当前操作的url
//	        String currentUrl = getCurrentUrl(); 
//	        
//	         //如果是超级管理员或有当前url的权限，那么直接返回。
//	        if (OperatorUtil.getIsSuperAdmin() ||(OperatorUtil.getLoginName()!=null&&authorityUtil.checkUrl(operatorPurviews, currentUrl))){
//	             return invocation.invoke();
//	        }
//	         
//	        if (!OperatorUtil.getIsSuperAdmin()&&operatorPurviews.size()==0) {
//	            LOG.info("此用户:" + OperatorUtil.getLoginName() + " 没有任何角色，没有权限执行任何功能"); 
//	            return "loginErr"; 
//	        }   
//	            return "authorityErr";
//	    }
		return null;
	}

}
