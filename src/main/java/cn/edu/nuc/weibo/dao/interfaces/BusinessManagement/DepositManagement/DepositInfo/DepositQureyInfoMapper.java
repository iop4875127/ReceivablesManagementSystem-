package cn.edu.nuc.weibo.dao.interfaces.BusinessManagement.DepositManagement.DepositInfo;

import java.util.List;

import cn.edu.nuc.weibo.entity.Deposit;
import cn.edu.nuc.weibo.entity.VO.BusinessManagement.DepositManagement.DepositInfo.DepositInfoVO;
import cn.edu.nuc.weibo.entity.searchObj.DepositInfoSearchObj;

public interface DepositQureyInfoMapper {

	Deposit selectByPrimaryKey(Integer id);

	List<DepositInfoVO> queryByPage(DepositInfoSearchObj depositInfoSearchObj);
}
