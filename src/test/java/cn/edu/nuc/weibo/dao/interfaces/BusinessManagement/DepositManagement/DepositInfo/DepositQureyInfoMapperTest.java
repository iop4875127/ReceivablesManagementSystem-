package cn.edu.nuc.weibo.dao.interfaces.BusinessManagement.DepositManagement.DepositInfo;

import java.math.BigDecimal;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import cn.edu.nuc.weibo.BaseTest;
import cn.edu.nuc.weibo.entity.Deposit;
import cn.edu.nuc.weibo.entity.VO.BusinessManagement.DepositManagement.DepositInfo.DepositInfoVO;
import cn.edu.nuc.weibo.entity.searchObj.DepositInfoSearchObj;

public class DepositQureyInfoMapperTest extends BaseTest {

	@Autowired
	private DepositQureyInfoMapper depositQureyInfoMapper;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testQueryByPage() {
		DepositInfoSearchObj aa = new DepositInfoSearchObj();
		aa.setArea(60000000);
		aa.setEndNumber(3);
		aa.setHomeType(1);
		aa.setPrivileges(5);
		BigDecimal bd = new BigDecimal(4500000.0000);
		aa.setRealityDeposit(bd);
		aa.setStartNumber(0);
		
		List<DepositInfoVO> aaa = depositQureyInfoMapper.queryByPage(aa);
		System.out.println(aaa);
		
	}
	
	@Test
	public void testSelectByPrimaryKey() {

		Deposit aa = depositQureyInfoMapper.selectByPrimaryKey(1);
		System.out.println( aa );
		Assert.assertNotNull(aa);
	}

}
