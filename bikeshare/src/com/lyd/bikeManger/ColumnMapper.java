package com.lyd.bikeManger;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lyd.bikeEntity.Column;

public interface ColumnMapper {

/**
	 * �õ���Ӧ�Ĳ˵���
	 * @param columnId  �˵�id
	 * @return
	 */
	Column getColumnLimite(@Param("columnId")Integer columnId);
	
	/**
	 * ����Ȩ�޵õ����Ӽ��˵�
	 * @param columnPermissionid   �˵�Ȩ��id
	 * @return
	 */
	List<Column> getChildColumn(@Param("columnPermissionid")Integer columnPermissionid);
	
    int deleteByPrimaryKey(Integer columnId);

    int insert(Column record);

    int insertSelective(Column record);

    Column selectByPrimaryKey(Integer columnId);

    int updateByPrimaryKeySelective(Column record);

    int updateByPrimaryKey(Column record);
}