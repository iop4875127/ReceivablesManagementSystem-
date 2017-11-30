package cn.edu.nuc.weibo.dao.interfaces;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import cn.edu.nuc.weibo.BaseTest;
import cn.edu.nuc.weibo.entity.Customer;
import cn.edu.nuc.weibo.entity.searchObj.CustomerBaseInfoSearchObj;
import junit.framework.Assert;

public class CustomerMapperTest extends BaseTest {

	@Autowired
	private CustomerMapper customerMapper;
	
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
		Customer aa = customerMapper.selectByPrimaryKey(1);
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

	@Test
	public void testQueryByPage() {
		CustomerBaseInfoSearchObj aa = new CustomerBaseInfoSearchObj();
		aa.setCustomerName("李");
		aa.setEndNumber(10);
		Integer aw = Integer.parseInt("5");
		Integer as = Integer.parseInt("5");
		aa.setProjectNo(aw);
		aa.setPrivileges(as);
		aa.setStartNumber(0);
		List<Customer> bb = customerMapper.queryByPage(aa);
		System.out.println( bb );
		Assert.assertNotNull(bb);
	}
	

}
