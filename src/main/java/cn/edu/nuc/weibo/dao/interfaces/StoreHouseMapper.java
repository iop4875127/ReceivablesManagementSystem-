package cn.edu.nuc.weibo.dao.interfaces;

import java.util.List;
import cn.edu.nuc.weibo.entity.StoreHouse;
import cn.edu.nuc.weibo.entity.searchObj.StoreHouseInfoSearchObj;

public interface StoreHouseMapper {
    
	int deleteByPrimaryKey(Integer id);

    int insert(StoreHouse record);

    int insertSelective(StoreHouse record);

    StoreHouse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StoreHouse record);

    int updateByPrimaryKey(StoreHouse record);
    
    List<StoreHouse> queryByPage(StoreHouseInfoSearchObj storeHouseInfoSearchObj);
    
    
}