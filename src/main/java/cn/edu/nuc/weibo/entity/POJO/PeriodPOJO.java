package cn.edu.nuc.weibo.entity.POJO;

import java.math.BigDecimal;
import java.util.Date;

public class PeriodPOJO {

	private Integer id;



	private Integer periodLotNo;

	private String shouldFinishTheTask;

	private String periodHomeworlkDate;

	private String periodMoney;

	private String periodPayableDate;

	private Integer state;

	private String realityFinishTheTask;

	private String periodPayRealityDate;

	private String contractNo;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "PeriodPOJO [id=" + id + ", periodLotNo=" + periodLotNo + ", shouldFinishTheTask=" + shouldFinishTheTask
				+ ", periodHomeworlkDate=" + periodHomeworlkDate + ", periodMoney=" + periodMoney
				+ ", periodPayableDate=" + periodPayableDate + ", state=" + state + ", realityFinishTheTask="
				+ realityFinishTheTask + ", periodPayRealityDate=" + periodPayRealityDate + ", contractNo=" + contractNo
				+ "]";
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
		this.shouldFinishTheTask = shouldFinishTheTask;
	}

	public String getPeriodHomeworlkDate() {
		return periodHomeworlkDate;
	}

	public void setPeriodHomeworlkDate(String periodHomeworlkDate) {
		this.periodHomeworlkDate = periodHomeworlkDate;
	}

	public String getPeriodMoney() {
		return periodMoney;
	}

	public void setPeriodMoney(String periodMoney) {
		this.periodMoney = periodMoney;
	}

	public String getPeriodPayableDate() {
		return periodPayableDate;
	}

	public void setPeriodPayableDate(String periodPayableDate) {
		this.periodPayableDate = periodPayableDate;
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
		this.realityFinishTheTask = realityFinishTheTask;
	}

	public String getPeriodPayRealityDate() {
		return periodPayRealityDate;
	}

	public void setPeriodPayRealityDate(String periodPayRealityDate) {
		this.periodPayRealityDate = periodPayRealityDate;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
}
