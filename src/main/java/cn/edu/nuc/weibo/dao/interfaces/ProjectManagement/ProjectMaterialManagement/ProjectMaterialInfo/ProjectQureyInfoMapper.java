package cn.edu.nuc.weibo.dao.interfaces.ProjectManagement.ProjectMaterialManagement.ProjectMaterialInfo;

import java.util.List;

import cn.edu.nuc.weibo.entity.VO.ProjectManagement.ProjectMaterialManagement.ProjectMaterialInfo.ProjectPageVO;
import cn.edu.nuc.weibo.entity.searchObj.ProjectInfoSearchObj;

public interface ProjectQureyInfoMapper {

	List<ProjectPageVO> queryByPage(ProjectInfoSearchObj projectInfoSearchObj);

	int qureyCount(ProjectInfoSearchObj projectInfoSearchObj);
}
