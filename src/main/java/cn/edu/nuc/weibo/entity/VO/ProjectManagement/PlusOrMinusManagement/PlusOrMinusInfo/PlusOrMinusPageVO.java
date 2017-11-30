package cn.edu.nuc.weibo.entity.VO.ProjectManagement.PlusOrMinusManagement.PlusOrMinusInfo;

import java.math.BigDecimal;
import java.util.Date;

public class PlusOrMinusPageVO {
	
//	id, projectNo, contractNo, contractPeriod, plusOrMinusContent, plusOrMinusMoney, plusOrMinusDate, state, customerName,  projectManager 
	
	private Integer id;

	private String projectNo;

	private String contractNo;

	private Integer contractPeriod;

	private String plusOrMinusContent;

	private BigDecimal plusOrMinusMoney;

	private Date plusOrMinusDate;

	private Integer state;

	private String customerName;

	private String projectManager;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public Integer getContractPeriod() {
		return contractPeriod;
	}

	public void setContractPeriod(Integer contractPeriod) {
		this.contractPeriod = contractPeriod;
	}

	public String getPlusOrMinusContent() {
		return plusOrMinusContent;
	}

	public void setPlusOrMinusContent(String plusOrMinusContent) {
		this.plusOrMinusContent = plusOrMinusContent;
	}

	public BigDecimal getPlusOrMinusMoney() {
		return plusOrMinusMoney;
	}

	public void setPlusOrMinusMoney(BigDecimal plusOrMinusMoney) {
		this.plusOrMinusMoney = plusOrMinusMoney;
	}

	public Date getPlusOrMinusDate() {
		return plusOrMinusDate;
	}

	public void setPlusOrMinusDate(Date plusOrMinusDate) {
		this.plusOrMinusDate = plusOrMinusDate;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}

	@Override
	public String toString() {
		return "PlusOrMinusQureyInfoMapper [id=" + id + ", projectNo=" + projectNo + ", contractNo=" + contractNo
				+ ", contractPeriod=" + contractPeriod + ", plusOrMinusContent=" + plusOrMinusContent
				+ ", plusOrMinusMoney=" + plusOrMinusMoney + ", plusOrMinusDate=" + plusOrMinusDate + ", state=" + state
				+ ", customerName=" + customerName + ", projectManager=" + projectManager + "]";
	}

}
