package org.leopard.service.user;

import java.util.ArrayList;
import java.util.List;

import org.leopard.dao.user.UserDao;
import org.leopard.model.user.User;
import org.leopard.model.user.UserAttachFile;

public  class UserServiceImp implements UserService{
	
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User getUserByName(User user) {
		// TODO Auto-generated method stub
		return userDao.getUserByName(user);
	}

	@Override
	public int getAllCount(User user) {
		// TODO Auto-generated method stub
		return userDao.getAllCount(user);
	}

	@Override
	public List<User> getUserPageList(User user) {
		// TODO Auto-generated method stub
		return userDao.getUserPageList(user);
	}

	@Override
	public List<UserAttachFile> attachFileList(User user) {
		// TODO Auto-generated method stub
		return userDao.attachFileList(user);
	}

	@Override
	public void delUSer(User user) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		String[] ids = user.getDelId().split(",");
		for(String id :ids){
			list.add(Integer.valueOf(id));
		}
		user.setDelIdList(list);
		userDao.delUSer(user);
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
	}

	@Override
	public void addUserAttachFile(UserAttachFile userAttachFile) {
		// TODO Auto-generated method stub
		userDao.addUserAttachFile(userAttachFile);
	}

	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub
		return userDao.getUser(user);
	}

	@Override
	public void upPassword(User user) {
		// TODO Auto-generated method stub
		userDao.upPassword(user);
	}

	@Override
	public Object getAttachFile(UserAttachFile userAttachFile) {
		// TODO Auto-generated method stub
		return  userDao.getAttachFile(userAttachFile);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
	}

	@Override
	public void deleteAttachFile(UserAttachFile userAttachFile) {
		// TODO Auto-generated method stub
		userDao.deleteAttachFile(userAttachFile);
	}
	
}
