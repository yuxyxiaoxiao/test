package org.leopard.action.rank;

import java.util.List;

import org.leopard.action.BaseAction;
import org.leopard.model.Page;
import org.leopard.model.rank.Rank;
import org.leopard.service.rank.RankService;

public class RankAction extends BaseAction{
	
	/** ����Service*/
	private RankService rankService;
	
	/** �����б�List*/
	private List<Rank> rankList;
	
	/** ����ʵ��*/
	private Rank rank = new Rank();
	
	/** ��ҳʵ��*/
	private Page page = new Page();
	
	/** */
	private int flag;
	/**
	 * ��ȡ�����б�
	 * @return
	 *
	 * @author ��˾�� -- CX -- ����
	 *
	 *	       2013-7-3 ����10:56:38
	 */
	public String rankList(){
		int totalCount = rankService.getAllCount(rank);
		rank.setTotalCount(totalCount); // ����������
		rank.calculatePage();// ������ҳ��
		page = rank; // ��ȡpage�����Ա�ҳ��ʹ��
		rankList = rankService.rankList(rank);
		if (flag == 1) {
			return "ajaxpage";
		} else {
			return SUCCESS;
		}
	}
	
	/**
	 * ��ת����Ӽ���ҳ��
	 * @return
	 *
	 * @author ��˾�� -- CX -- ����
	 *
	 *	       2013-7-3 ����11:59:45
	 */
	public String toaddRank(){
		return SUCCESS;
	}
	
	/**
	 * ��Ӽ���
	 */
	public String addRank(){
		rankService.addRank(rank);
		return SUCCESS;
	}
	
	/**
	 * ɾ������
	 * 
	 *
	 * @author ��˾�� -- CX -- ����
	 *
	 *	       2013-7-4 ����12:41:23
	 */
	public void delRank(){
		rankService.delRank(rank);
	}
	
	/**
	 * ��ת���޸�ҳ��
	 * @return
	 *
	 * @author ��˾�� -- CX -- ����
	 *
	 *	       2013-7-4 ����8:55:37
	 */
	public String toUpdateRank(){
		rank = rankService.getRankById(rank);
		return SUCCESS;
	}
	
	/**
	 * �޸ļ���
	 * @return
	 *
	 *
	 *	       2013-7-4 ����9:02:42
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
