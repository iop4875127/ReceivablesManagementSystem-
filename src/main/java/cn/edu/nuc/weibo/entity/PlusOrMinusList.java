package cn.edu.nuc.weibo.entity;

import java.util.List;

import cn.edu.nuc.weibo.entity.POJO.PlusOrMinusPOJO;

public class PlusOrMinusList {

	private List<PlusOrMinusPOJO> plusOrMinusPoJo;

	public List<PlusOrMinusPOJO> getPlusOrMinusPoJo() {
		return plusOrMinusPoJo;
	}

	public void setPlusOrMinusPoJo(List<PlusOrMinusPOJO> plusOrMinusPoJo) {
		this.plusOrMinusPoJo = plusOrMinusPoJo;
	}

	@Override
	public String toString() {
		return "PlusOrMinusList [plusOrMinusPoJo=" + plusOrMinusPoJo + "]";
	}



	


	
}
