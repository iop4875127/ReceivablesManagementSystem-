package cn.edu.nuc.weibo.entity.POJO;


public class PlusOrMinusPOJO {

	private Integer id;

    private String projectNo;

    private String contractNo;

    private Integer contractPeriod;

    private String plusOrMinusContent;

    private String plusOrMinusMoney;

    private String plusOrMinusDate;

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
		this.projectNo = projectNo;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
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
		this.plusOrMinusContent = plusOrMinusContent;
	}

	public String getPlusOrMinusMoney() {
		return plusOrMinusMoney;
	}

	public void setPlusOrMinusMoney(String plusOrMinusMoney) {
		this.plusOrMinusMoney = plusOrMinusMoney;
	}

	public String getPlusOrMinusDate() {
		return plusOrMinusDate;
	}

	public void setPlusOrMinusDate(String plusOrMinusDate) {
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
		return "PlusOrMinusPOJO [id=" + id + ", projectNo=" + projectNo + ", contractNo=" + contractNo
				+ ", contractPeriod=" + contractPeriod + ", plusOrMinusContent=" + plusOrMinusContent
				+ ", plusOrMinusMoney=" + plusOrMinusMoney + ", plusOrMinusDate=" + plusOrMinusDate + ", state=" + state
				+ "]";
	}
	
    
}
