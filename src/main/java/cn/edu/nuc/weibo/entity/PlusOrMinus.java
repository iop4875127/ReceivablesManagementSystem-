package cn.edu.nuc.weibo.entity;

import java.math.BigDecimal;
import java.util.Date;

public class PlusOrMinus {
    private Integer id;

    private String projectNo;

    private String contractNo;

    private Integer contractPeriod;

    private String plusOrMinusContent;

    private BigDecimal plusOrMinusMoney;

    private Date plusOrMinusDate;

    private Integer state;

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
        this.projectNo = projectNo == null ? null : projectNo.trim();
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    public Integer getContractPeriod() {
        return contractPeriod;
    }

    public void setContractPeriod(Integer contractPeriod) {
        this.contractPeriod = contractPeriod;
    }

    public String getPlusOrMinusContent() {
        return plusOrMinusContent;
    }

    public void setPlusOrMinusContent(String plusOrMinusContent) {
        this.plusOrMinusContent = plusOrMinusContent == null ? null : plusOrMinusContent.trim();
    }

    public BigDecimal getPlusOrMinusMoney() {
        return plusOrMinusMoney;
    }

    public void setPlusOrMinusMoney(BigDecimal plusOrMinusMoney) {
        this.plusOrMinusMoney = plusOrMinusMoney;
    }

    public Date getPlusOrMinusDate() {
        return plusOrMinusDate;
    }

    public void setPlusOrMinusDate(Date plusOrMinusDate) {
        this.plusOrMinusDate = plusOrMinusDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

	@Override
	public String toString() {
		return "PlusOrMinus [id=" + id + ", projectNo=" + projectNo + ", contractNo=" + contractNo + ", contractPeriod="
				+ contractPeriod + ", plusOrMinusContent=" + plusOrMinusContent + ", plusOrMinusMoney="
				+ plusOrMinusMoney + ", plusOrMinusDate=" + plusOrMinusDate + ", state=" + state + "]";
	}
    
}