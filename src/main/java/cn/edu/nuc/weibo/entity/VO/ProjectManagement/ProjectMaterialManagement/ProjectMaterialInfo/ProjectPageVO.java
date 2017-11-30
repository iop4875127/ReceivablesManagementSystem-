package cn.edu.nuc.weibo.entity.VO.ProjectManagement.ProjectMaterialManagement.ProjectMaterialInfo;

import java.util.Date;

public class ProjectPageVO {
	
	private Integer id;

    private String projectNo;

    private String projectManager;

    private String projectDepartment;

    private String state;

    private Date completeDate;

    private Date completionDate;

    private String contractNo;

    private String commission;

    private String projectAddress;

    private Integer contractPeriod;
    
    private String customerName;

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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}

	public Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getCommission() {
		return commission;
	}

	public void setCommission(String commission) {
		this.commission = commission;
	}

	public String getProjectAddress() {
		return projectAddress;
	}

	public void setProjectAddress(String projectAddress) {
		this.projectAddress = projectAddress;
	}

	public Integer getContractPeriod() {
		return contractPeriod;
	}

	public void setContractPeriod(Integer contractPeriod) {
		this.contractPeriod = contractPeriod;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public String toString() {
		return "ProjectPageVO [id=" + id + ", projectNo=" + projectNo + ", projectManager=" + projectManager
				+ ", projectDepartment=" + projectDepartment + ", state=" + state + ", completeDate=" + completeDate
				+ ", completionDate=" + completionDate + ", contractNo=" + contractNo + ", commission=" + commission
				+ ", projectAddress=" + projectAddress + ", contractPeriod=" + contractPeriod + ", customerName="
				+ customerName + "]";
	}
}
