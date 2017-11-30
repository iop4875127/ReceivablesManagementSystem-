package cn.edu.nuc.weibo.service.impl;

import java.util.List;

import cn.edu.nuc.weibo.entity.ReceiptDetail;
import cn.edu.nuc.weibo.entity.searchObj.ReceiptDetailInfoSearchObj;
import cn.edu.nuc.weibo.service.interfaces.ReceiptInfoService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nuc.weibo.dao.interfaces.ReceiptDetailMapper;
import cn.edu.nuc.weibo.dao.interfaces.ProjectManagement.ProjectMaterialManagement.ProjectMaterialInfo.ProjectQureyInfoMapper;
import cn.edu.nuc.weibo.entity.Customer;
import cn.edu.nuc.weibo.entity.VO.ProjectManagement.ProjectMaterialManagement.ProjectMaterialInfo.ProjectPageVO;
import cn.edu.nuc.weibo.entity.searchObj.ProjectInfoSearchObj;
import cn.edu.nuc.weibo.service.interfaces.ProjectInfoService;
@Service
public class ReceiptInfoServiceImpl implements ReceiptInfoService{

	@Autowired
	private ReceiptDetailMapper receiptDetailMapper; 
	
	public List<ReceiptDetail> queryByPage(ReceiptDetailInfoSearchObj receiptDetailInfoSearchObj) {

		List<ReceiptDetail> receiptDetailList = receiptDetailMapper.queryByPage(receiptDetailInfoSearchObj);
		return receiptDetailList;
	}

	public int queryCount(ReceiptDetailInfoSearchObj receiptDetailInfoSearchObj) {

		int aa = receiptDetailMapper.queryCount(receiptDetailInfoSearchObj);
		
		return aa;
	}

}
