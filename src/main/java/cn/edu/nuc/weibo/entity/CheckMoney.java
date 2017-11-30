package cn.edu.nuc.weibo.entity;

import java.math.BigDecimal;
import java.util.Date;

public class CheckMoney {
    private Integer id;

    private String contractNo;

    private Integer checkState;

    private Date checkDate;

    private String checkName;

    private String checkEmpNo;

    private Integer state;

    private BigDecimal pay;

    private BigDecimal receipt;

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
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    public Integer getCheckState() {
        return checkState;
    }

    public void setCheckState(Integer checkState) {
        this.checkState = checkState;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName == null ? null : checkName.trim();
    }

    public String getCheckEmpNo() {
        return checkEmpNo;
    }

    public void setCheckEmpNo(String checkEmpNo) {
        this.checkEmpNo = checkEmpNo == null ? null : checkEmpNo.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public BigDecimal getPay() {
        return pay;
    }

    public void setPay(BigDecimal pay) {
        this.pay = pay;
    }

    public BigDecimal getReceipt() {
        return receipt;
    }

    public void setReceipt(BigDecimal receipt) {
        this.receipt = receipt;
    }
}