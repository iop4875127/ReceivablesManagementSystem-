package cn.edu.nuc.weibo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nuc.weibo.dao.interfaces.CustomerMapper;
import cn.edu.nuc.weibo.entity.Customer;
import cn.edu.nuc.weibo.entity.searchObj.CustomerBaseInfoSearchObj;
import cn.edu.nuc.weibo.service.interfaces.CustomBaseInfoService;
@Service
public class CustomBaseInfoServiceImpl implements CustomBaseInfoService{

	@Autowired
	private CustomerMapper customerMapper;
 	
	public List<Customer> queryByPage(CustomerBaseInfoSearchObj customerBaseInfoSearchObj) {
		
		List<Customer> customerBaseInfos = customerMapper.queryByPage(customerBaseInfoSearchObj);
		
		return customerBaseInfos;
	}
	
	public int queryCount(CustomerBaseInfoSearchObj customerBaseInfoSearchObj) {
		
		int aa = customerMapper.queryCount(customerBaseInfoSearchObj);
		
		return aa;
	}

}
