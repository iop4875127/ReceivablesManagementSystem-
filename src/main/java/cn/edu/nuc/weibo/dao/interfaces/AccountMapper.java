package cn.edu.nuc.weibo.dao.interfaces;

import cn.edu.nuc.weibo.entity.Account;

public interface AccountMapper {
    int deleteByPrimaryKey(Integer aid);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer aid);
    
    Account findByEmail(String email);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
    
    
}