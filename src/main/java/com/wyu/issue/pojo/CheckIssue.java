package com.wyu.issue.pojo;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CheckIssue {
	
	//issue的ID
	private int issueId;
	
	//验证人
	private String checkMan;
	
	//验证时间
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	private Timestamp checkTime;
	
	//状态
	private String issueState;
	
	//解决方案
	private String totalSolution;

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public String getCheckMan() {
		return checkMan;
	}

	public void setCheckMan(String checkMan) {
		this.checkMan = checkMan;
	}

	public Timestamp getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Timestamp checkTime) {
		this.checkTime = checkTime;
	}

	public String getIssueState() {
		return issueState;
	}

	public void setIssueState(String issueState) {
		this.issueState = issueState;
	}

	public String getTotalSolution() {
		return totalSolution;
	}

	public void setTotalSolution(String totalSolution) {
		this.totalSolution = totalSolution;
	}
	
}
