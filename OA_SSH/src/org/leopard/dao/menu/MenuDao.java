package org.leopard.dao.menu;

import java.util.List;

import org.leopard.model.menu.Menu;
import org.leopard.model.role.Role;
import org.leopard.model.role.RoleMenu;

/**
 * 
 * Package : org.leopard.dao.menu
 *
 * @author 公司名   -- CX -- 程曦
 *
 *		   2013-7-9 下午2:11:44
 *
 */
public interface MenuDao {
/**
 * 
 * @param role
 * @return
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:08:23
 */
public	List<Menu> getMenuByRole(Role role);
/**
 * 
 * @param roleList
 * @return
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:08:29
 */
public List<Menu> getMenuByRole(List<Role> roleList);
/**
 * 
 * @return
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:08:33
 */
public List<Menu> getMenuList();
/**
 * 添加
 * 
 * @param menu
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:08:36
 */
public void addMenu(Menu menu);
/**
 * 得到树
 * 
 * @param menu
 * @return
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:08:39
 */
public Menu getMenuByName(Menu menu);
/**
 * 按照id修改
 * 
 * @param menu
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:08:42
 */
public void updateByid(Menu menu);
/**
 * 删除按照id
 * 
 * @param menu
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:08:45
 */
public void deleteById(Menu menu);

	
}
