package org.leopard.action.role_menu;

import java.util.List;

import net.sf.json.JSONArray;

import org.leopard.action.BaseAction;
import org.leopard.model.menu.Menu;
import org.leopard.model.role.Role;
import org.leopard.model.role.RoleMenu;
import org.leopard.service.menu.MenuService;
import org.leopard.service.role_menu.RoleMenuService;

public class RoleMenuAction extends BaseAction {
	
	/** 角色权限Service*/
	private RoleMenuService roleMenuService;
	
	/** 权限列表*/
	private List<Menu> menuList;
	
	/** 角色所拥有的权限列表*/
	private List<Menu> roleMenuList;
	
	/** 权限Service*/
	private MenuService menuService;
	
	/** 权限实体*/
	private Role role = new Role();
	
	/** 角色权限实体*/
	private RoleMenu roleMenu = new RoleMenu();
	
	/** 用于页面显示用的json数据 */
	private String json;

	/**
	 * 显示Menu列表
	 * 
	 * 
	 * @author 公司名 -- 用户名
	 * 
	 *         2013-7-1 下午7:33:09
	 */
	public void toaddRoleMenu() {
		roleMenuList = menuService.getMenuByRole(role);
		menuList = menuService.getMenuList();
		for (Menu roleMenu : roleMenuList) {
			for (Menu menu : menuList) {
				if (roleMenu.getId() == menu.getId()) {
					menu.setChecked("true");
					break;
				}
			}
		}
		// 将treeList转换成JSON数组形式
		JSONArray fromObject = JSONArray.fromObject(menuList);
		// 将json转换成字符串为前台接收
		json = fromObject.toString();
		pwWrite(json);
	}
	
	/**
	 * 更新角色的权限
	 * 
	 *
	 * @author 公司名 -- 用户名
	 *
	 *	       2013-7-2 下午10:39:49
	 */
	public void updateRoleMenu() {

		roleMenuService.updateRoleMenu(roleMenu);
	}

	public RoleMenuService getRoleMenuService() {
		return roleMenuService;
	}

	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public List<Menu> getRoleMenuList() {
		return roleMenuList;
	}

	public void setRoleMenuList(List<Menu> roleMenuList) {
		this.roleMenuList = roleMenuList;
	}

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public RoleMenu getRoleMenu() {
		return roleMenu;
	}

	public void setRoleMenu(RoleMenu roleMenu) {
		this.roleMenu = roleMenu;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

}
