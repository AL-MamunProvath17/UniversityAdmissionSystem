package com.igate.uas.dao;

import java.util.Date;
import java.util.List;

import com.igate.uas.bean.ApplicationBean;
import com.igate.uas.bean.UserBean;
import com.igate.uas.exception.UASException;
/**
*
* File Name : AdminDAO.java
* Class Name : AdminDAO
* Description : DAO interface for Mac
* Created On : Sep 17, 2012
* @author : jb804412
* 
*/
public interface MacDAO {
	/**
	 *
	 * @Method_Name setApplicationStatus
	 * @Description set applicant status 
	 * @Created_On Sep 15, 2012
	 * @author sc804382
	 * @param application
	 * @throws UASException
	 * 
	 * returns : boolean
	 */
	public boolean setApplicationStatus(ApplicationBean application) throws UASException;
	/**
	 *
	 * @Method_Name getApplicantList
	 * @Description get All applicant list related to mac 
	 * @Created_On Sep 15, 2012
	 * @author sc804382
	 * @param loginId
	 * @throws UASException
	 * 
	 * returns : List<ApplicationBean>
	 */
	public List<ApplicationBean> getApplicantList(String loginId) throws UASException;
	/**
	 *
	 * @Method_Name login
	 * @Description login for mac and admin 
	 * @Created_On Sep 15, 2012
	 * @author sc804382
	 * @param user
	 * @throws UASException
	 * 
	 * returns : boolean
	 */
	public boolean login(UserBean user) throws UASException;
	/**
	 *
	 * @Method_Name setStatus
	 * @Description set status of applicant 
	 * @Created_On Sep 15, 2012
	 * @author sc804382
	 * @param applicationId
	 * @param status
	 * @param doi
	 * @param loginId
	 * @throws UASException
	 * 
	 * returns : boolean
	 */
	public boolean setStatus(String[] applicationId,String[] status,Date[] doi,String loginId) throws UASException;
}
