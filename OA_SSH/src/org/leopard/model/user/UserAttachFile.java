package org.leopard.model.user;

public class UserAttachFile {
	private int id;
	
	private String attachFileName;
	
	private String uuidAttachFileName;
	
	private int userId;
	
	private String downIds;
	
	
	

	public String getDownIds() {
		return downIds;
	}

	public void setDownIds(String downIds) {
		this.downIds = downIds;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAttachFileName() {
		return attachFileName;
	}

	public void setAttachFileName(String attachFileName) {
		this.attachFileName = attachFileName;
	}

	public String getUuidAttachFileName() {
		return uuidAttachFileName;
	}

	public void setUuidAttachFileName(String uuidAttachFileName) {
		this.uuidAttachFileName = uuidAttachFileName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	
	
}
