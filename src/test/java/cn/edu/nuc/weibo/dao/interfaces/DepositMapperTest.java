package cn.edu.nuc.weibo.dao.interfaces;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.nuc.weibo.BaseTest;
import cn.edu.nuc.weibo.entity.Deposit;

public class DepositMapperTest extends BaseTest {

	@Autowired 
	private DepositMapper depositMapper;
	
	
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

		Deposit aa = depositMapper.selectByPrimaryKey(1);
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
