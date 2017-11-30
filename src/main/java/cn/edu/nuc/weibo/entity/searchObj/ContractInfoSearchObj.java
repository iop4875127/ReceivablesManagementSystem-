package cn.edu.nuc.weibo.entity.searchObj;

public class ContractInfoSearchObj {
	
	private int startNumber;
	 
	private int endNumber;
	/*
	 * 合同标号 contractNo customerName projectNo projectManager
	 */
    private String contractNo;
    /*
	 * 客户姓名
	 */
    private String customerName;
    /*
     * 工程编号
     */
    private String projectNo;
    /*
     * 工程负责人
     */
    private String projectManager;
    private Integer privileges;
	public int getStartNumber() {
		return startNumber;
	}
	public void setStartNumber(int startNumber) {
		this.startNumber = startNumber;
	}
	public int getEndNumber() {
		return endNumber;
	}
	public void setEndNumber(int endNumber) {
		this.endNumber = endNumber;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
	public Integer getPrivileges() {
		return privileges;
	}
	public void setPrivileges(Integer privileges) {
		this.privileges = privileges;
	}
	@Override
	public String toString() {
		return "ContractInfoSearchObj [startNumber=" + startNumber + ", endNumber=" + endNumber + ", contractNo="
				+ contractNo + ", customerName=" + customerName + ", projectNo=" + projectNo + ", projectManager="
				+ projectManager + ", privileges=" + privileges + "]";
	}
	
    
}
