package org.leopard.service.role_menu;

import org.leopard.dao.role_menu.RoleMenuDao;
import org.leopard.model.role.RoleMenu;



public class RoleMenuServiceImp implements RoleMenuService{
		private RoleMenuDao roleMenuDao;

		public RoleMenuDao getRoleMenuDao() {
			return roleMenuDao;
		}

		public void setRoleMenuDao(RoleMenuDao roleMenuDao) {
			this.roleMenuDao = roleMenuDao;
		}

		@Override
		public void updateRoleMenu(RoleMenu roleMenu) {
			// TODO Auto-generated method stub
			String ids = roleMenu.getMenuIds();
			roleMenuDao.delete(roleMenu);
				if(ids.length()>0){
					
					String[] idArr = ids.split(",");
					RoleMenu roleMenuInfo = null;
					for(int i=0;i<idArr.length;i++){
						roleMenuInfo = new RoleMenu();
						roleMenuInfo.setRoleId(roleMenu.getRoleId());
						roleMenuInfo.setMenuId(Integer.valueOf(idArr[i]));
						roleMenuDao.updateRoleMenu(roleMenuInfo);
				}
			}
		}
		
		
}
