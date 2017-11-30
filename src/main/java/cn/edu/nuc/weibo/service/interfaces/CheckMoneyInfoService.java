package cn.edu.nuc.weibo.service.interfaces;

import java.util.List;

import cn.edu.nuc.weibo.entity.VO.FinancialManagement.CheckMoney.CheckMoneyPageVO;
import cn.edu.nuc.weibo.entity.VO.ProjectManagement.PlusOrMinusManagement.PlusOrMinusInfo.PlusOrMinusPageVO;
import cn.edu.nuc.weibo.entity.searchObj.CheckMoneylInfoSearchObj;
import cn.edu.nuc.weibo.entity.searchObj.PlusOrMinusInfoSearchObj;

public interface CheckMoneyInfoService {

	/*
	 * 初始财务审查信息
	 */
	List<CheckMoneyPageVO> queryByPage(CheckMoneylInfoSearchObj CheckMoneylInfoSearchObj);
    
	
	
}
