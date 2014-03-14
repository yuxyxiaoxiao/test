package org.leopard.dao.menu;

import java.util.List;

import org.leopard.model.menu.Menu;
import org.leopard.model.role.Role;
import org.leopard.model.role.RoleMenu;

/**
 * 
 * Package : org.leopard.dao.menu
 *
 * @author ��˾��   -- CX -- ����
 *
 *		   2013-7-9 ����2:11:44
 *
 */
public interface MenuDao {
/**
 * 
 * @param role
 * @return
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:08:23
 */
public	List<Menu> getMenuByRole(Role role);
/**
 * 
 * @param roleList
 * @return
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:08:29
 */
public List<Menu> getMenuByRole(List<Role> roleList);
/**
 * 
 * @return
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:08:33
 */
public List<Menu> getMenuList();
/**
 * ���
 * 
 * @param menu
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:08:36
 */
public void addMenu(Menu menu);
/**
 * �õ���
 * 
 * @param menu
 * @return
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:08:39
 */
public Menu getMenuByName(Menu menu);
/**
 * ����id�޸�
 * 
 * @param menu
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:08:42
 */
public void updateByid(Menu menu);
/**
 * ɾ������id
 * 
 * @param menu
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:08:45
 */
public void deleteById(Menu menu);

	
}
