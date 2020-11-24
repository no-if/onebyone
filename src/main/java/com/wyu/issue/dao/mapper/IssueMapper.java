package com.wyu.issue.dao.mapper;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wyu.issue.pojo.CheckIssue;
import com.wyu.issue.pojo.CloseIssue;
import com.wyu.issue.pojo.Issue;
import com.wyu.issue.pojo.IssueParams;
import com.wyu.issue.pojo.IssueReport;
import com.wyu.issue.pojo.User;

@Mapper
public interface IssueMapper {
	/**
	 * 创建issue
	 * @param issue
	 */
	@Insert("insert into issue (issue_title,issue_no,issue_created_time,issue_type,issue_level,effect_version,schedule_time,repro_steps,modify_man,issue_state,is_delete) values (#{issueTitle},#{issueNo},#{issueCreatedTime},#{issueType},#{issueLevel},#{effectVersion},#{scheduleTime},#{reproSteps},#{modifyMan},#{issueState},#{isDelete})")
	void saveIssue(Issue params);
	
	/**
	 * 根据id删除issue
	 * @param issue
	 */
	@Update("update issue set is_delete=#{isDelete} where issue_id=#{issueId}")
	void deleteIssueById(Issue issue);
	
	/**
	 * 根据id修改issue状态-验证
	 * @param issue
	 */
	@Update("update issue set issue_state=#{issueState} where issue_id=#{issueId}")
	void setStateToCheckById(CheckIssue checkIssue);
	
	/**
	 * 更新issue解决方案
	 * @param checkIssue
	 */
	@Update("update issue set total_solution=#{totalSolution} where issue_id=#{issueId}")
	void setTotalSolution(CheckIssue checkIssue);
	
	/**
	 * 根据id修改issue状态-关闭
	 * @param issue
	 */
	@Update("update issue set issue_state=#{issueState} where issue_id=#{issueId}")
	void setStateToCloseById(CloseIssue closeIssue);
	
	/**
	 * 查询所有issue
	 * 
	 * @return
	 */
	@Select("select *from issue")
	List<Issue> findAll();
	
	/**
	 * 将数据保存到待验证表
	 * @param issue
	 */
	@Insert("insert into check_issue (issue_id,check_man,check_time) values (#{issueId},#{checkMan},#{checkTime})")
	void saveIssueToCheck(CheckIssue checkIssue);

	/**
	 * 将数据保存到已关闭表
	 * @param issue
	 */
	@Insert("insert into close_issue (issue_id,check_man,check_time,close_time) values (#{issueId},#{checkMan},#{checkTime},#{closeTime})")
	void saveIssueToClose(CloseIssue closeIssue);
	
	/**
	 * 查询验证时间
	 * @param closeIssue
	 * @return
	 */
	@Select("select check_time from check_issue where issue_id=#{issueId}")
	Timestamp selectCreatedTime(CloseIssue closeIssue);
	
	/**
	 * 根据id从验证表中删除待验证issue
	 * @param closeIssue
	 */
	@Delete("delete from check_issue where issue_id=#{issueId}")
	void deleteFromCheckIssue(CloseIssue closeIssue);
	
	/**
	 * 验证不通过退回-修改状态
	 * @param issue
	 */
	@Update("update issue set issue_state=#{issueState} where issue_id=#{issueId}")
	void setStateFromIssue(Issue issue);
	
	/**
	 * 从待验证表退回
	 * @param issue
	 */
	@Delete("delete from check_issue where issue_id=#{issueId}")
	void sendToIssue(Issue issue);
	
	/*邓艺坚*/
	/**
	 * 查询所有issue
	 * @return
	 */
	@Select("select * from issue where is_delete = 0")
	public List<Issue> selectAll();
	
	
	/**
	 * 查询自己的issue
	 * @return
	 */
	@Select("select * from issue where user_id=#{userId} and is_delete = 0 order by issue_created_time desc")
	List<Issue> selectMyissue(@Param("userId") int userId);
	
	/**
	 * 模糊查询自己的issue
	 * @return
	 */
	@Select("select issue.*,user.user_name from issue,user where issue.user_id=user.user_id and user.user_id=#{userId} and user.user_name like '%${userName}%' and issue_state=#{issueState} and issue_no like '%${issueNo}%' and modify_man like '%${modifyMan}%' and issue_created_time between #{issueCreatedTimeStart} and #{issueCreatedTimeFinish} and finish_time between #{finishTimeStart} and #{finishTimeFinish} order by issue_id desc")
	List<Issue> selectPartMyissue(Issue issue);
	
	/**
	 * 查询issue总表（模糊查询）
	 * @param issueNo
	 * @param issueStae
	 * @param issueCreatedTime
	 * @param createdBy
	 * @param modifyMan
	 * @param scheduleTime
	 * @return
	 */
	//  user.user_id=issue.user_id and user.user_name like '%${userName}%' and 
	@Select("select issue.* from issue,user where issue.user_id=user.user_id and user.user_name like '%${userName}%' and issue_state=#{issueState} and issue_no like '%${issueNo}%' and modify_man like '%${modifyMan}%' and issue_created_time between #{issueCreatedTimeStart} and #{issueCreatedTimeFinish} and finish_time between #{finishTimeStart} and #{finishTimeFinish} order by issue_id desc")
	//,@Param("issueCreatedTimeStart")Timestamp issueCreatedTimeStart,@Param("issueCreatedTimeFinish")Timestamp issueCreatedTimeFinish
	List<Issue> selectIssue(Issue issue);
	
	@Select("select *from user")
	List<User> selectUser();
	
	@Select("select user_id,login_id, user_name from user group by user_id order by login_id")
	List<IssueReport> selectReportUser();
	
	@Select("select login_id, user_name from user group by user_id")
	List<IssueReport> selectReportLogin();
	
	@Select("select count(abc.user_id) from user u left join " + 
			"(select * from issue iss) abc " + 
			"on u.user_id=abc.user_id where u.user_id=#{userId} " + 
			"group by u.user_id")
	Integer selectCreatedNum(IssueReport issueReport);

	@Select("select count(issue.modify_man) from user left join issue on user.user_name=issue.modify_man group by user.user_id having user.user_id=#{userId}")
	Integer selectModifyNum(IssueReport issueReport);
	
	@Select("select count(abc.issue_state) from user u left join " + 
			"(select * from issue iss where iss.issue_state='已关闭') abc " + 
			"on u.user_name=abc.modify_man " + 
			"where u.user_id=#{userId} " + 
			"group by u.user_id")
	Integer selectCloseNum(IssueReport issueReport);
	
	@Select("<script>"+
			"select user_id,login_id, user_name from user where 1 = 1 <if test='userName!= null'> "
			+ "and user_name like '%${userName}%' </if> and "
			+ "<if test='loginId!= null'> login_id like '%${loginId}%' </if> "
			+ "group by user_id order by login_id"+"</script>")
	List<IssueReport> selectPartReportUser(IssueReport issueReport);
	
}
