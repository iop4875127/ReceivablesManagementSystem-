package cn.edu.nuc.weibo.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ReceiptDetail {
    private Integer id;

    private String projectNo;

    private String payName;

    private String payContact;

    private String receiptNo;

    private String receiptName;

    private String receiptWay;

    private BigDecimal inFactMoney;

    private BigDecimal payableMoney;

    private Date receiptDate;

    private Integer numberOfPeriods;

    private String remarks;
    
    private String contractNo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getPayContact() {
		return payContact;
	}

	public void setPayContact(String payContact) {
		this.payContact = payContact;
	}

	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	public String getReceiptName() {
		return receiptName;
	}

	public void setReceiptName(String receiptName) {
		this.receiptName = receiptName;
	}

	public String getReceiptWay() {
		return receiptWay;
	}

	public void setReceiptWay(String receiptWay) {
		this.receiptWay = receiptWay;
	}

	public BigDecimal getInFactMoney() {
		return inFactMoney;
	}

	public void setInFactMoney(BigDecimal inFactMoney) {
		this.inFactMoney = inFactMoney;
	}

	public BigDecimal getPayableMoney() {
		return payableMoney;
	}

	public void setPayableMoney(BigDecimal payableMoney) {
		this.payableMoney = payableMoney;
	}

	public Date getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}

	public Integer getNumberOfPeriods() {
		return numberOfPeriods;
	}

	public void setNumberOfPeriods(Integer numberOfPeriods) {
		this.numberOfPeriods = numberOfPeriods;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	@Override
	public String toString() {
		return "ReceiptDetail [id=" + id + ", projectNo=" + projectNo + ", payName=" + payName + ", payContact="
				+ payContact + ", receiptNo=" + receiptNo + ", receiptName=" + receiptName + ", receiptWay="
				+ receiptWay + ", inFactMoney=" + inFactMoney + ", payableMoney=" + payableMoney + ", receiptDate="
				+ receiptDate + ", numberOfPeriods=" + numberOfPeriods + ", remarks=" + remarks + ", contractNo="
				+ contractNo + "]";
	}

    
    
}