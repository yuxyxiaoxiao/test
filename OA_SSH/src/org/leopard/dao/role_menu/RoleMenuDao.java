package org.leopard.dao.role_menu;

import org.leopard.model.role.RoleMenu;
/**
 * 
 * Package : org.leopard.dao.role_menu
 *
 * @author 公司名   -- CX -- 程曦
 *
 *		   2013-7-9 下午2:14:07
 *
 */
public interface RoleMenuDao {
/**
 * 
 * @param roleMenu
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:14:10
 */
public	void delete(RoleMenu roleMenu);
/**
 * 
 * @param roleMenuInfo
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:14:13
 */
public void updateRoleMenu(RoleMenu roleMenuInfo);

}
