package cn.edu.nuc.weibo.entity.VO.BusinessManagement.ContractManagement.ContractInfo;

import java.math.BigDecimal;
import java.util.Date;

public class ContractPageVO {
	


	/*
	 * 合同标号
	 */
    private String contractNo;

    /*
	 * 签订日期
	 */
    private Date signingDate;
    /*
	 * 合同造价
	 */
    private BigDecimal contractCost;

    /*
	 * 违约说明
	 */
    private String contractViolate;
    /*
	 * 备注
	 */
    private String remarks;
//=============================================================
    
    /*
	 * 客户编号
	 */
    private Integer customerNo;
    
    /*
	 * 客户姓名
	 */
    private String customerName;

    /*
     * 联系方式
     */
    private Integer contact;
    /*
     * 工程地址
     */
    private String address;
    /*
     * 工程面积
     */
    private String area;
    /*
     * 住户类型
     */
    private Integer homeType;
//===========================================================================
    
    /*
     * 工程编号
     */
    private String projectNo;
    /*
     * 工程负责人
     */
    private String projectManager;
    /*
     * 所属部门
     */
    private String projectDepartment;
//============================================================================
    /*
     * 量房定金
     */
    private BigDecimal shouldDeposit;
//=============================================================================
    /*
     * 工程第几期
     */
    private Integer periodLotNo;
    
    /*
     * 工程任务
     */
    private String shouldFinishTheTask;
    /*
     * 交付时间
     */
    private Date periodHomeworlkDate;
    /*
     * 交付金额
     */
    private BigDecimal periodMoney;
    
    
	
	public String getContractNo() {
		return contractNo;
	}



	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}



	public Date getSigningDate() {
		return signingDate;
	}



	public void setSigningDate(Date signingDate) {
		this.signingDate = signingDate;
	}



	public BigDecimal getContractCost() {
		return contractCost;
	}



	public void setContractCost(BigDecimal contractCost) {
		this.contractCost = contractCost;
	}



	public String getContractViolate() {
		return contractViolate;
	}



	public void setContractViolate(String contractViolate) {
		this.contractViolate = contractViolate;
	}



	public String getRemarks() {
		return remarks;
	}



	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}



	



	public Integer getCustomerNo() {
		return customerNo;
	}



	public void setCustomerNo(Integer customerNo) {
		this.customerNo = customerNo;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public Integer getContact() {
		return contact;
	}



	public void setContact(Integer contact) {
		this.contact = contact;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getArea() {
		return area;
	}



	public void setArea(String area) {
		this.area = area;
	}



	public Integer getHomeType() {
		return homeType;
	}



	public void setHomeType(Integer homeType) {
		this.homeType = homeType;
	}



	public String getProjectNo() {
		return projectNo;
	}



	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}



	public String getProjectManager() {
		return projectManager;
	}



	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}



	public String getProjectDepartment() {
		return projectDepartment;
	}



	public void setProjectDepartment(String projectDepartment) {
		this.projectDepartment = projectDepartment;
	}



	public BigDecimal getShouldDeposit() {
		return shouldDeposit;
	}



	public void setShouldDeposit(BigDecimal shouldDeposit) {
		this.shouldDeposit = shouldDeposit;
	}



	public Integer getPeriodLotNo() {
		return periodLotNo;
	}



	public void setPeriodLotNo(Integer periodLotNo) {
		this.periodLotNo = periodLotNo;
	}



	public String getShouldFinishTheTask() {
		return shouldFinishTheTask;
	}



	public void setShouldFinishTheTask(String shouldFinishTheTask) {
		this.shouldFinishTheTask = shouldFinishTheTask;
	}



	public Date getPeriodHomeworlkDate() {
		return periodHomeworlkDate;
	}



	public void setPeriodHomeworlkDate(Date periodHomeworlkDate) {
		this.periodHomeworlkDate = periodHomeworlkDate;
	}



	public BigDecimal getPeriodMoney() {
		return periodMoney;
	}



	public void setPeriodMoney(BigDecimal periodMoney) {
		this.periodMoney = periodMoney;
	}



	@Override
	public String toString() {
		return "ContractPageVO [contractNo=" + contractNo + ", signingDate=" + signingDate + ", contractCost="
				+ contractCost + ", contractViolate=" + contractViolate + ", remarks=" + remarks + ", customerNo="
				+ customerNo + ", customerName=" + customerName + ", contact=" + contact + ", address=" + address
				+ ", area=" + area + ", homeType=" + homeType + ", projectNo=" + projectNo + ", projectManager="
				+ projectManager + ", projectDepartment=" + projectDepartment + ", shouldDeposit=" + shouldDeposit
				+ ", periodLotNo=" + periodLotNo + ", shouldFinishTheTask=" + shouldFinishTheTask
				+ ", periodHomeworlkDate=" + periodHomeworlkDate + ", periodMoney=" + periodMoney + "]";
	}





    
    
}
