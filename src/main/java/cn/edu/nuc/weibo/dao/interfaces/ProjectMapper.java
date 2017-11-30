package cn.edu.nuc.weibo.dao.interfaces;

import java.util.List;
import cn.edu.nuc.weibo.entity.Project;
import cn.edu.nuc.weibo.entity.VO.ProjectManagement.ProjectMaterialManagement.ProjectMaterialInfo.ProjectPageVO;
import cn.edu.nuc.weibo.entity.searchObj.ProjectInfoSearchObj;

public interface ProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
    
    String findByProjectNo(String projectNo);
    
    List<String> findByContractNo(String contractNo);
}