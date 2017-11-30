package cn.edu.nuc.weibo.controller.CustomerServiceManagement.CustomInfo.CustomBaseInfo;

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
import cn.edu.nuc.weibo.entity.searchObj.CustomerBaseInfoSearchObj;
import cn.edu.nuc.weibo.service.impl.CustomBaseInfoServiceImpl;


@Controller
@RequestMapping(value="/CustomBaseInfo")
public class CustomBaseInfoController {

	@Autowired
	private CustomBaseInfoServiceImpl customBaseInfoServiceImpl;

	@RequestMapping(value="/listCustomBaseInfo", method=RequestMethod.GET)
	public String forward(HttpServletRequest request){
		return "CustomerServiceManagement/CustomInfo/CustomBaseInfo/Index";
	}

	@RequestMapping(value="/QueryByPage")
	@ResponseBody
	public Map<String, Object> QueryByPage(HttpServletRequest request, String customerName, Integer projectNo, Integer privileges,  int page, int rows)throws Exception{

		int startNo = (page - 1) * rows;
		int endNo = page * rows;

		CustomerBaseInfoSearchObj customerBaseInfoSearchObj = new CustomerBaseInfoSearchObj();
		customerBaseInfoSearchObj.setStartNumber(startNo);
		customerBaseInfoSearchObj.setEndNumber(endNo);
		customerBaseInfoSearchObj.setCustomerName(customerName);
		customerBaseInfoSearchObj.setProjectNo(projectNo);
		customerBaseInfoSearchObj.setPrivileges(privileges);


		List<Customer> customerBaseInfoList =  customBaseInfoServiceImpl.queryByPage(customerBaseInfoSearchObj);
		System.out.println(customerBaseInfoList);
		int total = customBaseInfoServiceImpl.queryCount(customerBaseInfoSearchObj);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("total", total);
		data.put("rows", customerBaseInfoList);


		return data;

	}

}
