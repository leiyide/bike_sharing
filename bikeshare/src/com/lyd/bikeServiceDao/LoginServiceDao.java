package com.lyd.bikeServiceDao;

import java.util.List;


import org.apache.ibatis.annotations.Param;

import com.lyd.bikeEntity.Column;
import com.lyd.bikeEntity.Employee;
import com.lyd.bikeEntity.LimiteRole;
import com.lyd.bikeEntity.User;
/**
 * @author leiyide
 * =============================== 
 * Date��2018/2/6
 * Time��16:12
 * ================================
 */
public interface LoginServiceDao {

	/**
	 * �û���¼
	 * @param email        ����
	 * @param password     ����
	 * @return             �û�����
	 */
	public User getUserLogin(String email,String password);
	
	/**
	 * Ա�����е�¼
	 * @param employeeEmail   Ա������
	 * @param password        ��¼����
	 * @return                Ա������
	 */
	public Employee getEmployeeLogin(String employeeEmail,String password);
	
	/**
	 * �һ��û�������
	 * @param userName   �û�������
	 * @param userEmail  �û�������
	 * @param userPhone  �û����ֻ�����
	 * @param userIdCard �û������֤
	 * @return           �û�����
	 */
	public User findUserPassword(String userName,String userEmail,String userPhone,String userIdCard);
	
	/**
	 * �һ�Ա��������
	 * @param employeeName   Ա��������
	 * @param employeeEmail  Ա��������
	 * @param employeePhone  Ա�����ֻ�����
	 * @param employeeIdCard Ա�������֤
	 * @return               Ա������
	 */
	public Employee findEmployeePassword(String employeeName,String employeeEmail,String employeePhone,String employeeIdCard);
	
	/**
	 * ע���û�
	 * @param username   �û�����
	 * @param userEmail  �û�����
	 * @param userPhone  �û��ֻ�����
	 * @param userIdcard �û����֤
	 * @param password   �û�����
	 * @return           �û�����
	 */
	public Boolean addNewUser(String username,String userEmail,String userPhone,String userIdcard,String password);
	
	/**
	 * ��֤���֤��Ψһ�ԣ�ȷ��һ�����ֻ֤��ע��һ���˺�
	 * @param userIdCard
	 * @return
	 */
	public User checkIdCard(String userIdCard);
	
	/**
	 * �õ��û���Ȩ�޶��󼯺�
	 * @param rank   �û��ȼ�
	 * @return
	 */
	public List<LimiteRole> getUserLimit(Integer rank);
	
	/**
	 * �õ���Ӧ�Ĳ˵���
	 * @param columnId  �˵�id
	 * @return
	 */
	public Column getColumnLimite(Integer columnId);
	
	/**
	 * ����Ȩ�޵õ����Ӽ��˵�
	 * @param columnPermissionid   �˵�Ȩ��id
	 * @return
	 */
	public List<Column> getChildColumn(Integer columnPermissionid);
}
