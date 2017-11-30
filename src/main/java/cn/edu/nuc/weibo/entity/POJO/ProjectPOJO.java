package cn.edu.nuc.weibo.entity.POJO;

import java.util.Date;

public class ProjectPOJO {

	private Integer id;

    private String projectNo;

    private String projectManager;

    private String projectDepartment;

    private String state;

    private String completeDate;

    private String completionDate;

    private String contractNo;

    private String commission;

    private String projectAddress;

    private Integer contractPeriod;

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

	public String getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(String completeDate) {
		this.completeDate = completeDate;
	}

	public String getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(String completionDate) {
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

	@Override
	public String toString() {
		return "ProjectPOJO [id=" + id + ", projectNo=" + projectNo + ", projectManager=" + projectManager
				+ ", projectDepartment=" + projectDepartment + ", state=" + state + ", completeDate=" + completeDate
				+ ", completionDate=" + completionDate + ", contractNo=" + contractNo + ", commission=" + commission
				+ ", projectAddress=" + projectAddress + ", contractPeriod=" + contractPeriod + "]";
	}
	
    
}
