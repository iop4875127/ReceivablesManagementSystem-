package cn.edu.nuc.weibo.dao.interfaces;

import java.util.List;

import cn.edu.nuc.weibo.entity.ReceiptDetail;
import cn.edu.nuc.weibo.entity.searchObj.ReceiptDetailInfoSearchObj;

public interface ReceiptDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReceiptDetail record);

    int insertSelective(ReceiptDetail record);

    ReceiptDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReceiptDetail record);

    int updateByPrimaryKey(ReceiptDetail record);
    
    List<ReceiptDetail> queryByPage(ReceiptDetailInfoSearchObj receiptDetailInfoSearchObj);
    
    int queryCount(ReceiptDetailInfoSearchObj receiptDetailInfoSearchObj);

	List<ReceiptDetail> queryByPage1(ReceiptDetailInfoSearchObj receiptDetailInfoSearchObj);
	
	
}