package com.wyu.issue.pojo;

public class User {
	private int userId;

	private String loginId;

	private String userName;

	private String userEmail;

	private String userPassword;

	private int iscancel;

	private Role role;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public int getIscancel() {
		return iscancel;
	}

	public void setIscancel(int iscancel) {
		this.iscancel = iscancel;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;

	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
