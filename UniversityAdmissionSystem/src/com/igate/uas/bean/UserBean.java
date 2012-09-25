package com.igate.uas.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserBean implements Serializable{
	private String loginId;
	private String password;
	private String role;

	public UserBean() {
	}

	public UserBean(String loginId, String password, String role) {
		this.loginId = loginId;
		this.password = password;
		this.role = role;
	}

	/**
	 * @return the loginId
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * @param loginId
	 *            the loginId to set
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
}
