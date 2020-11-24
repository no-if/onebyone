package com.wyu.issue.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyu.issue.dao.mapper.RoleMapper;
import com.wyu.issue.dao.mapper.UserMapper;
import com.wyu.issue.pojo.User;
import com.wyu.issue.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userDao;

	@Autowired
	private RoleMapper roleMapper;

	@Override
	public User userLogin(User user) {
		// TODO Auto-generated method stub
		return userDao.getUser(user);
	}

	@Override
	public void modifyUser(User user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
	}

	@Override
	public List<User> getAllUser(User user) {
		// TODO Auto-generated method stub
		List<User> list = userDao.getAllUser(user);

		return list;
	}

	// 插入一个新用户
	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		// System.out.println("---------------------------------service层这是一个保存测试");
		// System.out.println(user);

		userDao.saveUser(user);
		roleMapper.saveRole(user.getLoginId());
	}

	// 根据ID查出结果
	@Override
	public String getLoginId(String loginId) {
		// TODO Auto-generated method stub

		return userDao.getLoginId(loginId);

	}

	// 根据邮箱查出结果
	@Override
	public String getUserEmail(String userEmail) {
		// TODO Auto-generated method stub
		return userDao.getUserEmail(userEmail);
	}

	// 更新用户注销状态字段
	@Override
	public void userCancel(User user) {
		// TODO Auto-generated method stub
		userDao.updateCancel(user);

	}

	// 更新角色表的角色字段与描述
	@Override
	public void userPromotion(User user) {
		// TODO Auto-generated method stub

		roleMapper.updateRoleName(user);

	}
}
