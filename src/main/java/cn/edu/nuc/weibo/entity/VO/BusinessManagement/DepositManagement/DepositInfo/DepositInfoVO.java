package cn.edu.nuc.weibo.entity.VO.BusinessManagement.DepositManagement.DepositInfo;

import java.math.BigDecimal;

public class DepositInfoVO {
	
	private Integer id;

    private BigDecimal shouldDeposit;

    private Integer area;

    private String remarks;

    private Integer state;

    private BigDecimal realityDeposit;

    private Integer privileges;

    private Integer customerNo;
    
    private String customerName;

    private Integer homeType;

	public void setState(int state) {
		this.state = state;
	}

	public int getHomeType() {
		return homeType;
	}

	public void setHomeType(int homeType) {
		this.homeType = homeType;
	}




	public int getState() {
		return state;
	}





	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getShouldDeposit() {
		return shouldDeposit;
	}

	public void setShouldDeposit(BigDecimal shouldDeposit) {
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

	public BigDecimal getRealityDeposit() {
		return realityDeposit;
	}

	public void setRealityDeposit(BigDecimal realityDeposit) {
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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public String toString() {
		return "DepositInfoVO [id=" + id + ", shouldDeposit=" + shouldDeposit + ", area=" + area + ", remarks="
				+ remarks + ", realityDeposit=" + realityDeposit + ", privileges=" + privileges + ", customerNo="
				+ customerNo + ", customerName=" + customerName + ", state=" + state + ", homeType=" + homeType + "]";
	}


}
