package cn.edu.nuc.weibo.service.interfaces;

import java.util.List;

import cn.edu.nuc.weibo.entity.VO.BusinessManagement.DepositManagement.DepositInfo.DepositInfoVO;
import cn.edu.nuc.weibo.entity.VO.ProjectManagement.PlusOrMinusManagement.PlusOrMinusInfo.PlusOrMinusPageVO;
import cn.edu.nuc.weibo.entity.searchObj.DepositInfoSearchObj;
import cn.edu.nuc.weibo.entity.searchObj.PlusOrMinusInfoSearchObj;

public interface PlusOrMinusInfoService {

	/*
	 * 初始工程增减项信息
	 */
	List<PlusOrMinusPageVO> queryByPage(PlusOrMinusInfoSearchObj plusOrMinusInfoSearchObj);
    
	
	
}
