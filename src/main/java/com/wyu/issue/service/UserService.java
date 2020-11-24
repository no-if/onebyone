package com.wyu.issue.service;

import java.util.List;

import com.wyu.issue.pojo.User;

public interface UserService {

	public User userLogin(User user);

	public void modifyUser(User user);

	public List<User> getAllUser(User user);

	// 更新用户注销状态字段
	public void userCancel(User user);

	// 更新角色表的角色字段与描述
	public void userPromotion(User user);

	// 插入一个新用户
	public void saveUser(User user);

	// 根据ID查出结果
	public String getLoginId(String loginId);

	// 根据邮箱查出结果
	public String getUserEmail(String userEmail);
}
