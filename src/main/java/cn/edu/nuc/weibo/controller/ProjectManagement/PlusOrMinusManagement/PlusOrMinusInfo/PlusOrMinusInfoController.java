package cn.edu.nuc.weibo.controller.ProjectManagement.PlusOrMinusManagement.PlusOrMinusInfo;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import cn.edu.nuc.weibo.entity.PlusOrMinusList;
import cn.edu.nuc.weibo.entity.Result;
import cn.edu.nuc.weibo.entity.POJO.PlusOrMinusPOJO;
import cn.edu.nuc.weibo.entity.VO.ProjectManagement.PlusOrMinusManagement.PlusOrMinusInfo.PlusOrMinusPageVO;
import cn.edu.nuc.weibo.entity.searchObj.PlusOrMinusInfoSearchObj;
import cn.edu.nuc.weibo.service.impl.PlusOrMinusInfoServiceImpl;

@Controller
@RequestMapping(value="/PlusOrMinusInfo")
public class PlusOrMinusInfoController {
	
	@Autowired
	private PlusOrMinusInfoServiceImpl plusOrMinusInfoServiceImpl;

	@RequestMapping(value="/listPlusOrMinusInfo", method=RequestMethod.GET)
	public String forward(HttpServletRequest request){
		return "ProjectManagement/PlusOrMinusManagement/PlusOrMinusInfo/Index";
	}

	@RequestMapping(value="/QueryByPage")
	@ResponseBody
	public Map<String, Object> QueryByPage(HttpServletRequest request, String contractNo, String projectNo, String projectManager, String customerName, String projectAddress,  int page, int rows)throws Exception{

		int startNo = (page - 1) * rows;
		int endNo = page * rows;
		PlusOrMinusInfoSearchObj plusOrMinusInfoSearchObj = new PlusOrMinusInfoSearchObj();
		plusOrMinusInfoSearchObj.setStartNumber(startNo);
		plusOrMinusInfoSearchObj.setEndNumber(endNo);
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
		plusOrMinusInfoSearchObj.setContractNo(contractNo);
		plusOrMinusInfoSearchObj.setCustomerName(customerName);
		plusOrMinusInfoSearchObj.setProjectAddress(projectAddress);
		plusOrMinusInfoSearchObj.setProjectManager(projectManager);
		plusOrMinusInfoSearchObj.setProjectNo(projectNo);

		List<PlusOrMinusPageVO> plusOrMinusInfoList =  plusOrMinusInfoServiceImpl.queryByPage(plusOrMinusInfoSearchObj);
		
		int count = plusOrMinusInfoServiceImpl.queryCount(plusOrMinusInfoSearchObj);
		System.out.println(plusOrMinusInfoList);

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("total", count);
		data.put("rows", plusOrMinusInfoList);


		return data;

	}

	@RequestMapping(value="/AddPlusOrMinus")
	public String AddPlusOrMinus(PlusOrMinusList plusOrMinusList) throws IOException{
		
		List<PlusOrMinusPOJO> plusOrMinus = plusOrMinusList.getPlusOrMinusPoJo();
		int aa = plusOrMinusInfoServiceImpl.AddPlusOrMinus(plusOrMinus);
		System.out.println(aa);
		return "redirect:/PlusOrMinusInfo/listPlusOrMinusInfo";
		
	}
	
	
}
