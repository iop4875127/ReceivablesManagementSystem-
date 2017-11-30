package cn.edu.nuc.weibo.entity.VO.FinancialManagement.CheckMoney;

import java.math.BigDecimal;

public class CheckMoneyPageVO {

	/*
	 * 合同编号
	 */
	private String contractNo;
	
	/*
	 * 项目编号
	 */
	private String projectNo;
	
	/*
	 * 支出金额
	 */
	private BigDecimal cost;
	
	/*
	 * 进账金额
	 * 
	 */
	private BigDecimal receipt;
	
	/*
	 * 净利润
	 */
	private BigDecimal hasMoney;

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public BigDecimal getReceipt() {
		return receipt;
	}

	public void setReceipt(BigDecimal receipt) {
		this.receipt = receipt;
	}

	public BigDecimal getHasMoney() {
		return hasMoney;
	}

	public void setHasMoney(BigDecimal hasMoney) {
		this.hasMoney = hasMoney;
	}

	@Override
	public String toString() {
		return "CheckMoneyPageVO [contractNo=" + contractNo + ", projectNo=" + projectNo + ", cost=" + cost
				+ ", receipt=" + receipt + ", hasMoney=" + hasMoney + "]";
	}
	
	
}
