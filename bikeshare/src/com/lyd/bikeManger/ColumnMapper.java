package com.lyd.bikeManger;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lyd.bikeEntity.Column;

public interface ColumnMapper {

/**
	 * 得到对应的菜单栏
	 * @param columnId  菜单id
	 * @return
	 */
	Column getColumnLimite(@Param("columnId")Integer columnId);
	
	/**
	 * 根据权限得到父子级菜单
	 * @param columnPermissionid   菜单权限id
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