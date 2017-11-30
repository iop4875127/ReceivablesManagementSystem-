package cn.edu.nuc.weibo.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.edu.nuc.weibo.entity.Customer;
import cn.edu.nuc.weibo.entity.POJO.ContractPOJOList;
import cn.edu.nuc.weibo.entity.VO.BusinessManagement.ContractManagement.ContractInfo.ContractPageVO;
import cn.edu.nuc.weibo.entity.searchObj.ContractInfoSearchObj;
import cn.edu.nuc.weibo.entity.searchObj.CustomerBaseInfoSearchObj;

public interface ContractInfoService {

	/*
	 * 初始化合同信息
	 */
	List<ContractPageVO> queryByPage(ContractInfoSearchObj contractInfoSearchObj);
    
	/*
	 * 增加合同
	 */
	int AddContract(ContractPOJOList contractPOJOList);
}
