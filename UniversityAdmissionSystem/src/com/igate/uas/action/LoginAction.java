package com.igate.uas.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.igate.uas.bean.UserBean;
import com.igate.uas.exception.UASException;
import com.igate.uas.service.MacService;
import com.igate.uas.service.MacServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 *
 * File Name : LoginAction.java
 * Class Name : LoginAction
 * Description : Login Action
 * Created On : Sep 17, 2012
 * @author : jb804412
 * 
 */
@SuppressWarnings("serial")
public class LoginAction extends ActionSupport implements
		ModelDriven<UserBean>, SessionAware {

	MacService macService;
	Map<String, Object> session;
	UserBean user = new UserBean();

	@Override
	public UserBean getModel() {
		return user;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public MacService getMacService() {
		return macService;
	}

	public void setMacService(MacService macService) {
		this.macService = macService;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 *
	 * @Method_Name login
	 * @Description login 
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @throws UASException
	 * 
	 * returns : String
	 */
	public String login() throws Exception {

		MacService macServiceInstance = getMacServiceInstance();
		if (macServiceInstance.login(user)) {
			String userRole = user.getRole();
			session.put("user", user);
			return userRole;
		}
		else {
			addActionError("Invalid Credentials For User");
			return INPUT;
		}
	}

	private MacService getMacServiceInstance() {
		if (macService == null)
			macService = new MacServiceImpl();
		return macService;
	}

}
