package cn.edu.nuc.weibo.dao.interfaces;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import cn.edu.nuc.weibo.BaseTest;
import cn.edu.nuc.weibo.entity.Period;
import cn.edu.nuc.weibo.entity.searchObj.PeriodInfoSearchObj;

public class PeriodMapperTest extends BaseTest {

	@Autowired 
	private PeriodMapper periodMapper;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testDeleteByPrimaryKey() {
		Period aa = periodMapper.selectByPrimaryKey(1);
		System.out.println( aa );
		Assert.assertNotNull(aa);
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
		PeriodInfoSearchObj aa = new PeriodInfoSearchObj();
		aa.setEndNumber(3);
		aa.setStartNumber(0);
		aa.setContractNo("100001");
		aa.setPeriodLotNo(1);
		List<Period> bb = periodMapper.queryByPage(aa);
		System.out.println( bb );
		Assert.assertNotNull(bb);
	}
	
}
