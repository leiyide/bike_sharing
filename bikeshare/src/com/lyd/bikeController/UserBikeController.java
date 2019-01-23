package com.lyd.bikeController;

import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyd.bikeServiceDao.BikeServiceDao;

@Controller
public class UserBikeController {

	//ҵ���߼���BikeMapper��ע��
	@Resource(name="bikeServiceDao")
	private BikeServiceDao bikeServiceDao;
	
	/**
	 * �û��õ������б�
	 * @param offset ��ǰҳ
	 * @param limit  ÿҳ��ʾ����
	 * @param bikeId �������
	 * @param bikeGenerationnum  ��������
	 * @param bikeArea           �������ڳ���
	 * @return
	 */
	@RequestMapping("/getBikeList")
	@ResponseBody
	public Object getBikeList(int offset,int limit,Integer bikeId, String bikeKind,String address){
		String flag=null;
		if("��һ��".equals(bikeKind)){
			flag="1";
		}
		if("�ڶ���".equals(bikeKind)){
			flag="2";
		}
		if("������".equals(bikeKind)){
			flag="3";
		}
		if("".equals(bikeKind)||bikeKind==null){
			flag=null;
		}
		Integer valueOf = null;
		if(flag!=null){
			valueOf = Integer.valueOf(flag);
		}
		int currentPage=offset/limit+1;
		Map<String, Object> bikeList = bikeServiceDao.getBikeList(currentPage, limit, bikeId, valueOf, address);
		return bikeList;  
	}
}
