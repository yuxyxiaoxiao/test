package org.leopard.model.user;

import java.util.List;

public class UserRole {
		private int id;
		private int userId;
		private int roleId;
		private String addId;
		private String delId;
		private List<Integer> list;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public int getRoleId() {
			return roleId;
		}
		public void setRoleId(int roleId) {
			this.roleId = roleId;
		}
		public String getAddId() {
			return addId;
		}
		public void setAddId(String addId) {
			this.addId = addId;
		}
		public String getDelId() {
			return delId;
		}
		public void setDelId(String delId) {
			this.delId = delId;
		}
		public List<Integer> getList() {
			return list;
		}
		public void setList(List<Integer> list) {
			this.list = list;
		}
		
		
}
