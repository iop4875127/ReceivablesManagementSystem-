package cn.edu.nuc.weibo.controller.FinancialManagement.CheckMoney;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.nuc.weibo.entity.ReceiptDetail;
import cn.edu.nuc.weibo.entity.VO.FinancialManagement.CheckMoney.CheckMoneyPageVO;
import cn.edu.nuc.weibo.entity.searchObj.CheckMoneylInfoSearchObj;
import cn.edu.nuc.weibo.service.impl.CheckMoneyServiceImpl;
import cn.edu.nuc.weibo.service.impl.ReceiptInfoServiceImpl;

@Controller
@RequestMapping(value="/CheckMoneyInfo")
public class CheckMoneyInfoController {

	@Autowired
	private CheckMoneyServiceImpl checkMoneyInfoServiceImpl;

	@RequestMapping(value="/listCheckMoneyInfo", method=RequestMethod.GET)
	public String forward(HttpServletRequest request){
		return "FinancialManagement/CheckMoney/Index";
	}

	@RequestMapping(value="/QueryByPage")
	@ResponseBody
	public Map<String, Object> QueryByPage(HttpServletRequest request, String projectNo, String contractNo,  int page, int rows)throws Exception{

		int startNo = (page - 1) * rows;
		int endNo = page * rows;

		CheckMoneylInfoSearchObj checkMoneylInfoSearchObj = new CheckMoneylInfoSearchObj();
		checkMoneylInfoSearchObj.setStartNumber(startNo);
		checkMoneylInfoSearchObj.setEndNumber(endNo);
		checkMoneylInfoSearchObj.setProjectNo(projectNo);
		checkMoneylInfoSearchObj.setContractNo(contractNo);

		List<CheckMoneyPageVO> checkMoneyInfoList = checkMoneyInfoServiceImpl.queryByPage(checkMoneylInfoSearchObj);

		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("total", checkMoneyInfoList.size());
		data.put("rows", checkMoneyInfoList);

		return data;

	}
	
}
