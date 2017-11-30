package cn.edu.nuc.weibo.dao.interfaces;

import java.util.List;
import cn.edu.nuc.weibo.entity.Period;
import cn.edu.nuc.weibo.entity.searchObj.PeriodInfoSearchObj;

public interface PeriodMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Period record);

    int insertSelective(Period record);

    Period selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Period record);

    int updateByPrimaryKey(Period record);
    
    List<Period> queryByPage(PeriodInfoSearchObj periodInfoSearchObj);
    
}