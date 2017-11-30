package cn.edu.nuc.weibo.dao.interfaces;

import java.math.BigDecimal;

import cn.edu.nuc.weibo.entity.Deposit;

public interface DepositMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Deposit record);

    int insertSelective(Deposit record);

    Deposit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Deposit record);

    int updateByPrimaryKey(Deposit record);
    
    Deposit findByCustomerNo(int customerNo);
}