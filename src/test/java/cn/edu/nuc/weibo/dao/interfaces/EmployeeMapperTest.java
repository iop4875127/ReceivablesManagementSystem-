package cn.edu.nuc.weibo.dao.interfaces;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.nuc.weibo.BaseTest;
import cn.edu.nuc.weibo.entity.Customer;
import cn.edu.nuc.weibo.entity.Employee;
import cn.edu.nuc.weibo.entity.searchObj.CustomerBaseInfoSearchObj;
import cn.edu.nuc.weibo.entity.searchObj.EmployeeInfoSearchObj;

public class EmployeeMapperTest extends BaseTest {
	
	@Autowired 
	private EmployeeMapper employeeMapper ;

	@Test
	public void testDeleteByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertSelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByPrimaryKey() {
		Employee aa = employeeMapper.selectByPrimaryKey(1);
		System.out.println( aa );
		Assert.assertNotNull(aa);
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKey() {
		fail("Not yet implemented");
	}

//	========================以上调用方法不用测试==================================================
	@Test
	public void testQueryByPage() {
		EmployeeInfoSearchObj aa = new EmployeeInfoSearchObj();
		//aa.setEmployeeNo("2");
		aa.setName("上官");
		aa.setEndNumber(3);
		aa.setStartNumber(0);
		List<Employee> bb = employeeMapper.queryByPage(aa);
		System.out.println( bb );
		Assert.assertNotNull(bb);
	}
	
	
}
