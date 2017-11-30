package cn.edu.nuc.weibo.service.interfaces;

import java.util.List;

import cn.edu.nuc.weibo.entity.Customer;
import cn.edu.nuc.weibo.entity.VO.BusinessManagement.DepositManagement.DepositInfo.DepositInfoVO;
import cn.edu.nuc.weibo.entity.searchObj.CustomerBaseInfoSearchObj;
import cn.edu.nuc.weibo.entity.searchObj.DepositInfoSearchObj;

public interface DepositInfoService {

	/*
	 * 初始客户量房定金信息
	 */
	List<DepositInfoVO> queryByPage(DepositInfoSearchObj depositInfoSearchObj);
    
	
}
