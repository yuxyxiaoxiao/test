package org.leopard.service.user_role;

import org.leopard.model.user.UserRole;

/**
 * 用户权限相关操作
 * 
 * Package : org.leopard.service.user_role
 *
 * @author 公司名   -- CX -- 程曦
 *
 *		   2013-7-9 下午2:20:37
 *
 */
public interface UserRoleService {
	/**
	 * 添加权限
	 * 
	 * @param userRole
	 *
	 * @author 公司名-- CX -- 程曦
	 *
	 *	       2013-7-9 下午2:20:39
	 */
public	void addUserRole(UserRole userRole);
/**
 * 删除权限
 * 
 * @param userRole
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:20:41
 */
public void delUserRole(UserRole userRole);
}
