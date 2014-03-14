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
 * @author   DGCX -- C.X -- 程曦
 *
 *		   2013-7-11 下午5:36:00
 *
 */
public class UserAction extends BaseAction implements InterfaceFinal {

	/** 用户Service */
	private UserService userService;

	/** 用户实体model */
	private User user = new User();

	/** 页面展示用户列表使用的List */
	private List<User> userList;

	/** 页面使用分页时使用 获取分页信息 */
	private Page page;

	/** flage=1时 ajaxpage分页 否则刷新整个页面 */
	private int flag;

	/** 页面展示用户附件使用的List */
	private List<UserAttachFile> attachFileList;

	/** 上传的头像文件 */
	private File headPhoto;

	/** 上传头像文件名 */
	private String headPhotoFileName;

	/** 上传的文件 */
	private List<File> uploadFiles;

	/** 上传文件的文件名 */
	private List<String> uploadFilesFileName;

	/** 用户附件model */
	private UserAttachFile userAttachFile = new UserAttachFile();

	/** 级别列表 */
	private List<Rank> rankList;

	/** 级别实体 */
	private Rank rank;
	
	/** 级别Service */
	private RankService rankService;

	/**
	 * 用户登录
	 * 
	 * @author 八维 -- 
	 * 
	 *         2013-6-25 上午9:16:06
	 */
	public void login() {

		String rand = String.valueOf(request.getSession().getAttribute("rand"));
		String validate = user.getValidate();
		String pwd = Md5Util.getMD5(user.getPassword());
		/** 验证码正确 */
		if (rand.equals(validate)) {
			user = (User) userService.getUserByName(user);
			/** 用户名正确 */
			if (null != user) {
				/** 密码正确 */
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
	 * 跳转到欢迎界面
	 * 
	 * @return
	 * 
	 * @author 公司名 -- 用户名
	 * 
	 *         2013-6-27 下午6:35:58
	 */
	public String welcome() {
		user = (User) request.getSession().getAttribute("user");
		return SUCCESS;
	}

	/**
	 * 获取用户列表
	 * 
	 * @return
	 * 
	 * @author 公司名 -- 用户名
	 * 
	 *         2013-6-27 下午6:51:28
	 */
	public String userList() {
		int totalCount = userService.getAllCount(user);
		user.setTotalCount(totalCount); // 设置总条数
		user.calculatePage();// 设置总页数
		page = user; // 获取page对象以便页面使用
		userList = userService.getUserPageList(user);

		for (User use : userList) {
			Date uB = use.getUserBirthday();
			// 不为空转换生日日期格式
			if (null != uB) {
				SimpleDateFormat date = new SimpleDateFormat("yyyy年MM月dd日");
				use.setUserVeiwBirthday(date.format(uB));

			}
			Date uE = use.getUserEntryDate();
			// 不为空转换入职日期格式
			if (null != uE) {
				SimpleDateFormat date = new SimpleDateFormat(
						"yyyy年MM月dd日 HH时mm分ss秒");
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
	 * 获取附件列表
	 * 
	 * @return
	 * 
	 * @author 公司名 -- 用户名
	 * 
	 *         2013-6-26 下午4:16:03
	 */
	public String attachFileList() {
		attachFileList = userService.attachFileList(user);
		return SUCCESS;
	}

	/**
	 * 删除用户
	 * 
	 * @return
	 * 
	 * @author 公司名 -- 用户名
	 * 
	 *         2013-6-27 下午6:53:34
	 */
	public String delUser() {
		userService.delUSer(user);
		return null;
	}

	/**
	 * 跳转到增加用户界面
	 * 
	 * @return
	 * 
	 * @author 公司名 -- 用户名
	 * 
	 *         2013-7-2 下午12:32:08
	 */
	public String toaddUser() {
		rankList = rankService.rankList(rank);

		return SUCCESS;
	}

	/**
	 * 
	 * 添加时查询用户名存不存在
	 * 
	 * @author 公司名 -- 用户名
	 * 
	 *         2013-6-25 下午11:15:54
	 */
	public void selectUserName() {
		User u = (User) userService.getUserByName(user);
		if (null == u) {
			pwWrite("ok"); // 用户不存在
		} else {
			pwWrite("no"); // 用户存在
		}
	}

	/**
	 * 添加用户
	 * 
	 * @return
	 * 
	 * @author 公司名 -- 用户名
	 * 
	 *         2013-6-25 下午11:03:40
	 */
	public String addUser() {
		// 上传头像
		String photoName = UUID.randomUUID().toString()
				+ getPostfix(headPhotoFileName);// 保存时的头像名
		String photoPath = request.getRealPath("/photo/"); // 保存头像的路径

		FileUtil.upFile(headPhoto, photoName, photoPath); // 上传工具类
		user.setPhotoPath("photo/" + photoName); // 保存在数据库中的路径
		// 添加用户
		user.setPassword(Md5Util.getMD5(user.getPassword())); // 把密码加密后存进去
		userService.addUser(user); // 添加用户
		String path = PropertyUtil.getPath("path"); // 文件保存路径
		// 添加上传文件
		for (int i = 0; i < uploadFiles.size(); i++) {
			String prefix = getPerfix(uploadFilesFileName.get(i)); // 前缀
			String postfix = getPostfix(uploadFilesFileName.get(i)); // 后缀
			String uuid = UUID.randomUUID().toString(); // 唯一标示
			FileUtil.upFile(uploadFiles.get(i), prefix + uuid + postfix, path); // 上传工具类
			// 将信息写入用户附件表中
			UserAttachFile userAttachFile = new UserAttachFile();
			userAttachFile.setAttachFileName(uploadFilesFileName.get(i));
			userAttachFile.setUuidAttachFileName(prefix + uuid + postfix);
			userAttachFile.setUserId(user.getId());
			userService.addUserAttachFile(userAttachFile);
		}
		return SUCCESS;
	}

	/**
	 * 跳转到修改密码页面
	 * 
	 * @return
	 * 
	 * @author 公司名 -- 用户名
	 * 
	 *         2013-6-27 下午6:54:34
	 */
	public String toUpdatePwd() {

		return SUCCESS;
	}

	/**
	 * 修改密码
	 * 
	 * @return
	 * 
	 * @author 公司名 -- 用户名
	 * 
	 *         2013-6-25 下午11:06:27
	 */
	public String updatePwd() {
		User uu = (User) userService.getUser(user);
		// 原密码
		String password = uu.getPassword(); 
		//输入的密码经md5加密
		String oldWod=Md5Util.getMD5(user.getPassword());
		try {
			PrintWriter pw = response.getWriter();
			// 旧密码不匹配
			if (!password.equals(oldWod)) {
				pw.write("1");
			} else {
				//进行修改  
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
	 * 下载附件
	 * 
	 * @return
	 * 
	 * @author 公司名 -- 用户名
	 * 
	 *         2013-6-26 下午4:15:25
	 */
//	public String downFile() {
//		UserAttachFile downFile = (UserAttachFile) userService
//				.getAttachFile(userAttachFile);
//		String path = PropertyUtil.getPath("path"); // 文件下载路径
//		String downloadFile = path + downFile.getUuidAttachFileName();
//		String fileName = downFile.getAttachFileName();
//			FileUtil.downloadFile(request, response, downloadFile, fileName);
//		return null;
//	}
	public String downFile() {
	String path = PropertyUtil.getPath("path"); // 文件下载路径
	String[] fileIds = userAttachFile.getDownIds().split(",");
	String[] fileNames = new String[fileIds.length];
	
	for (int i = 0; i < fileIds.length; i++) {
		userAttachFile.setId(Integer.parseInt(fileIds[i]));
		UserAttachFile downFile = (UserAttachFile) userService
				.getAttachFile(userAttachFile);
		fileNames[i] = downFile.getUuidAttachFileName();
	}

	// 压缩 fileNames 中制定的文件，压路径为baseDirName中制定的路径 命名为 中文.zip
	String zipFileName = path + "aa.zip";// 压缩后的路径及其文件名
	// 压缩多个指定的文件 到ZIP  path路径   fileNames文件数组   zipFileName路径+文件名
	AntZipUtil.zip(path, fileNames, zipFileName, "GBK");
	
		FileUtil.downloadFile(request, response,zipFileName, "hello.zip");
	
	return null;
}
	/**
	 * 跳转到用户修改界面
	 * 
	 * @return
	 * 
	 * @author 公司名 -- 用户名
	 * 
	 *         2013-7-4 下午12:31:35
	 */
	public String toUpdateUser() {
		user = userService.getUser(user);
		rankList = rankService.rankList(rank);
		return SUCCESS;
	}

	public String updateUser() {

		// 上传头像
		String photoName = UUID.randomUUID().toString()
				+ getPostfix(headPhotoFileName);// 保存时的头像名
		String photoPath = request.getRealPath("/photo/"); // 保存头像的路径

		FileUtil.upFile(headPhoto, photoName, photoPath); // 上传工具类
		user.setPhotoPath("photo/" + photoName); // 保存在数据库中的路径
		// 修改用户
		user.setPassword(Md5Util.getMD5(user.getPassword())); // 把密码加密后存进去
		userService.updateUser(user);
		String path = PropertyUtil.getPath("path"); // 文件保存路径
		// 添加上传文件
		for (int i = 0; i < uploadFiles.size(); i++) {
			String prefix = getPerfix(uploadFilesFileName.get(i)); // 前缀
			String postfix = getPostfix(uploadFilesFileName.get(i)); // 后缀
			String uuid = UUID.randomUUID().toString(); // 唯一标示
			FileUtil.upFile(uploadFiles.get(i), prefix + uuid + postfix, path); // 上传工具类
			// 将信息写入用户附件表中
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
	 * 获取前缀
	 * 
	 * @param fileName
	 * @return String
	 */
	public String getPerfix(String fileName) {
		String perfix = fileName.substring(0, fileName.lastIndexOf("."));
		return perfix;
	}

	/**
	 * 获取后缀
	 * 
	 * @param fileName
	 * @return String
	 */
	public String getPostfix(String fileName) {
		String postfix = fileName.substring(fileName.lastIndexOf("."));
		return postfix;
	}
	
	/**
	 * 退出系统  清空session
	 * @return
	 *
	 * @author 公司名 -- 用户名
	 *
	 *	       2013-7-8 下午7:48:25
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
