package com.wyu.issue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wyu.issue.pojo.CheckIssue;
import com.wyu.issue.pojo.CloseIssue;
import com.wyu.issue.pojo.Issue;
import com.wyu.issue.pojo.IssueParams;
import com.wyu.issue.pojo.IssueReport;
import com.wyu.issue.pojo.Params;
import com.wyu.issue.service.IssueService;

@RestController
@RequestMapping("/issue")
public class IssueController {

	/*朱华健*/
	@Autowired
	private IssueService issueService;
	
	@RequestMapping("/save")
	public void saveIssue(@RequestBody IssueParams params) {
		issueService.saveIssue(params.getParams());
		return;
	}
	
	@RequestMapping("/delete")
	public void deleteIssueById(@RequestBody Issue issue) {
		issueService.deleteIssueById(issue);
		return;
	}
	
	@RequestMapping("/set/check")
	public void setStateToCheck(@RequestBody CheckIssue checkIssue) {
		issueService.setStateToCheckById(checkIssue);
	}
	
	@RequestMapping("/set/close")
	public void setStateToclose(@RequestBody CloseIssue closeIssue) {
		issueService.setStateToCloseById(closeIssue);
	}
	
	@RequestMapping("/sendback")
	public void sendBackToIssue(@RequestBody Issue issue) {
		issueService.sendBackToIssue(issue);
	}
	
	/*邓艺坚*/
	@RequestMapping("/selectAll")
	public List<Issue> selectAll() {
		return issueService.selectAll();
	}
	
	@RequestMapping("/selectMyissue")	
	public List<Issue> selectMyissue(@RequestBody Issue issue) {
		
		return issueService.selectMyissue(issue.getUserId());
	}
	
	@RequestMapping("/selectIssue")	
	public List<Issue> selectIssue(@RequestBody Issue issue){
		return issueService.selectIssue(issue);
	}
	
	@RequestMapping("/selectIssueReport")
	public List<IssueReport> selectIssueReport(@RequestBody IssueReport issueReport){
		return issueService.selectIssueReport(issueReport);
	}
	
	@RequestMapping("/selectPartIssueReport")
	public List<IssueReport> selectPartIssueReport(@RequestBody IssueReport issueReport){
		return issueService.selectPartIssueReport(issueReport);
	}
	
	@RequestMapping("/selectPartMyissue")	
	public List<Issue> selectPartMyissue(@RequestBody Issue issue){
		return issueService.selectPartMyissue(issue);
	}
}
