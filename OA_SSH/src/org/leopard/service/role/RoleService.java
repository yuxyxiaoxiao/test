package org.leopard.service.role;

import java.util.List;

import org.leopard.model.menu.Menu;
import org.leopard.model.role.Role;
import org.leopard.model.user.User;
import org.leopard.model.user.UserRole;
/**
 * ��ɫ��ز���
 * 
 * Package : org.leopard.service.role
 *
 * @author ��˾��   -- CX -- ����
 *
 *		   2013-7-9 ����2:17:08
 *
 */
public interface RoleService {
	/**
	 * �õ��û��Ľ�ɫ
	 * 
	 * @param user
	 * @return
	 *
	 * @author ��˾��-- CX -- ����
	 *
	 *	       2013-7-9 ����2:17:10
	 */
public	List<Role> getRoleByUser(User user);
/**
 * �õ�ȫ��
 * 
 * @param role
 * @return
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:17:13
 */
public int getAllCount(Role role);
/**
 * 
 * @param role
 * @return
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:17:15
 */
public List<Role> getRolePageList(Role role);
/**
 * ��ӽ�ɫ
 * 
 * @param role
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:17:17
 */
public void addRole(Role role);
/**
 * ɾ����ɫ
 * 
 * @param role
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:17:21
 */
public void delRole(Role role);
/**
 * 
 * @param role
 * @return
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:17:28
 */
public Role selectRoleName(Role role);
/**
 * 
 * @param user
 * @return
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:17:30
 */
public List<Role> getNotRoleByUser(User user);
/**
 * �޸Ľ�ɫ
 * 
 * @param role
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:17:32
 */
public void updateRole(Role role);
/**
 * �õ���ɫ   ����Id
 * 
 * @param role
 * @return
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:17:34
 */
public Role getRoleById(Role role);

   
}
