package com.lyd.bikeServiceDaoImpl;

import java.util.List;


import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.lyd.bikeEntity.Column;
import com.lyd.bikeEntity.Employee;
import com.lyd.bikeEntity.LimiteRole;
import com.lyd.bikeEntity.User;
import com.lyd.bikeManger.ColumnMapper;
import com.lyd.bikeManger.EmployeeMapper;
import com.lyd.bikeManger.LimiteRoleMapper;
import com.lyd.bikeManger.UserMapper;
import com.lyd.bikeServiceDao.LoginServiceDao;
/**
 * @author leiyide
 * =============================== 
 * Date��2018/2/6
 * Time��16:12
 * ================================
 */

@Component("loginServiceDao")
public class LoginServiceDaoImpl implements LoginServiceDao{

	//���ݷ��ʲ�UserMapper��ע��
	@Resource(name="userMapper")
	private UserMapper userMapper;
	
	//���ݷ��ʲ�EmployeeMapper��ע��
	@Resource(name="employeeMapper")
	private EmployeeMapper employeeMapper;
	
	//���ݷ��ʲ�LimiteRole��ע��
	@Resource(name="limiteRoleMapper")
	private LimiteRoleMapper limiteRoleMapper;
	
	//���ݷ��ʲ�ColumnMapper��ע��
	@Resource(name="columnMapper")
	private ColumnMapper columnMapper;
	
	/**
	 * �û���¼
	 * @param email        ����
	 * @param password     ����
	 * @return             �û�����
	 */
	@Override
	public User getUserLogin(String email, String password) {
		return userMapper.getUserLogin(email, password);
	}
	
	/**
	 * Ա�����е�¼
	 * @param employeeEmail   Ա������
	 * @param password        ��¼����
	 * @return                Ա������
	 */
	public Employee getEmployeeLogin(String employeeEmail, String password){
		return employeeMapper.getEmployeeLogin(employeeEmail, password);
	}
	
	/**
	 * �һ��û�������
	 * @param userName   �û�������
	 * @param userEmail  �û�������
	 * @param userPhone  �û����ֻ�����
	 * @param userIdCard �û������֤
	 * @return           �û�����
	 */
	public User findUserPassword(String userName,String userEmail,String userPhone,String userIdCard){
		return userMapper.findUserPassword(userName, userEmail, userPhone, userIdCard);
	}
	
	/**
	 * �һ�Ա��������
	 * @param employeeName   Ա��������
	 * @param employeeEmail  Ա��������
	 * @param employeePhone  Ա�����ֻ�����
	 * @param employeeIdCard Ա�������֤
	 * @return               Ա������
	 */
	public Employee findEmployeePassword(String employeeName,String employeeEmail,String employeePhone,String employeeIdCard){
		return employeeMapper.findEmployeePassword(employeeName, employeeEmail, employeePhone, employeeIdCard);
	}
	
	/**
	 * ע���û�
	 * @param username   �û�����
	 * @param userEmail  �û�����
	 * @param userPhone  �û��ֻ�����
	 * @param userIdcard �û����֤
	 * @param password   �û�����
	 * @return           �û�����
	 */
	public Boolean addNewUser(String username,String userEmail,String userPhone,String userIdcard,String password){
		 int addNewUser = userMapper.addNewUser(username, userEmail, userPhone, userIdcard, password);
		if(addNewUser!=0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * ��֤���֤��Ψһ�ԣ�ȷ��һ�����ֻ֤��ע��һ���˺�
	 * @param userIdCard
	 * @return
	 */
	public User checkIdCard(String userIdCard){
		return userMapper.checkIdCard(userIdCard);
	}
	
	/**
	 * �õ��û���Ȩ�޶��󼯺�
	 * @param rank   �û��ȼ�
	 * @return
	 */
	public List<LimiteRole> getUserLimit(Integer rank){
		return limiteRoleMapper.getUserLimite(rank);
	}
	
	/**
	 * �õ���Ӧ�Ĳ˵���
	 * @param columnId  �˵�id
	 * @return
	 */
	public Column getColumnLimite(Integer columnId){
		return columnMapper.getColumnLimite(columnId);
	}
	
	/**
	 * ����Ȩ�޵õ����Ӽ��˵�
	 * @param columnPermissionid   �˵�Ȩ��id
	 * @return
	 */
	public List<Column> getChildColumn(Integer columnPermissionid){
		return columnMapper.getChildColumn(columnPermissionid);
	}
}
