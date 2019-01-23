package com.lyd.bikeManger;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lyd.bikeEntity.LimiteRole;

public interface LimiteRoleMapper {
	/**
	 * 根据等级得到权限关联对象
	 * @param rank     等级
	 * @return         权限对象集合
	 */
	List<LimiteRole> getUserLimite(@Param("rank")Integer rank);
	
    int deleteByPrimaryKey(Integer limiteRoleId);

    int insert(LimiteRole record);

    int insertSelective(LimiteRole record);

    LimiteRole selectByPrimaryKey(Integer limiteRoleId);

    int updateByPrimaryKeySelective(LimiteRole record);

    int updateByPrimaryKey(LimiteRole record);
}