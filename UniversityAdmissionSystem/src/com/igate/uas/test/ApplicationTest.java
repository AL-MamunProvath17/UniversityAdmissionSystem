package com.igate.uas.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.igate.uas.bean.ApplicationBean;
import com.igate.uas.bean.UserBean;
import com.igate.uas.exception.UASException;
import com.igate.uas.service.ApplicantService;
import com.igate.uas.service.ApplicantServiceImpl;
import com.igate.uas.service.MacService;
import com.igate.uas.service.MacServiceImpl;

@SuppressWarnings("unused")
public class ApplicationTest {

	@Test
	public void validApplication() {
		try {
			ApplicantService applicantService = new ApplicantServiceImpl();

			ApplicationBean application = new ApplicationBean();
			application.setFullName("Vivek Rakhade");
			application.setDateOfBirth(new Date());
			application.setHighestQualification("B.E.");
			application.setGoals("Engineer");
			application.setMarks_obtained(80);
			application.setScheduledProgramId("25");
			application.setEmail_id("vivek@gmail.com");
			boolean status = applicantService.addApplication(application);

			assertTrue(status);

		} catch (UASException e) {
			e.printStackTrace();
		}
	}

	/*@Test
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
	}*/

}
