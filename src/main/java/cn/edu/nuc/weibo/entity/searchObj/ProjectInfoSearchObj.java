package cn.edu.nuc.weibo.entity.searchObj;

public class ProjectInfoSearchObj extends QureyByPage {

	/*
	 * 合同编号 contractNo, projectNo, projectManager, customerName, projectAddress
	 */
	private String contractNo;
    /*
     * 工程编号
     */
    private String projectNo;
    
    /*
     * 工程经理
     */
    private String projectManager;

    /*
     * 客户姓名
     */
    private String customerName;
    
    /*
     * 工程地址
     */
    private String projectAddress;
    

	
    public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getProjectNo() {
		return projectNo;
	}

	@Override
	public String toString() {
		return "ProjectInfoSearchObj [contractNo=" + contractNo + ", projectNo=" + projectNo + ", projectManager="
				+ projectManager + ", customerName=" + customerName + ", projectAddress=" + projectAddress + "]";
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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProjectAddress() {
		return projectAddress;
	}

	public void setProjectAddress(String projectAddress) {
		this.projectAddress = projectAddress;
	}

	
}	
