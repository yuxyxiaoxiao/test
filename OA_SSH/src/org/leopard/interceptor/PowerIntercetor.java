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
//	        //��ȡ��ǰ�û����е�Ȩ��
//	        List<OperatorPurviewDO> operatorPurviews = getCurrentOperatorPurviews();
//	        
//	        //��ȡ��ǰ������url
//	        String currentUrl = getCurrentUrl(); 
//	        
//	         //����ǳ�������Ա���е�ǰurl��Ȩ�ޣ���ôֱ�ӷ��ء�
//	        if (OperatorUtil.getIsSuperAdmin() ||(OperatorUtil.getLoginName()!=null&&authorityUtil.checkUrl(operatorPurviews, currentUrl))){
//	             return invocation.invoke();
//	        }
//	         
//	        if (!OperatorUtil.getIsSuperAdmin()&&operatorPurviews.size()==0) {
//	            LOG.info("���û�:" + OperatorUtil.getLoginName() + " û���κν�ɫ��û��Ȩ��ִ���κι���"); 
//	            return "loginErr"; 
//	        }   
//	            return "authorityErr";
//	    }
		return null;
	}

}
