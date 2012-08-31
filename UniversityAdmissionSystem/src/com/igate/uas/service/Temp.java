package com.igate.uas.service;

import java.util.Date;

import com.igate.uas.bean.ApplicationBean;
import com.igate.uas.dao.AdminDAO;
import com.igate.uas.dao.AdminDAOImpl;
import com.igate.uas.dao.ApplicantDAO;
import com.igate.uas.dao.ApplicantDAOImpl;
import com.igate.uas.dao.MacDAO;
import com.igate.uas.dao.MacDAOImpl;
import com.igate.uas.exception.UASException;



public class Temp {
	
	
	public static void main(String[] args)
	{
		
	/*ApplicationBean a=new ApplicationBean("", "sandip",new Date(), "Be", 80.5f,"None","sumit@gmail.com","00001","",new Date(),"12345");
		ApplicantDAO app=new ApplicantDAOImpl();
		
		try {
			String status=app.addApplication(a);
			System.out.println(status);
		} catch (UASException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	*/
		
		ApplicationBean a=new ApplicationBean("au1200055", "",new Date(), "", 80.5f,"","","","accepted",new Date(),"12345");
		MacDAO mac=new MacDAOImpl();
		try {
			if(mac.setApplicationStatus(a))
			{
			System.out.println("Yes");	
			}
			else
			{
			System.out.println("No");
			}
		} catch (UASException e) {
			System.out.println(e.getMessage());
			
		}
		
	
	}

}
