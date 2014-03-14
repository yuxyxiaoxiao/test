package org.leopard.action.user_role;


import java.util.List;

import org.leopard.action.BaseAction;
import org.leopard.model.role.Role;
import org.leopard.model.user.User;
import org.leopard.model.user.UserRole;
import org.leopard.service.role.RoleService;
import org.leopard.service.user.UserService;
import org.leopard.service.user_role.UserRoleService;
/**
 * 
 * Package : org.leopard.action.user_role
 *
 * @author ��˾�� -- �û���
 *
 *		   2013-7-2 ����10:09:43
 *
 */
public class UserRoleAction extends BaseAction{
	
	/** userRole��ϵ��Service*/
	private UserRoleService userRoleService;
	
	/** ��ɫService*/
	private RoleService roleService;
	
	/** �û�Service*/
	private UserService userService;
	/** �û�ʵ��*/
	private User user = new User();
	/** �û���ɫ�б�����ҳ����ʾ*/
	public List<Role> userRoleList;
	/** ���û���ɫ�б�����ҳ����ʾ*/
	public List<Role> userNotRoleList;
	/** �û���ɫ��ϵ��ʵ��*/
	private UserRole userRole = new UserRole();
	/**
	 * ��ת�����û��ܽ�ɫ
	 * @return
	 *
	 * @author ��˾�� -- �û���
	 *
	 *	       2013-6-27 ����11:02:36
	 */
	public String toUserRole(){
		user = (User) userService.getUser(user);
		userRoleList = 	roleService.getRoleByUser(user);
		userNotRoleList = roleService.getNotRoleByUser(user);
		return SUCCESS;
	}
	
	/**
	 * �û���ӽ�ɫ
	 * 
	 *
	 * @author ��˾�� -- �û���
	 *
	 *	       2013-7-2 ����10:15:09
	 */
	public void addUserRole(){
		userRoleService.addUserRole(userRole);
		
	}
	
	/**
	 * ɾ���û���ɫ
	 * 
	 *
	 * @author ��˾�� -- �û���
	 *
	 *	       2013-7-2 ����10:15:44
	 */
	public void delUserRole(){
		userRoleService.delUserRole(userRole);
		
	}
	
	public UserRoleService getUserRoleService() {
		return userRoleService;
	}

	public void setUserRoleService(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Role> getUserRoleList() {
		return userRoleList;
	}

	public void setUserRoleList(List<Role> userRoleList) {
		this.userRoleList = userRoleList;
	}

	public List<Role> getUserNotRoleList() {
		return userNotRoleList;
	}

	public void setUserNotRoleList(List<Role> userNotRoleList) {
		this.userNotRoleList = userNotRoleList;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	
	
}
