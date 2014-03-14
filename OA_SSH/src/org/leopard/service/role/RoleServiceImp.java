package org.leopard.service.role;

import java.util.ArrayList;
import java.util.List;

import org.leopard.dao.role.RoleDao;
import org.leopard.model.menu.Menu;
import org.leopard.model.role.Role;
import org.leopard.model.user.User;
import org.leopard.model.user.UserRole;

public class RoleServiceImp implements RoleService{
	private  RoleDao  roleDao;

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public List<Role> getRoleByUser(User user) {
		// TODO Auto-generated method stub
		return roleDao.getRoleByUser(user);
	}

	@Override
	public int getAllCount(Role role) {
		// TODO Auto-generated method stub
		return roleDao.getAllCount(role);
	}

	@Override
	public List<Role> getRolePageList(Role role) {
		// TODO Auto-generated method stub
		return roleDao.getRolePageList(role);
	}

	@Override
	public void addRole(Role role) {
		// TODO Auto-generated method stub
		roleDao.addRole(role);
	}

	@Override
	public void delRole(Role role) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		String[] ids = role.getDelId().split(",");
		for(String id :ids){
			list.add(Integer.valueOf(id));
		}
		role.setDelIdList(list);
		roleDao.delRole(role);
	}

	@Override
	public Role selectRoleName(Role role) {
		// TODO Auto-generated method stub
		return roleDao.selectRoleName(role);
	}

	@Override
	public List<Role> getNotRoleByUser(User user) {
		// TODO Auto-generated method stub
		return roleDao.getNotRoleByUser(user);
	}

	@Override
	public void updateRole(Role role) {
		// TODO Auto-generated method stub
		roleDao.updateRole(role);
	}

	@Override
	public Role getRoleById(Role role) {
		// TODO Auto-generated method stub
		return roleDao.getRoleById(role);
	}
	
}
