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
	
	/** ��ɫȨ��Service*/
	private RoleMenuService roleMenuService;
	
	/** Ȩ���б�*/
	private List<Menu> menuList;
	
	/** ��ɫ��ӵ�е�Ȩ���б�*/
	private List<Menu> roleMenuList;
	
	/** Ȩ��Service*/
	private MenuService menuService;
	
	/** Ȩ��ʵ��*/
	private Role role = new Role();
	
	/** ��ɫȨ��ʵ��*/
	private RoleMenu roleMenu = new RoleMenu();
	
	/** ����ҳ����ʾ�õ�json���� */
	private String json;

	/**
	 * ��ʾMenu�б�
	 * 
	 * 
	 * @author ��˾�� -- �û���
	 * 
	 *         2013-7-1 ����7:33:09
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
		// ��treeListת����JSON������ʽ
		JSONArray fromObject = JSONArray.fromObject(menuList);
		// ��jsonת�����ַ���Ϊǰ̨����
		json = fromObject.toString();
		pwWrite(json);
	}
	
	/**
	 * ���½�ɫ��Ȩ��
	 * 
	 *
	 * @author ��˾�� -- �û���
	 *
	 *	       2013-7-2 ����10:39:49
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
