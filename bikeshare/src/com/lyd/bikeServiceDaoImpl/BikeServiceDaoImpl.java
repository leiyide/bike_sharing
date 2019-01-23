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
 * Date��2018/2/26
 * Time��14:12
 * ================================
 */
@Component("bikeServiceDao")
public class BikeServiceDaoImpl implements BikeServiceDao{
	
	//���ݷ��ʲ�BikeMapper��ע��
	@Resource(name="bikeMapper")
	private BikeMapper bikeMapper;

	@Override
	public Map<String, Object> getBikeList(int currentPage, int pagesize, Integer bikeId, Integer bikeGenerationnum,
			String bikeArea) {
				//����jar�����ṩ�ķ�ҳ�������з�ҳ
				//��ҳ,��һ�������ǵ�ǰ��ҳ�����ڶ�����ҳ����ʾ���ݵ�����
				PageHelper.startPage(currentPage,pagesize);
				if(!StringUtils.isNotBlank(bikeArea)) {
					bikeArea="%"+bikeArea+"%";
				}
				//�õ������б���
				List<Bike> bikeList = bikeMapper.getBikeList(bikeId, bikeGenerationnum, bikeArea);
				//���ݲ�ѯ�����ݽ��з�ҳ
				PageInfo<Bike> page=new PageInfo<Bike>(bikeList);
				//����һ��map���ϣ��������ݵ�װ��
				Map<String,Object> map=new HashMap<String,Object>();
				//�������ݵ�װ��
				map.put("rows", page.getList());
				map.put("total", page.getTotal());
				return map;
	}
}
