package org.leopard.dao.role;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.leopard.model.menu.Menu;
import org.leopard.model.role.Role;
import org.leopard.model.user.User;
import org.leopard.model.user.UserRole;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class RoleDaoImp extends HibernateDaoSupport implements RoleDao {

	

	@Override
	public int getAllCount(final Role role) {
		// TODO Auto-generated method stub
		int count = 0;
		count = (Integer) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						List paramValueList = new ArrayList();
						StringBuffer hql = new StringBuffer(
								"select count(*) from Role where 1=1");
						Query query = getRoleQuery(role, hql, paramValueList,
								session);

						// Criteria createCriteria =
						// session.createCriteria(hql);
						// createCriteria.uniqueResult();
						return query.uniqueResult();
					}
				});
		return count;
	}
	
	private Query getRoleQuery(Role role, StringBuffer hql,
			List paramValueList, Session session) {
		String roleName = role.getRoleName();
		if (null != role && null != roleName
				&& roleName.length() > 0) {
			hql.append(" and roleName like '%'||?||'%'");
			paramValueList.add(roleName);
		}
		Query query = session.createQuery(hql.toString());
		for (int i = 0; i < paramValueList.size(); i++) {
			query.setParameter(i, paramValueList.get(i));
		}

		return query;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getRolePageList(final Role role) {
		// TODO Auto-generated method stub
		List<Role> roleList = new ArrayList<Role>();
		roleList = (List<Role>) this.getHibernateTemplate().execute(
				new HibernateCallback() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						List paramValueList = new ArrayList();
						StringBuffer hql = new StringBuffer(
								"Select new Role(role.id,role.roleName) from Role role where 1=1");
						Query query = getRoleQuery(role, hql, paramValueList,
								session);
						query.setFirstResult(role.getStartPos());
						query.setMaxResults(role.getPageSize());
						return query.list();
					}
				});
		return roleList;
	}

	@Override
	public void addRole(Role role) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(role);
	}

	@Override
	public void delRole(final Role role) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				String hql = "delete from Role where id in(:id)";
				Query query = session.createQuery(hql);
				query.setParameterList("id", role.getDelIdList());
				query.executeUpdate();
				return null;
			}
		});
	}

	@Override
	public Role selectRoleName(final Role role) {
		// TODO Auto-generated method stub
		Role userRoleInfo = null;
		userRoleInfo = (Role) this.getHibernateTemplate().execute(
				new HibernateCallback() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						String hql = "from Role where rolename = ?";
						Query query = session.createQuery(hql);
						query.setString(0, role.getRoleName());
						Object uniqueResult = query.uniqueResult();
						if (uniqueResult == null)
							uniqueResult = -1;
						return uniqueResult;
					}
				});
		return userRoleInfo;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getRoleByUser(final User user) {
		// TODO Auto-generated method stub
		List<Role> list = new ArrayList<Role>();
		list = (List<Role>) this.getHibernateTemplate().execute(
				new HibernateCallback() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						String hql = "Select new Role(role.id,role.roleName) from Role role,UserRole userRole where role.id = userRole.roleId and userRole.userId = ? ";
						Query query = session.createQuery(hql);
						query.setInteger(0, user.getId());
						return query.list();
					}
				});
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getNotRoleByUser(final User user) {
		// TODO Auto-generated method stub
		List<Role> list = new ArrayList<Role>();
		list = (List<Role>) this.getHibernateTemplate().execute(
				new HibernateCallback() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						String h = "from UserRole userRole where userRole.userId = ?";
						Query queryh = session.createQuery(h);
						queryh.setInteger(0, user.getId());
						List<UserRole> userRoleList  =  queryh.list();
						List<Integer> userRoleIdList  = new ArrayList<Integer>();
						userRoleIdList.add(-1);
						if(null != userRoleList && userRoleList.size() >0){
							for(UserRole userRole : userRoleList){
								userRoleIdList.add(userRole.getRoleId());
							}
						}	
					
						String hql = "Select new Role(role.id,role.roleName) from Role role where role.id not in(:ids)";
						Query query = session.createQuery(hql);
						query.setParameterList("ids",userRoleIdList);
						List list2 = query.list();
						return list2;
					}
				});
		return list;
	}

	@Override
	public void updateRole(Role role) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(role);
	}

	@Override
	public Role getRoleById(Role role) {
		// TODO Auto-generated method stub
		return (Role) this.getHibernateTemplate().get(Role.class,role.getId());
	}
	
}
