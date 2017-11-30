package cn.edu.nuc.weibo.service.impl;


import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.nuc.weibo.BaseTest;
import cn.edu.nuc.weibo.entity.Account;
import cn.edu.nuc.weibo.service.interfaces.AccountService;

public class AccountServiceImplTest extends BaseTest {
	
	@Autowired
	private AccountService accountService;

	@Test
	public void testLogin() {
		
		Account account = accountService.login("zhangsan@163.com", "123456");
		System.out.println( account );
		Assert.assertNotNull(account);
	}

}
