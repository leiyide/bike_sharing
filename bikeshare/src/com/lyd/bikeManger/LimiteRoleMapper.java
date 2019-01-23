package com.lyd.bikeManger;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lyd.bikeEntity.LimiteRole;

public interface LimiteRoleMapper {
	/**
	 * ���ݵȼ��õ�Ȩ�޹�������
	 * @param rank     �ȼ�
	 * @return         Ȩ�޶��󼯺�
	 */
	List<LimiteRole> getUserLimite(@Param("rank")Integer rank);
	
    int deleteByPrimaryKey(Integer limiteRoleId);

    int insert(LimiteRole record);

    int insertSelective(LimiteRole record);

    LimiteRole selectByPrimaryKey(Integer limiteRoleId);

    int updateByPrimaryKeySelective(LimiteRole record);

    int updateByPrimaryKey(LimiteRole record);
}