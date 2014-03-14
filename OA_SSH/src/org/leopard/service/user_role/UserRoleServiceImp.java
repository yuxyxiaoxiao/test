package org.leopard.service.user_role;

import java.util.ArrayList;
import java.util.List;

import org.leopard.dao.user_role.UserRoleDao;
import org.leopard.model.user.UserRole;



public class UserRoleServiceImp implements UserRoleService{
	private UserRoleDao userRoleDao;

	public UserRoleDao getUserRoleDao() {
		return userRoleDao;
	}

	public void setUserRoleDao(UserRoleDao userRoleDao) {
		this.userRoleDao = userRoleDao;
	}

	@Override
	public void addUserRole(UserRole userRole) {
		// TODO Auto-generated method stub
		int userId = userRole.getUserId();
		String[] roleIds = userRole.getAddId().split(",");
		for(String roleId : roleIds){
			
					userRole.setUserId(userId);
					userRole.setRoleId(Integer.valueOf(roleId));
					userRoleDao.addUserRole(userRole);
		}
	}

	@Override
	public void delUserRole(UserRole userRole) {
		// TODO Auto-generated method stub
		String[] roleIds = userRole.getDelId().split(",");
		List<Integer> list = new ArrayList<Integer>();
		for(String roleId : roleIds){
			
			list.add(Integer.valueOf(roleId));
			
		}
		userRole.setList(list);
		userRoleDao.delUserRole(userRole);
	}
	
	
	
}
