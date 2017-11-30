package cn.edu.nuc.weibo.service.interfaces;

import java.util.List;

import cn.edu.nuc.weibo.entity.Customer;
import cn.edu.nuc.weibo.entity.VO.ProjectManagement.ProjectMaterialManagement.ProjectMaterialInfo.ProjectPageVO;
import cn.edu.nuc.weibo.entity.searchObj.CustomerBaseInfoSearchObj;
import cn.edu.nuc.weibo.entity.searchObj.ProjectInfoSearchObj;

public interface CustomBaseInfoService {

	/*
	 * 初始化工程信息
	 */
	List<Customer> queryByPage(CustomerBaseInfoSearchObj customerBaseInfoSearchObj);
    
	
}
