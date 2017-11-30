package cn.edu.nuc.weibo.entity.searchObj;

import java.math.BigDecimal;

public class DepositInfoSearchObj extends QureyByPage{
//	area homeType realityDeposit privileges
    /*
     * 房屋面积 房屋类型 实际两房定金 会员优惠程度
     */
    private Integer area;
    /*
     * 房屋类型
     */
    private Integer homeType;
	/*
     * 实际两房定金
     */
    private BigDecimal realityDeposit;
    /*
     * 会员优惠程度
     */
    private Integer privileges;
	public Integer getArea() {
		return area;
	}
	public void setArea(Integer area) {
		this.area = area;
	}
	public Integer getHomeType() {
		return homeType;
	}
	public void setHomeType(Integer homeType) {
		this.homeType = homeType;
	}
	public BigDecimal getRealityDeposit() {
		return realityDeposit;
	}
	public void setRealityDeposit(BigDecimal realityDeposit) {
		this.realityDeposit = realityDeposit;
	}
	public Integer getPrivileges() {
		return privileges;
	}
	public void setPrivileges(Integer privileges) {
		this.privileges = privileges;
	}
	@Override
	public String toString() {
		return "DepositInfoSearchObj [area=" + area + ", homeType=" + homeType + ", realityDeposit=" + realityDeposit
				+ ", privileges=" + privileges + "]";
	}
    
    
}
