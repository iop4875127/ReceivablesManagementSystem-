package cn.edu.nuc.weibo.entity;

import java.math.BigDecimal;

public class Deposit {
    @Override
	public String toString() {
		return "Deposit [id=" + id + ", shouldDeposit=" + shouldDeposit + ", area=" + area + ", remarks=" + remarks
				+ ", state=" + state + ", realityDeposit=" + realityDeposit + ", privileges=" + privileges
				+ ", customerNo=" + customerNo + "]";
	}

	private Integer id;

    private BigDecimal shouldDeposit;

    private Integer area;

    private String remarks;

    private Integer state;

    private BigDecimal realityDeposit;

    private Integer privileges;

    private Integer customerNo;

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
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
}