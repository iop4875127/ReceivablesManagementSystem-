package cn.edu.nuc.weibo.dao.interfaces.ProjectManagement.PlusOrMinusManagement.PlusOrMinusInfo;

import java.math.BigDecimal;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import cn.edu.nuc.weibo.BaseTest;
import cn.edu.nuc.weibo.entity.VO.ProjectManagement.PlusOrMinusManagement.PlusOrMinusInfo.PlusOrMinusPageVO;
import cn.edu.nuc.weibo.entity.searchObj.PlusOrMinusInfoSearchObj;

public class PlusOrMinusQureyInfoMapperTest extends BaseTest {

	
	@Autowired
	private PlusOrMinusQureyInfoMapper plusOrMinusQureyInfoMapper; 
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testQueryByPage() {
		PlusOrMinusInfoSearchObj aa = new PlusOrMinusInfoSearchObj();
		aa.setEndNumber(3);
		aa.setStartNumber(0);
		List<PlusOrMinusPageVO> bb = plusOrMinusQureyInfoMapper.queryByPage(aa);
		System.out.println( bb );
	}

}
