package com.igate.uas.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CollegeBean implements Serializable{

	private String collegeId;
	private String collegeName;

	private String street;
	private String landmark;
	private String city;
	private String state;
	private String pincode;

	public CollegeBean() {
	}

	public CollegeBean(String collegeId, String collegeName, String street,
			String landmark, String city, String state, String pincode) {
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.street = street;
		this.landmark = landmark;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
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
	 * @return the collegeName
	 */
	public String getCollegeName() {
		return collegeName;
	}

	/**
	 * @param collegeName
	 *            the collegeName to set
	 */
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street
	 *            the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the landmark
	 */
	public String getLandmark() {
		return landmark;
	}

	/**
	 * @param landmark
	 *            the landmark to set
	 */
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}

	/**
	 * @param pincode
	 *            the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public boolean equals(Object obj) {
		CollegeBean anotherObject = (CollegeBean) obj;
		return this.collegeId.equals(anotherObject.getCollegeId());
	}

	@Override
	public int hashCode() {
		return this.collegeId.hashCode();
	}

	@Override
	public String toString() {
		return this.collegeId;
	}

	
	
}
