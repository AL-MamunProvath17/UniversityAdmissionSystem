<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

 <head>
  
    <link href="CSS/style.css" type="text/css" rel="stylesheet"/>

    <script src="SCRIPT/UAS.js" type="text/javascript"></script>
    
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    
    <title>Administrator</title>
    
 </head>
 
 <body>
 <s:if test="#session.user == null">
You are not Authorized to view this page, Kindly Login
<jsp:forward page="HomePage.jsp"></jsp:forward>
</s:if>
<!-- site wrapper starts here-->
 <div class="site-wrapper">
  
  <!--  includes header-->
    <s:include value="Resources/General/Header.html" />
   
<!--   includes menu bar-->
    <s:include value="Resources/General/MenuBar.html"/>
    
    
    <!--    body wrapper starts here-->
    <div class="body-wrapper">
    
     <!--  ADMIN navigator-->
     <div class="navigationMAC">

<div class="notification">Welcome: <s:property
	value="#session.user.loginId" /> <br />
<br />
<a href="logout.action" Class="tableclassButton">Log Out</a>
</div>
<div class="admintools">
         <p align="center">TOOLS</p>
         <ul>
          <li onclick="loadpage('Resources/Admin/AddCollege.jsp')">Add College</li>
          <li onclick="loadpage('Resources/Admin/AddDegree.jsp')">Add Degree</li>
          <li onclick="loadpage('Resources/Admin/LoadCollegeDegree.action')">Add Degree To College</li>
          <li onclick="loadpage('Resources/Admin/OfferProgram.jsp')">Offer Programs</li>
          <li onclick="loadpage('Resources/Admin/LoadCollegeDegreeProgram.action')">Add Program to College</li>
          <li onclick="loadpage('Resources/Admin/LoadScheduleDataAction.action')">Schedule Program</li>
          <li onclick="loadpage('Resources/Admin/LoadCollege.action')">Manage College</li>
          <li onclick="loadpage('Resources/Admin/LoadPrograms.action')">Manage Programs</li>
          <li onclick="loadpage('Resources/Admin/LoadMacMembers.action')">Manage MAC</li>
         </ul>
        </div>
     </div>
     <!-- main content-->
     <div  id="mainId">
     </div>
    
    </div>
    <!--    body wrapper ends here-->
    
    
    <!--    includes footer-->
    <s:include value="Resources/General/Footer.html"/>
 
 
 </div>
<!-- site wrapper ends here-->

 </body>
 
</html>