package com.igate.uas.bean;

public class DegreeBean {
	private String degreeId;
	private String degreeName;

	public DegreeBean() {
	}

	public DegreeBean(String degreeId, String degreeName) {
		this.degreeId = degreeId;
		this.degreeName = degreeName;
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
	 * @return the degreeName
	 */
	public String getDegreeName() {
		return degreeName;
	}

	/**
	 * @param degreeName
	 *            the degreeName to set
	 */
	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}

}
