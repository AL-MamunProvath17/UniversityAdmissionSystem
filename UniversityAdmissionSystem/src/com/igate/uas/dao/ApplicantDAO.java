package com.igate.uas.dao;

import com.igate.uas.bean.ApplicationBean;
import com.igate.uas.exception.UASException;
/**
*
* File Name : AdminDAO.java
* Class Name : AdminDAO
* Description : DAO interface for Admin
* Created On : Sep 17, 2012
* @author : jb804412
* 
*/
public interface ApplicantDAO {
	/**
	 *
	 * @Method_Name addApplication
	 * @Description adds Applicant
	 * @Created_On Sep 15, 2012
	 * @author sc804382
	 * @param application
	 * @throws UASException
	 * 
	 * returns : boolean
	 */
	public boolean addApplication(ApplicationBean application)
			throws UASException;

	/**
	 *
	 * @Method_Name showStatus
	 * @Description show applicant status
	 * @Created_On Sep 15, 2012
	 * @author sc804382
	 * @param applicationId
	 * @throws UASException
	 * 
	 * returns : ApplicationBean
	 */
	public ApplicationBean showStatus(String applicationId) throws UASException;
}
