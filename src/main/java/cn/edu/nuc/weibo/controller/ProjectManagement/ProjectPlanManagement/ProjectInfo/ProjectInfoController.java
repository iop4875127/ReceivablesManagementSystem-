package cn.edu.nuc.weibo.controller.ProjectManagement.ProjectPlanManagement.ProjectInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.nuc.weibo.entity.Customer;
import cn.edu.nuc.weibo.entity.VO.ProjectManagement.ProjectMaterialManagement.ProjectMaterialInfo.ProjectPageVO;
import cn.edu.nuc.weibo.entity.searchObj.CustomerBaseInfoSearchObj;
import cn.edu.nuc.weibo.entity.searchObj.ProjectInfoSearchObj;
import cn.edu.nuc.weibo.service.impl.CustomBaseInfoServiceImpl;
import cn.edu.nuc.weibo.service.impl.ProjectInfoServiceImpl;

@Controller
@RequestMapping(value="/ProjectInfo")
public class ProjectInfoController {

	@Autowired
	private ProjectInfoServiceImpl projectInfoServiceImpl;
	
	@RequestMapping(value="/listProjectInfo", method=RequestMethod.GET)
	public String forward(HttpServletRequest request){
		return "ProjectManagement/ProjectPlanManagement/ProjectInfo/Index";
	}

	@RequestMapping(value="/QueryByPage")
	@ResponseBody
	public Map<String, Object> QueryByPage(HttpServletRequest request, String contractNo, String projectNo, String projectManager, String customerName, String projectAddress,  int page, int rows)throws Exception{

		int startNo = (page - 1) * rows;
		int endNo = page * rows;
		ProjectInfoSearchObj projectInfoSearchObj = new ProjectInfoSearchObj();
		projectInfoSearchObj.setStartNumber(startNo);
		projectInfoSearchObj.setEndNumber(endNo);
		if(contractNo ==""){
			contractNo = null;
		}
		if(projectNo ==""){
			projectNo = null;
		}
		if(projectManager ==""){
			projectManager = null;
		}
		if(customerName ==""){
			customerName = null;
		}
		if(projectAddress ==""){
			projectAddress = null;
		}
		projectInfoSearchObj.setContractNo(contractNo);
		projectInfoSearchObj.setCustomerName(customerName);
		projectInfoSearchObj.setProjectAddress(projectAddress);
		projectInfoSearchObj.setProjectManager(projectManager);
		projectInfoSearchObj.setProjectNo(projectNo);

		List<ProjectPageVO> projectInfoList =  projectInfoServiceImpl.queryByPage(projectInfoSearchObj);
		System.out.println(projectInfoSearchObj);

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("total", projectInfoList.size());
		data.put("rows", projectInfoList);


		return data;

	}
	
}
