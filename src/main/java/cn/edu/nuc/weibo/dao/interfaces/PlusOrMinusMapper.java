package cn.edu.nuc.weibo.dao.interfaces;

import java.util.List;

import cn.edu.nuc.weibo.entity.PlusOrMinus;
import cn.edu.nuc.weibo.entity.searchObj.PlusOrMinusInfoSearchObj;

public interface PlusOrMinusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlusOrMinus record);

    int insertSelective(PlusOrMinus record);

    PlusOrMinus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlusOrMinus record);

    int updateByPrimaryKey(PlusOrMinus record);
    
    List<PlusOrMinus> findByProjectNo(String projectNo);
}