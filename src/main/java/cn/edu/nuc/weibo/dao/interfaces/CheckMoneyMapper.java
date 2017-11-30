package cn.edu.nuc.weibo.dao.interfaces;

import cn.edu.nuc.weibo.entity.CheckMoney;

public interface CheckMoneyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CheckMoney record);

    int insertSelective(CheckMoney record);

    CheckMoney selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CheckMoney record);

    int updateByPrimaryKey(CheckMoney record);
}