package com.igate.uas.service;

import static ch.lambdaj.Lambda.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import ch.lambdaj.function.matcher.Predicate;

import com.igate.uas.bean.ApplicationBean;

public class TempLambda {

	public static void main(String[] args) {
		
		List<ApplicationBean> apps = new ArrayList<ApplicationBean>();

		apps.add(new ApplicationBean("1", null, null, null, 0.0f, null, null,
				null, "applied", null, null));
		apps.add(new ApplicationBean("2", null, null, null, 0.0f, null, null,
				null, "applied", null, null));
		apps.add(new ApplicationBean("3", null, null, null, 0.0f, null, null,
				null, "confirmed", null, null));
		apps.add(new ApplicationBean("4", null, null, null, 0.0f, null, null,
				null, "applied", null, null));
		apps.add(new ApplicationBean("5", null, null, null, 0.0f, null, null,
				null, "rejected", null, null));

		Matcher<ApplicationBean> applied = new Predicate<ApplicationBean>() {

			@Override
			public boolean apply(ApplicationBean application) {
				return "applied".equals(application.getStatus());
			}

		};

		
		
		List<ApplicationBean> filteredapps = filter(applied, apps);
		/*List<ApplicationBean> filteredapps = filter(having(on(
				ApplicationBean.class).getStatus(), Matchers
				.equalTo("confirmed")), apps);*/
		
		for (ApplicationBean app : filteredapps) {
			System.out.println("App Id: " + app.getApplicationId());
		}
	}

}
