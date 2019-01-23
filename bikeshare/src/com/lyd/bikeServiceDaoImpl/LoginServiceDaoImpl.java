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
 * Date：2018/2/6
 * Time：16:12
 * ================================
 */

@Component("loginServiceDao")
public class LoginServiceDaoImpl implements LoginServiceDao{

	//数据访问层UserMapper的注入
	@Resource(name="userMapper")
	private UserMapper userMapper;
	
	//数据访问层EmployeeMapper的注入
	@Resource(name="employeeMapper")
	private EmployeeMapper employeeMapper;
	
	//数据访问层LimiteRole的注入
	@Resource(name="limiteRoleMapper")
	private LimiteRoleMapper limiteRoleMapper;
	
	//数据访问层ColumnMapper的注入
	@Resource(name="columnMapper")
	private ColumnMapper columnMapper;
	
	/**
	 * 用户登录
	 * @param email        邮箱
	 * @param password     密码
	 * @return             用户对象
	 */
	@Override
	public User getUserLogin(String email, String password) {
		return userMapper.getUserLogin(email, password);
	}
	
	/**
	 * 员工进行登录
	 * @param employeeEmail   员工邮箱
	 * @param password        登录密码
	 * @return                员工对象
	 */
	public Employee getEmployeeLogin(String employeeEmail, String password){
		return employeeMapper.getEmployeeLogin(employeeEmail, password);
	}
	
	/**
	 * 找回用户的密码
	 * @param userName   用户的名称
	 * @param userEmail  用户的邮箱
	 * @param userPhone  用户的手机号码
	 * @param userIdCard 用户的身份证
	 * @return           用户对象
	 */
	public User findUserPassword(String userName,String userEmail,String userPhone,String userIdCard){
		return userMapper.findUserPassword(userName, userEmail, userPhone, userIdCard);
	}
	
	/**
	 * 找回员工的密码
	 * @param employeeName   员工的名称
	 * @param employeeEmail  员工的邮箱
	 * @param employeePhone  员工的手机号码
	 * @param employeeIdCard 员工的身份证
	 * @return               员工对象
	 */
	public Employee findEmployeePassword(String employeeName,String employeeEmail,String employeePhone,String employeeIdCard){
		return employeeMapper.findEmployeePassword(employeeName, employeeEmail, employeePhone, employeeIdCard);
	}
	
	/**
	 * 注册用户
	 * @param username   用户名称
	 * @param userEmail  用户邮箱
	 * @param userPhone  用户手机号码
	 * @param userIdcard 用户身份证
	 * @param password   用户密码
	 * @return           用户对象
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
	 * 验证身份证是唯一性，确保一个身份证只能注册一个账号
	 * @param userIdCard
	 * @return
	 */
	public User checkIdCard(String userIdCard){
		return userMapper.checkIdCard(userIdCard);
	}
	
	/**
	 * 得到用户的权限对象集合
	 * @param rank   用户等级
	 * @return
	 */
	public List<LimiteRole> getUserLimit(Integer rank){
		return limiteRoleMapper.getUserLimite(rank);
	}
	
	/**
	 * 得到对应的菜单栏
	 * @param columnId  菜单id
	 * @return
	 */
	public Column getColumnLimite(Integer columnId){
		return columnMapper.getColumnLimite(columnId);
	}
	
	/**
	 * 根据权限得到父子级菜单
	 * @param columnPermissionid   菜单权限id
	 * @return
	 */
	public List<Column> getChildColumn(Integer columnPermissionid){
		return columnMapper.getChildColumn(columnPermissionid);
	}
}
