package com.lyd.bikeServiceDao;

import java.util.Map;


public interface BikeServiceDao {
	
	/**
	 * 用户得到单车列表
	 * @param currentPage
	 * @param pagesize
	 * @param bikeId       单车编号
	 * @param bikeGenerationnum  单车代数
	 * @param bikeArea    单车所在区域
	 * @return
	 */
	Map<String,Object> getBikeList(int currentPage,int pagesize, Integer bikeId,Integer bikeGenerationnum,String bikeArea);
	
}
