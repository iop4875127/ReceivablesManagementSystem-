package cn.edu.nuc.weibo.controller.HumanResourcesManagement.EmployeeManagement.EmployeeInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.edu.nuc.weibo.entity.Employee;
import cn.edu.nuc.weibo.entity.searchObj.EmployeeInfoSearchObj;
import cn.edu.nuc.weibo.service.impl.EmployeeInfoServiceImpl;

@Controller
@RequestMapping(value="/EmployeeInfo")
public class EmployeeInfoController {

	@Autowired
	private EmployeeInfoServiceImpl employeeInfoServiceImpl;

	@RequestMapping(value="/listEmployeeInfo", method=RequestMethod.GET)
	public String forward(HttpServletRequest request){
		return "HumanResourcesManagement/EmployeeManagement/EmployeeInfo/Index";
	}

	@RequestMapping(value="/QueryByPage")
	@ResponseBody
	public Map<String, Object> QueryByPage(HttpServletRequest request, String name, String department, String position, String employeeNo,  int page, int rows)throws Exception{

		int startNo = (page - 1) * rows;
		int endNo = page * rows;
		int totleCount;
		EmployeeInfoSearchObj employeeInfoSearchObj = new EmployeeInfoSearchObj();
		if(name ==""){
			name = null;
		}
		if(department ==""){
			department = null;
		}
		if(position ==""){
			position = null;
		}
		if(employeeNo ==""){
			employeeNo = null;
		}
		employeeInfoSearchObj.setStartNumber(startNo);
		employeeInfoSearchObj.setEndNumber(endNo);
		employeeInfoSearchObj.setDepartment(department);
		employeeInfoSearchObj.setEmployeeNo(employeeNo);
		employeeInfoSearchObj.setName(name);
		employeeInfoSearchObj.setPosition(position);

		List<Employee> employeeInfoList =  employeeInfoServiceImpl.queryByPage(employeeInfoSearchObj);
		System.out.println(employeeInfoList);
		totleCount = employeeInfoList.size();

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("total", totleCount);
		data.put("rows", employeeInfoList);


		return data;

	}
	
}
