package org.leopard.model.user;


import java.util.Date;
import java.util.List;

import org.leopard.model.Page;
public class User extends Page{
	
	private int id;

	private String userName;
	
	private String chineseName;
	
	private String password;
	
	private String validate;
	
	private String  newPassword;
	
	private Integer userAge;
	
	private String userSex;
	
	private Date userBirthday;
	
	private String userVeiwBirthday;
	
	private Date userStartBirthday;

	private Date userEndBirthday;
	
	private Date userEntryDate;
	
	private String userViewEntry;
	
	private Date userStartEntry;
	private Date userEndEntry;
	
	//删除时所用的Id  时间2013年6月18日
	private String delId;
	
	//删除时用来存id的  时间2013年6月19日
	private List<Integer> delIdList;
	
	//添加时使用的id
	private String addId;
	
	private String photoPath;
	
	private String rank;
	
	
	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public Date getUserStartEntry() {
		return userStartEntry;
	}

	public void setUserStartEntry(Date userStartEntry) {
		this.userStartEntry = userStartEntry;
	}

	public Date getUserEndEntry() {
		return userEndEntry;
	}

	public void setUserEndEntry(Date userEndEntry) {
		this.userEndEntry = userEndEntry;
	}

	public String getUserViewEntry() {
		return userViewEntry;
	}

	public void setUserViewEntry(String userViewEntry) {
		this.userViewEntry = userViewEntry;
	}

	public Date getUserEntryDate() {
		return userEntryDate;
	}

	public void setUserEntryDate(Date userEntryDate) {
		this.userEntryDate = userEntryDate;
	}

	public Date getUserStartBirthday() {
		return userStartBirthday;
	}

	public void setUserStartBirthday(Date userStartBirthday) {
		this.userStartBirthday = userStartBirthday;
	}

	public Date getUserEndBirthday() {
		return userEndBirthday;
	}

	public void setUserEndBirthday(Date userEndBirthday) {
		this.userEndBirthday = userEndBirthday;
	}

	public String getUserVeiwBirthday() {
		return userVeiwBirthday;
	}

	public void setUserVeiwBirthday(String userVeiwBirthday) {
		this.userVeiwBirthday = userVeiwBirthday;
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public List<Integer> getDelIdList() {
		return delIdList;
	}

	public void setDelIdList(List<Integer> list) {
		this.delIdList = list;
	}

	public String getDelId() {
		return delId;
	}

	public void setDelId(String delId) {
		this.delId = delId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getValidate() {
		return validate;
	}

	public void setValidate(String validate) {
		this.validate = validate;
	}

	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	public String getAddId() {
		return addId;
	}

	public void setAddId(String addId) {
		this.addId = addId;
	}


}
