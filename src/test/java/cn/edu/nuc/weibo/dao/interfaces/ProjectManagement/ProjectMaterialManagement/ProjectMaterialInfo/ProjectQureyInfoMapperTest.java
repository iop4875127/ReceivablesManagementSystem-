package cn.edu.nuc.weibo.dao.interfaces.ProjectManagement.ProjectMaterialManagement.ProjectMaterialInfo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.nuc.weibo.BaseTest;
import cn.edu.nuc.weibo.entity.VO.ProjectManagement.ProjectMaterialManagement.ProjectMaterialInfo.ProjectPageVO;
import cn.edu.nuc.weibo.entity.searchObj.ProjectInfoSearchObj;

public class ProjectQureyInfoMapperTest extends BaseTest {

	@Autowired
	private	ProjectQureyInfoMapper projectQureyInfoMapper;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryByPage() {
		ProjectInfoSearchObj aa = new ProjectInfoSearchObj();
		aa.setStartNumber(0);
		aa.setEndNumber(3);
		aa.setContractNo("100001");
		aa.setCustomerName("张三丰");
		aa.setProjectAddress("武当山");
		aa.setProjectManager("上官伤");
		aa.setProjectNo("2");
		List<ProjectPageVO> aaa = projectQureyInfoMapper.queryByPage(aa);
		System.out.println(aaa);
	}
}
