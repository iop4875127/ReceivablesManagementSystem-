package cn.edu.nuc.weibo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.edu.nuc.weibo.dao.interfaces.CustomerMapper;
import cn.edu.nuc.weibo.dao.interfaces.BusinessManagement.DepositManagement.DepositInfo.DepositQureyInfoMapper;
import cn.edu.nuc.weibo.entity.Customer;
import cn.edu.nuc.weibo.entity.VO.BusinessManagement.DepositManagement.DepositInfo.DepositInfoVO;
import cn.edu.nuc.weibo.entity.searchObj.DepositInfoSearchObj;
import cn.edu.nuc.weibo.service.interfaces.DepositInfoService;

@Service
public class DepositInfoServiceImpl implements DepositInfoService{

	private DepositQureyInfoMapper depositQureyInfoMapper;

	public List<DepositInfoVO> queryByPage(DepositInfoSearchObj depositInfoSearchObj) {
		
		List<DepositInfoVO> depositInfos = depositQureyInfoMapper.queryByPage(depositInfoSearchObj);
		
		return depositInfos;
	}
	
	
	
}
