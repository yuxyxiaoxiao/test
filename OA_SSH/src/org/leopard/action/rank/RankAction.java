package org.leopard.action.rank;

import java.util.List;

import org.leopard.action.BaseAction;
import org.leopard.model.Page;
import org.leopard.model.rank.Rank;
import org.leopard.service.rank.RankService;

public class RankAction extends BaseAction{
	
	/** 级别Service*/
	private RankService rankService;
	
	/** 级别列表List*/
	private List<Rank> rankList;
	
	/** 级别实体*/
	private Rank rank = new Rank();
	
	/** 分页实体*/
	private Page page = new Page();
	
	/** */
	private int flag;
	/**
	 * 获取级别列表
	 * @return
	 *
	 * @author 公司名 -- CX -- 程曦
	 *
	 *	       2013-7-3 下午10:56:38
	 */
	public String rankList(){
		int totalCount = rankService.getAllCount(rank);
		rank.setTotalCount(totalCount); // 设置总条数
		rank.calculatePage();// 设置总页数
		page = rank; // 获取page对象以便页面使用
		rankList = rankService.rankList(rank);
		if (flag == 1) {
			return "ajaxpage";
		} else {
			return SUCCESS;
		}
	}
	
	/**
	 * 跳转到添加级别页面
	 * @return
	 *
	 * @author 公司名 -- CX -- 程曦
	 *
	 *	       2013-7-3 下午11:59:45
	 */
	public String toaddRank(){
		return SUCCESS;
	}
	
	/**
	 * 添加级别
	 */
	public String addRank(){
		rankService.addRank(rank);
		return SUCCESS;
	}
	
	/**
	 * 删除级别
	 * 
	 *
	 * @author 公司名 -- CX -- 程曦
	 *
	 *	       2013-7-4 上午12:41:23
	 */
	public void delRank(){
		rankService.delRank(rank);
	}
	
	/**
	 * 跳转到修改页面
	 * @return
	 *
	 * @author 公司名 -- CX -- 程曦
	 *
	 *	       2013-7-4 上午8:55:37
	 */
	public String toUpdateRank(){
		rank = rankService.getRankById(rank);
		return SUCCESS;
	}
	
	/**
	 * 修改级别
	 * @return
	 *
	 *
	 *	       2013-7-4 上午9:02:42
	 */
	public String updateRank(){
		rankService.updateRank(rank);
		return SUCCESS;
	}
	public RankService getRankService() {
		return rankService;
	}

	public void setRankService(RankService rankService) {
		this.rankService = rankService;
	}
	public List<Rank> getRankList() {
		return rankList;
	}
	public void setRankList(List<Rank> rankList) {
		this.rankList = rankList;
	}
	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	
}
