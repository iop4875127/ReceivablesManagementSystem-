package cn.edu.nuc.weibo.service.interfaces;

import java.util.List;

import cn.edu.nuc.weibo.entity.Customer;
import cn.edu.nuc.weibo.entity.Period;
import cn.edu.nuc.weibo.entity.searchObj.CustomerBaseInfoSearchObj;
import cn.edu.nuc.weibo.entity.searchObj.PeriodInfoSearchObj;

public interface PeriodInfoService {

	/*
	 * 初始化分期信息
	 */
	List<Period> queryByPage(PeriodInfoSearchObj periodInfoSearchObj);
    
	
}
