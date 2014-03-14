package org.leopard.dao.user;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.leopard.model.user.User;
import org.leopard.model.user.UserAttachFile;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class UserDaoImp extends HibernateDaoSupport implements UserDao {

	@Override
	public User getUserByName(final User user) {
		// TODO Auto-generated method stub
		User userInfo = null;
		userInfo = (User) this.getHibernateTemplate().execute(
				new HibernateCallback() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						String hql = "from User where username  = ?";
						Query query = session.createQuery(hql);
						query.setString(0, user.getUserName());
						Object uniqueResult = query.uniqueResult();
						
//					Criteria criteria = session.createCriteria(hql);
//					criteria.add(Restrictions.eq("username",user.getUserName()));
//					Object uniqueResult = criteria.uniqueResult();
						if (uniqueResult == null)
							uniqueResult = -1;
						return uniqueResult;
					}
				});
		return userInfo;
	}

	@Override
	public int getAllCount(final User user) {
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
								"select count(*) from User where 1=1");
						Query query = getUserQuery(user, hql, paramValueList,
								session);
						return query.uniqueResult();
					}
				});
		return count;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserPageList(final User user) {
		// TODO Auto-generated method stub
		List<User> userList = new ArrayList<User>();
		userList = (List<User>) this.getHibernateTemplate().execute(new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						List paramValueList = new ArrayList();
						Criteria cr = session.createCriteria(User.class);
						
						cr.setFirstResult(user.getStartPos());
						cr.setMaxResults(user.getPageSize());
						List list = getUserCriteria(user, session, paramValueList ,cr);
						
//						StringBuffer hql = new StringBuffer(
//								"from User where 1=1");
//						Query query = getUserQuery(user, hql, paramValueList,
//								session);
//						query.setFirstResult(user.getStartPos());
//						query.setMaxResults(user.getPageSize());
//						return query.list();
						return list;
					}
				});
		return userList;
	}
	//使用  Criteria   
	private List getUserCriteria(User user, Session session, List paramValueList, Criteria cr){
		
		if(null != user){
			
			String userName = user.getUserName();
			if (null != userName && userName.length() > 0) {
				cr.add(Restrictions.like("userName",userName));
			}
			
			String userSex = user.getUserSex();
			if (null != userSex && userSex.length() > 0) {
				cr.add(Restrictions.eq("userSex", userSex));
			}
			
			Integer userAge = user.getUserAge();
			if (null != userAge ) {
				cr.add(Restrictions.eq("userAge",userAge));
			}
			
			Date userStartBirthday = user.getUserStartBirthday();
			if (null != userStartBirthday) {
				cr.add(Restrictions.ge("userBirthday",userStartBirthday));
			}
			
			Date userEndBirthday = user.getUserEndBirthday();
			if (null != userEndBirthday) {
				cr.add(Restrictions.le("userBirthday",userEndBirthday));
			}
			
			Date userStartEntry = user.getUserStartEntry();
			if (null != userStartEntry) {
				cr.add(Restrictions.ge("userEntryDate",userStartEntry));
			}
			
			Date userEndEntry = user.getUserEndEntry();
			if (null != userEndEntry) {
				cr.add(Restrictions.le("userEntryDate",userEndEntry));
				Calendar calendar = Calendar.getInstance(); // 得到日历
				calendar.setTime(userEndEntry);// 把当前时间赋给日历
				calendar.add(Calendar.DAY_OF_MONTH, +1); // 设置为后一天
				paramValueList.add(calendar.getTime());
			}
		}
		List list = cr.list();
		return list;
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Query getUserQuery(User user, StringBuffer hql,
			List paramValueList, Session session) {
		if(null != user){
			String userName = user.getUserName();
			if (null != userName
					&& userName.length() > 0) {
				hql.append(" and userName like '%'||?||'%'");
				paramValueList.add(userName);
			}
			String userSex = user.getUserSex();
			if (null != userSex
					&& userSex.length() > 0) {
				hql.append(" and userSex  = ? ");
				paramValueList.add(userSex);
			}
			Integer userAge = user.getUserAge();
			if (null != userAge ) {
				hql.append(" and userAge  = ? ");
				paramValueList.add(userAge);
			}
			Date userStartBirthday = user.getUserStartBirthday();
			if (null != userStartBirthday) {
				hql.append(" and userBirthday >= ?");
				paramValueList.add(userStartBirthday);
			}
			Date userEndBirthday = user.getUserEndBirthday();
			if (null != userEndBirthday) {
				hql.append(" and userBirthday <= ?");
				paramValueList.add(userEndBirthday);
			}
			Date userStartEntry = user.getUserStartEntry();
			if (null != userStartEntry) {
				hql.append(" and userEntryDate >= ?");
				paramValueList.add(userStartEntry);
			}
			Date userEndEntry = user.getUserEndEntry();
			if (null != userEndEntry) {
				hql.append(" and userEntryDate <= ?");
				Calendar calendar = Calendar.getInstance(); // 得到日历
				calendar.setTime(userEndEntry);// 把当前时间赋给日历
				calendar.add(Calendar.DAY_OF_MONTH, +1); // 设置为后一天
				paramValueList.add(calendar.getTime());
			}
		}
		
		
		Query query = session.createQuery(hql.toString());
		int size = paramValueList.size();
		for (int i = 0; i < size; i++) {
			query.setParameter(i, paramValueList.get(i));
		}

		return query;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserAttachFile> attachFileList(final User user) {
		List<UserAttachFile> list = new ArrayList<UserAttachFile>();
		list = (List<UserAttachFile>) this.getHibernateTemplate().execute(
				new HibernateCallback() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						String hql = "from UserAttachFile where userid = ? ";
						Query query = session.createQuery(hql);
						query.setInteger(0, user.getId());
						return query.list();
					}
				});
		return list;
	}

	@Override
	public void delUSer(final User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "delete from User where id in(:id)";
				Query query = session.createQuery(hql);
				query.setParameterList("id", user.getDelIdList());
				query.executeUpdate();
				return null;
			}

		});
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(user);
	}

	@Override
	public void addUserAttachFile(UserAttachFile userAttachFile) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(userAttachFile);
	}

	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub
		return (User) this.getHibernateTemplate().get(User.class, user.getId());
	}

	@Override
	public void upPassword(final User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				String hql = "UPDATE User set password = ? WHERE id = ?";
				Query query = session.createQuery(hql);
				query.setParameter(0, user.getNewPassword());
				query.setParameter(1, user.getId());
				query.executeUpdate();
				return null;
			}
		});
	}

	@Override
	public Object getAttachFile(UserAttachFile userAttachFile) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(UserAttachFile.class,
				userAttachFile.getId());
	}

	@Override
	public void deleteAttachFile(final UserAttachFile userAttachFile) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				String hql = "delete from UserAttachFile where userId = ?";
				Query query = session.createQuery(hql);
				query.setInteger(0,userAttachFile.getUserId());
				query.executeUpdate();
				return null;
			}
		});
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(user);
	}
	
}
