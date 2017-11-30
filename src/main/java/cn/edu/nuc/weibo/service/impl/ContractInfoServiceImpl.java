package cn.edu.nuc.weibo.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nuc.weibo.dao.interfaces.ContractMapper;
import cn.edu.nuc.weibo.dao.interfaces.CustomerMapper;
import cn.edu.nuc.weibo.dao.interfaces.DepositMapper;
import cn.edu.nuc.weibo.dao.interfaces.PeriodMapper;
import cn.edu.nuc.weibo.dao.interfaces.ProjectMapper;
import cn.edu.nuc.weibo.dao.interfaces.BusinessManagement.ContractManagement.ContractInfo.ContractQureyInfoMapper;
import cn.edu.nuc.weibo.dao.interfaces.ProjectManagement.ProjectMaterialManagement.ProjectMaterialInfo.ProjectQureyInfoMapper;
import cn.edu.nuc.weibo.entity.Contract;
import cn.edu.nuc.weibo.entity.Customer;
import cn.edu.nuc.weibo.entity.Deposit;
import cn.edu.nuc.weibo.entity.Period;
import cn.edu.nuc.weibo.entity.Project;
import cn.edu.nuc.weibo.entity.POJO.ContractPOJO;
import cn.edu.nuc.weibo.entity.POJO.ContractPOJOList;
import cn.edu.nuc.weibo.entity.POJO.DepositPOJO;
import cn.edu.nuc.weibo.entity.POJO.PeriodPOJO;
import cn.edu.nuc.weibo.entity.POJO.ProjectPOJO;
import cn.edu.nuc.weibo.entity.VO.BusinessManagement.ContractManagement.ContractInfo.ContractPageVO;
import cn.edu.nuc.weibo.entity.searchObj.ContractInfoSearchObj;
import cn.edu.nuc.weibo.entity.searchObj.CustomerBaseInfoSearchObj;
import cn.edu.nuc.weibo.entity.searchObj.ProjectInfoSearchObj;
import cn.edu.nuc.weibo.service.interfaces.ContractInfoService;
@Service
public class ContractInfoServiceImpl implements ContractInfoService{

	@Autowired
	private ContractQureyInfoMapper contractQureyInfoMapper;
	@Autowired
	private ContractMapper contractMapper;
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private ProjectQureyInfoMapper projectQureyInfoMapper;
	@Autowired
	private ProjectMapper projectMapper;
	@Autowired
	private PeriodMapper periodMapper;
	@Autowired
	private DepositMapper depositMapper;

	public List<ContractPageVO> queryByPage(ContractInfoSearchObj contractInfoSearchObj) {

		List<ContractPageVO> contractInfos = contractQureyInfoMapper.queryByPage(contractInfoSearchObj);

		return contractInfos;
	}

	public List<Contract> query(ContractInfoSearchObj contractInfoSearchObj) {

		List<Contract> contractInfos = contractMapper.queryByPage(contractInfoSearchObj);

		return contractInfos;
	}

	public int AddContract(ContractPOJOList contractPOJOList) {

		int aa = 0;
		try {
			Customer customer = contractPOJOList.getCustomer();
			CustomerBaseInfoSearchObj customerBaseInfoSearchObj = new CustomerBaseInfoSearchObj();
			int count2 = customerMapper.queryCount(customerBaseInfoSearchObj);
			Integer customerNo = count2 + 1;
			customer.setCustomerNo(customerNo);
			int count = customerMapper.insertSelective(customer);
			customer.setProjectNo(customer.getProjectNo());
			customer.setState(1);
			
			ContractPOJO contractPOJO = contractPOJOList.getContractPOJO();
			Date date=null;
			String  dates = contractPOJO.getSigningDate();
			SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
			try {
				date = formatter.parse(dates);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			String str1=  contractPOJO.getContractCost();
			BigDecimal bd=new BigDecimal(str1);
			Contract contract = new Contract();
			contract.setContractCost(bd);
			contract.setContractNo(contractPOJO.getContractNo());
			contract.setContractViolate(contractPOJO.getContractViolate());
			contract.setCustomerName(contractPOJO.getCustomerName());
			contract.setCustomsNo(customerNo);
			contract.setPrivilege(contractPOJO.getPrivilege());
			contract.setRemarks(contractPOJO.getRemarks());
			contract.setSigningDate(date);
			contract.setState(1);
			int count5 = contractMapper.insertSelective(contract);
			
			DepositPOJO depositPOJO = contractPOJOList.getDepositPOJO();
			Deposit deposit = new Deposit();
			deposit.setArea(depositPOJO.getArea());
			deposit.setCustomerNo(customer.getCustomerNo());
			deposit.setPrivileges(depositPOJO.getPrivileges());
//			deposit.setRealityDeposit(contract.getContractCost() * 0.1);
			deposit.setRemarks(depositPOJO.getRemarks());
			deposit.setShouldDeposit(new BigDecimal(depositPOJO.getShouldDeposit()));
			deposit.setState(1);
			int count6 = depositMapper.insertSelective(deposit);
			
			
			List<PeriodPOJO> list2 = contractPOJOList.getList();
			int count3 = 0;
			for (int i = 0; i < list2.size(); i++) {
				PeriodPOJO periodPOJO = list2.get(i);
				Period period = new Period();
				period.setPeriodLotNo(periodPOJO.getPeriodLotNo());
				period.setShouldFinishTheTask(period.getShouldFinishTheTask());
				String dates4 = periodPOJO.getPeriodHomeworlkDate();
				period.setPeriodHomeworlkDate(formatter.parse(dates4));
				period.setPeriodMoney(new BigDecimal(periodPOJO.getPeriodMoney()));
				period.setPeriodPayableDate(periodPOJO.getPeriodPayableDate());
				period.setState(1);
				period.setContractNo(contractPOJO.getContractNo());
				
				count3 = periodMapper.insertSelective(period);
						
			}
			
			List<ProjectPOJO> list3 = contractPOJOList.getList2();
			int count4 = 0;
			for (int i = 0; i < list3.size(); i++) {
				ProjectPOJO projectPOJO = list3.get(i);
				String  dates2 = projectPOJO.getCompleteDate();
				String dates3 = projectPOJO.getCompletionDate();
				try {
					date = formatter.parse(dates2);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				Project project = new Project();
				project.setCompleteDate(date);
				try {
					date = formatter.parse(dates3);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				project.setCompletionDate(date);
				ProjectInfoSearchObj projectInfoSearchObj = new ProjectInfoSearchObj();
				int projectNo = projectQureyInfoMapper.qureyCount(projectInfoSearchObj);
				String str3 = String.valueOf(projectNo);  
				project.setProjectNo(str3);
				project.setProjectManager(projectPOJO.getProjectManager());
				project.setProjectDepartment(projectPOJO.getProjectDepartment());
				project.setState("1");
				project.setContractNo(contractPOJO.getContractNo());
				project.setCommission(projectPOJO.getCommission());
				project.setProjectAddress(projectPOJO.getProjectAddress());
				project.setContractPeriod(i);
				
				count4 = projectMapper.insertSelective(project);
			}
			
			
			if (count > 0 && count2 > 0 && count3 > 0 && count4 > 0 && count5 > 0 && count6 > 0) {
				aa = 1;
			}
			System.out.println(count + count2 + count3 + count4 + count5 + count6);
			return aa;
		} catch (Exception e) {
			return aa;
		}
		
	}

}
