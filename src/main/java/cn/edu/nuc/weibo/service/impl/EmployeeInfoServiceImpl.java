package cn.edu.nuc.weibo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nuc.weibo.dao.interfaces.CustomerMapper;
import cn.edu.nuc.weibo.dao.interfaces.EmployeeMapper;
import cn.edu.nuc.weibo.entity.Customer;
import cn.edu.nuc.weibo.entity.Employee;
import cn.edu.nuc.weibo.entity.searchObj.EmployeeInfoSearchObj;
import cn.edu.nuc.weibo.service.interfaces.EmployeeInfoService;
@Service
public class EmployeeInfoServiceImpl implements EmployeeInfoService {

	@Autowired
	private EmployeeMapper employeeMapper;

	public List<Employee> queryByPage(EmployeeInfoSearchObj employeeInfoSearchObj) {
		List<Employee> employeeInfos = employeeMapper.queryByPage(employeeInfoSearchObj);

		return employeeInfos;
	}

}
