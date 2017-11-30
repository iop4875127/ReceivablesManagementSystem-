package cn.edu.nuc.weibo.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Period {
    private Integer id;

    private Integer periodLotNo;

    private String shouldFinishTheTask;

    private Date periodHomeworlkDate;

    private BigDecimal periodMoney;

    private String periodPayableDate;

    private Integer state;

    private String realityFinishTheTask;

    private Date periodPayRealityDate;

    private String contractNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPeriodLotNo() {
        return periodLotNo;
    }

    public void setPeriodLotNo(Integer periodLotNo) {
        this.periodLotNo = periodLotNo;
    }

    public String getShouldFinishTheTask() {
        return shouldFinishTheTask;
    }

    public void setShouldFinishTheTask(String shouldFinishTheTask) {
        this.shouldFinishTheTask = shouldFinishTheTask == null ? null : shouldFinishTheTask.trim();
    }

    public Date getPeriodHomeworlkDate() {
        return periodHomeworlkDate;
    }

    public void setPeriodHomeworlkDate(Date periodHomeworlkDate) {
        this.periodHomeworlkDate = periodHomeworlkDate;
    }

    public BigDecimal getPeriodMoney() {
        return periodMoney;
    }

    public void setPeriodMoney(BigDecimal periodMoney) {
        this.periodMoney = periodMoney;
    }

    public String getPeriodPayableDate() {
        return periodPayableDate;
    }

    public void setPeriodPayableDate(String periodPayableDate) {
        this.periodPayableDate = periodPayableDate == null ? null : periodPayableDate.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRealityFinishTheTask() {
        return realityFinishTheTask;
    }

    public void setRealityFinishTheTask(String realityFinishTheTask) {
        this.realityFinishTheTask = realityFinishTheTask == null ? null : realityFinishTheTask.trim();
    }

    public Date getPeriodPayRealityDate() {
        return periodPayRealityDate;
    }

    public void setPeriodPayRealityDate(Date periodPayRealityDate) {
        this.periodPayRealityDate = periodPayRealityDate;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

	@Override
	public String toString() {
		return "Period [id=" + id + ", periodLotNo=" + periodLotNo + ", shouldFinishTheTask=" + shouldFinishTheTask
				+ ", periodHomeworlkDate=" + periodHomeworlkDate + ", periodMoney=" + periodMoney
				+ ", periodPayableDate=" + periodPayableDate + ", state=" + state + ", realityFinishTheTask="
				+ realityFinishTheTask + ", periodPayRealityDate=" + periodPayRealityDate + ", contractNo=" + contractNo
				+ "]";
	}
    
}