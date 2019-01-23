package com.lyd.bikeManger;

import org.apache.ibatis.annotations.Param;

import com.lyd.bikeEntity.Employee;

public interface EmployeeMapper {
	
	/**
	 * 员工进行登录
	 * @param employeeEmail   员工邮箱
	 * @param password        登录密码
	 * @return                员工对象
	 */
	Employee getEmployeeLogin(@Param("employeeEmail")String employeeEmail, @Param("password")String password);
	
	/**
	 * 找回员工的密码
	 * @param employeeName   员工的名称
	 * @param employeeEmail  员工的邮箱
	 * @param employeePhone  员工的手机号码
	 * @param employeeIdCard 员工的身份证
	 * @return               员工对象
	 */
	Employee findEmployeePassword(@Param("employeeName")String employeeName,@Param("employeeEmail")String employeeEmail,@Param("employeePhone")String employeePhone,@Param("employeeIdCard")String employeeIdCard);
	
    int deleteByPrimaryKey(Integer employeeId);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer employeeId);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}