package org.leopard.dao.user_role;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.leopard.model.user.UserRole;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class UserRoleDaoImp extends HibernateDaoSupport implements UserRoleDao {

	@Override
	public void addUserRole(UserRole userRole) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(userRole);
	}

	@Override
	public void delUserRole(final UserRole userRole) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "delete from UserRole where roleId in(:ids) and userId = :userIds";
				Query query = session.createQuery(hql);
				query.setParameterList("ids", userRole.getList());
				query.setParameter("userIds", userRole.getUserId());
				query.executeUpdate();
				return null;
			}

		});
	}

}
