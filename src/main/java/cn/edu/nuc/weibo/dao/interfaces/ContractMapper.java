package cn.edu.nuc.weibo.dao.interfaces;

import java.util.List;

import cn.edu.nuc.weibo.entity.Contract;
import cn.edu.nuc.weibo.entity.Customer;
import cn.edu.nuc.weibo.entity.searchObj.ContractInfoSearchObj;
import cn.edu.nuc.weibo.entity.searchObj.CustomerBaseInfoSearchObj;

public interface ContractMapper {
    
	int deleteByPrimaryKey(Integer id);

    int insert(Contract record);

    int insertSelective(Contract record);

    Contract selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Contract record);

    int updateByPrimaryKey(Contract record);
    
    List<Contract> queryByPage(ContractInfoSearchObj contractInfoSearchObj);
    
    int findByContractNo(String contractNO);

}