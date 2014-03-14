package org.leopard.service.role;

import java.util.List;

import org.leopard.model.menu.Menu;
import org.leopard.model.role.Role;
import org.leopard.model.user.User;
import org.leopard.model.user.UserRole;
/**
 * 角色相关操作
 * 
 * Package : org.leopard.service.role
 *
 * @author 公司名   -- CX -- 程曦
 *
 *		   2013-7-9 下午2:17:08
 *
 */
public interface RoleService {
	/**
	 * 得到用户的角色
	 * 
	 * @param user
	 * @return
	 *
	 * @author 公司名-- CX -- 程曦
	 *
	 *	       2013-7-9 下午2:17:10
	 */
public	List<Role> getRoleByUser(User user);
/**
 * 得到全部
 * 
 * @param role
 * @return
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:17:13
 */
public int getAllCount(Role role);
/**
 * 
 * @param role
 * @return
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:17:15
 */
public List<Role> getRolePageList(Role role);
/**
 * 添加角色
 * 
 * @param role
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:17:17
 */
public void addRole(Role role);
/**
 * 删除角色
 * 
 * @param role
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:17:21
 */
public void delRole(Role role);
/**
 * 
 * @param role
 * @return
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:17:28
 */
public Role selectRoleName(Role role);
/**
 * 
 * @param user
 * @return
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:17:30
 */
public List<Role> getNotRoleByUser(User user);
/**
 * 修改角色
 * 
 * @param role
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:17:32
 */
public void updateRole(Role role);
/**
 * 得到角色   按照Id
 * 
 * @param role
 * @return
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:17:34
 */
public Role getRoleById(Role role);

   
}
