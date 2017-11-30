package cn.edu.nuc.weibo.service.interfaces;

import java.util.List;

import cn.edu.nuc.weibo.entity.Employee;
import cn.edu.nuc.weibo.entity.searchObj.EmployeeInfoSearchObj;

public interface EmployeeInfoService {

	/*
	 * 初始化职员信息
	 */
	List<Employee> queryByPage(EmployeeInfoSearchObj employeeInfoSearchObj);
    
	
}
