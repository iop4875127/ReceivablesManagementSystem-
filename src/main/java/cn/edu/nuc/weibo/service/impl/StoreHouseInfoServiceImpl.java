package cn.edu.nuc.weibo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nuc.weibo.dao.interfaces.StoreHouseMapper;
import cn.edu.nuc.weibo.entity.StoreHouse;
import cn.edu.nuc.weibo.entity.searchObj.StoreHouseInfoSearchObj;
import cn.edu.nuc.weibo.service.interfaces.StoreHouseInfoService;
@Service
public class StoreHouseInfoServiceImpl implements StoreHouseInfoService {

	@Autowired
	private StoreHouseMapper storeHouseMapper;
	
	public List<StoreHouse> queryByPage(StoreHouseInfoSearchObj storeHouseInfoSearchObj) {

		List<StoreHouse> storeHouseInfos = storeHouseMapper.queryByPage(storeHouseInfoSearchObj);
		
		return storeHouseInfos;
		
	}

}
