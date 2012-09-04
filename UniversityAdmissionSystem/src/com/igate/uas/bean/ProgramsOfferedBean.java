package com.igate.uas.bean;

public class ProgramsOfferedBean {

	private String programId;
	private String programName;
	private String applicantEligibility;
	private int duration;
	private String degreeCertificateOffered;
	private String description;

	public ProgramsOfferedBean() {
	}

	public ProgramsOfferedBean(String programId, String programName,
			String applicantEligibility, int duration,
			String degreeCertificateOffered, String description) {
		this.programId = programId;
		this.programName = programName;
		this.applicantEligibility = applicantEligibility;
		this.duration = duration;
		this.degreeCertificateOffered = degreeCertificateOffered;
		this.description = description;
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

	/**
	 * @return the programName
	 */
	public String getProgramName() {
		return programName;
	}

	/**
	 * @param programName
	 *            the programName to set
	 */
	public void setProgramName(String programName) {
		this.programName = programName;
	}

	/**
	 * @return the applicantEligibility
	 */
	public String getApplicantEligibility() {
		return applicantEligibility;
	}

	/**
	 * @param applicantEligibility
	 *            the applicantEligibility to set
	 */
	public void setApplicantEligibility(String applicantEligibility) {
		this.applicantEligibility = applicantEligibility;
	}

	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param duration
	 *            the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * @return the degreeCertificateOffered
	 */
	public String getDegreeCertificateOffered() {
		return degreeCertificateOffered;
	}

	/**
	 * @param degreeCertificateOffered
	 *            the degreeCertificateOffered to set
	 */
	public void setDegreeCertificateOffered(String degreeCertificateOffered) {
		this.degreeCertificateOffered = degreeCertificateOffered;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object obj) {
		ProgramsOfferedBean anotherObect = (ProgramsOfferedBean) obj;
		return this.programId.equals(anotherObect.getProgramId());
	}

	@Override
	public int hashCode() {
		return this.programId.hashCode();
	}

}
