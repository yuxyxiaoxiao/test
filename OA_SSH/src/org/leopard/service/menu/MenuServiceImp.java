package org.leopard.service.menu;

import java.util.List;

import org.leopard.dao.menu.MenuDao;
import org.leopard.model.menu.Menu;
import org.leopard.model.role.Role;
import org.leopard.model.role.RoleMenu;
import org.leopard.model.user.User;



public class MenuServiceImp implements MenuService{
	private  MenuDao  menuDao;

	public MenuDao getMenuDao() {
		return menuDao;
	}

	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	@Override
	public List<Menu> getMenuByRole(List<Role> roleList) {
		// TODO Auto-generated method stub
		return menuDao.getMenuByRole(roleList);
	}

	@Override
	public List<Menu> getMenuByRole(Role role) {
		// TODO Auto-generated method stub
		return menuDao.getMenuByRole(role);
	}

	@Override
	public List<Menu> getMenuList() {
		// TODO Auto-generated method stub
		return menuDao.getMenuList();
	}

	@Override
	public void addMenu(Menu menu) {
		// TODO Auto-generated method stub
		menuDao.addMenu(menu);
	}

	@Override
	public Menu getMenuByName(Menu menu) {
		// TODO Auto-generated method stub
		return menuDao.getMenuByName(menu);
	}

	@Override
	public void updateByid(Menu menu) {
		// TODO Auto-generated method stub
		menuDao.updateByid(menu);
	}
	public void deleteById(Menu menu){
		menuDao.deleteById(menu);
	}

}
