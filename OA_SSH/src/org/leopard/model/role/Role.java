package org.leopard.model.role;

import java.util.List;

import org.leopard.model.Page;

public class Role extends Page {
	private int id;
	private String roleName;
	private String delId;
	private List<Integer> delIdList;
	
	public Role(){
		
	}
	public Role(int id, String roleName) {

		this.id = id;
		this.roleName = roleName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDelId() {
		return delId;
	}
	public void setDelId(String delId) {
		this.delId = delId;
	}
	public List<Integer> getDelIdList() {
		return delIdList;
	}
	public void setDelIdList(List<Integer> delIdList) {
		this.delIdList = delIdList;
	}
	
	
}
