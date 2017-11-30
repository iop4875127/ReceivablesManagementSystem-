package cn.edu.nuc.weibo.dao.interfaces.BusinessManagement.ContractManagement.ContractInfo;

import java.util.List;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.nuc.weibo.BaseTest;
import cn.edu.nuc.weibo.entity.VO.BusinessManagement.ContractManagement.ContractInfo.ContractPageVO;
import cn.edu.nuc.weibo.entity.searchObj.ContractInfoSearchObj;

public class ContractQureyInfoMapperTest extends BaseTest {

	@Autowired
	private ContractQureyInfoMapper contractQureyInfoMapper;
	 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testQueryfByPage() {
		ContractInfoSearchObj aa = new ContractInfoSearchObj();
		aa.setContractNo("100002");
		aa.setEndNumber(10);
		aa.setStartNumber(0);
		List<ContractPageVO> bb = contractQureyInfoMapper.queryByPage(aa);
		System.out.println(bb);
		Assert.assertNotNull(bb);
		
		}

}
