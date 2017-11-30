package cn.edu.nuc.weibo.controller.BusinessManagement.PeriodManagement.PeriodInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.edu.nuc.weibo.entity.Period;
import cn.edu.nuc.weibo.entity.searchObj.PeriodInfoSearchObj;
import cn.edu.nuc.weibo.service.interfaces.PeriodInfoService;

@Controller
@RequestMapping(value="/PeriodInfo")
public class PeriodInfoController {

	@Autowired
	private PeriodInfoService periodInfoService;
	
	@RequestMapping(value="/listPeriodInfo", method=RequestMethod.GET)
	public String forward(HttpServletRequest request){
		return "BusinessManagement/PeriodManagement/PeriodInfo/Index";
	}
	
	@RequestMapping(value="/QueryByPage")
	@ResponseBody
	public Map<String, Object> QueryByPage(HttpServletRequest request, Integer periodLotNo, String contractNo,  int page, int rows)throws Exception{

		int startNo = (page - 1) * rows;
		int endNo = page * rows;
		PeriodInfoSearchObj periodInfoSearchObj  = new PeriodInfoSearchObj();
		periodInfoSearchObj.setStartNumber(startNo);
		periodInfoSearchObj.setEndNumber(endNo);
		periodInfoSearchObj.setPeriodLotNo(periodLotNo);
		periodInfoSearchObj.setContractNo(contractNo);

		List<Period> periodInfoList =  periodInfoService.queryByPage(periodInfoSearchObj);
		System.out.println(periodInfoList );

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("total", periodInfoList.size());
		data.put("rows", periodInfoList);


		return data;

	}
	
}
