package org.leopard.service.user;

import java.util.List;

import org.leopard.model.user.User;
import org.leopard.model.user.UserAttachFile;

/**
 * 用户相关操作
 * 
 * Package : org.leopard.service.user
 *
 * @author 公司名   -- CX -- 程曦
 *
 *		   2013-7-9 下午2:17:49
 *
 */
public interface UserService {
	/**
	 * 得到用户  名字
	 * 
	 * @param user
	 * @return
	 *
	 * @author 公司名-- CX -- 程曦
	 *
	 *	       2013-7-9 下午2:17:51
	 */
public	User getUserByName(User user);
/**
 * 全部
 * 
 * @param user
 * @return
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:17:54
 */
public int getAllCount(User user);
/**
 * 用户列表分页
 * 
 * @param user
 * @return
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:17:56
 */
public List<User> getUserPageList(User user);
/**
 * 上传文件列表
 * 
 * @param user
 * @return
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:17:59
 */
public List<UserAttachFile> attachFileList(User user);
/**
 * 删除用户
 * 
 * @param user
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:18:01
 */
public void delUSer(User user);

/**
 * 添加用户
 * 
 * @param user
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:18:08
 */
public void addUser(User user);
/**
 * 添加附件
 * 
 * @param userAttachFile
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:18:12
 */
public void addUserAttachFile(UserAttachFile userAttachFile);
/**
 * 得到用户
 * 
 * @param user
 * @return
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:18:14
 */
public User getUser(User user);
/**
 * 修改密码
 * 
 * @param user
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:18:16
 */
public void upPassword(User user);
/**
 * 上传
 * 
 * @param userAttachFile
 * @return
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:18:18
 */
public Object getAttachFile(UserAttachFile userAttachFile);
/**
 * 修改用户
 * 
 * @param user
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:18:22
 */
public void updateUser(User user);
/**
 * 删除
 * 
 * @param userAttachFile
 *
 * @author 公司名-- CX -- 程曦
 *
 *	       2013-7-9 下午2:18:24
 */
public void deleteAttachFile(UserAttachFile userAttachFile);
	

}
