package cn.edu.nuc.weibo.dao.interfaces.ProjectManagement.PlusOrMinusManagement.PlusOrMinusInfo;

import java.util.List;

import cn.edu.nuc.weibo.entity.PlusOrMinus;
import cn.edu.nuc.weibo.entity.VO.ProjectManagement.PlusOrMinusManagement.PlusOrMinusInfo.PlusOrMinusPageVO;
import cn.edu.nuc.weibo.entity.searchObj.PlusOrMinusInfoSearchObj;

public interface PlusOrMinusQureyInfoMapper {
	
	List<PlusOrMinusPageVO> queryByPage(PlusOrMinusInfoSearchObj plusOrMinusInfoSearchObj);

	int queryCount(PlusOrMinusInfoSearchObj plusOrMinusInfoSearchObj);
	
	int insert(PlusOrMinus plusOrMinus);
}
