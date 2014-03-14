package org.leopard.model.menu;

import org.leopard.model.Page;

public class Menu {
	private int id;
	private int pid;
	private String name;
	private String url;
	private String target;
	
	private String checked;
	
	
	public Menu() {
		super();
	}
	public Menu(int id, int pid, String name, String url,String target) {
		super();
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.url = url;
		this.target = target;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	
}
