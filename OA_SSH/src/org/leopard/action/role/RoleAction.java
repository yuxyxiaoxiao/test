package org.leopard.action.role;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.leopard.action.BaseAction;
import org.leopard.model.Page;
import org.leopard.model.role.Role;
import org.leopard.model.user.User;
import org.leopard.service.role.RoleService;

/**
 * 
 * Package : org.leopard.action.role
 * 
 * @author 公司名 -- 用户名
 * 
 *         2013-7-2 下午10:17:23
 * 
 */
public class RoleAction extends BaseAction {
	/** 角色Service */
	private RoleService roleService;
	/** 角色实体 */
	private Role role = new Role();
	/** 分页 */
	private Page page;
	/** flage=1时 ajaxpage分页 否则刷新整个页面 */
	private int flag;
	/** 角色列表用于页面显示 */
	private List<Role> roleList;

	/**
	 * 获取角色列表
	 * 
	 * @return
	 * 
	 * @author 公司名 -- 用户名
	 * 
	 *         2013-7-2 下午10:22:19
	 */
	public String roleList() {
		int totalCount = roleService.getAllCount(role);
		role.setTotalCount(totalCount); // 设置总条数
		role.calculatePage();// 设置总页数
		page = role; // 获取page对象以便页面使用
		roleList = roleService.getRolePageList(role);

		if (flag == 1) {
			return "ajaxpage";
		} else {
			return SUCCESS;
		}
	}

	/**
	 * 跳转到添加角色页面
	 * 
	 * @return
	 * 
	 * @author 公司名 -- 用户名
	 * 
	 *         2013-7-2 下午10:23:28
	 */
	public String toaddRole() {

		return SUCCESS;
	}

	/**
	 * 添加角色
	 * 
	 * @return
	 * 
	 * @author 公司名 -- 用户名
	 * 
	 *         2013-7-2 下午10:24:31
	 */
	public String addRole() {
		roleService.addRole(role);
		return SUCCESS;
	}

	/**
	 * 删除角色
	 * 
	 * 
	 * @author 公司名 -- 用户名
	 * 
	 *         2013-7-2 下午10:24:51
	 */
	public void delRole() {
		roleService.delRole(role);
	}

	/**
	 * 添加时角色查询角色名存不存在
	 * 
	 * 
	 * @author 公司名 -- 用户名
	 * 
	 *         2013-7-2 下午10:25:28
	 */
	public void selectRoleName() {
		Role ur = (Role) roleService.selectRoleName(role);
		if (null == ur) {
			pwWrite("ok"); //角色名不存在
		} else {
			pwWrite("no"); //角色名存在
		}
	}
	
	public String toUpdateRole(){
		role = roleService.getRoleById(role);
		return SUCCESS; 
	}
	/**
	 * 修改角色
	 * @return
	 *
	 * @author 公司名 -- 用户名
	 *
	 *	       2013-7-4 下午7:18:21
	 */
	public String updateRole(){
		roleService.updateRole(role);
		return SUCCESS;
	}
	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

}
