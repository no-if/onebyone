package com.wyu.issue.service.impl;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wyu.issue.dao.mapper.IssueMapper;
import com.wyu.issue.pojo.CheckIssue;
import com.wyu.issue.pojo.CloseIssue;
import com.wyu.issue.pojo.Issue;
import com.wyu.issue.pojo.IssueParams;
import com.wyu.issue.pojo.IssueReport;
import com.wyu.issue.pojo.Params;
import com.wyu.issue.service.IssueService;

@Service
@Transactional
public class IssueServiceImpl implements IssueService{

	/*朱华健*/
	@Autowired
	private IssueMapper issuemapper;
	
	@Override
	public void saveIssue(Issue params) {
		//获取当前系统时间
		Timestamp createdTime = new Timestamp(System.currentTimeMillis());
		//生成NO
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmm");
        String str=sdf.format(new Date());
		String issueNo = str + "_" + params.getUserId();
		
		//设置issue初始状态
		params.setIssueState("待修改");
		params.setIssueNo(issueNo);
		params.setIssueCreatedTime(createdTime);
		//默认设置为0
		params.setIsDelete(0);
		issuemapper.saveIssue(params);
	}

	@Override
	public void deleteIssueById(Issue issue) {
		issue.setIsDelete(1);
		issuemapper.deleteIssueById(issue);
	}

	@Override
	public void setStateToCheckById(CheckIssue checkIssue) {
		//获取当前系统时间
		Timestamp checkTime = new Timestamp(System.currentTimeMillis());
		checkIssue.setCheckTime(checkTime);
		checkIssue.setIssueState("待验证");
		
		//修改状态，保存到待验证表
		issuemapper.setStateToCheckById(checkIssue);
		issuemapper.setTotalSolution(checkIssue);
		issuemapper.saveIssueToCheck(checkIssue);
	}

	@Override
	public void setStateToCloseById(CloseIssue closeIssue) {
		//获取当前系统时间
		Timestamp closeTime = new Timestamp(System.currentTimeMillis());
		closeIssue.setCloseTime(closeTime);
		Timestamp checkTime = issuemapper.selectCreatedTime(closeIssue);
		closeIssue.setCheckTime(checkTime);
		closeIssue.setIssueState("已关闭");
		
		issuemapper.setStateToCloseById(closeIssue);
		issuemapper.saveIssueToClose(closeIssue);
		issuemapper.deleteFromCheckIssue(closeIssue);
	}

	@Override
	public void sendBackToIssue(Issue issue) {
		issue.setIssueState("待修改");
		//修改状态
		issuemapper.setStateFromIssue(issue);
		//从待验证表删除
		issuemapper.sendToIssue(issue);
	}
	
	@Override
	public List<Issue> selectAll() {
		return issuemapper.selectAll();
	}

	@Override
	public List<Issue> selectMyissue(int userId) {
		return issuemapper.selectMyissue(userId);
	}

	@Override
	public List<Issue> selectIssue(Issue issue) {
		//
			return issuemapper.selectIssue(issue);
	}

	@Override
	public List<IssueReport> selectIssueReport(IssueReport issueReport) {
		List<IssueReport> reportList = new ArrayList<IssueReport>();
		reportList = issuemapper.selectReportUser();
		int createdNum=0, modifyNum=0, closeNum=0;
		double finishRate = 0.0;
		for (IssueReport report : reportList) {
			if(issuemapper.selectCreatedNum(report)==null) {
				report.setCreatedNum(createdNum);
			}else {
				createdNum = issuemapper.selectCreatedNum(report);
				report.setCreatedNum(createdNum);
			}
			if(issuemapper.selectModifyNum(report)==null) {
				report.setModifyNum(modifyNum);
			}else {
				modifyNum = issuemapper.selectModifyNum(report);
				report.setModifyNum(modifyNum);
			}
			if(issuemapper.selectCloseNum(report)==null) {
				report.setCloseNum(closeNum);
			}else {
				closeNum = issuemapper.selectCloseNum(report);
				report.setCloseNum(closeNum);
			}
			if(modifyNum==0) {
				report.setCompletionRate("0%");
			}else{
				finishRate = (double)100*closeNum/modifyNum;
				DecimalFormat df = new DecimalFormat("0");
				report.setCompletionRate(df.format(finishRate)+"%");
			}
		}
		return reportList;
	}

	@Override
	public List<IssueReport> selectPartIssueReport(IssueReport issueReport) {
		List<IssueReport> reportList = new ArrayList<IssueReport>();
		reportList = issuemapper.selectPartReportUser(issueReport);
		int createdNum=0, modifyNum=0, closeNum=0;
		double finishRate = 0.0;
		for (IssueReport report : reportList) {
			if(issuemapper.selectCreatedNum(report)==null) {
				report.setCreatedNum(createdNum);
			}else {
				createdNum = issuemapper.selectCreatedNum(report);
				report.setCreatedNum(createdNum);
			}
			if(issuemapper.selectModifyNum(report)==null) {
				report.setModifyNum(modifyNum);
			}else {
				modifyNum = issuemapper.selectModifyNum(report);
				report.setModifyNum(modifyNum);
			}
			if(issuemapper.selectCloseNum(report)==null) {
				report.setCloseNum(closeNum);
			}else {
				closeNum = issuemapper.selectCloseNum(report);
				report.setCloseNum(closeNum);
			}
			if(modifyNum==0) {
				report.setCompletionRate("0%");
			}else{
				finishRate = (double)100*closeNum/modifyNum;
				DecimalFormat df = new DecimalFormat("0");
				report.setCompletionRate(df.format(finishRate)+"%");
			}
		}
		return reportList;
	}

	@Override
	public List<Issue> selectPartMyissue(Issue issue) {
		return issuemapper.selectPartMyissue(issue);
	}

}
