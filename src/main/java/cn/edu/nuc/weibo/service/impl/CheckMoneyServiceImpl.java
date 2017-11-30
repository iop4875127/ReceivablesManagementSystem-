package cn.edu.nuc.weibo.service.impl;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.edu.nuc.weibo.dao.interfaces.ContractMapper;
import cn.edu.nuc.weibo.dao.interfaces.DepositMapper;
import cn.edu.nuc.weibo.dao.interfaces.PlusOrMinusMapper;
import cn.edu.nuc.weibo.dao.interfaces.ProjectMapper;
import cn.edu.nuc.weibo.dao.interfaces.ReceiptDetailMapper;
import cn.edu.nuc.weibo.entity.Contract;
import cn.edu.nuc.weibo.entity.Deposit;
import cn.edu.nuc.weibo.entity.PlusOrMinus;
import cn.edu.nuc.weibo.entity.ReceiptDetail;
import cn.edu.nuc.weibo.entity.VO.FinancialManagement.CheckMoney.CheckMoneyPageVO;
import cn.edu.nuc.weibo.entity.searchObj.CheckMoneylInfoSearchObj;
import cn.edu.nuc.weibo.entity.searchObj.ContractInfoSearchObj;
import cn.edu.nuc.weibo.entity.searchObj.ReceiptDetailInfoSearchObj;
import cn.edu.nuc.weibo.service.interfaces.CheckMoneyInfoService;
@Service
public class CheckMoneyServiceImpl implements CheckMoneyInfoService{

	@Autowired
	private ContractMapper contractMapper;
	@Autowired
	private ReceiptDetailMapper receiptDetailMapper;
	@Autowired
	private PlusOrMinusMapper plusOrMinusMapper;
	@Autowired
	private ProjectMapper projectMapper;
	@Autowired
	private DepositMapper depositMapper;

	public List<CheckMoneyPageVO> queryByPage(CheckMoneylInfoSearchObj checkMoneylInfoSearchObj) {
		ArrayList<CheckMoneyPageVO> aa = new ArrayList<CheckMoneyPageVO>();
		//拿着工程编号去找工程款
		if(checkMoneylInfoSearchObj.getProjectNo() != null){
			//拿着工程号找到收款项
			ReceiptDetailInfoSearchObj receiptDetailInfoSearchObj = new ReceiptDetailInfoSearchObj();
			receiptDetailInfoSearchObj.setStartNumber(checkMoneylInfoSearchObj.getStartNumber());
			receiptDetailInfoSearchObj.setEndNumber(checkMoneylInfoSearchObj.getEndNumber());
			receiptDetailInfoSearchObj.setContractNo(checkMoneylInfoSearchObj.getContractNo());
			receiptDetailInfoSearchObj.setProjectNo(checkMoneylInfoSearchObj.getProjectNo());
			List<ReceiptDetail> receiptDetailList = receiptDetailMapper.queryByPage1(receiptDetailInfoSearchObj);
			//将收款项的金额都加起来
			BigDecimal sum = new BigDecimal("0");
			for( int i = 0; i < receiptDetailList.size(); i++){

				BigDecimal rdli = receiptDetailList.get(i).getInFactMoney();
				sum = sum.add(rdli);
				
			}
			/*//显示到前台只需要五条信息就行，这里用合同的信息为主
			ContractInfoSearchObj contractInfoSearchObj = new ContractInfoSearchObj();
			List<Contract> contractList = contractMapper.queryByPage(contractInfoSearchObj);
			for( int j = 0; j < contractList.size(); j++){
				String contractNo = contractList.get(j).getContractNo();

				ReceiptDetailInfoSearchObj receiptDetailInfoSearchObj = new ReceiptDetailInfoSearchObj();
				receiptDetailInfoSearchObj.setStartNumber(checkMoneylInfoSearchObj.getStartNumber());
				receiptDetailInfoSearchObj.setEndNumber(checkMoneylInfoSearchObj.getEndNumber());
				receiptDetailInfoSearchObj.setContractNo(checkMoneylInfoSearchObj.getContractNo());
				receiptDetailInfoSearchObj.setProjectNo(checkMoneylInfoSearchObj.getProjectNo());
				List<ReceiptDetail> receiptDetailList = receiptDetailMapper.queryByPage1(receiptDetailInfoSearchObj);

				BigDecimal sum = new BigDecimal("0");
				for( int i = 0; i < receiptDetailList.size(); i++){

					BigDecimal rdli = receiptDetailList.get(i).getInFactMoney();
					sum = sum.add(rdli);
				}
			}*/
			//去增减项中找数据
			List<PlusOrMinus> plusOrMinusList  = plusOrMinusMapper.findByProjectNo(checkMoneylInfoSearchObj.getProjectNo());
			for( int k = 0; k < receiptDetailList.size(); k++){

				BigDecimal pomlk = plusOrMinusList.get(k).getPlusOrMinusMoney();
				sum = sum.add(pomlk);
			}
			//去量房定金找数据
			String contractNo = projectMapper.findByProjectNo(checkMoneylInfoSearchObj.getProjectNo());
			int customerNo = contractMapper.findByContractNo(contractNo);
			Deposit deposit = depositMapper.findByCustomerNo(customerNo);
			sum = sum.add(deposit.getRealityDeposit());
			
			//返回前台视图
			CheckMoneyPageVO checkMoneyPageVO = new CheckMoneyPageVO();
			checkMoneyPageVO.setReceipt(sum);
			checkMoneyPageVO.setCost(deposit.getRealityDeposit());
			checkMoneyPageVO.setContractNo(contractNo);
			checkMoneyPageVO.setHasMoney(sum.subtract(deposit.getRealityDeposit()));
			
			
			
			aa.add(checkMoneyPageVO);
			
		}else if(checkMoneylInfoSearchObj.getContractNo() != null && (checkMoneylInfoSearchObj.getProjectNo()==null||checkMoneylInfoSearchObj.getProjectNo()=="")){
			CheckMoneyPageVO checkMoneyPageVO = new CheckMoneyPageVO();
			//显示进账拿着合同编号去进账表中去找记录先找到合同用了几个项目
				List<String> projectNoList = projectMapper.findByContractNo(checkMoneylInfoSearchObj.getContractNo());
				//用项目编号找到进账记录，然后把金额加起来
				BigDecimal sum = new BigDecimal("0");
				for(int i = 0; i < projectNoList.size(); i++){
					String projectNo = projectNoList.get(i);
					ReceiptDetailInfoSearchObj receiptDetailInfoSearchObj = new ReceiptDetailInfoSearchObj();
					receiptDetailInfoSearchObj.setStartNumber(checkMoneylInfoSearchObj.getStartNumber());
					receiptDetailInfoSearchObj.setEndNumber(checkMoneylInfoSearchObj.getEndNumber());
					receiptDetailInfoSearchObj.setContractNo(checkMoneylInfoSearchObj.getContractNo());
					receiptDetailInfoSearchObj.setProjectNo(checkMoneylInfoSearchObj.getProjectNo());
					List<ReceiptDetail> receiptDetailList = receiptDetailMapper.queryByPage1(receiptDetailInfoSearchObj);
					//将收款项的金额都加起来
					for( int k = 0; k < receiptDetailList.size(); k++){
						BigDecimal rdli = receiptDetailList.get(k).getInFactMoney();
						sum = sum.add(rdli);
					}
					//用项目编号找到增减项记录加起来
					List<PlusOrMinus> plusOrMinusList  = plusOrMinusMapper.findByProjectNo(checkMoneylInfoSearchObj.getProjectNo());
					for( int k = 0; k < receiptDetailList.size(); k++){

						BigDecimal pomlk = plusOrMinusList.get(k).getPlusOrMinusMoney();
						sum = sum.add(pomlk);
					}
					//用合同编号将良方加精来
					String contractNo = projectMapper.findByProjectNo(checkMoneylInfoSearchObj.getProjectNo());
					int customerNo = contractMapper.findByContractNo(contractNo);
					Deposit deposit = depositMapper.findByCustomerNo(customerNo);
					sum = sum.add(deposit.getRealityDeposit());
					

					checkMoneyPageVO.setReceipt(sum);
					checkMoneyPageVO.setCost(deposit.getRealityDeposit());
					checkMoneyPageVO.setContractNo(contractNo);
					checkMoneyPageVO.setHasMoney(sum.subtract(deposit.getRealityDeposit()));
				}
				
			
			//显示出账拿着合同编号去找两房，由于剋直接赋值就不计算了
			//计算核算结果

				
				
				
				aa.add(checkMoneyPageVO);
				
		}else {
			CheckMoneyPageVO checkMoneyPageVO = new CheckMoneyPageVO();
			//查询合同表遍历将每一个合同编号取出来执行上边第二个
			ContractInfoSearchObj contractInfoSearchObj = new ContractInfoSearchObj();
			contractInfoSearchObj.setEndNumber(10);
			List<Contract> contractList = contractMapper.queryByPage(contractInfoSearchObj);
			for( int j = 0; j < contractList.size(); j++){
				String contractNo =  contractList.get(j).getContractNo();
				//显示进账拿着合同编号去进账表中去找记录先找到合同用了几个项目
				List<String> projectNoList = projectMapper.findByContractNo(checkMoneylInfoSearchObj.getContractNo());
				//用项目编号找到进账记录，然后把金额加起来
				BigDecimal sum = new BigDecimal("0");
				for(int i = 0; i < projectNoList.size(); i++){
					String projectNo = projectNoList.get(i);
					ReceiptDetailInfoSearchObj receiptDetailInfoSearchObj = new ReceiptDetailInfoSearchObj();
					receiptDetailInfoSearchObj.setStartNumber(checkMoneylInfoSearchObj.getStartNumber());
					receiptDetailInfoSearchObj.setEndNumber(checkMoneylInfoSearchObj.getEndNumber());
					receiptDetailInfoSearchObj.setContractNo(contractNo);
					receiptDetailInfoSearchObj.setProjectNo(checkMoneylInfoSearchObj.getProjectNo());
					List<ReceiptDetail> receiptDetailList = receiptDetailMapper.queryByPage1(receiptDetailInfoSearchObj);
					//将收款项的金额都加起来
					for( int k = 0; k < receiptDetailList.size(); k++){
						BigDecimal rdli = receiptDetailList.get(k).getInFactMoney();
						sum = sum.add(rdli);
					}
					//用项目编号找到增减项记录加起来
					List<PlusOrMinus> plusOrMinusList  = plusOrMinusMapper.findByProjectNo(checkMoneylInfoSearchObj.getProjectNo());
					for( int k = 0; k < receiptDetailList.size(); k++){

						BigDecimal pomlk = plusOrMinusList.get(k).getPlusOrMinusMoney();
						sum = sum.add(pomlk);
					}
					//用合同编号将良方加精来
					String contractNo1 = projectMapper.findByProjectNo(checkMoneylInfoSearchObj.getProjectNo());
					int customerNo = contractMapper.findByContractNo(contractNo1);
					Deposit deposit = depositMapper.findByCustomerNo(customerNo);
					sum = sum.add(deposit.getRealityDeposit());
					
					

					checkMoneyPageVO.setReceipt(sum);
					checkMoneyPageVO.setCost(deposit.getRealityDeposit());
					checkMoneyPageVO.setContractNo(contractNo);
					checkMoneyPageVO.setHasMoney(sum.subtract(deposit.getRealityDeposit()));
					
					
				}
				
			
			//显示出账拿着合同编号去找两房，由于剋直接赋值就不计算了
			//计算核算结果

				
				aa.add(checkMoneyPageVO);
				
			}
		}
		return aa;
		











	}

	public int queryCount(CheckMoneylInfoSearchObj CheckMoneylInfoSearchObj) {
		// TODO Auto-generated method stub
		return 0;
	}


}
