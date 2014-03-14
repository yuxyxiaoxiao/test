package org.leopard.model.rank;

import java.util.List;

import org.leopard.model.Page;

public class Rank extends Page{
	private int id;
	private String name;
	private String delIds;
	
	private List<Integer> delList;
	
	
	public List<Integer> getDelList() {
		return delList;
	}
	public void setDelList(List<Integer> delList) {
		this.delList = delList;
	}
	public String getDelIds() {
		return delIds;
	}
	public void setDelIds(String delIds) {
		this.delIds = delIds;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
