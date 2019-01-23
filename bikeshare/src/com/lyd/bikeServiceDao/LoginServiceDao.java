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
 * Date：2018/2/6
 * Time：16:12
 * ================================
 */
public interface LoginServiceDao {

	/**
	 * 用户登录
	 * @param email        邮箱
	 * @param password     密码
	 * @return             用户对象
	 */
	public User getUserLogin(String email,String password);
	
	/**
	 * 员工进行登录
	 * @param employeeEmail   员工邮箱
	 * @param password        登录密码
	 * @return                员工对象
	 */
	public Employee getEmployeeLogin(String employeeEmail,String password);
	
	/**
	 * 找回用户的密码
	 * @param userName   用户的名称
	 * @param userEmail  用户的邮箱
	 * @param userPhone  用户的手机号码
	 * @param userIdCard 用户的身份证
	 * @return           用户对象
	 */
	public User findUserPassword(String userName,String userEmail,String userPhone,String userIdCard);
	
	/**
	 * 找回员工的密码
	 * @param employeeName   员工的名称
	 * @param employeeEmail  员工的邮箱
	 * @param employeePhone  员工的手机号码
	 * @param employeeIdCard 员工的身份证
	 * @return               员工对象
	 */
	public Employee findEmployeePassword(String employeeName,String employeeEmail,String employeePhone,String employeeIdCard);
	
	/**
	 * 注册用户
	 * @param username   用户名称
	 * @param userEmail  用户邮箱
	 * @param userPhone  用户手机号码
	 * @param userIdcard 用户身份证
	 * @param password   用户密码
	 * @return           用户对象
	 */
	public Boolean addNewUser(String username,String userEmail,String userPhone,String userIdcard,String password);
	
	/**
	 * 验证身份证是唯一性，确保一个身份证只能注册一个账号
	 * @param userIdCard
	 * @return
	 */
	public User checkIdCard(String userIdCard);
	
	/**
	 * 得到用户的权限对象集合
	 * @param rank   用户等级
	 * @return
	 */
	public List<LimiteRole> getUserLimit(Integer rank);
	
	/**
	 * 得到对应的菜单栏
	 * @param columnId  菜单id
	 * @return
	 */
	public Column getColumnLimite(Integer columnId);
	
	/**
	 * 根据权限得到父子级菜单
	 * @param columnPermissionid   菜单权限id
	 * @return
	 */
	public List<Column> getChildColumn(Integer columnPermissionid);
}
