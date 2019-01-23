package com.lyd.bikeManger;

import org.apache.ibatis.annotations.Param;

import com.lyd.bikeEntity.User;

public interface UserMapper {
	/**
	 * 用户进行登录
	 * @param email      邮箱
	 * @param passsword  密码
	 * @return           用户信息对象
	 */
	User getUserLogin(@Param("email")String email,@Param("password")String passsword);
	
	/**
	 * 找回用户的密码
	 * @param userName   用户的名称
	 * @param userEmail  用户的邮箱
	 * @param userPhone  用户的手机号码
	 * @param userIdCard 用户的身份证
	 * @return           用户对象
	 */
	User findUserPassword(@Param("userName")String userName,@Param("userEmail")String userEmail,@Param("userPhone")String userPhone,@Param("userIdCard")String userIdCard);
	
	/**
	 * 注册用户
	 * @param username   用户名称
	 * @param userEmail  用户邮箱
	 * @param userPhone  用户手机号码
	 * @param userIdcard 用户身份证
	 * @param password   用户密码
	 * @return           用户对象
	 */
	int addNewUser(@Param("username")String username,@Param("userEmail")String userEmail,@Param("userPhone")String userPhone,@Param("userIdcard")String userIdcard,@Param("password")String password);
	
	/**
	 * 验证身份证是唯一性，确保一个身份证只能注册一个账号
	 * @param userIdCard
	 * @return
	 */
	User checkIdCard(@Param("userIdCard")String userIdCard);
	
    int insert(User record);

    int insertSelective(User record);
}