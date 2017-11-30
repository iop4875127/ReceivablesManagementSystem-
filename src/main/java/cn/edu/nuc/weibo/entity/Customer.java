package cn.edu.nuc.weibo.entity;

public class Customer {
    private Integer id;

    private String customerName;

    private Integer sex;

    private Integer contact;

    private String address;

    private String area;

    private Integer homeType;

    private Integer projectNo;

    private Integer state;

    private Integer customerNo;

    /*
     * 会员优惠程度
     */
    private Integer privileges;
    
    public Integer getId() {
        return id;
    }

    public Integer getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Integer privileges) {
		this.privileges = privileges;
	}

	public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public Integer getHomeType() {
        return homeType;
    }

    public void setHomeType(Integer homeType) {
        this.homeType = homeType;
    }

    public Integer getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(Integer projectNo) {
        this.projectNo = projectNo;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(Integer customerNo) {
        this.customerNo = customerNo;
    }

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerName=" + customerName + ", sex=" + sex + ", contact=" + contact
				+ ", address=" + address + ", area=" + area + ", homeType=" + homeType + ", projectNo=" + projectNo
				+ ", state=" + state + ", customerNo=" + customerNo + ", privileges=" + privileges + "]";
	}
    
}