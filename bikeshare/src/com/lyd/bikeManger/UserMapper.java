package com.lyd.bikeManger;

import org.apache.ibatis.annotations.Param;

import com.lyd.bikeEntity.User;

public interface UserMapper {
	/**
	 * �û����е�¼
	 * @param email      ����
	 * @param passsword  ����
	 * @return           �û���Ϣ����
	 */
	User getUserLogin(@Param("email")String email,@Param("password")String passsword);
	
	/**
	 * �һ��û�������
	 * @param userName   �û�������
	 * @param userEmail  �û�������
	 * @param userPhone  �û����ֻ�����
	 * @param userIdCard �û������֤
	 * @return           �û�����
	 */
	User findUserPassword(@Param("userName")String userName,@Param("userEmail")String userEmail,@Param("userPhone")String userPhone,@Param("userIdCard")String userIdCard);
	
	/**
	 * ע���û�
	 * @param username   �û�����
	 * @param userEmail  �û�����
	 * @param userPhone  �û��ֻ�����
	 * @param userIdcard �û����֤
	 * @param password   �û�����
	 * @return           �û�����
	 */
	int addNewUser(@Param("username")String username,@Param("userEmail")String userEmail,@Param("userPhone")String userPhone,@Param("userIdcard")String userIdcard,@Param("password")String password);
	
	/**
	 * ��֤���֤��Ψһ�ԣ�ȷ��һ�����ֻ֤��ע��һ���˺�
	 * @param userIdCard
	 * @return
	 */
	User checkIdCard(@Param("userIdCard")String userIdCard);
	
    int insert(User record);

    int insertSelective(User record);
}