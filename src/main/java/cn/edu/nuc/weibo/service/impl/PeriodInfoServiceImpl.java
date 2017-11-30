package cn.edu.nuc.weibo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.edu.nuc.weibo.dao.interfaces.PeriodMapper;
import cn.edu.nuc.weibo.entity.Period;
import cn.edu.nuc.weibo.entity.searchObj.PeriodInfoSearchObj;
import cn.edu.nuc.weibo.service.interfaces.PeriodInfoService;
@Service
public class PeriodInfoServiceImpl implements PeriodInfoService{

	@Autowired
	private PeriodMapper periodMapper;
	
	public List<Period> queryByPage(PeriodInfoSearchObj periodInfoSearchObj) {
		
		List<Period> periodInfos = periodMapper.queryByPage(periodInfoSearchObj);
		
		return periodInfos;
	}

}
