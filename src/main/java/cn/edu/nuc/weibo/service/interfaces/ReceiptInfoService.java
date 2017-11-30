package cn.edu.nuc.weibo.service.interfaces;

import java.util.List;

import cn.edu.nuc.weibo.entity.ReceiptDetail;
import cn.edu.nuc.weibo.entity.searchObj.ReceiptDetailInfoSearchObj;

public interface ReceiptInfoService {

	/*
	 * 初始化收款信息
	 */
	List<ReceiptDetail> queryByPage(ReceiptDetailInfoSearchObj receiptDetailInfoSearchObj);
	
	/*
	 * 初始化收款信息条数
	 */
	int queryCount(ReceiptDetailInfoSearchObj receiptDetailInfoSearchObj);
	
}
