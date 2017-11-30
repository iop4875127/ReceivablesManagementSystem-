package cn.edu.nuc.weibo.dao.interfaces;

import java.util.List;
import cn.edu.nuc.weibo.entity.Employee;
import cn.edu.nuc.weibo.entity.searchObj.EmployeeInfoSearchObj;

public interface EmployeeMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
    
    List<Employee> queryByPage(EmployeeInfoSearchObj employeeInfoSearchObj);
    
    
}