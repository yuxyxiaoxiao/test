package org.leopard.dao.role_menu;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.leopard.model.role.RoleMenu;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class RoleMenuDaoImp extends HibernateDaoSupport implements RoleMenuDao {

	@Override
	public void delete(final RoleMenu roleMenu) {
		// TODO Auto-generated method stub
this.getHibernateTemplate().execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				String hql = "delete from RoleMenu roleMenu where roleMenu.roleId=?";
				Query query = session.createQuery(hql);
				query.setInteger(0, roleMenu.getRoleId());
				query.executeUpdate();
				return null;
			}
		});
	}

	@Override
	public void updateRoleMenu(RoleMenu roleMenuInfo) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(roleMenuInfo);
	}

}
