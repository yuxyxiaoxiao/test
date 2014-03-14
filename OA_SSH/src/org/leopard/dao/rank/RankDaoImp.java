package org.leopard.dao.rank;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.leopard.model.rank.Rank;
import org.leopard.model.user.User;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class RankDaoImp extends HibernateDaoSupport implements RankDao {

	@Override
	public int getAllCount(final Rank rank) {
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
								"select count(*) from Rank where 1=1");
						Query query = getRankQuery(rank, hql, paramValueList,
								session);

						return query.uniqueResult();
					}
				});
		return count;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Rank> rankList(final Rank rank) {
		// TODO Auto-generated method stub
		List<Rank> rankList = new ArrayList<Rank>();
		rankList = (List<Rank>) this.getHibernateTemplate().execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				List paramValueList = new ArrayList();
				StringBuffer hql = new StringBuffer("from Rank where 1 = 1 ");
				Query query = getRankQuery(rank, hql, paramValueList,
						session);
				return query.list();
			}
		});
		return rankList;
	}

	private Query getRankQuery(Rank rank, StringBuffer hql,
			List paramValueList, Session session) {
		if(null != rank){
			String name = rank.getName();
			if (null != name
					&& name.length() > 0) {
				hql.append(" and name like '%'||?||'%'");
				paramValueList.add(name);
			}
			
		}
		
		
		Query query = session.createQuery(hql.toString());
		int size = paramValueList.size();
		for (int i = 0; i < size; i++) {
			query.setParameter(i, paramValueList.get(i));
		}

		return query;
	}


	@Override
	public void addRank(Rank rank) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(rank);
	}


	@Override
	public void delRank(final Rank rank) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				String hql = "delete from Rank where id in(:ids)";
				Query query = session.createQuery(hql);
				query.setParameterList("ids",rank.getDelList());
				query.executeUpdate();
				return null;
			}
		});
	}


	@Override
	public Rank getRankById(Rank rank) {
		// TODO Auto-generated method stub
		return (Rank) this.getHibernateTemplate().get(Rank.class,rank.getId());
	}


	@Override
	public void updateRank(Rank rank) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(rank);
	}
	
}
