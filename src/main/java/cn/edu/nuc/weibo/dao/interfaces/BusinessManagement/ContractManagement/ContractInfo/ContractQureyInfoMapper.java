package cn.edu.nuc.weibo.dao.interfaces.BusinessManagement.ContractManagement.ContractInfo;

import java.util.List;

import cn.edu.nuc.weibo.entity.VO.BusinessManagement.ContractManagement.ContractInfo.ContractPageVO;
import cn.edu.nuc.weibo.entity.searchObj.ContractInfoSearchObj;

public interface ContractQureyInfoMapper {

	List<ContractPageVO> queryByPage(ContractInfoSearchObj contractInfoSearchObj);
	
}
