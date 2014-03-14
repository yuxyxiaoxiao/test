package org.leopard.action.menu;



import java.util.List;

import net.sf.json.JSONArray;

import org.leopard.action.BaseAction;

import org.leopard.model.menu.Menu;
import org.leopard.model.role.Role;
import org.leopard.model.user.User;
import org.leopard.service.menu.MenuService;
import org.leopard.service.role.RoleService;

/**
 * 
 * Package : org.leopard.action.menu
 *
 * @author ��˾�� -- CX -- ����
 *
 *		   2013-7-2 ����10:46:01
 *
 */

public class MenuAction extends BaseAction {
	
	
	/**
	 * Ȩ��service
	 */
	private MenuService menuService;
	
	/** �û���ɫ�б�*/
	public List<Role> userRoleList;
	
	/** �û�ʵ��model */
	private User user = new User();
	
	/** ��ɫService*/
	private RoleService roleService;
	
	/** Ȩ���б�*/
	public List<Menu> menuList;
	
	/** Ȩ��ʵ��*/
	private Menu menu = new Menu();
	
	/** ����ҳ����ʾ�õ�json���� */
	public String json;
	/**
	 * ��ȡȨ����   ���ݽ�ɫ
	 * @return
	 *
	 * @author ��˾�� -- CX -- ����
	 *
	 *	       2013-6-28 ����9:01:50
	 */
	public String menu(){
		List<Role> roleList = roleService.getRoleByUser(user);
		if(null != roleList && roleList.size() > 0){
			 menuList = menuService.getMenuByRole(roleList);
			request.getSession().setAttribute("menuList",menuList);
		}
		//��treeListת����JSON������ʽ
		JSONArray fromObject = JSONArray.fromObject(menuList);
		//��jsonת�����ַ���Ϊǰ̨����
		json = fromObject.toString();
		return SUCCESS;
	}
	
	/**
	 * ��ȡ����Ȩ��
	 * @return
	 *
	 * @author ��˾�� -- CX -- ����
	 *
	 *	       2013-7-3 ����6:49:01
	 */
	public String menuList(){
		menuList  =	menuService.getMenuList();
		//��treeListת����JSON������ʽ
		JSONArray fromObject = JSONArray.fromObject(menuList);
		// ��jsonת�����ַ���Ϊǰ̨����
		json = fromObject.toString();
		return SUCCESS;
	}
	
	/**
	 * ���Ȩ��
	 * 
	 *
	 * @author ��˾�� -- CX -- ����
	 *
	 *	       2013-7-3 ����6:49:21
	 */
	public void addMenu(){
		menuService.addMenu(menu);
		menu = menuService.getMenuByName(menu);
		pwWrite("{\"id\":"+menu.getId()+"}");//���������ݵ�idҳ����ӽڵ�  �Ա����ݿ��ҳ�汣��ͬ��
	}
	/**
	 * 
	 * �޸�
	 *
	 * @author ��˾��-- CX -- ����
	 *
	 *	       2013-7-9 ����11:42:29
	 */
	public void updateByid(){
		menuService.updateByid(menu);
	}
	
	public void deleteById(){
		menuService.deleteById(menu);
	}
	
	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	public List<Role> getUserRoleList() {
		return userRoleList;
	}
	public void setUserRoleList(List<Role> userRoleList) {
		this.userRoleList = userRoleList;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public RoleService getRoleService() {
		return roleService;
	}
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	public List<Menu> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
}
