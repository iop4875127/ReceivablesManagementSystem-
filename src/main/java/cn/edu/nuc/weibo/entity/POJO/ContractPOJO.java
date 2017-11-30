package cn.edu.nuc.weibo.entity.POJO;

import java.math.BigDecimal;
import java.util.Date;

public class ContractPOJO {

	private Integer id;

    private String contractNo;

    private String signingDate;

    private String contractCost;

    private Integer privilege;

    private String contractViolate;

    private String remarks;

    private Integer state;

    private Integer customsNo;
    
    private String customerName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getSigningDate() {
		return signingDate;
	}

	public void setSigningDate(String signingDate) {
		this.signingDate = signingDate;
	}

	public String getContractCost() {
		return contractCost;
	}

	public void setContractCost(String contractCost) {
		this.contractCost = contractCost;
	}

	public Integer getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Integer privilege) {
		this.privilege = privilege;
	}

	public String getContractViolate() {
		return contractViolate;
	}

	public void setContractViolate(String contractViolate) {
		this.contractViolate = contractViolate;
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

	public Integer getCustomsNo() {
		return customsNo;
	}

	public void setCustomsNo(Integer customsNo) {
		this.customsNo = customsNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public String toString() {
		return "ContractPOJO [id=" + id + ", contractNo=" + contractNo + ", signingDate=" + signingDate
				+ ", contractCost=" + contractCost + ", privilege=" + privilege + ", contractViolate=" + contractViolate
				+ ", remarks=" + remarks + ", state=" + state + ", customsNo=" + customsNo + ", customerName="
				+ customerName + "]";
	}
	
    
}
