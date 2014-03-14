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
 * @author 公司名 -- CX -- 程曦
 *
 *		   2013-7-2 下午10:46:01
 *
 */

public class MenuAction extends BaseAction {
	
	
	/**
	 * 权限service
	 */
	private MenuService menuService;
	
	/** 用户角色列表*/
	public List<Role> userRoleList;
	
	/** 用户实体model */
	private User user = new User();
	
	/** 角色Service*/
	private RoleService roleService;
	
	/** 权限列表*/
	public List<Menu> menuList;
	
	/** 权限实体*/
	private Menu menu = new Menu();
	
	/** 用于页面显示用的json数据 */
	public String json;
	/**
	 * 获取权限树   根据角色
	 * @return
	 *
	 * @author 公司名 -- CX -- 程曦
	 *
	 *	       2013-6-28 下午9:01:50
	 */
	public String menu(){
		List<Role> roleList = roleService.getRoleByUser(user);
		if(null != roleList && roleList.size() > 0){
			 menuList = menuService.getMenuByRole(roleList);
			request.getSession().setAttribute("menuList",menuList);
		}
		//将treeList转换成JSON数组形式
		JSONArray fromObject = JSONArray.fromObject(menuList);
		//将json转换成字符串为前台接收
		json = fromObject.toString();
		return SUCCESS;
	}
	
	/**
	 * 获取所有权限
	 * @return
	 *
	 * @author 公司名 -- CX -- 程曦
	 *
	 *	       2013-7-3 下午6:49:01
	 */
	public String menuList(){
		menuList  =	menuService.getMenuList();
		//将treeList转换成JSON数组形式
		JSONArray fromObject = JSONArray.fromObject(menuList);
		// 将json转换成字符串为前台接收
		json = fromObject.toString();
		return SUCCESS;
	}
	
	/**
	 * 添加权限
	 * 
	 *
	 * @author 公司名 -- CX -- 程曦
	 *
	 *	       2013-7-3 下午6:49:21
	 */
	public void addMenu(){
		menuService.addMenu(menu);
		menu = menuService.getMenuByName(menu);
		pwWrite("{\"id\":"+menu.getId()+"}");//输出添加数据的id页面添加节点  以便数据库和页面保持同步
	}
	/**
	 * 
	 * 修改
	 *
	 * @author 公司名-- CX -- 程曦
	 *
	 *	       2013-7-9 上午11:42:29
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
