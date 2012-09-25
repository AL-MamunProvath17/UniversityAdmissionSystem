package com.igate.uas.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.igate.uas.bean.UserBean;
import com.igate.uas.exception.UASException;
import com.igate.uas.service.MacService;
import com.igate.uas.service.MacServiceImpl;

@SuppressWarnings("unused")
public class LoginTest {

	@Test
	public void validLoginMac() {
		try {
			MacService macService = new MacServiceImpl();
			UserBean user = new UserBean();
			user.setLoginId("vikas");
			user.setPassword("vikas");
			boolean isLoggedIn = macService.login(user);

			assertEquals("mac", user.getRole());

		} catch (UASException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void validLoginAdmin() {
		try {
			MacService macService = new MacServiceImpl();
			UserBean user = new UserBean();
			user.setLoginId("sumit");
			user.setPassword("sumit");
			boolean isLoggedIn = macService.login(user);

			assertEquals("admin", user.getRole());

		} catch (UASException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void invalidLogin() {
		try {
			MacService macService = new MacServiceImpl();
			UserBean user = new UserBean();
			user.setLoginId("fake");
			user.setPassword("fake");
			boolean isLoggedIn = macService.login(user);

			assertFalse(isLoggedIn);

		} catch (UASException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void blankLogin() {
		try {
			MacService macService = new MacServiceImpl();
			UserBean user = new UserBean();
			user.setLoginId("");
			user.setPassword("");
			boolean isLoggedIn = macService.login(user);

			assertFalse(isLoggedIn);

		} catch (UASException e) {
			e.printStackTrace();
		}
	}

}
