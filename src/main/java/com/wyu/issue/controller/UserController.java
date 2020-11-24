package com.wyu.issue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wyu.issue.pojo.Params;
import com.wyu.issue.pojo.Role;
import com.wyu.issue.pojo.User;
import com.wyu.issue.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 获取用户名与密码，用户登录
	 * 
	 * @param parsms
	 * @return user
	 */

	@RequestMapping("/login")
	public User userLogin(@RequestBody Params parsms) {
		User user = parsms.getParams();
		if (user.getLoginId() != null && user.getUserPassword() != null) {
			// 超级用户登录
			if (user.getLoginId().equals("Admin") && user.getUserPassword().equals("Admin123")) {
				user.setLoginId("Admin");
				user.setUserName("Admin");
				user.setUserPassword(null);
				// user.getRole().setRoleName("超级用户");
				Role role = new Role();
				role.setRoleName("超级用户");
				user.setRole(role);
				return user;
			}

			// 普通用户登录
			String md5Password = DigestUtils.md5DigestAsHex(user.getUserPassword().getBytes());// 对密码进行 md5 加密
			user.setUserPassword(md5Password);
			user = userService.userLogin(parsms.getParams());
			if (user == null) {
				System.out.println("输入信息有误！请重新输入!");
				return null;
			} else {

				if (user.getIscancel() == 1) {
					System.out.println("用户已注销！请联系管理员!");
					return user;
				}

				else if (user != null && user.getIscancel() == 0) { // 登录成功
					return user;
				}
			}
		}
		return null;
	}

	/**
	 * 修改个人信息
	 * 
	 * @param parsms
	 * @return String
	 */
	@RequestMapping("/update")
	public String modifyUser(@RequestBody Params parsms) {
		User user = parsms.getParams();

		if (user.getLoginId() != null && user.getUserName() != null && user.getUserEmail() != null
				&& user.getUserPassword() != null) {
			// 对密码进行 md5 加密
			String md5Password = DigestUtils.md5DigestAsHex(user.getUserPassword().getBytes());
			user.setUserPassword(md5Password);
			userService.modifyUser(user);
			return "修改成功！";
		}

		return "修改失败！";

	}

	/**
	 * 查询个人信息(支持模糊查询)
	 * 
	 * @param parsms
	 * @return list
	 */

	@RequestMapping("/query")
	public List<User> getUser(@RequestBody Params parsms) {

		User user = parsms.getParams();

		List<User> list = userService.getAllUser(user);

		return list;
	}

	// 用户注册
	@RequestMapping("/register")
	public String doregister(@RequestBody Params params) {

		User user = params.getParams();

		// 判断登录ID是否符合输入要求
		boolean loginIdState = Checkin.checkLoginId(user.getLoginId());
		// 判断密码格式是否符合输入要求
		boolean PasswordState = Checkin.checkPasswordRule(user.getUserPassword());

		if (!loginIdState) {
			return "failID";
		}
		// 查询是否是已存在ID
		if (userService.getLoginId(user.getLoginId()) != null)
			return "SameID";

		if (!PasswordState) {
			return "failpassword";
		}
		// 查询是否是已存在邮箱
		if (userService.getUserEmail(user.getUserEmail()) != null) {
			return "faileurEmail";
		}

		if (loginIdState && PasswordState) {
			// MD5密码加密
			String md5Password = DigestUtils.md5DigestAsHex(user.getUserPassword().getBytes());
			user.setUserPassword(md5Password);
			userService.saveUser(user);
			return "success";
		} else {

			return "failure";
		}

	}

	// 注销用户
	@RequestMapping("/cancel")
	public void userCancel(@RequestBody Params params) {

		User user = params.getParams();
		// 设值注销字段
		user.setIscancel(1);

		userService.userCancel(user);

	}

	// 普通用户升职为经理
	@RequestMapping("/promotion")
	public void userPromotion(@RequestBody Params params) {

		User user = params.getParams();

		userService.userPromotion(user);

	}

}
