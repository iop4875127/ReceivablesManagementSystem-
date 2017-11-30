package cn.edu.nuc.weibo.entity.POJO;

import java.math.BigDecimal;

public class DepositPOJO {

	private Integer id;

    private String shouldDeposit;

    private Integer area;

    private String remarks;

    private Integer state;

    private String realityDeposit;

    private Integer privileges;

    private Integer customerNo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShouldDeposit() {
		return shouldDeposit;
	}

	public void setShouldDeposit(String shouldDeposit) {
		this.shouldDeposit = shouldDeposit;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getRealityDeposit() {
		return realityDeposit;
	}

	public void setRealityDeposit(String realityDeposit) {
		this.realityDeposit = realityDeposit;
	}

	public Integer getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Integer privileges) {
		this.privileges = privileges;
	}

	public Integer getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(Integer customerNo) {
		this.customerNo = customerNo;
	}

	@Override
	public String toString() {
		return "DepositPOJO [id=" + id + ", shouldDeposit=" + shouldDeposit + ", area=" + area + ", remarks=" + remarks
				+ ", state=" + state + ", realityDeposit=" + realityDeposit + ", privileges=" + privileges
				+ ", customerNo=" + customerNo + "]";
	}
    
    
	
}
