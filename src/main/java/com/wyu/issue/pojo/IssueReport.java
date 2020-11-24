package com.wyu.issue.pojo;

public class IssueReport {
	private int userId;
	private String loginId;
	private String userName;
	private int createdNum;
	private int modifyNum;
	private int closeNum;
	private String completionRate;
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getCreatedNum() {
		return createdNum;
	}
	public void setCreatedNum(int createdNum) {
		this.createdNum = createdNum;
	}
	public int getModifyNum() {
		return modifyNum;
	}
	public void setModifyNum(int modifyNum) {
		this.modifyNum = modifyNum;
	}
	public int getCloseNum() {
		return closeNum;
	}
	public void setCloseNum(int closeNum) {
		this.closeNum = closeNum;
	}
	public String getCompletionRate() {
		return completionRate;
	}
	public void setCompletionRate(String completionRate) {
		this.completionRate = completionRate;
	}
	
}
