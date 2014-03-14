package org.leopard.dao.role;

import java.util.List;

import org.leopard.model.menu.Menu;
import org.leopard.model.role.Role;
import org.leopard.model.user.User;
import org.leopard.model.user.UserRole;
/**
 * 
 * Package : org.leopard.dao.role
 *
 * @author 公司名   -- CX -- 程曦
 *
 *		   2013-7-9 下午2:11:58
 *
 */
public interface RoleDao {
	/**
	 * 
	 * @param user
	 * @return
	 *
	 * @author 公司名-- CX -- 程曦
	 *
	 *	       2013-7-9 下午2:12:02
	 */
	public List<Role> getRoleByUser(User user);
	/**
	 * 
	 * 
	 * @param role
	 * @return
	 *
	 * @author 公司名-- CX -- 程曦
	 *
	 *	       2013-7-9 下午2:12:06
	 */
	public int getAllCount(Role role);
	/**
	 * 得到角色
	 * 
	 * @param role
	 * @return
	 *
	 * @author 公司名-- CX -- 程曦
	 *
	 *	       2013-7-9 下午2:12:09
	 */
	public List<Role> getRolePageList(Role role);
	/**
	 * 添加
	 * 
	 * @param role
	 *
	 * @author 公司名-- CX -- 程曦
	 *
	 *	       2013-7-9 下午2:12:13
	 */
	public void addRole(Role role);
	/**
	 * 删除
	 * 
	 * @param role
	 *
	 * @author 公司名-- CX -- 程曦
	 *
	 *	       2013-7-9 下午2:12:17
	 */
	public void delRole(Role role);
	/**
	 * 角色展示
	 * 
	 * @param role
	 * @return
	 *
	 * @author 公司名-- CX -- 程曦
	 *
	 *	       2013-7-9 下午2:12:22
	 */
	public Role selectRoleName(Role role);
	/**
	 * 没有的角色
	 * 
	 * @param user
	 * @return
	 *
	 * @author 公司名-- CX -- 程曦
	 *
	 *	       2013-7-9 下午2:12:26
	 */
	public List<Role> getNotRoleByUser(User user);
	/**
	 * 修改
	 * 
	 * @param role
	 *
	 * @author 公司名-- CX -- 程曦
	 *
	 *	       2013-7-9 下午2:12:29
	 */
	public void updateRole(Role role);
	/**
	 * 按id得到角色
	 * 
	 * @param role
	 * @return
	 *
	 * @author 公司名-- CX -- 程曦
	 *
	 *	       2013-7-9 下午2:12:33
	 */
	public Role getRoleById(Role role);

	
}
