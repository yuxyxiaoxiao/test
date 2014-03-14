package org.leopard.dao.menu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.leopard.model.menu.Menu;
import org.leopard.model.role.Role;
import org.leopard.model.role.RoleMenu;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MenuDaoImp extends HibernateDaoSupport implements MenuDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> getMenuByRole(List<Role> roleList) {
		// TODO Auto-generated method stub
		final List<Integer> roleIdList = new ArrayList<Integer>();
		for (Role role : roleList) {
			roleIdList.add(role.getId());
		}
		List<Menu> MenuList = new ArrayList<Menu>();
		MenuList = (List<Menu>) this.getHibernateTemplate().execute(
				new HibernateCallback() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						String hql = "select distinct new Menu(menu.id,menu.pid,menu.name,menu.url,menu.target) from  Menu menu,RoleMenu roleMenu where roleMenu.menuId = menu.id and roleMenu.roleId in (:roleIds)";
						Query query = session.createQuery(hql);
						query.setParameterList("roleIds", roleIdList);

						return query.list();
					}
				});
		return MenuList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> getMenuByRole(final Role role) {
		// TODO Auto-generated method stub
		List<Menu> menuLit = new ArrayList<Menu>();
		menuLit = (List<Menu>) this.getHibernateTemplate().execute(
				new HibernateCallback() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						String hql = "select new Menu(menu.id,menu.pid,menu.name,menu.url,menu.target) from  Menu menu,RoleMenu roleMenu where roleMenu.menuId = menu.id and roleMenu.roleId  = ?";
						Query query = session.createQuery(hql);
						query.setInteger(0, role.getId());
						return query.list();
					}
				});
		return menuLit;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> getMenuList() {
		// TODO Auto-generated method stub
		List<Menu> menuList = new ArrayList<Menu>();
		menuList = (List<Menu>) this.getHibernateTemplate().execute(
				new HibernateCallback() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						// List paramValueList = new ArrayList();
						StringBuffer hql = new StringBuffer(
								"Select new Menu(menu.id,menu.pid,menu.name,menu.url,menu.target) from Menu menu where 1=1");
						Query query = session.createQuery(hql.toString());
						return query.list();
					}
				});
		return menuList;
	}

	@Override
	public void addMenu(Menu menu) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(menu);
	}

	@Override
	public Menu getMenuByName(final Menu menu) {
		// TODO Auto-generated method stub
		Menu menu2 = null;
		menu2 = (Menu) this.getHibernateTemplate().execute(
				new HibernateCallback() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						String hql = "Select new Menu(menu.id,menu.pid,menu.name,menu.url,menu.target) from Menu menu where name = ?";
						Query query = session.createQuery(hql);
						query.setString(0, menu.getName());

						return query.uniqueResult();
					}
				});
		return menu2;
	}

	@Override
	public void updateByid(Menu menu) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(menu);
	}

	@Override
	public void deleteById(Menu menu) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(menu);
	}

}
