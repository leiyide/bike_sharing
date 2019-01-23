package com.lyd.bikeServiceDaoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyd.bikeEntity.Bike;
import com.lyd.bikeManger.BikeMapper;
import com.lyd.bikeServiceDao.BikeServiceDao;
/**
 * @author leiyide
 * =============================== 
 * Date：2018/2/26
 * Time：14:12
 * ================================
 */
@Component("bikeServiceDao")
public class BikeServiceDaoImpl implements BikeServiceDao{
	
	//数据访问层BikeMapper的注入
	@Resource(name="bikeMapper")
	private BikeMapper bikeMapper;

	@Override
	public Map<String, Object> getBikeList(int currentPage, int pagesize, Integer bikeId, Integer bikeGenerationnum,
			String bikeArea) {
				//调用jar包中提供的分页方法进行分页
				//分页,第一个参数是当前是页数，第二个是页面显示数据的条数
				PageHelper.startPage(currentPage,pagesize);
				if(!StringUtils.isNotBlank(bikeArea)) {
					bikeArea="%"+bikeArea+"%";
				}
				//得到单车列表集合
				List<Bike> bikeList = bikeMapper.getBikeList(bikeId, bikeGenerationnum, bikeArea);
				//根据查询的数据进行分页
				PageInfo<Bike> page=new PageInfo<Bike>(bikeList);
				//声明一个map集合，进行数据的装入
				Map<String,Object> map=new HashMap<String,Object>();
				//进行数据的装入
				map.put("rows", page.getList());
				map.put("total", page.getTotal());
				return map;
	}
}
