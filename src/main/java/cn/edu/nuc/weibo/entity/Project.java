package cn.edu.nuc.weibo.entity;

import java.util.Date;

public class Project {
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
        this.projectNo = projectNo == null ? null : projectNo.trim();
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager == null ? null : projectManager.trim();
    }

    public String getProjectDepartment() {
        return projectDepartment;
    }

    public void setProjectDepartment(String projectDepartment) {
        this.projectDepartment = projectDepartment == null ? null : projectDepartment.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
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
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission == null ? null : commission.trim();
    }

    public String getProjectAddress() {
        return projectAddress;
    }

    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress == null ? null : projectAddress.trim();
    }

    public Integer getContractPeriod() {
        return contractPeriod;
    }

    public void setContractPeriod(Integer contractPeriod) {
        this.contractPeriod = contractPeriod;
    }

	@Override
	public String toString() {
		return "Project [id=" + id + ", projectNo=" + projectNo + ", projectManager=" + projectManager
				+ ", projectDepartment=" + projectDepartment + ", state=" + state + ", completeDate=" + completeDate
				+ ", completionDate=" + completionDate + ", contractNo=" + contractNo + ", commission=" + commission
				+ ", projectAddress=" + projectAddress + ", contractPeriod=" + contractPeriod + "]";
	}
    
}