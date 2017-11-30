package cn.edu.nuc.weibo.entity.searchObj;

public class EmployeeInfoSearchObj extends QureyByPage {

//	name department position employeeNo
	private String name;
    
    private String department;

    private String position;

	private String employeeNo;
    
    public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}


    @Override
	public String toString() {
		return "EmployeeInfoSearchObj [employeeNo=" + employeeNo + ", name=" + name + ", department=" + department
				+ ", position=" + position + "]";
	}

	
}
