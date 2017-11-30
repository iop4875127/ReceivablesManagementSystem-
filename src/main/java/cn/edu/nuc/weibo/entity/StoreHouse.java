package cn.edu.nuc.weibo.entity;

import java.math.BigDecimal;

public class StoreHouse {
    private Integer id;

    private String materialName;

    private String materialNo;

    private BigDecimal materialPrice;

    private String materialParams;

    private Integer state;

    private String materialParts;

    private Integer priority;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName == null ? null : materialName.trim();
    }

    public String getMaterialNo() {
        return materialNo;
    }

    public void setMaterialNo(String materialNo) {
        this.materialNo = materialNo == null ? null : materialNo.trim();
    }

    public BigDecimal getMaterialPrice() {
        return materialPrice;
    }

    public void setMaterialPrice(BigDecimal materialPrice) {
        this.materialPrice = materialPrice;
    }

    public String getMaterialParams() {
        return materialParams;
    }

    public void setMaterialParams(String materialParams) {
        this.materialParams = materialParams == null ? null : materialParams.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMaterialParts() {
        return materialParts;
    }

    public void setMaterialParts(String materialParts) {
        this.materialParts = materialParts == null ? null : materialParts.trim();
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

	@Override
	public String toString() {
		return "StoreHouse [id=" + id + ", materialName=" + materialName + ", materialNo=" + materialNo
				+ ", materialPrice=" + materialPrice + ", materialParams=" + materialParams + ", state=" + state
				+ ", materialParts=" + materialParts + ", priority=" + priority + "]";
	}
    
    
}