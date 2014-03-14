package org.leopard.service.rank;

import java.util.List;

import org.leopard.model.rank.Rank;
/**
 * 
 * Package : org.leopard.service.rank
 *
 * @author 公司名   -- CX -- 程曦
 *
 *		   2013-7-9 下午2:16:47
 *
 */
public interface RankService {
	/**
	 * 
	 * @param rank
	 * @return
	 *
	 * @author 公司名-- CX -- 程曦
	 *
	 *	       2013-7-9 下午2:16:50
	 */
public	List<Rank> rankList(Rank rank);
/**
 * 
 * @param rank
 * @return
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:16:53
 */
public int getAllCount(Rank rank);
/**
 * 
 * @param rank
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:16:55
 */
public void addRank(Rank rank);
/**
 * 
 * @param rank
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:16:58
 */
public void delRank(Rank rank);
/**
 * 
 * @param rank
 * @return
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:17:00
 */
public Rank getRankById(Rank rank);
/**
 * 
 * @param rank
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:17:02
 */
public void updateRank(Rank rank);

}
