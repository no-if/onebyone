package com.wyu.issue.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;

import com.wyu.issue.pojo.User;

@Mapper
public interface UserMapper {

	// 根据登录Id与密码查询出用户信息
	@Select("select * FROM user  WHERE user.LOGIN_ID=#{loginId} AND user.USER_PASSWORD=#{userPassword}")
	@Results({ @Result(column = "LOGIN_ID", property = "loginId"), @Result(column = "USER_NAME", property = "userName"),
			@Result(column = "USER_EMAIL", property = "userEmail"),
			@Result(column = "LOGIN_ID", property = "role", one = @One(select = "com.wyu.issue.dao.mapper.RoleMapper.getRole", fetchType = FetchType.EAGER)) })
	User getUser(User user);

	// 根据用户登录Id,修改用户的个人信息
	@Update("update user SET USER_NAME=#{userName},USER_EMAIL=#{userEmail},USER_PASSWORD=#{userPassword} WHERE LOGIN_ID=#{loginId}")
	public void updateUser(User user);

	// 查询用户信息(支持模糊查询)
	@Select("select * FROM user  WHERE user.LOGIN_ID LIKE '%${loginId}%' AND user.USER_NAME LIKE '%${userName}%' ORDER BY LOGIN_ID")
	@Results({ @Result(column = "LOGIN_ID", property = "loginId"), @Result(column = "USER_NAME", property = "userName"),
			@Result(column = "USER_EMAIL", property = "userEmail"),
			@Result(column = "LOGIN_ID", property = "role", one = @One(select = "com.wyu.issue.dao.mapper.RoleMapper.getRole", fetchType = FetchType.EAGER)) })
	List<User> getAllUser(User user);

	@Insert("insert into user (LOGIN_ID,USER_NAME,USER_EMAIL,USER_PASSWORD,CREATED_TIME) values (#{loginId},#{userName},#{userEmail},#{userPassword},NOW())")
	void saveUser(User user);

	@Select("select LOGIN_ID from user where LOGIN_ID = #{loginId}")
	String getLoginId(String loginId);

	@Select("select USER_EMAIL from user where USER_EMAIL = #{userEmail}")
	String getUserEmail(String userEmail);

	@Update("update user set IS_CANCEL=#{iscancel} WHERE LOGIN_ID=#{loginId}")
	public void updateCancel(User user);
}
