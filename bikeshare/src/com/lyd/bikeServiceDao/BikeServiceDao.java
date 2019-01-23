package com.lyd.bikeServiceDao;

import java.util.Map;


public interface BikeServiceDao {
	
	/**
	 * �û��õ������б�
	 * @param currentPage
	 * @param pagesize
	 * @param bikeId       �������
	 * @param bikeGenerationnum  ��������
	 * @param bikeArea    ������������
	 * @return
	 */
	Map<String,Object> getBikeList(int currentPage,int pagesize, Integer bikeId,Integer bikeGenerationnum,String bikeArea);
	
}
