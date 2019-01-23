package com.lyd.bikeManger;

import org.apache.ibatis.annotations.Param;

import com.lyd.bikeEntity.Employee;

public interface EmployeeMapper {
	
	/**
	 * Ա�����е�¼
	 * @param employeeEmail   Ա������
	 * @param password        ��¼����
	 * @return                Ա������
	 */
	Employee getEmployeeLogin(@Param("employeeEmail")String employeeEmail, @Param("password")String password);
	
	/**
	 * �һ�Ա��������
	 * @param employeeName   Ա��������
	 * @param employeeEmail  Ա��������
	 * @param employeePhone  Ա�����ֻ�����
	 * @param employeeIdCard Ա�������֤
	 * @return               Ա������
	 */
	Employee findEmployeePassword(@Param("employeeName")String employeeName,@Param("employeeEmail")String employeeEmail,@Param("employeePhone")String employeePhone,@Param("employeeIdCard")String employeeIdCard);
	
    int deleteByPrimaryKey(Integer employeeId);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer employeeId);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}