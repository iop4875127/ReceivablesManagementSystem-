package cn.edu.nuc.weibo.entity.searchObj;

public class ReceiptDetailInfoSearchObj extends QureyByPage {

	private String projectNo;
	
	private String payName;
	
	private String contractNo;

	public String getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	public String getPayName() {
		return payName;
	}

	public void setPayName(String payName) {
		this.payName = payName;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	@Override
	public String toString() {
		return "ReceiptDetailInfoSearchObj [projectNo=" + projectNo + ", payName=" + payName + ", contractNo="
				+ contractNo + "]";
	}

	
	
	
}
