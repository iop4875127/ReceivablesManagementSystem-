package cn.edu.nuc.weibo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nuc.weibo.dao.interfaces.ProjectManagement.ProjectMaterialManagement.ProjectMaterialInfo.ProjectQureyInfoMapper;
import cn.edu.nuc.weibo.entity.Customer;
import cn.edu.nuc.weibo.entity.VO.ProjectManagement.ProjectMaterialManagement.ProjectMaterialInfo.ProjectPageVO;
import cn.edu.nuc.weibo.entity.searchObj.ProjectInfoSearchObj;
import cn.edu.nuc.weibo.service.interfaces.ProjectInfoService;
@Service
public class ProjectInfoServiceImpl implements ProjectInfoService{

	@Autowired
	private ProjectQureyInfoMapper projectQureyInfoMapper;
	
	public List<ProjectPageVO> queryByPage(ProjectInfoSearchObj projectInfoSearchObj) {
		
		List<ProjectPageVO> projectInfos = projectQureyInfoMapper.queryByPage(projectInfoSearchObj);
		
		return projectInfos;
	}

	public int queryCount(ProjectInfoSearchObj projectInfoSearchObj) {

		int count = projectQureyInfoMapper.qureyCount(projectInfoSearchObj);
		
		return count;
	}

}
