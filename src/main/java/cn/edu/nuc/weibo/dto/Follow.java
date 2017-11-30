package cn.edu.nuc.weibo.dto;

import cn.edu.nuc.weibo.entity.Account;

public class Follow {
	
	private Integer fid;
	private Integer aid;
	private Integer followAid;
	private Account account;
	private Integer flag;
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public Integer getFollowAid() {
		return followAid;
	}
	public void setFollowAid(Integer followAid) {
		this.followAid = followAid;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	
	

}
