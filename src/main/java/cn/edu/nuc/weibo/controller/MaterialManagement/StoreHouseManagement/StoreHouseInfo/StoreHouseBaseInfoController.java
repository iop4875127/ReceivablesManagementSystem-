package cn.edu.nuc.weibo.controller.MaterialManagement.StoreHouseManagement.StoreHouseInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.edu.nuc.weibo.entity.StoreHouse;
import cn.edu.nuc.weibo.entity.searchObj.StoreHouseInfoSearchObj;
import cn.edu.nuc.weibo.service.impl.StoreHouseInfoServiceImpl;

@Controller
@RequestMapping(value="/StoreHouseInfo")
public class StoreHouseBaseInfoController {

	@Autowired
	private StoreHouseInfoServiceImpl storeHouseInfoServiceImpl;
	
	@RequestMapping(value="/listStoreHouseInfo", method=RequestMethod.GET)
	public String forward(HttpServletRequest request){
		return "MaterialManagement/StoreHouseManagement/StoreHouseInfo/Index";
	}
	
	@RequestMapping(value="/QueryByPage")
	@ResponseBody
	public Map<String, Object> QueryByPage(HttpServletRequest request, String materialNo, String materialName,  int page, int rows)throws Exception{

		int startNo = (page - 1) * rows ;
		int endNo = page * rows;
		int totleCount;
		StoreHouseInfoSearchObj storeHouseInfoSearchObj = new StoreHouseInfoSearchObj();
		storeHouseInfoSearchObj.setStartNumber(startNo);
		storeHouseInfoSearchObj.setEndNumber(endNo);
		if(materialNo ==""){
			materialNo = null;
		}
		storeHouseInfoSearchObj.setMaterialNo(materialNo);
		storeHouseInfoSearchObj.setMaterialName(materialName);

		List<StoreHouse> storeHouseInfoList =  storeHouseInfoServiceImpl.queryByPage(storeHouseInfoSearchObj);
		System.out.println(storeHouseInfoList);
		totleCount = storeHouseInfoList.size();

		Map<String, Object> data = new HashMap();
		data.put("total", totleCount);
		data.put("rows", storeHouseInfoList);


		return data;

	}
	
}
