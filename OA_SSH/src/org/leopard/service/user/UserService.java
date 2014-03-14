package org.leopard.service.user;

import java.util.List;

import org.leopard.model.user.User;
import org.leopard.model.user.UserAttachFile;

/**
 * �û���ز���
 * 
 * Package : org.leopard.service.user
 *
 * @author ��˾��   -- CX -- ����
 *
 *		   2013-7-9 ����2:17:49
 *
 */
public interface UserService {
	/**
	 * �õ��û�  ����
	 * 
	 * @param user
	 * @return
	 *
	 * @author ��˾��-- CX -- ����
	 *
	 *	       2013-7-9 ����2:17:51
	 */
public	User getUserByName(User user);
/**
 * ȫ��
 * 
 * @param user
 * @return
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:17:54
 */
public int getAllCount(User user);
/**
 * �û��б��ҳ
 * 
 * @param user
 * @return
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:17:56
 */
public List<User> getUserPageList(User user);
/**
 * �ϴ��ļ��б�
 * 
 * @param user
 * @return
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:17:59
 */
public List<UserAttachFile> attachFileList(User user);
/**
 * ɾ���û�
 * 
 * @param user
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:18:01
 */
public void delUSer(User user);

/**
 * ����û�
 * 
 * @param user
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:18:08
 */
public void addUser(User user);
/**
 * ��Ӹ���
 * 
 * @param userAttachFile
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:18:12
 */
public void addUserAttachFile(UserAttachFile userAttachFile);
/**
 * �õ��û�
 * 
 * @param user
 * @return
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:18:14
 */
public User getUser(User user);
/**
 * �޸�����
 * 
 * @param user
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:18:16
 */
public void upPassword(User user);
/**
 * �ϴ�
 * 
 * @param userAttachFile
 * @return
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:18:18
 */
public Object getAttachFile(UserAttachFile userAttachFile);
/**
 * �޸��û�
 * 
 * @param user
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:18:22
 */
public void updateUser(User user);
/**
 * ɾ��
 * 
 * @param userAttachFile
 *
 * @author ��˾��-- CX -- ����
 *
 *	       2013-7-9 ����2:18:24
 */
public void deleteAttachFile(UserAttachFile userAttachFile);
	

}
