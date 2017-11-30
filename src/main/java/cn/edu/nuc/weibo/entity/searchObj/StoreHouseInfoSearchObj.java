package cn.edu.nuc.weibo.entity.searchObj;

public class StoreHouseInfoSearchObj extends QureyByPage {
	
	private String materialName;

    private String materialNo;
    
    public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	@Override
	public String toString() {
		return "StoreHouseInfoSearchObj [materialName=" + materialName + ", materialNo=" + materialNo + "]";
	}

	public String getMaterialNo() {
		return materialNo;
	}

	public void setMaterialNo(String materialNo) {
		this.materialNo = materialNo;
	}


}
