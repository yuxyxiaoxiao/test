package org.leopard.service.rank;

import java.util.ArrayList;
import java.util.List;

import org.leopard.dao.rank.RankDao;
import org.leopard.model.rank.Rank;

public class RankServiceImp implements RankService {
	private RankDao rankDao;

	public RankDao getRankDao() {
		return rankDao;
	}

	public void setRankDao(RankDao rankDao) {
		this.rankDao = rankDao;
	}

	@Override
	public List<Rank> rankList(Rank rank) {
		// TODO Auto-generated method stub
		return rankDao.rankList(rank);
	}

	@Override
	public int getAllCount(Rank rank) {
		// TODO Auto-generated method stub
		return rankDao.getAllCount(rank);
	}

	@Override
	public void addRank(Rank rank) {
		// TODO Auto-generated method stub
		rankDao.addRank(rank);
	}

	@Override
	public void delRank(Rank rank) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		String[] ids = rank.getDelIds().split(",");
		for (String id : ids) {
			list.add(Integer.parseInt(id));
		}
		rank.setDelList(list);
		rankDao.delRank(rank);
	}

	@Override
	public Rank getRankById(Rank rank) {
		// TODO Auto-generated method stub
		return rankDao.getRankById(rank);
	}

	@Override
	public void updateRank(Rank rank) {
		// TODO Auto-generated method stub
		rankDao.updateRank(rank);
	}

}
