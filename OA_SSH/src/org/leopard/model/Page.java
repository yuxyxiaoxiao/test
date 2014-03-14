package org.leopard.model;

public class Page {
	//��ѯ���ݿ��ȡ�ܸ���
	private int  totalCount;
	//��ҳ��
	private int pageCount;
	//ÿҳ������
	private int pageSize = 5;
	//��ǰҳ��
	private int pageIndex = 1;
	//��ʼλ��
	private int startPos;
	//��ֹλ��
	private int endPos;
	
	
	
	public void calculatePage(){
		//��ȡ��ҳ��
		if(totalCount % pageSize ==0){
			pageCount = totalCount / pageSize;
		}else{
			pageCount = totalCount / pageSize + 1;
		}
		startPos = ( pageIndex - 1 ) * pageSize;
		endPos = pageIndex * pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartPos() {
		return startPos;
	}

	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}

	public int getEndPos() {
		return endPos;
	}

	public void setEndPos(int endPos) {
		this.endPos = endPos;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	
}
