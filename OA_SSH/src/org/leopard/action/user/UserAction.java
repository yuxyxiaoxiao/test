package org.leopard.action.user;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.leopard.action.BaseAction;
import org.leopard.model.Page;
import org.leopard.model.rank.Rank;
import org.leopard.model.user.User;
import org.leopard.model.user.UserAttachFile;
import org.leopard.service.rank.RankService;
import org.leopard.service.user.UserService;
import org.leopard.utils.AntZipUtil;
import org.leopard.utils.FileUtil;
import org.leopard.utils.Md5Util;
import org.leopard.utils.PropertyUtil;
import org.leopard.utils.datafinal.InterfaceFinal;

/**
 * 
 * Package : org.leopard.action.user
 *
 * @author   DGCX -- C.X -- ����
 *
 *		   2013-7-11 ����5:36:00
 *
 */
public class UserAction extends BaseAction implements InterfaceFinal {

	/** �û�Service */
	private UserService userService;

	/** �û�ʵ��model */
	private User user = new User();

	/** ҳ��չʾ�û��б�ʹ�õ�List */
	private List<User> userList;

	/** ҳ��ʹ�÷�ҳʱʹ�� ��ȡ��ҳ��Ϣ */
	private Page page;

	/** flage=1ʱ ajaxpage��ҳ ����ˢ������ҳ�� */
	private int flag;

	/** ҳ��չʾ�û�����ʹ�õ�List */
	private List<UserAttachFile> attachFileList;

	/** �ϴ���ͷ���ļ� */
	private File headPhoto;

	/** �ϴ�ͷ���ļ��� */
	private String headPhotoFileName;

	/** �ϴ����ļ� */
	private List<File> uploadFiles;

	/** �ϴ��ļ����ļ��� */
	private List<String> uploadFilesFileName;

	/** �û�����model */
	private UserAttachFile userAttachFile = new UserAttachFile();

	/** �����б� */
	private List<Rank> rankList;

	/** ����ʵ�� */
	private Rank rank;
	
	/** ����Service */
	private RankService rankService;

	/**
	 * �û���¼
	 * 
	 * @author ��ά -- 
	 * 
	 *         2013-6-25 ����9:16:06
	 */
	public void login() {

		String rand = String.valueOf(request.getSession().getAttribute("rand"));
		String validate = user.getValidate();
		String pwd = Md5Util.getMD5(user.getPassword());
		/** ��֤����ȷ */
		if (rand.equals(validate)) {
			user = (User) userService.getUserByName(user);
			/** �û�����ȷ */
			if (null != user) {
				/** ������ȷ */
				if (pwd.equals(user.getPassword())) {
					request.getSession().setAttribute("user", user);
					pwWrite("ok");
				} else {
					pwWrite(USERPWD_ERROR);
				}
			} else {
				pwWrite(USER_ERROR);
			}
		} else {
			pwWrite(VALIDATE_ERROR);
		}

	}

	/**
	 * ��ת����ӭ����
	 * 
	 * @return
	 * 
	 * @author ��˾�� -- �û���
	 * 
	 *         2013-6-27 ����6:35:58
	 */
	public String welcome() {
		user = (User) request.getSession().getAttribute("user");
		return SUCCESS;
	}

	/**
	 * ��ȡ�û��б�
	 * 
	 * @return
	 * 
	 * @author ��˾�� -- �û���
	 * 
	 *         2013-6-27 ����6:51:28
	 */
	public String userList() {
		int totalCount = userService.getAllCount(user);
		user.setTotalCount(totalCount); // ����������
		user.calculatePage();// ������ҳ��
		page = user; // ��ȡpage�����Ա�ҳ��ʹ��
		userList = userService.getUserPageList(user);

		for (User use : userList) {
			Date uB = use.getUserBirthday();
			// ��Ϊ��ת���������ڸ�ʽ
			if (null != uB) {
				SimpleDateFormat date = new SimpleDateFormat("yyyy��MM��dd��");
				use.setUserVeiwBirthday(date.format(uB));

			}
			Date uE = use.getUserEntryDate();
			// ��Ϊ��ת����ְ���ڸ�ʽ
			if (null != uE) {
				SimpleDateFormat date = new SimpleDateFormat(
						"yyyy��MM��dd�� HHʱmm��ss��");
				use.setUserViewEntry(date.format(uE));
			}

		}

		if (flag == 1) {
			return "ajaxpage";
		} else {
			return SUCCESS;
		}

	}

	/**
	 * ��ȡ�����б�
	 * 
	 * @return
	 * 
	 * @author ��˾�� -- �û���
	 * 
	 *         2013-6-26 ����4:16:03
	 */
	public String attachFileList() {
		attachFileList = userService.attachFileList(user);
		return SUCCESS;
	}

	/**
	 * ɾ���û�
	 * 
	 * @return
	 * 
	 * @author ��˾�� -- �û���
	 * 
	 *         2013-6-27 ����6:53:34
	 */
	public String delUser() {
		userService.delUSer(user);
		return null;
	}

	/**
	 * ��ת�������û�����
	 * 
	 * @return
	 * 
	 * @author ��˾�� -- �û���
	 * 
	 *         2013-7-2 ����12:32:08
	 */
	public String toaddUser() {
		rankList = rankService.rankList(rank);

		return SUCCESS;
	}

	/**
	 * 
	 * ���ʱ��ѯ�û����治����
	 * 
	 * @author ��˾�� -- �û���
	 * 
	 *         2013-6-25 ����11:15:54
	 */
	public void selectUserName() {
		User u = (User) userService.getUserByName(user);
		if (null == u) {
			pwWrite("ok"); // �û�������
		} else {
			pwWrite("no"); // �û�����
		}
	}

	/**
	 * ����û�
	 * 
	 * @return
	 * 
	 * @author ��˾�� -- �û���
	 * 
	 *         2013-6-25 ����11:03:40
	 */
	public String addUser() {
		// �ϴ�ͷ��
		String photoName = UUID.randomUUID().toString()
				+ getPostfix(headPhotoFileName);// ����ʱ��ͷ����
		String photoPath = request.getRealPath("/photo/"); // ����ͷ���·��

		FileUtil.upFile(headPhoto, photoName, photoPath); // �ϴ�������
		user.setPhotoPath("photo/" + photoName); // ���������ݿ��е�·��
		// ����û�
		user.setPassword(Md5Util.getMD5(user.getPassword())); // ��������ܺ���ȥ
		userService.addUser(user); // ����û�
		String path = PropertyUtil.getPath("path"); // �ļ�����·��
		// ����ϴ��ļ�
		for (int i = 0; i < uploadFiles.size(); i++) {
			String prefix = getPerfix(uploadFilesFileName.get(i)); // ǰ׺
			String postfix = getPostfix(uploadFilesFileName.get(i)); // ��׺
			String uuid = UUID.randomUUID().toString(); // Ψһ��ʾ
			FileUtil.upFile(uploadFiles.get(i), prefix + uuid + postfix, path); // �ϴ�������
			// ����Ϣд���û���������
			UserAttachFile userAttachFile = new UserAttachFile();
			userAttachFile.setAttachFileName(uploadFilesFileName.get(i));
			userAttachFile.setUuidAttachFileName(prefix + uuid + postfix);
			userAttachFile.setUserId(user.getId());
			userService.addUserAttachFile(userAttachFile);
		}
		return SUCCESS;
	}

	/**
	 * ��ת���޸�����ҳ��
	 * 
	 * @return
	 * 
	 * @author ��˾�� -- �û���
	 * 
	 *         2013-6-27 ����6:54:34
	 */
	public String toUpdatePwd() {

		return SUCCESS;
	}

	/**
	 * �޸�����
	 * 
	 * @return
	 * 
	 * @author ��˾�� -- �û���
	 * 
	 *         2013-6-25 ����11:06:27
	 */
	public String updatePwd() {
		User uu = (User) userService.getUser(user);
		// ԭ����
		String password = uu.getPassword(); 
		//��������뾭md5����
		String oldWod=Md5Util.getMD5(user.getPassword());
		try {
			PrintWriter pw = response.getWriter();
			// �����벻ƥ��
			if (!password.equals(oldWod)) {
				pw.write("1");
			} else {
				//�����޸�  
				user.setNewPassword(Md5Util.getMD5(user.getNewPassword()));
				userService.upPassword(user);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * ���ظ���
	 * 
	 * @return
	 * 
	 * @author ��˾�� -- �û���
	 * 
	 *         2013-6-26 ����4:15:25
	 */
//	public String downFile() {
//		UserAttachFile downFile = (UserAttachFile) userService
//				.getAttachFile(userAttachFile);
//		String path = PropertyUtil.getPath("path"); // �ļ�����·��
//		String downloadFile = path + downFile.getUuidAttachFileName();
//		String fileName = downFile.getAttachFileName();
//			FileUtil.downloadFile(request, response, downloadFile, fileName);
//		return null;
//	}
	public String downFile() {
	String path = PropertyUtil.getPath("path"); // �ļ�����·��
	String[] fileIds = userAttachFile.getDownIds().split(",");
	String[] fileNames = new String[fileIds.length];
	
	for (int i = 0; i < fileIds.length; i++) {
		userAttachFile.setId(Integer.parseInt(fileIds[i]));
		UserAttachFile downFile = (UserAttachFile) userService
				.getAttachFile(userAttachFile);
		fileNames[i] = downFile.getUuidAttachFileName();
	}

	// ѹ�� fileNames ���ƶ����ļ���ѹ·��ΪbaseDirName���ƶ���·�� ����Ϊ ����.zip
	String zipFileName = path + "aa.zip";// ѹ�����·�������ļ���
	// ѹ�����ָ�����ļ� ��ZIP  path·��   fileNames�ļ�����   zipFileName·��+�ļ���
	AntZipUtil.zip(path, fileNames, zipFileName, "GBK");
	
		FileUtil.downloadFile(request, response,zipFileName, "hello.zip");
	
	return null;
}
	/**
	 * ��ת���û��޸Ľ���
	 * 
	 * @return
	 * 
	 * @author ��˾�� -- �û���
	 * 
	 *         2013-7-4 ����12:31:35
	 */
	public String toUpdateUser() {
		user = userService.getUser(user);
		rankList = rankService.rankList(rank);
		return SUCCESS;
	}

	public String updateUser() {

		// �ϴ�ͷ��
		String photoName = UUID.randomUUID().toString()
				+ getPostfix(headPhotoFileName);// ����ʱ��ͷ����
		String photoPath = request.getRealPath("/photo/"); // ����ͷ���·��

		FileUtil.upFile(headPhoto, photoName, photoPath); // �ϴ�������
		user.setPhotoPath("photo/" + photoName); // ���������ݿ��е�·��
		// �޸��û�
		user.setPassword(Md5Util.getMD5(user.getPassword())); // ��������ܺ���ȥ
		userService.updateUser(user);
		String path = PropertyUtil.getPath("path"); // �ļ�����·��
		// ����ϴ��ļ�
		for (int i = 0; i < uploadFiles.size(); i++) {
			String prefix = getPerfix(uploadFilesFileName.get(i)); // ǰ׺
			String postfix = getPostfix(uploadFilesFileName.get(i)); // ��׺
			String uuid = UUID.randomUUID().toString(); // Ψһ��ʾ
			FileUtil.upFile(uploadFiles.get(i), prefix + uuid + postfix, path); // �ϴ�������
			// ����Ϣд���û���������
			UserAttachFile userAttachFile = new UserAttachFile();
			userAttachFile.setAttachFileName(uploadFilesFileName.get(i));
			userAttachFile.setUuidAttachFileName(prefix + uuid + postfix);
			userAttachFile.setUserId(user.getId());
			userService.deleteAttachFile(userAttachFile);
			userService.addUserAttachFile(userAttachFile);

		}
		return SUCCESS;
	}

	/**
	 * ��ȡǰ׺
	 * 
	 * @param fileName
	 * @return String
	 */
	public String getPerfix(String fileName) {
		String perfix = fileName.substring(0, fileName.lastIndexOf("."));
		return perfix;
	}

	/**
	 * ��ȡ��׺
	 * 
	 * @param fileName
	 * @return String
	 */
	public String getPostfix(String fileName) {
		String postfix = fileName.substring(fileName.lastIndexOf("."));
		return postfix;
	}
	
	/**
	 * �˳�ϵͳ  ���session
	 * @return
	 *
	 * @author ��˾�� -- �û���
	 *
	 *	       2013-7-8 ����7:48:25
	 */
	public String secede(){
		request.getSession().invalidate();
		return SUCCESS;
	}
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public List<UserAttachFile> getAttachFileList() {
		return attachFileList;
	}

	public void setAttachFileList(List<UserAttachFile> attachFileList) {
		this.attachFileList = attachFileList;
	}

	public File getHeadPhoto() {
		return headPhoto;
	}

	public void setHeadPhoto(File headPhoto) {
		this.headPhoto = headPhoto;
	}

	public String getHeadPhotoFileName() {
		return headPhotoFileName;
	}

	public void setHeadPhotoFileName(String headPhotoFileName) {
		this.headPhotoFileName = headPhotoFileName;
	}

	public List<File> getUploadFiles() {
		return uploadFiles;
	}

	public void setUploadFiles(List<File> uploadFiles) {
		this.uploadFiles = uploadFiles;
	}

	public List<String> getUploadFilesFileName() {
		return uploadFilesFileName;
	}

	public void setUploadFilesFileName(List<String> uploadFilesFileName) {
		this.uploadFilesFileName = uploadFilesFileName;
	}

	public UserAttachFile getUserAttachFile() {
		return userAttachFile;
	}

	public void setUserAttachFile(UserAttachFile userAttachFile) {
		this.userAttachFile = userAttachFile;
	}

	public List<Rank> getRankList() {
		return rankList;
	}

	public void setRankList(List<Rank> rankList) {
		this.rankList = rankList;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public RankService getRankService() {
		return rankService;
	}

	public void setRankService(RankService rankService) {
		this.rankService = rankService;
	}

}
