package cn.edu.nuc.weibo.entity.POJO;

import java.util.List;
import java.util.Map;

import cn.edu.nuc.weibo.entity.Customer;

public class ContractPOJOList {
	
	private ContractPOJO contractPOJO;
	
	private Customer customer;
	
	private DepositPOJO depositPOJO;
	
	private List<PeriodPOJO> list;
	
	private List<ProjectPOJO> list2;

	public ContractPOJO getContractPOJO() {
		return contractPOJO;
	}

	public void setContractPOJO(ContractPOJO contractPOJO) {
		this.contractPOJO = contractPOJO;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public DepositPOJO getDepositPOJO() {
		return depositPOJO;
	}

	public void setDepositPOJO(DepositPOJO depositPOJO) {
		this.depositPOJO = depositPOJO;
	}

	public List<PeriodPOJO> getList() {
		return list;
	}

	public void setList(List<PeriodPOJO> list) {
		this.list = list;
	}

	public List<ProjectPOJO> getList2() {
		return list2;
	}

	public void setList2(List<ProjectPOJO> list2) {
		this.list2 = list2;
	}

	@Override
	public String toString() {
		return "ContractPOJOList [contractPOJO=" + contractPOJO + ", customer=" + customer + ", depositPOJO="
				+ depositPOJO + ", list=" + list + ", list2=" + list2 + "]";
	}
	
	
	
	
	
}
