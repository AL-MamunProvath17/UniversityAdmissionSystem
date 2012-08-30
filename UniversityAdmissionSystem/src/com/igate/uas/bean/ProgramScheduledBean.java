package com.igate.uas.bean;

import java.util.Date;

public class ProgramScheduledBean {

	private String scheduledProgramId;
	private Date startDate;
	private Date endDate;
	private int sessionPerWeek;
	private String collegeId;
	private String degreeId;
	private String programId;

	public ProgramScheduledBean() {
	}

	public ProgramScheduledBean(String scheduledProgramId, Date startDate,
			Date endDate, int sessionPerWeek, String collegeId,
			String degreeId, String programId) {
		this.scheduledProgramId = scheduledProgramId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.sessionPerWeek = sessionPerWeek;
		this.collegeId = collegeId;
		this.degreeId = degreeId;
		this.programId = programId;
	}

	/**
	 * @return the scheduledProgramId
	 */
	public String getScheduledProgramId() {
		return scheduledProgramId;
	}

	/**
	 * @param scheduledProgramId
	 *            the scheduledProgramId to set
	 */
	public void setScheduledProgramId(String scheduledProgramId) {
		this.scheduledProgramId = scheduledProgramId;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the sessionPerWeek
	 */
	public int getSessionPerWeek() {
		return sessionPerWeek;
	}

	/**
	 * @param sessionPerWeek
	 *            the sessionPerWeek to set
	 */
	public void setSessionPerWeek(int sessionPerWeek) {
		this.sessionPerWeek = sessionPerWeek;
	}

	/**
	 * @return the collegeId
	 */
	public String getCollegeId() {
		return collegeId;
	}

	/**
	 * @param collegeId
	 *            the collegeId to set
	 */
	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}

	/**
	 * @return the degreeId
	 */
	public String getDegreeId() {
		return degreeId;
	}

	/**
	 * @param degreeId
	 *            the degreeId to set
	 */
	public void setDegreeId(String degreeId) {
		this.degreeId = degreeId;
	}

	/**
	 * @return the programId
	 */
	public String getProgramId() {
		return programId;
	}

	/**
	 * @param programId
	 *            the programId to set
	 */
	public void setProgramId(String programId) {
		this.programId = programId;
	}

}
