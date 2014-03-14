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
 * @author ��˾��   -- CX -- ����
 *
 *		   2013-7-9 ����2:11:58
 *
 */
public interface RoleDao {
	/**
	 * 
	 * @param user
	 * @return
	 *
	 * @author ��˾��-- CX -- ����
	 *
	 *	       2013-7-9 ����2:12:02
	 */
	public List<Role> getRoleByUser(User user);
	/**
	 * 
	 * 
	 * @param role
	 * @return
	 *
	 * @author ��˾��-- CX -- ����
	 *
	 *	       2013-7-9 ����2:12:06
	 */
	public int getAllCount(Role role);
	/**
	 * �õ���ɫ
	 * 
	 * @param role
	 * @return
	 *
	 * @author ��˾��-- CX -- ����
	 *
	 *	       2013-7-9 ����2:12:09
	 */
	public List<Role> getRolePageList(Role role);
	/**
	 * ���
	 * 
	 * @param role
	 *
	 * @author ��˾��-- CX -- ����
	 *
	 *	       2013-7-9 ����2:12:13
	 */
	public void addRole(Role role);
	/**
	 * ɾ��
	 * 
	 * @param role
	 *
	 * @author ��˾��-- CX -- ����
	 *
	 *	       2013-7-9 ����2:12:17
	 */
	public void delRole(Role role);
	/**
	 * ��ɫչʾ
	 * 
	 * @param role
	 * @return
	 *
	 * @author ��˾��-- CX -- ����
	 *
	 *	       2013-7-9 ����2:12:22
	 */
	public Role selectRoleName(Role role);
	/**
	 * û�еĽ�ɫ
	 * 
	 * @param user
	 * @return
	 *
	 * @author ��˾��-- CX -- ����
	 *
	 *	       2013-7-9 ����2:12:26
	 */
	public List<Role> getNotRoleByUser(User user);
	/**
	 * �޸�
	 * 
	 * @param role
	 *
	 * @author ��˾��-- CX -- ����
	 *
	 *	       2013-7-9 ����2:12:29
	 */
	public void updateRole(Role role);
	/**
	 * ��id�õ���ɫ
	 * 
	 * @param role
	 * @return
	 *
	 * @author ��˾��-- CX -- ����
	 *
	 *	       2013-7-9 ����2:12:33
	 */
	public Role getRoleById(Role role);

	
}
