package cn.edu.nuc.weibo.dao.interfaces;

import cn.edu.nuc.weibo.entity.CostingDetail;

public interface CostingDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CostingDetail record);

    int insertSelective(CostingDetail record);

    CostingDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CostingDetail record);

    int updateByPrimaryKey(CostingDetail record);
}