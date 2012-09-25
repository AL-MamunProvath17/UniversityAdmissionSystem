package com.igate.uas.utils;

import java.util.Date;

import org.hamcrest.Matcher;

import ch.lambdaj.function.matcher.Predicate;

import com.igate.uas.bean.ApplicationBean;

public class CollectionUtils {

	public static Matcher<ApplicationBean> applied = new Predicate<ApplicationBean>() {
		@Override
		public boolean apply(ApplicationBean application) {
			return "applied".equals(application.getStatus());
		}
	};

	public static Matcher<ApplicationBean> accepted = new Predicate<ApplicationBean>() {
		@Override
		public boolean apply(ApplicationBean application) {
			return "accepted".equals(application.getStatus());
		}
	};

	public static Matcher<ApplicationBean> confirmed = new Predicate<ApplicationBean>() {
		@Override
		public boolean apply(ApplicationBean application) {
			return "confirmed".equals(application.getStatus());
		}
	};

	public static Matcher<ApplicationBean> rejected = new Predicate<ApplicationBean>() {
		@Override
		public boolean apply(ApplicationBean application) {
			return "rejected".equals(application.getStatus());
		}
	};

	public static Matcher<ApplicationBean> getMatcher(final String criteria) {
		return new Predicate<ApplicationBean>() {

			@Override
			public boolean apply(ApplicationBean application) {
				return criteria.equals(application.getStatus());
			}
		};
	}

	public static Matcher<ApplicationBean> getMarksFilter(
			final double minimumMarks) {
		return new Predicate<ApplicationBean>() {

			@Override
			public boolean apply(ApplicationBean application) {
				return application.getMarks_obtained() >= minimumMarks;
			}
		};
	}
	
	public static Matcher<ApplicationBean> dateMatcher = new Predicate<ApplicationBean>() {

		@Override
		public boolean apply(ApplicationBean application) {
			return (new Date()).compareTo(application.getDateOfInterview()) >0; 
		}

	};

}
