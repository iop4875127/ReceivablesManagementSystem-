package cn.edu.nuc.weibo.entity.searchObj;

public class PeriodInfoSearchObj extends QureyByPage {
		
//	periodLotNo contractNo
	private Integer periodLotNo;
    
    private String contractNo;
    
    @Override
	public String toString() {
		return "PeriodInfoSearchObj [periodLotNo=" + periodLotNo + ", contractNo=" + contractNo + "]";
	}

	public Integer getPeriodLotNo() {
		return periodLotNo;
	}

	public void setPeriodLotNo(Integer periodLotNo) {
		this.periodLotNo = periodLotNo;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	
}
