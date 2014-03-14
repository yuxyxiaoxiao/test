package org.leopard.dao.user;

import java.util.List;

import org.leopard.model.user.User;
import org.leopard.model.user.UserAttachFile;
/**
 * 
 * Package : org.leopard.dao.user
 *
 * @author ��˾��   -- CX -- ����
 *
 *		   2013-7-9 ����2:14:20
 *
 */
public interface UserDao {
/**
 * 
 * @param user
 * @return
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:14:28
 */
public User getUserByName(User user);
/**
 * 
 * @param user
 * @return
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:14:39
 */
public int getAllCount(User user);
/**
 * 
 * @param user
 * @return
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:14:43
 */
public List<User> getUserPageList(User user);
/**
 * 
 * @param user
 * @return
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:14:46
 */
public List<UserAttachFile> attachFileList(User user);
/**
 * 
 * @param user
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:14:52
 */
public void delUSer(User user);
/**
 * 
 * @param user
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:14:55
 */
public void addUser(User user);
/**
 * 
 * @param userAttachFile
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:14:58
 */
public void addUserAttachFile(UserAttachFile userAttachFile);
/**
 * 
 * @param user
 * @return
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:15:01
 */
public User getUser(User user);
/**
 * 
 * @param user
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:15:04
 */
public void upPassword(User user);
/**
 * 
 * @param userAttachFile
 * @return
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:15:07
 */
public Object getAttachFile(UserAttachFile userAttachFile);
/**
 * 
 * @param user
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:15:17
 */
public void updateUser(User user);
/**
 * 
 * @param userAttachFile
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:15:21
 */
public void deleteAttachFile(UserAttachFile userAttachFile);
	

}
