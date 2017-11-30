package cn.edu.nuc.weibo.controller.BusinessManagement.DepositManagement.DepositInfo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.nuc.weibo.dao.interfaces.BusinessManagement.DepositManagement.DepositInfo.DepositQureyInfoMapper;
import cn.edu.nuc.weibo.entity.VO.BusinessManagement.DepositManagement.DepositInfo.DepositInfoVO;
import cn.edu.nuc.weibo.entity.searchObj.DepositInfoSearchObj;
@Controller
@RequestMapping(value="/DepositInfo")
public class DepositInfoController {

	@Autowired
	private DepositQureyInfoMapper depositQureyInfoMapper; 
	
	@RequestMapping(value="/listDepositInfo", method=RequestMethod.GET)
	public String forward(HttpServletRequest request){
		return "BusinessManagement/DepositManagement/DepositInfo/Index";
	}
	
	@RequestMapping(value="/QueryByPage")
	@ResponseBody
	public Map<String, Object> QueryByPage(HttpServletRequest request, Integer area, Integer homeType, Integer privileges,BigDecimal realityDeposit,  int page, int rows)throws Exception{

		int startNo = (page - 1) * rows;
		int endNo = page * rows;
		DepositInfoSearchObj depositInfoSearchObj  = new DepositInfoSearchObj();
		depositInfoSearchObj.setStartNumber(startNo);
		depositInfoSearchObj.setEndNumber(endNo);
		depositInfoSearchObj.setArea(area);
		depositInfoSearchObj.setHomeType(homeType);
		depositInfoSearchObj.setPrivileges(privileges);
		depositInfoSearchObj.setRealityDeposit(realityDeposit);

		List<DepositInfoVO> depositInfoList =  depositQureyInfoMapper.queryByPage(depositInfoSearchObj);
		System.out.println(depositInfoList );

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("total", depositInfoList.size());
		data.put("rows", depositInfoList);


		return data;

	}
	
}
