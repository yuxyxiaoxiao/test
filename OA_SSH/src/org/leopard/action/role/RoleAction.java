package org.leopard.action.role;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.leopard.action.BaseAction;
import org.leopard.model.Page;
import org.leopard.model.role.Role;
import org.leopard.model.user.User;
import org.leopard.service.role.RoleService;

/**
 * 
 * Package : org.leopard.action.role
 * 
 * @author ��˾�� -- �û���
 * 
 *         2013-7-2 ����10:17:23
 * 
 */
public class RoleAction extends BaseAction {
	/** ��ɫService */
	private RoleService roleService;
	/** ��ɫʵ�� */
	private Role role = new Role();
	/** ��ҳ */
	private Page page;
	/** flage=1ʱ ajaxpage��ҳ ����ˢ������ҳ�� */
	private int flag;
	/** ��ɫ�б�����ҳ����ʾ */
	private List<Role> roleList;

	/**
	 * ��ȡ��ɫ�б�
	 * 
	 * @return
	 * 
	 * @author ��˾�� -- �û���
	 * 
	 *         2013-7-2 ����10:22:19
	 */
	public String roleList() {
		int totalCount = roleService.getAllCount(role);
		role.setTotalCount(totalCount); // ����������
		role.calculatePage();// ������ҳ��
		page = role; // ��ȡpage�����Ա�ҳ��ʹ��
		roleList = roleService.getRolePageList(role);

		if (flag == 1) {
			return "ajaxpage";
		} else {
			return SUCCESS;
		}
	}

	/**
	 * ��ת����ӽ�ɫҳ��
	 * 
	 * @return
	 * 
	 * @author ��˾�� -- �û���
	 * 
	 *         2013-7-2 ����10:23:28
	 */
	public String toaddRole() {

		return SUCCESS;
	}

	/**
	 * ��ӽ�ɫ
	 * 
	 * @return
	 * 
	 * @author ��˾�� -- �û���
	 * 
	 *         2013-7-2 ����10:24:31
	 */
	public String addRole() {
		roleService.addRole(role);
		return SUCCESS;
	}

	/**
	 * ɾ����ɫ
	 * 
	 * 
	 * @author ��˾�� -- �û���
	 * 
	 *         2013-7-2 ����10:24:51
	 */
	public void delRole() {
		roleService.delRole(role);
	}

	/**
	 * ���ʱ��ɫ��ѯ��ɫ���治����
	 * 
	 * 
	 * @author ��˾�� -- �û���
	 * 
	 *         2013-7-2 ����10:25:28
	 */
	public void selectRoleName() {
		Role ur = (Role) roleService.selectRoleName(role);
		if (null == ur) {
			pwWrite("ok"); //��ɫ��������
		} else {
			pwWrite("no"); //��ɫ������
		}
	}
	
	public String toUpdateRole(){
		role = roleService.getRoleById(role);
		return SUCCESS; 
	}
	/**
	 * �޸Ľ�ɫ
	 * @return
	 *
	 * @author ��˾�� -- �û���
	 *
	 *	       2013-7-4 ����7:18:21
	 */
	public String updateRole(){
		roleService.updateRole(role);
		return SUCCESS;
	}
	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

}
