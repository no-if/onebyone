package com.wyu.issue.pojo;

import java.sql.Date;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Description issue信息实体类
 * @author 朱华健
 * @Date 2020年11月17日
 * @version 1.0.0
 */
public class Issue {
	
	//issueId
	private int issueId;
	
	//用户ID
	private int userId;
	
	//创建人姓名
	private String userName;
	
	//标题
	private String issueTitle; 
	
	//NO
	private String issueNo;
	
	//创建时间
	private Timestamp issueCreatedTime;
	
	//类型
	private String issueType;
	
	//等级
	private int issueLevel;
	
	//影响版本
	private String effectVersion;
	
	//计划修改时间
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date scheduleTime;
	
	//实际完成时间
	private Timestamp finishTime;
	
	//重现步骤
	private String reproSteps;
	
	//指派修改人
	private String modifyMan;
	
	//状态
	private String issueState;
	
	//解决方案
	private String totalSolution;
	
	//删除状态 0-未删除 1-已删除 默认0
	
	//查询创建时间的开始和结束时间
	 private Timestamp issueCreatedTimeStart;
	 private Timestamp issueCreatedTimeFinish;
	 //查询结束时间的开始和结束时间
	 private Timestamp FinishTimeStart;
	 private Timestamp FinishTimeFinish;
	
	private int isDelete;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getIssueTitle() {
		return issueTitle;
	}

	public void setIssueTitle(String issueTitle) {
		this.issueTitle = issueTitle;
	}

	public String getIssueNo() {
		return issueNo;
	}

	public void setIssueNo(String issueNo) {
		this.issueNo = issueNo;
	}

	public Timestamp getIssueCreatedTime() {
		return issueCreatedTime;
	}

	public void setIssueCreatedTime(Timestamp issueCreatedTime) {
		this.issueCreatedTime = issueCreatedTime;
	}

	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	public int getIssueLevel() {
		return issueLevel;
	}

	public void setIssueLevel(int issueLevel) {
		this.issueLevel = issueLevel;
	}

	public String getEffectVersion() {
		return effectVersion;
	}

	public void setEffectVersion(String effectVersion) {
		this.effectVersion = effectVersion;
	}

	public Date getScheduleTime() {
		return scheduleTime;
	}

	public void setScheduleTime(Date scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

	public Timestamp getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Timestamp finishTime) {
		this.finishTime = finishTime;
	}

	public String getReproSteps() {
		return reproSteps;
	}

	public void setReproSteps(String reproSteps) {
		this.reproSteps = reproSteps;
	}

	public String getModifyMan() {
		return modifyMan;
	}

	public void setModifyMan(String modifyMan) {
		this.modifyMan = modifyMan;
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

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public Timestamp getIssueCreatedTimeStart() {
		return issueCreatedTimeStart;
	}

	public void setIssueCreatedTimeStart(Timestamp issueCreatedTimeStart) {
		this.issueCreatedTimeStart = issueCreatedTimeStart;
	}

	public Timestamp getIssueCreatedTimeFinish() {
		return issueCreatedTimeFinish;
	}

	public void setIssueCreatedTimeFinish(Timestamp issueCreatedTimeFinish) {
		this.issueCreatedTimeFinish = issueCreatedTimeFinish;
	}

	public Timestamp getFinishTimeStart() {
		return FinishTimeStart;
	}

	public void setFinishTimeStart(Timestamp finishTimeStart) {
		FinishTimeStart = finishTimeStart;
	}

	public Timestamp getFinishTimeFinish() {
		return FinishTimeFinish;
	}

	public void setFinishTimeFinish(Timestamp finishTimeFinish) {
		FinishTimeFinish = finishTimeFinish;
	}

	@Override
	public String toString() {
		return "Issue [issueId=" + issueId + ", userId=" + userId + ", issueTitle=" + issueTitle + ", issueNo="
				+ issueNo + ", issueCreatedTime=" + issueCreatedTime + ", issueType=" + issueType + ", issueLevel="
				+ issueLevel + ", effectVersion=" + effectVersion + ", scheduleTime=" + scheduleTime + ", finishTime="
				+ finishTime + ", reproSteps=" + reproSteps + ", modifyMan=" + modifyMan + ", issueState=" + issueState
				+ ", totalSolution=" + totalSolution + ", issueCreatedTimeStart=" + issueCreatedTimeStart
				+ ", issueCreatedTimeFinish=" + issueCreatedTimeFinish + ", FinishTimeStart=" + FinishTimeStart
				+ ", FinishTimeFinish=" + FinishTimeFinish + ", isDelete=" + isDelete + "]";
	}
	
}
