package org.leopard.dao.rank;

import java.util.List;

import org.leopard.model.rank.Rank;
/**
 * 
 * Package : org.leopard.dao.rank
 *
 * @author ��˾��   -- CX -- ����
 *
 *		   2013-7-9 ����2:11:19
 *
 */
public interface RankDao {
/**
 * 
 * @param rank
 * @return
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:11:23
 */
public	List<Rank> rankList(Rank rank);
/**
 * 
 * @param rank
 * @return
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:11:26
 */
public int getAllCount(Rank rank);
/**
 * 
 * @param rank
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:11:29
 */
public void addRank(Rank rank);
/**
 * 
 * @param rank
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:11:32
 */
public void delRank(Rank rank);
/**
 * 
 * @param rank
 * @return
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:11:35
 */
public Rank getRankById(Rank rank);
/**
 * 
 * @param rank
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:11:38
 */
public void updateRank(Rank rank);

}
