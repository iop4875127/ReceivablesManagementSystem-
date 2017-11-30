package cn.edu.nuc.weibo.service.interfaces;

import java.util.List;

import cn.edu.nuc.weibo.entity.VO.ProjectManagement.ProjectMaterialManagement.ProjectMaterialInfo.ProjectPageVO;
import cn.edu.nuc.weibo.entity.searchObj.CustomerBaseInfoSearchObj;
import cn.edu.nuc.weibo.entity.searchObj.ProjectInfoSearchObj;

public interface ProjectInfoService {

	/*
	 * 初始化工程星系
	 */
	List<ProjectPageVO> queryByPage(ProjectInfoSearchObj projectInfoSearchObj);
	
	/*
	 * 工程分页条数
	 */
	int queryCount(ProjectInfoSearchObj projectInfoSearchObj);
	
}
