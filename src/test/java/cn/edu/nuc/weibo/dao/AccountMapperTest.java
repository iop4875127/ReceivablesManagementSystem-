package cn.edu.nuc.weibo.dao;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.nuc.weibo.BaseTest;
import cn.edu.nuc.weibo.dao.interfaces.AccountMapper;
import cn.edu.nuc.weibo.entity.Account;

public class AccountMapperTest extends BaseTest {
	
	@Autowired
	private AccountMapper accountMapper;
	

	@Test
	public void testDeleteByPrimaryKey() {
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
		Account account = accountMapper.selectByPrimaryKey(1);
		System.out.println( account );
		Assert.assertNotNull(account);
	}
	
	@Test
	public void testFindByEmail() {
		Account account = accountMapper.findByEmail("zhangsan@163.com");
		System.out.println( account );
		Assert.assertNotNull(account);
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKey() {
		fail("Not yet implemented");
	}

}
