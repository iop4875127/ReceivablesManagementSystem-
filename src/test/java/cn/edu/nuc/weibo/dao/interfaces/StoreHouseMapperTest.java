package cn.edu.nuc.weibo.dao.interfaces;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.nuc.weibo.BaseTest;
import cn.edu.nuc.weibo.entity.Customer;
import cn.edu.nuc.weibo.entity.StoreHouse;
import cn.edu.nuc.weibo.entity.searchObj.CustomerBaseInfoSearchObj;
import cn.edu.nuc.weibo.entity.searchObj.StoreHouseInfoSearchObj;

public class StoreHouseMapperTest extends BaseTest {

	@Autowired
	private StoreHouseMapper storeHouseMapper;
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
		StoreHouse aa = storeHouseMapper.selectByPrimaryKey(1);
		System.out.println( aa );
		Assert.assertNotNull(aa);
	}

	@Test
	public void testSelectByPrimaryKey() {
		fail("Not yet implemented");
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
		StoreHouseInfoSearchObj aa = new StoreHouseInfoSearchObj();
/*		aa.setMaterialName("房梁");
		aa.setMaterialNo("1");*/
		aa.setEndNumber(3);
		aa.setStartNumber(0);
		List<StoreHouse> bb = storeHouseMapper.queryByPage(aa);
		System.out.println( bb );
		Assert.assertNotNull(bb);
	}
}
