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
 * @author ��˾��   -- CX -- ����
 *
 *		   2013-7-9 ����2:16:13
 *
 */
public interface MenuService {
/**
 * 
 * @param roleList
 * @return
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:16:19
 */
public 	List<Menu> getMenuByRole(List<Role> roleList);
/**
 * 
 * @param role
 * @return
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:16:23
 */
public List<Menu> getMenuByRole(Role role);
/**
 * 
 * @return
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:16:28
 */
public List<Menu> getMenuList();
/**
 * ���Menu
 * 
 * @param menu
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:16:31
 */
public void addMenu(Menu menu);
/**
 * �������ֵõ�Menu
 * 
 * @param menu
 * @return
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:16:34
 */
public Menu getMenuByName(Menu menu);
/**
 * ����id�޸�
 * 
 * @param menu
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:16:38
 */
public void updateByid(Menu menu);
/**
 * ����idɾ��
 * 
 * @param menu
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:16:40
 */
public void deleteById(Menu menu);


}
