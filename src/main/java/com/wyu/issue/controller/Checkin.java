package com.wyu.issue.controller;

import org.springframework.stereotype.Controller;

@Controller
public class Checkin {

	// 数字
	public static final String REG_NUMBER = ".*\\d+.*";
	// 小写字母
	public static final String REG_UPPERCASE = ".*[A-Z]+.*";
	// 大写字母
	public static final String REG_LOWERCASE = ".*[a-z]+.*";
	// 特殊符号
	public static final String REG_SYMBOL = ".*[~!@#$%^&*()_+|<>,.?/:;'\\[\\]{}\"]+.*";

	public static boolean checkPasswordRule(String password) {
		// 密码为空或者长度小于8位则返回false
		if (password == null || password.length() < 8)
			return false;
		int i = 0;
		if (password.matches(REG_NUMBER))
			i++;
		if (password.matches(REG_LOWERCASE))
			i++;
		if (password.matches(REG_UPPERCASE))
			i++;
		if (password.matches(REG_SYMBOL))
			i++;
		if (i < 4)
			return false;
		return true;
	}

	public static boolean checkLoginId(String loginId) {
		// 登录ID为空或者长度大于30位则返回false

		if (loginId == null || loginId.length() > 30)
			return false;
		if (loginId.equals("Admin"))
			return false;

		int i = 0;
		if (loginId.matches(REG_NUMBER))
			i++;
		if (loginId.matches(REG_LOWERCASE))
			i++;
		if (loginId.matches(REG_UPPERCASE))
			i++;
		if (i < 1)
			return false;
		return true;
	}

}
