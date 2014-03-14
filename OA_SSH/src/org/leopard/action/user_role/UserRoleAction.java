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
 * @author 公司名 -- 用户名
 *
 *		   2013-7-2 下午10:09:43
 *
 */
public class UserRoleAction extends BaseAction{
	
	/** userRole关系表Service*/
	private UserRoleService userRoleService;
	
	/** 角色Service*/
	private RoleService roleService;
	
	/** 用户Service*/
	private UserService userService;
	/** 用户实体*/
	private User user = new User();
	/** 用户角色列表用于页面显示*/
	public List<Role> userRoleList;
	/** 非用户角色列表用于页面显示*/
	public List<Role> userNotRoleList;
	/** 用户角色关系表实体*/
	private UserRole userRole = new UserRole();
	/**
	 * 跳转到给用户受角色
	 * @return
	 *
	 * @author 公司名 -- 用户名
	 *
	 *	       2013-6-27 下午11:02:36
	 */
	public String toUserRole(){
		user = (User) userService.getUser(user);
		userRoleList = 	roleService.getRoleByUser(user);
		userNotRoleList = roleService.getNotRoleByUser(user);
		return SUCCESS;
	}
	
	/**
	 * 用户添加角色
	 * 
	 *
	 * @author 公司名 -- 用户名
	 *
	 *	       2013-7-2 下午10:15:09
	 */
	public void addUserRole(){
		userRoleService.addUserRole(userRole);
		
	}
	
	/**
	 * 删除用户角色
	 * 
	 *
	 * @author 公司名 -- 用户名
	 *
	 *	       2013-7-2 下午10:15:44
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
