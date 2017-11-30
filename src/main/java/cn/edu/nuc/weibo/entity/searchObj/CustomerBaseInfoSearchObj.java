package cn.edu.nuc.weibo.entity.searchObj;

public class CustomerBaseInfoSearchObj extends QureyByPage{
	
	private String customerName;
	 
	private Integer projectNo;
	
    /*
     * 会员优惠程度
     */
    private Integer privileges;



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public Integer getProjectNo() {
		return projectNo;
	}



	public void setProjectNo(Integer projectNo) {
		this.projectNo = projectNo;
	}



	public Integer getPrivileges() {
		return privileges;
	}



	public void setPrivileges(Integer privileges) {
		this.privileges = privileges;
	}



	@Override
	public String toString() {
		return "CustomerBaseInfoSearchObj [customerName=" + customerName + ", projectNo=" + projectNo + ", privileges="
				+ privileges + "]";
	}




	
	    
}
