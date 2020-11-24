package com.wyu.issue.service;

import java.util.List;

import com.wyu.issue.pojo.CheckIssue;
import com.wyu.issue.pojo.CloseIssue;
import com.wyu.issue.pojo.Issue;
import com.wyu.issue.pojo.IssueParams;
import com.wyu.issue.pojo.IssueReport;
import com.wyu.issue.pojo.Params;

public interface IssueService {
	/*朱华健*/
	/**
	 * 添加一条issue记录
	 * @param issue
	 */
	public void saveIssue(Issue params);
	
	/**
	 * 根据id删除一条issue记录
	 * @param issue
	 */
	public void deleteIssueById(Issue issue);
	
	/**
	 * 根据id设置issue状态为待验证
	 * @param issue
	 */
	public void setStateToCheckById(CheckIssue checkIssue);
	
	/**
	 * 根据id设置issue状态为关闭
	 * @param issue
	 */
	public void setStateToCloseById(CloseIssue closeIssue);
	
	/**
	 * 验证不通过退回
	 * @param issue
	 */
	public void sendBackToIssue(Issue issue);
	
	/*邓艺坚*/
	/**
	 * 查询所有issue
	 * @return
	 */
	public List<Issue> selectAll();
	/**
	 * 查询自己的issue
	 * @param userId
	 * @return
	 */
	public List<Issue> selectMyissue(int userId);
	/**
	 * 模糊查询
	 * @param issue
	 * @param issueState
	 * @return
	 */
	public List<Issue> selectIssue(Issue issue);
	
	public List<IssueReport> selectIssueReport(IssueReport issueReport);
	
	/**
	 * issue报表模糊查询
	 * @param issueReport
	 * @return
	 */
	public List<IssueReport> selectPartIssueReport(IssueReport issueReport);
	
	public List<Issue> selectPartMyissue(Issue issue);
}
