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

	//业务逻辑层BikeMapper的注入
	@Resource(name="bikeServiceDao")
	private BikeServiceDao bikeServiceDao;
	
	/**
	 * 用户得到单车列表
	 * @param offset 当前页
	 * @param limit  每页显示条数
	 * @param bikeId 单车编号
	 * @param bikeGenerationnum  单车代数
	 * @param bikeArea           单车所在城市
	 * @return
	 */
	@RequestMapping("/getBikeList")
	@ResponseBody
	public Object getBikeList(int offset,int limit,Integer bikeId, String bikeKind,String address){
		String flag=null;
		if("第一代".equals(bikeKind)){
			flag="1";
		}
		if("第二代".equals(bikeKind)){
			flag="2";
		}
		if("第三代".equals(bikeKind)){
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
