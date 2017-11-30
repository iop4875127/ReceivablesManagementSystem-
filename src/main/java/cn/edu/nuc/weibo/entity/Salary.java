package cn.edu.nuc.weibo.entity;

import java.math.BigDecimal;

public class Salary {
    private Integer id;

    private String employeeNo;

    private BigDecimal basicSalary;

    private BigDecimal pushMoney;

    private BigDecimal cutMoney;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo == null ? null : employeeNo.trim();
    }

    public BigDecimal getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(BigDecimal basicSalary) {
        this.basicSalary = basicSalary;
    }

    public BigDecimal getPushMoney() {
        return pushMoney;
    }

    public void setPushMoney(BigDecimal pushMoney) {
        this.pushMoney = pushMoney;
    }

    public BigDecimal getCutMoney() {
        return cutMoney;
    }

    public void setCutMoney(BigDecimal cutMoney) {
        this.cutMoney = cutMoney;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

	@Override
	public String toString() {
		return "Salary [id=" + id + ", employeeNo=" + employeeNo + ", basicSalary=" + basicSalary + ", pushMoney="
				+ pushMoney + ", cutMoney=" + cutMoney + ", state=" + state + "]";
	}
    
    
}