package cn.edu.nuc.weibo.service.interfaces;

import java.util.List;

import cn.edu.nuc.weibo.entity.StoreHouse;
import cn.edu.nuc.weibo.entity.searchObj.StoreHouseInfoSearchObj;

public interface StoreHouseInfoService {

	/*
	 * 初始化物料信息
	 */
	List<StoreHouse> queryByPage(StoreHouseInfoSearchObj StoreHouseInfoSearchObj);
    
	
	
}
