package cn.edu.nuc.weibo.controller.FinancialManagement.ReceiptDetail;

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
import cn.edu.nuc.weibo.entity.ReceiptDetail;
import cn.edu.nuc.weibo.entity.searchObj.ReceiptDetailInfoSearchObj;
import cn.edu.nuc.weibo.service.impl.CustomBaseInfoServiceImpl;
import cn.edu.nuc.weibo.service.impl.ReceiptInfoServiceImpl;

@Controller
@RequestMapping(value="/ReceiptInfo")
public class ReceiptInfoController {
	@Autowired
	private ReceiptInfoServiceImpl receiptInfoServiceImpl;


	@RequestMapping(value="/listReceiptInfo", method=RequestMethod.GET)
	public String forward(HttpServletRequest request){
		return "FinancialManagement/ReceiptDetail/Index";
	}

	@RequestMapping(value="/QueryByPage")
	@ResponseBody
	public Map<String, Object> QueryByPage(HttpServletRequest request, String projectNo, String payName,  int page, int rows)throws Exception{

		int startNo = (page - 1) * rows;
		int endNo = page * rows;

		ReceiptDetailInfoSearchObj receiptDetailInfoSearchObj = new ReceiptDetailInfoSearchObj();
		receiptDetailInfoSearchObj.setStartNumber(startNo);
		receiptDetailInfoSearchObj.setEndNumber(endNo);
		receiptDetailInfoSearchObj.setProjectNo(projectNo);
		receiptDetailInfoSearchObj.setPayName(payName);


		List<ReceiptDetail> receiptDetailInfoList = receiptInfoServiceImpl.queryByPage(receiptDetailInfoSearchObj);
		System.out.println(receiptDetailInfoList);

		int total = receiptInfoServiceImpl.queryCount(receiptDetailInfoSearchObj);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("total", total);
		data.put("rows", receiptDetailInfoList);


		return data;

	}
	
}
