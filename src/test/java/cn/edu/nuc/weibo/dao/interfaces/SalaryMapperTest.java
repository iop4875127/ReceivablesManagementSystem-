package cn.edu.nuc.weibo.dao.interfaces;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.nuc.weibo.BaseTest;
import cn.edu.nuc.weibo.entity.Salary;

public class SalaryMapperTest extends BaseTest {
	@Autowired
	private SalaryMapper salaryMapper;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

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
		Salary aa = salaryMapper.selectByPrimaryKey(1);
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
	

}
