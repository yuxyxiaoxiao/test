package org.leopard.service.menu;

import java.util.List;

import org.leopard.model.menu.Menu;
import org.leopard.model.role.Role;
import org.leopard.model.role.RoleMenu;
import org.leopard.model.user.User;
import org.leopard.model.user.UserRole;
/**
 * 
 * Package : org.leopard.service.menu
 *
 * @author 公司名   -- CX -- 程曦
 *
 *		   2013-7-9 下午2:16:13
 *
 */
public interface MenuService {
/**
 * 
 * @param roleList
 * @return
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:16:19
 */
public 	List<Menu> getMenuByRole(List<Role> roleList);
/**
 * 
 * @param role
 * @return
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:16:23
 */
public List<Menu> getMenuByRole(Role role);
/**
 * 
 * @return
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:16:28
 */
public List<Menu> getMenuList();
/**
 * 添加Menu
 * 
 * @param menu
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:16:31
 */
public void addMenu(Menu menu);
/**
 * 按照名字得到Menu
 * 
 * @param menu
 * @return
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:16:34
 */
public Menu getMenuByName(Menu menu);
/**
 * 按照id修改
 * 
 * @param menu
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:16:38
 */
public void updateByid(Menu menu);
/**
 * 按照id删除
 * 
 * @param menu
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:16:40
 */
public void deleteById(Menu menu);


}
