package com.lyd.bikeManger;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lyd.bikeEntity.Bike;

public interface BikeMapper {
	
	/**
	 * 得到单车列表
	 * @param bikeId       单车编号
	 * @param bikeGenerationnum  单车代数
	 * @param bikeArea    单车所在区域
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