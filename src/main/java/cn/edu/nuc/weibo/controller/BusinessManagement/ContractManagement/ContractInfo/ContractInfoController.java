package cn.edu.nuc.weibo.controller.BusinessManagement.ContractManagement.ContractInfo;

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

import cn.edu.nuc.weibo.entity.Contract;
import cn.edu.nuc.weibo.entity.Customer;
import cn.edu.nuc.weibo.entity.PlusOrMinusList;
import cn.edu.nuc.weibo.entity.POJO.ContractPOJOList;
import cn.edu.nuc.weibo.entity.POJO.DepositPOJO;
import cn.edu.nuc.weibo.entity.POJO.PeriodPOJO;
import cn.edu.nuc.weibo.entity.POJO.ContractPOJO;
import cn.edu.nuc.weibo.entity.POJO.PlusOrMinusPOJO;
import cn.edu.nuc.weibo.entity.POJO.ProjectPOJO;
import cn.edu.nuc.weibo.entity.VO.BusinessManagement.ContractManagement.ContractInfo.ContractPageVO;
import cn.edu.nuc.weibo.entity.searchObj.ContractInfoSearchObj;
import cn.edu.nuc.weibo.service.impl.ContractInfoServiceImpl;
import cn.edu.nuc.weibo.service.interfaces.ContractInfoService;

@Controller
@RequestMapping(value="/ContractInfo")
public class ContractInfoController {
	
	@Autowired
	private ContractInfoServiceImpl contractInfoServiceImpl;

	@RequestMapping(value="/listContractInfo", method=RequestMethod.GET)
	public String forward(HttpServletRequest request){
		return "BusinessManagement/ContractManagement/ContractInfo/Index";
	}
	
	@RequestMapping(value="/QueryByPage")
	@ResponseBody
	public Map<String, Object> QueryByPage(HttpServletRequest request, 	String contractNo, String customerName, String projectNo, String projectManager, int page, int rows)throws Exception{

		int startNo = (page - 1) * rows;
		int endNo = page * rows;
		int totleCount;
		ContractInfoSearchObj contractInfoSearchObj = new ContractInfoSearchObj();
		contractInfoSearchObj.setStartNumber(startNo);
		contractInfoSearchObj.setEndNumber(endNo);
		if(contractNo ==""){
			contractNo = null;
		}
		if(customerName ==""){
			customerName = null;
		}
		if(projectManager ==""){
			projectManager = null;
		}
		if(projectNo ==""){
			projectNo = null;
		}
		contractInfoSearchObj.setContractNo(contractNo);
		contractInfoSearchObj.setCustomerName(customerName);
		contractInfoSearchObj.setProjectManager(projectManager);
		contractInfoSearchObj.setProjectNo(projectNo);
		
		List<ContractPageVO> contractInfoList =  contractInfoServiceImpl.queryByPage(contractInfoSearchObj);
		System.out.println(contractInfoList);
		totleCount = contractInfoList.size();

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("total", totleCount);
		data.put("rows", contractInfoList);


		return data;

	}
	
	@RequestMapping(value="/Query")
	@ResponseBody
	public Map<String, Object> Query(HttpServletRequest request, String contractNo, String customerName, String projectNo, String projectManager, int page, int rows)throws Exception{

		int startNo = (page - 1) * rows;
		int endNo = page * rows;
		int totleCount;
		ContractInfoSearchObj contractInfoSearchObj = new ContractInfoSearchObj();
		contractInfoSearchObj.setStartNumber(startNo);
		contractInfoSearchObj.setEndNumber(endNo);
		if(contractNo ==""){
			contractNo = null;
		}
		if(customerName ==""){
			customerName = null;
		}
		if(projectManager ==""){
			projectManager = null;
		}
		if(projectNo ==""){
			projectNo = null;
		}
		contractInfoSearchObj.setContractNo(contractNo);
		contractInfoSearchObj.setCustomerName(customerName);
		contractInfoSearchObj.setProjectManager(projectManager);
		contractInfoSearchObj.setProjectNo(projectNo);
		
		List<Contract> contractInfoList =  contractInfoServiceImpl.query(contractInfoSearchObj);
		System.out.println(contractInfoList);
		totleCount = contractInfoList.size();

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("total", totleCount);
		data.put("rows", contractInfoList);


		return data;

	}
	
	@RequestMapping(value="/AddContract")
	public String AddContract(ContractPOJOList contractPOJOList) throws IOException{
		
		int count = contractInfoServiceImpl.AddContract(contractPOJOList);
		

			return "redirect:/ContractInfo/listContractInfo";
	}
	
	
}
