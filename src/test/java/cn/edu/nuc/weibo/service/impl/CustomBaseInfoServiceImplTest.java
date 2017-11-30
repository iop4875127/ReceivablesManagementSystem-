package cn.edu.nuc.weibo.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.nuc.weibo.BaseTest;
import cn.edu.nuc.weibo.entity.Customer;
import cn.edu.nuc.weibo.entity.searchObj.CustomerBaseInfoSearchObj;
import cn.edu.nuc.weibo.service.interfaces.CustomBaseInfoService;

public class CustomBaseInfoServiceImplTest  extends BaseTest{

	@Autowired
	private CustomBaseInfoService customBaseInfoService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testQueryByPage() {
		CustomerBaseInfoSearchObj aa = new CustomerBaseInfoSearchObj();
		aa.setCustomerName("张三");
		aa.setEndNumber(3);
		aa.setProjectNo(1);
		aa.setStartNumber(0);
		List<Customer> bb = customBaseInfoService.queryByPage(aa);
		System.out.println(bb);
	}

}
