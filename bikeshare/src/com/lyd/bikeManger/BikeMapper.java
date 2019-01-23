package com.lyd.bikeManger;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lyd.bikeEntity.Bike;

public interface BikeMapper {
	
	/**
	 * �õ������б�
	 * @param bikeId       �������
	 * @param bikeGenerationnum  ��������
	 * @param bikeArea    ������������
	 * @return
	 */
	List<Bike> getBikeList(@Param("bikeId")Integer bikeId,@Param("bikeGenerationnum")Integer bikeGenerationnum,@Param("bikeArea")String bikeArea);
   
	int deleteByPrimaryKey(Integer bikeId);

    int insert(Bike record);

    int insertSelective(Bike record);

    Bike selectByPrimaryKey(Integer bikeId);

    int updateByPrimaryKeySelective(Bike record);

    int updateByPrimaryKey(Bike record);
}