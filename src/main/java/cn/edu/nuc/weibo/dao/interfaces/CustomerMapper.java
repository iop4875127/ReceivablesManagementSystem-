package cn.edu.nuc.weibo.dao.interfaces;

import java.util.List;
import cn.edu.nuc.weibo.entity.Customer;
import cn.edu.nuc.weibo.entity.searchObj.CustomerBaseInfoSearchObj;

public interface CustomerMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
    
    List<Customer> queryByPage(CustomerBaseInfoSearchObj customerBaseInfoSearchObj);
    
    int queryCount(CustomerBaseInfoSearchObj customerBaseInfoSearchObj);
    
}