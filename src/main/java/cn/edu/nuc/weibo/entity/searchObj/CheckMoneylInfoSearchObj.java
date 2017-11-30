package cn.edu.nuc.weibo.entity.searchObj;

public class CheckMoneylInfoSearchObj extends QureyByPage {

	private String contractNo;
	
	private String projectNo;

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

	@Override
	public String toString() {
		return "CheckMoneylInfoSearchObj [contractNo=" + contractNo + ", projectNo=" + projectNo + "]";
	}
	
	
	
}
